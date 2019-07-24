module.exports =  (sequelize) => {
    const Oblasti = require('./oblasti')(sequelize);
    return {Oblasti};
}