'use strict';

const argv = require('yargs')
  .usage('Usage: $0 <command> [options]')
  .command('dev-srv', 'local API server (-p port || 3002)')
  .demand(1)
  .epilogue('https://github.com/pansy-cx/virgil-cli')
  .argv

module.exports = argv
