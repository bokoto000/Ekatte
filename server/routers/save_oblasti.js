const express = require("express");
const router = express.Router();
const bodyParser = require("body-parser");
router.use(bodyParser.json());
router.use(
  bodyParser.urlencoded({
    extended: true
  })
);



async function save_data(data, Oblasti, res) {
  errorCount = 0;
  for (i = 0; i < data.length; i++) {
    entry = data[i];
    try {
      await Oblasti.create({
        oblast: entry.oblast,
        ekatte: entry.ekatte,
        name: entry.name,
        document: entry.document
      });
    } catch (e) {
      console.log("e" + entry.name);
      errorCount++;
    }
  }
  /*
  data.forEach(async function(entry) {
    console.log(entry.name);
    try {
      await Oblasti.create({
        oblast: entry.oblast,
        ekatte: entry.ekatte,
        name: entry.name,
        document: entry.document
      });
    } catch (e) {
        console.log("e");
      errorCount++;
    }
  });
  */
  return errorCount;
}



async function save_obstini(data, Obstini, res, ObstiniOblasti) {
  errorCount = 0;
  for (i = 0; i < data.length; i++) {
    entry = data[i];
    oblast="none";
    try{
      const obstina_oblast = await ObstiniOblasti.findOne({
        where:{obstina:entry.obstina}
      })
      oblast = obstina_oblast.dataValues.oblast;
      console.log(obstina_oblast);
    } catch (e){

    }
    if(oblast!="none")
    try {
      await Obstini.create({
        obstina: entry.obstina,
        ekatte: entry.ekatte,
        oblast: oblast,
        document: entry.document,
        name: entry.name
      });
    } catch (e) {
      console.log(e);      console.log(e);      console.log(e);      console.log(e);      console.log(e);      console.log(e);      console.log(e);      console.log(e);
      errorCount++;
    }
  }
  return errorCount;
}

async function save_obstinioblasti(data, ObstiniOblasti){
  for (i = 0; i < data.length; i++) {
    entry = data[i];
    try {
      await ObstiniOblasti.create({
        oblast:entry.oblast,
        obstina:entry.obstina
      })
    } catch (e){
      //console.log(e);
      //console.log(entry.name);
    }
  }
  return errorCount;
}

async function save_selista(data, Selista, res, ObstiniOblasti) {
  errorCount = 0;
  for (i = 0; i < data.length; i++) {
    entry = data[i];
    try {
      await Selista.create({
        ekatte: entry.ekatte,
        t_v_m: entry.t_v_m,
        obstina: entry.obstina,
        name: entry.name
      });
    } catch (e) {
      //console.log(e+entry.name);
      errorCount++;
    }
  }
  return errorCount;
}

async function save_all(req, res, ormModels) {
  const Oblasti = ormModels.Oblasti;
  const Obstini = ormModels.Obstini;
  const Selista = ormModels.Selista;
  const ObstiniOblasti = ormModels.ObstiniOblasti;
  const oblasti = req.body.data.oblasti;
  const selista = req.body.data.selista;
  const obstini = req.body.data.obstini;



  errorCount=0;
  if (selista){
    await save_obstinioblasti(selista, ObstiniOblasti);
  }
  if (oblasti.length > 0) {
    errorCount+= await save_data(oblasti, Oblasti, res);
  } else console.log("No oblasti");
  if (obstini) {
    errorCount+= await save_obstini(obstini, Obstini, res, ObstiniOblasti);
  } else console.log("No obstini");
  if (selista) {
    errorCount+= await save_selista(selista, Selista, res, ObstiniOblasti);
  } else console.log("No Selista");
  return errorCount;
}

module.exports = ormModels => {
  router.post("/", async (req, res) => {
    const errorCount = await save_all(req, res, ormModels);
    if (errorCount > 0) res.send(400);
    else res.send(200);
  });

  return router;
};
