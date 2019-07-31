module.exports = (app, ormModels) => {
    app.use('/oblasti', require('../routers/oblasti')(ormModels));
    app.use('/save-oblasti', require('../routers/save_oblasti')(ormModels));
    app.use('/get-data', require('../routers/get_data')(ormModels));
    app.use('/get-stats', require('../routers/get_stats')(ormModels));
}