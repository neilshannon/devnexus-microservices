require './devnexus.rb'
require 'minitest/autorun'
require 'rack/test'
require 'json'

class DevNexusTest < Minitest::Test
  include Rack::Test::Methods

  def app
    DevNexus
  end

  def test_people
    get '/people'
     response = last_response.body
     response_json = JSON.parse(response).first

     assert_equal response_json['firstName'], 'Neil'
     assert_equal response_json['lastName'], 'Shannon'
  end

end
