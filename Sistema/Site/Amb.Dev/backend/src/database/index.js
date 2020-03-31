const Sequelize = require('sequelize');
const dbconfig = require('../config/database')
const Users = require('../models/Users');

const connection = new Sequelize(dbconfig)

Users.init(connection)

module.exports = connection;