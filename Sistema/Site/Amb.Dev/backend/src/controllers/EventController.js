const User = require('../models/Users')
const moment = require('moment')

module.exports = {
    async listEvents(req, res){

        const user = await User.findAll()
        const obj = JSON.stringify(user);

        // JSON.parse(obj)

        return res.json(
            user
        )
    }
}