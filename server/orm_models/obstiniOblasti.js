const Sequelize = require("sequelize");
module.exports = sequelize => {
  const ObstiniOblasti = sequelize.define(
    "obstinioblasti",
    {
      id: {
        field: "id",
        type: Sequelize.INTEGER,
        autoIncrement: true,
        primaryKey: true
      },
      obstina: {
        field: "obstina",
        type: Sequelize.STRING
      },
      oblast: {
        field: "oblast",
        type: Sequelize.STRING
      }
    },
    {
      freezeTableName: true
    }
  );
  return ObstiniOblasti;
};
