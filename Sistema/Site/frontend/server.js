const express = require('express')
const app = express();

const PORT = process.env.PORT || 8080;

app.use(express.static(__dirname + '/dist/frontend'));

app.get('/*', (req, res) => {
    res.sendfile(__dirname + 'dist/frontend/index.html')
})

app.listen(PORT, () => {
    console.log('listening server at: ', PORT)
})