/**
 * 
 */

app.controller('demoCtrl', function($scope, $http, demoFactory){
	$scope.results = demoFactory.getData(
			function(response){
				console.log(response.data)
				$scope.result = response.data;
			});
	
	$scope.resultFn= function(){
		$scope.result = demoFactory.getData();
	}
})

