app.factory('demoFactory', function($http){
	var url = "https:/swapi.co/api/people/1";
	var result = '';
	
	var factory = [];
	
	factory.getData = function(callback){
		$http.get(url).then(callback);
		return result;
	};
	return factory;
});