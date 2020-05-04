const chatId = document.getElementById("chatId");
const msg = document.getElementById("msg");
const btn = document.getElementById("btn");

btn.onclick = ()=>{
    var chat = parseInt(chatId.value);
    var texto = msg.value;
 
    console.log( fetch("localhost:8080/envioMensagem", {
        method: "post", 
        body: {chat , texto}
    }));
}