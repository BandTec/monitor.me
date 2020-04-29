const express = require("express");
const app = express();
const TelegramBot = require("node-telegram-bot-api");
const TOKEN = "1127314189:AAHcH7b9CmwknOeiCJLXN3kayd_-77LLFj4";
const bot = new TelegramBot(TOKEN, {polling: true});

//bot.sendMessage(957999937,"kjdkenfj");

bot.on('message',(msg)=> {
     console.log(msg);
});

app.listen(8080,()=>{
    console.log("servidor rodando");
});