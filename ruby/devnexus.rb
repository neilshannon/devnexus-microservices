require 'rubygems'
require 'sinatra/base'
require 'json'
require './person_repository.rb'

class DevNexus < Sinatra::Base

  def initialize
    vcap_services = ENV['VCAP_SERVICES']

    if vcap_services
      services = JSON.parse(vcap_services)
      @mongo_uri = services['mlab'].first['credentials']['uri']
    else
      @mongo_uri = 'mongodb://localhost/devnexus'
    end

    @person_repository = PersonRepository.new(@mongo_uri)
    super
  end

  get '/people' do
    people = @person_repository.find_all
    people.to_json
  end

end
