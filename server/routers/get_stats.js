const express = require("express");
const router = express.Router();

module.exports = ormModels => {
  const Oblasti = ormModels.Oblasti;
  const Obstini = ormModels.Obstini;
  const Selista = ormModels.Selista;

  router.get("/", async (req, res) => {
    try {
      const selo = await Selista.count({
      });
      const obstina = await Obstini.count({
      });
      const oblast = await Oblasti.count({
      });
      const result =
        "Села: " + selo +
        ", Общини: " +
        obstina +
        ", Области: " +
        oblast;

      res.send(result);
    } catch (e) {
      res.send(400);
    }
  });

  return router;
};
