const express = require("express");
const router = express.Router();

module.exports = ormModels => {
  router.get("/", function(req, res, next) {
    res.render("search", { layout: "default", template: "home-template" });
  });
  router.get("/view-data/:selo", async function(req, res, next) {
    console.log(req.params);
    try {
        const name = req.params.selo;
        const Selista = ormModels.Selista;
        const Obstini = ormModels.Obstini;
        const Oblasti = ormModels.Oblasti;
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
  
        res.render("results", {results:result, layout: "default", template: "home-template" });
      } catch (e) {
          console.log(e);
        res.send(400);
      }

  });
  return router;
};
