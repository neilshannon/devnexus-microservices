var restify = require('restify');
var cfenv = require('cfenv');
var appEnv = cfenv.getAppEnv();
var client = require('mongodb').MongoClient;

var server = module.exports.app = restify.createServer({
  name: 'devnexus-microservices-node',
  version: '0.1.0'
});

var credentials = appEnv.getServiceCreds('devnexus');
var mongoUrl = credentials ? credentials.uri : 'mongodb://localhost/devnexus';
var port = appEnv.port;

client.connect(mongoUrl, function(err, database){
    if (err){
        console.log(err);
        return;
    }

    var db = database;

    server.use(restify.acceptParser(server.acceptable));
    server.use(restify.queryParser());
    server.use(restify.bodyParser());

    server.get('/people', function (req, res, next) {
        db.collection('person').find().toArray(function(err, results){
            res.send(results);
            return next();
        });
    });

    server.listen(port, function () {
        console.log('%s listening at %s', server.name, server.url);
    });

});


