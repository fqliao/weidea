#!/usr/bin/env node

'use strict';

const chalk = require('chalk')

console.log(chalk.bold(
  `virgil's personal project to quick build tools`
))

require('./lib/dev-srv')