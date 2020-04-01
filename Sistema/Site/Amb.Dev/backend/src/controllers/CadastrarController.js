const User = require('../models/Users')

module.exports = {
    async cadastrar(req, res){
        const {name, email, whatsapp, password} = req.body

        const user = await User.create({name, email, whatsapp, password})
        
        return res.json(user)
    }
}