// Imports
const express = require('express');
const CadastrarController = require('./controllers/CadastrarController')
const EventController = require('./controllers/EventController')
// const ProfileController = require('./controllers/ProfileController')
const SessionController = require('./controllers/SessionController')

//Gerencia Rotas
const routes = express.Router();
// ------------------------------------------------------------>
routes.get('/list', EventController.listEvents)//Lista todos os eventos de um design especifico
// routes.get('/profile', ProfileController.ListProfile)// Executa Perfil do usuário

//Criação de Conteudo
routes.post('/event', EventController.create)//Cadastra novo evento
routes.post('/cadastrar', CadastrarController.cadastrar);//Cadastra nova Ong
routes.post('/sessions', SessionController.create);

//Deleção de Conteudo
// routes.delete('/events/:id', EventController.delete);

//exporta const de rota para outros arquivos
module.exports = routes;