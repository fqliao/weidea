#!/usr/bin/env node

'use strict';

const chalk = require('chalk')

console.log(chalk.bold(
  `
		==============================================================\n
		'virgil-cli' is virgil's personal project to quick build tools\n
		==============================================================
  `
))

require('./lib/dev-srv')