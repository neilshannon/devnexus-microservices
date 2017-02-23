require 'mongo'

class PersonRepository
	Mongo::Logger.logger.level = ::Logger::FATAL

	def initialize(mongo_uri)
		@mongo_uri = mongo_uri
	end

	def find_all
		with_mongo do |db|
			db.collection(:person).find.to_a
		end
	end

	def with_mongo
		begin
			client = Mongo::Client.new(@mongo_uri)
			yield client.database
    end
  end

end