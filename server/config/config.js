const sequelize = require('./dbConfig');
const bodyParser = require('body-parser');


module.exports = async (app) => {

    app.use(bodyParser.json({ limit: '50mb' }));
    app.use(bodyParser.urlencoded({ limit: '50mb', extended: true }));

    await sequelize.query(`CREATE TABLE IF NOT EXISTS oblasti
    (
        oblast_id integer NOT NULL UNIQUE PRIMARY KEY,
        oblast character varying(255) NOT NULL UNIQUE,
        ekatte character varying(255) NOT NULL UNIQUE,
        document character varying(255) NOT NULL,
        name character varying NOT NULL UNIQUE
    )`);

    await sequelize.query(`CREATE TABLE IF NOT EXISTS obstini
    (
        obstina_id integer NOT NULL UNIQUE PRIMARY KEY,
        obstina character varying(255) NOT NULL UNIQUE ,
        ekatte character varying NOT NULL UNIQUE,
        oblast_id integer NOT NULL,
        document character varying(255) NOT NULL,
        name character varying(255) NOT NULL UNIQUE
    )`);

    await sequelize.query(`CREATE TABLE IF NOT EXISTS selista
    (
        ekatte character varying(255) NOT NULL UNIQUE PRIMARY KEY,
        t_v_m character varying(255) NOT NULL,
        obstina_id integer NOT NULL,
        name character varying(255) NOT NULL UNIQUE
    )`)


    const ormModels = require('../orm_models/index')(sequelize);
    require('./routersConfig')(app, ormModels);

}