/**
 * 
 */

var appTopStory = angular.module('topStoryApp',[]);

appTopStory.controller('selectedStoryCtrl', function TopStory($scope, $http, $window){
	/**hhtp = XMLHttpRequest object to communicated to HTTP servers
	 * 
	 * http is a promise
	 * 
	 * 
	 */
	$http.get('https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty')
		.success(function(data){
			$scope.storyList = data;
			$scope.selectedStory;
		});
	
	$scope.update = function(id){
		var URI = 'https://hacker-news.firebaseio.com/v0/item/'+id+'.json?print=pretty';
		
		$http.get(URI)
			.success(function(storyData){
				$scope.storyInfo = storyData;
			})
	}

	$scope.gotostory = function(url){
		$window.open(url);
	}
	
})