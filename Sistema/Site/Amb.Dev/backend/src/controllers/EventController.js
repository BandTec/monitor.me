const Event = require('../models/Events')
const moment = require('moment')

module.exports = {
    async listEvents(req, res){

        const AllEvents = await Event.findAll()

        return res.json(
            AllEvents
        )
    },

    async create(req, res){

        const {modelo, memoryRam, GPU, hardDisk } = req.body;

        const UserId = req.headers.authorization;

        console.log('>>>>>>>>>>>>>>',UserId)

        const dadosHardware = await Event.create({modelo, memoryRam, GPU, hardDisk, UserId})

        console.log(JSON.stringify(dadosHardware))

        return res.json(
            dadosHardware
        )
    }
}

// user.forEach(o => {
        //     // console.log(JSON.stringify(o))   

        //     let {name, email, create, upd} =
        //     {
        //         name: o.name,
        //         email: o.email,
        //         create: o.createdAt,
        //         upd: o.updatedAt
        //     }
        //     upd = moment(upd).locale('pt-br').format('DD/MM/YYYY, h:mm:ss a')
        //     create = moment(create).locale('pt-br').format('DD/MM/YYYY, h:mm:ss a')

        //     console.log(`nome: ${name}, email: ${email}, create: ${create}, upd: ${upd}`)
        // });
        