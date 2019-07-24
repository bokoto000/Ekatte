const Sequelize = require('sequelize');
module.exports = (sequelize) => {
    const Oblasti = sequelize.define('oblasti', {
        oblast_id: {
          field: 'oblast_id',
          type: Sequelize.INTEGER,
          autoIncrement: true,
          primaryKey: true  
        },
        oblast: {
          field: 'oblast',
          type: Sequelize.STRING
        },
        ekatte: {
            field: 'ekatte',
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