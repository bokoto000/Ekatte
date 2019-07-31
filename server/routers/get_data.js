const express = require("express");
const router = express.Router();

module.exports = ormModels => {
  const Oblasti = ormModels.Oblasti;
  const Obstini = ormModels.Obstini;
  const Selista = ormModels.Selista;

  router.get("/", async (req, res) => {
    try {
      const name = req.body.name;
      const selo = await Selista.findOne({
        where: { name: name }
      });
      const obstina = await Obstini.findOne({
        where: { obstina: selo.dataValues.obstina }
      });
      const oblast = await Oblasti.findOne({
        where: { oblast: obstina.dataValues.oblast }
      });
      const result =
        selo.dataValues.name +
        ", Община: " +
        obstina.dataValues.name +
        ", Област: " +
        oblast.dataValues.name;

      res.send(result);
    } catch (e) {
      res.send(400);
    }
  });

  return router;
};
