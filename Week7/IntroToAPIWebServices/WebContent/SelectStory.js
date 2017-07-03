var appTopStory = angular.module('topStoryApp', []);

appTopStory.controller('selectedStoryCtrl', function TopStory($scope, $http, $window) {''
	// $http is XMLHttpRequest object to communicate to HTTP servers
	// $http is a promise to get and send data using AJAX
	
	/*
	 * A reference to the browser's window object. While window 
	 * is globally available in JavaScript, it causes testability 
	 * problems, because it is a global variable. In AngularJS
	 *  we always refer to it through the $window service, so it
	 *  may be overridden, removed or mocked for testing.
	 */
    $http.get('https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty')
        .success(function (data) {
			$scope.storyList = data;
			$scope.selectedStory;
        });
	$scope.update = function(id) {
	var URI = 'https://hacker-news.firebaseio.com/v0/item/' + id + '.json?print.pretty';
	// another AJAX call to get data	
	$http.get(URI)
			.success(function (storyData) {
				$scope.storyInfo = storyData;
		});
	};
	
	$scope.gotostory = function(url) {
		// $window is global reference to browser window
		// open link in a new tab
		$window.open(url);
	};
});
