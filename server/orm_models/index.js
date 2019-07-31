module.exports =  (sequelize) => {
    const Oblasti = require('./oblasti')(sequelize);
    const Obstini = require('./obstini')(sequelize);
    const Selista = require('./selista')(sequelize);
    const ObstiniOblasti = require('./obstiniOblasti')(sequelize);
    return {
        Oblasti,
        Obstini,
        Selista,
        ObstiniOblasti
    };
}