const sequelize = require('./dbConfig');
const bodyParser = require('body-parser');


module.exports = async (app) => {

    app.use(bodyParser.json({ limit: '50mb' }));
    app.use(bodyParser.urlencoded({ limit: '50mb', extended: true }));

    await sequelize.query(`CREATE TABLE IF NOT EXISTS oblasti
    (
        oblast_id SERIAL,
        oblast character varying(255) NOT NULL UNIQUE  PRIMARY KEY,
        ekatte character varying(255) NOT NULL,
        document character varying(255) NOT NULL,
        name character varying NOT NULL UNIQUE
    )`);

    await sequelize.query(`CREATE TABLE IF NOT EXISTS obstini
    (
        obstina_id SERIAL,
        obstina character varying(255) NOT NULL UNIQUE  PRIMARY KEY,
        ekatte character varying NOT NULL,
        oblast character varying(255) NOT NULL ,
        document character varying(255) NOT NULL,
        name character varying(255) NOT NULL
    )`);

    await sequelize.query(`CREATE TABLE IF NOT EXISTS selista
    (
        ekatte character varying(255) NOT NULL UNIQUE PRIMARY KEY,
        t_v_m character varying(255) NOT NULL,
        obstina character varying(255) NOT NULL,
        name character varying(255) NOT NULL
    )`)


    await sequelize.query(`CREATE TABLE IF NOT EXISTS obstiniOblasti
    (
        id SERIAL,
        obstina character varying(255) NOT NULL UNIQUE,
        oblast character varying(255) NOT NULL  
    )`);


    try{   
    await sequelize.query(`ALTER TABLE selista ADD CONSTRAINT fk_obstina FOREIGN KEY (obstina) REFERENCES obstini(obstina);
    ALTER TABLE obstini ADD CONSTRAINT fk_obstina FOREIGN KEY (obstina) REFERENCES obstinioblasti(obstina);
    ALTER TABLE obstinioblasti ADD CONSTRAINT fk_obstina FOREIGN KEY (obstina) REFERENCES obstini(obstina);
    `);
    }catch(e){
        console.log("Keys already made");
    }

    const ormModels = require('../orm_models/index')(sequelize);
    require('./routersConfig')(app, ormModels);

}