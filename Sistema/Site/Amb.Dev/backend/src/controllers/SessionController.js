const User = require('../models/Users')
// const connection = require('../database')
// const moment = require('moment')
const bcrypt = require('bcryptjs')

module.exports = {
    async createLogin (request,response){

        const {email, password} = request.body
        
        const userAtivo = await User.findOne({where:{email: email}})

        if(!userAtivo){
            return response.status(400).json({error: "Não Existem Usuários Com este Login"})
        }
        if(!await bcrypt.compare(password, userAtivo.password)){
            return response.status(400).json({error: "Senha Inválida"})
        }else{
            response.json(userAtivo)
        }            
    },

    async authenticate(request,response){

        const allU = await User.findAll()

        response.json(allU)
    }
}