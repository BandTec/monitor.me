// Imports
const express = require('express');
const CadastrarController = require('./controllers/CadastrarController')
const EventController = require('./controllers/EventController')
// const ProfileController = require('./controllers/ProfileController')
const SessionController = require('./controllers/SessionController')

//Gerencia Rotas
const routes = express.Router();
// ------------------------------------------------------------>
routes.get('/:UserId/eventMyHardware', EventController.myHardware)//Lista todos os eventos de um design especifico
routes.get('/:UserId/eventMyHardware/:hardId/eventHistory', EventController.consultHardHistory)//Cadastra novo Hardware de Usuário
routes.get('/:UserId/eventMyHardware/:hardId/AllH', EventController.consultAllH)//Consulta Todos Hardware de Usuário
routes.get('/:UserId/eventMyHardware/:hardId/AllH/:id', EventController.consultHbyId)//Consulta Hardware de Usuário

routes.post('/eventHistory1', EventController.createEvent)//Cadastra novo EventHardware de Usuário
// routes.get('/profile', ProfileController.ListProfile)// Executa Perfil do usuário

//Criação de Conteudo
routes.post('/cadastrar/:UserId/novoHardware', EventController.createHardUser)//Cadastra novo Hardware de Usuário
routes.post('/cadastrar', CadastrarController.cadastrar);//Cadastra Novo usuario
routes.post('/sessions', SessionController.create);

//Deleção de Conteudo
// routes.delete('/events/:id', EventController.delete);


//Att de Rota
routes.put('/:UserId/eventMyHardware/:hardId/AllH/:id', EventController.atualizaHardware)//Consulta Hardware de Usuário

//exporta const de rota para outros arquivos
module.exports = routes;