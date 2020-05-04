const express = require("express");
const app = express();
const routes = require("./routes/routes");
const bodyParser = require("body-parser");
const cors = require("cors");

app.use(cors());
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());
app.use(bodyParser);
app.use(routes);

app.listen(8080,()=>{
    console.log("servidor rodando");
});