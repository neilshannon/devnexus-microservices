require 'rubygems'
require 'sinatra/base'
require 'json'

class DevNexus < Sinatra::Base

configure do
    vcap_services = ENV['VCAP_SERVICES']
    if vcap_services
    	services = JSON.parse(vcap_services)
    	mongo_uri = services['mlab'].first['credentials'].uri
	else
		mongo_uri = 'mongodb://localhost/devnexus'
	end
end

get '/people' do
    'hello world'
end

end