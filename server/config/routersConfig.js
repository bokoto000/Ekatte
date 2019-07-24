module.exports = (app, ormModels) => {
    app.use('/oblasti', require('../routers/oblasti')(ormModels));
}