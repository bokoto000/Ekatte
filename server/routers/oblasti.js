const express = require('express');
const router = express.Router();

module.exports = (ormModels) => {
    const Oblasti = ormModels.Oblasti

    router.get('/', async (req, res) => {

        const oblasti = await Oblasti.findAll({
        })

        res.json({ oblasti })
    })


    return router;
}