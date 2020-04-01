const User = require('../models/Users')
// const connection = require('../database')
const moment = require('moment')

module.exports = {
    async create (request,response){

        const {email, password} = request.body
        
        const userAtivo = await User.findOne({
            where:{
                email: email,
                password: password
            }
        })

        console.log(JSON.stringify(userAtivo))
        
        if(!userAtivo){
            return response.status(400).json({error: "Não Existem Usuários Com este Login"})
        }

        return response.json(userAtivo)
    }
}