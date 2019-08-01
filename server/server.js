const express = require('express');
const app = express();
const hbs = require('express-handlebars');

app.set('view engine', 'hbs');
app.engine('hbs', hbs({
    extname: 'hbs',
    defaultView: 'default',
    layoutsDir: __dirname+'/views/pages/',
    partialsDir: __dirname + '/views/partials/'
}));

const port = process.env.PORT || 5000;

const path = require('path');

require('./config/config')(app);

app.use("/public", express.static(path.join(__dirname, '/public')));

app.listen(port, () => console.log(`Listening on port ${port}`));