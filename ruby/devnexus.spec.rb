require './devnexus.rb'
require 'minitest/autorun'
require 'rack/test'

class DevNexusTest < Minitest::Test
  include Rack::Test::Methods

  def app
    DevNexus
  end

  def test_people
    get '/people'
    assert_equal 'hello world', last_response.body
  end

end
