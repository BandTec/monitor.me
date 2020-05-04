const express = require("express");
const routes = express.Router();
const envioMensagem = require("../modules/envioMensagem");

routes.post("/envioMensagem", (req,res)=>{
    // var {chatId , msg} = req.body;
    // envioMensagem(chatId , msg).then(()=>{
    //     console.log("Mensagem enviada");
    // }).catch((erro)=>{
    //  console.error(erro);
    // });

    console.log(req);
})

module.exports = routes;
