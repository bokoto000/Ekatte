const Sequelize = require('sequelize');
module.exports = (sequelize) => {
    const Oblasti = sequelize.define('selista', {
        ekatte: {
          field: 'ekatte',
          type: Sequelize.STRING,
          primaryKey: true  
        },
        t_v_m: {
          field: 't_v_m',
          type: Sequelize.STRING
        },
        obstina: {
            field: 'obstina',
            type: Sequelize.STRING
          }, 
        name: {
            field: 'name',
            type: Sequelize.STRING
          }, 
      },  {
        freezeTableName: true,
      });
      return Oblasti;
}