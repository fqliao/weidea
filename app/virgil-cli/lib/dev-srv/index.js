'use strict';

const path = require('path'),
			argv = require('../argv'),
			chalk = require('chalk'),
			fse = require('fs-extra'),
			cors = require('cors'),
			chokidar = require('chokidar'),
			enableDestroy = require('server-destroy'),
			jsonServer = require('json-server')

const local_db_file = path.join(process.cwd(), '/test/db.json'),
			local_r_file = path.join(process.cwd(), '/test/r.json')

let port = 3002,
		server,
		fixed_db = {}

const getLocalIP = () => {
  let address,
    	os = require('os'),
    	ifaces = os.networkInterfaces()

  for (let dev in ifaces) {
    let iface = ifaces[dev].filter(details => details.family === 'IPv4' && details.internal === false);
    if (iface.length > 0) {
      address = iface[0].address
      break
    }
  }
  return address
}

const watch = () => {
	console.log('🙈  Watching : Local Data => %s/test/{db,r}.json\n', process.cwd())
	chokidar
    .watch([local_r_file, local_db_file])
    .on('change', () => {
      console.log(chalk.gray('🙏  Restarting...'))
      server.destroy(() => {
        start()
      })
    })
}

const start = () => {
	let local_db = {}, local_r = {}
	try {
		local_db = fse.readJsonSync(local_db_file)
		local_r = fse.readJsonSync(local_r_file)
	} catch (e) {
		console.warn(chalk.bold('🙋  Warning : NO Local Data => %s/test/{db,r}.json\n', process.cwd()))
	}
	Object.assign(fixed_db, local_db)

	let app = jsonServer.create()
	app.use(cors())
	let router = jsonServer.router(local_db)
	router.render = (req, res) => {
		let db_data = res.locals.data
		if (req.method === 'POST' || req.method === 'PUT' || req.method === 'PATCH' || req.method === 'DELETE') {
      db_data = fixed_db[req.path.replace('/', '')] || {}
    }

    let _status = req.query._status || 200

    // 自定义错误状态
    let msgJson = {}, msgCode = 0
    for (let i in db_data) {
    	if (i === 'code' || i === 'status') {
    		msgCode = db_data[i]
    		msgJson[i] = msgCode
    	}
    	if (i === 'msg' || i === 'error' || i === 'err') {
    		msgJson[i] = db_data[i]
    	}
    }
    
    // 发送数据
    if (msgCode && msgCode > 400) {
    	res.status(msgCode).jsonp(msgJson)
    } else if (_status * 1 >= 400) {
    	res.sendStatus(_status)
    } else {
    	res.json(db_data)
    }
	}
	app.use(jsonServer.rewriter(local_r))		// 映射路由
  app.use(jsonServer.defaults())
  app.use(router)
  server = app.listen(port, () => {
    console.log(`👏  Running : http://${getLocalIP()}:${port}\n`)
  })
  enableDestroy(server)
}

if (argv._ && argv._[0] === 'dev-srv') {
	console.log(chalk.bold('Virgil Local API Server \n'))
	if (argv.p) {
		port = parseInt(argv.p)
	}
	start()
	watch()
}