var appTopStory = angular.module('topStoryApp', []);

appTopStory.controller('selectedStoryCtrl', 
		function TopStory($scope, $http, $window){
		/* $http is XMLHttpRequeest object to communicate
		 * to HTTP servers
		 * $http is a promise to get and send data using AJAX
		 */
	$http.get('https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty')
		.success(function(data){
			$scope.storyList = data;
			$scope.selectedStory;
			
		});
	
	$scope.update = function(id){
		// AJAX call to get data
		var URI = 'https://hacker-news.firebaseio.com/v0/item/' 
			+ id + '.json?print=pretty';
			
		$http.get(URI)
			.success(function(storyData){
				$scope.storyInfo=storyData;
				console.log(storyData);
			})
	}
	
	
	$scope.gotostory = function(url){
		//$window is a global reference to the browser window
		// this will open the link in a new tab
		
		$window.open(url);
	}
	
})