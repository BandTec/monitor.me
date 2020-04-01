const Sequelize = require('sequelize');
const dbconfig = require('../config/database')
const Users = require('../models/Users');
const Events = require('../models/Events');

const connection = new Sequelize(dbconfig)

Users.init(connection)
Events.init(connection)

module.exports = connection;