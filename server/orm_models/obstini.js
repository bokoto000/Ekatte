const Sequelize = require("sequelize");
module.exports = sequelize => {
  const Oblasti = sequelize.define(
    "obstini",
    {
      obstina_id: {
        field: "obstina_id",
        type: Sequelize.INTEGER,
        autoIncrement: true,
        primaryKey: true
      },
      obstina: {
        field: "obstina",
        type: Sequelize.STRING
      },
      ekatte: {
        field: "ekatte",
        type: Sequelize.STRING
      },
      oblast: {
        field: "oblast",
        type: Sequelize.STRING
      },
      document: {
        field: "document",
        type: Sequelize.STRING
      },
      name: {
        field: "name",
        type: Sequelize.STRING
      }
    },
    {
      freezeTableName: true
    }
  );
  return Oblasti;
};
