var expect = require('chai').expect;
var app = require('../lib/server.js').app;
var request = require('supertest');


describe('the devnexus node api', function(){
  it('should find all people', function(done){
    request(app)
     .get('/people')
     .set('Accept', 'application/json')
     .expect('Content-Type', /json/)
     .expect(function (res){
        var neil = res.body[0];
        expect(neil.firstName).to.equal('Neil');
        expect(neil.lastName).to.equal('Shannon');
     }).end(done);
  });
});

