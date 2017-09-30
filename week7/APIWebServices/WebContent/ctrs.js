/**
 * 
 */
var app = angular.module("topStoryApp", []);

app.controller("storyCtrl", 
	function TopStory($scope,$http,$window){
	
		$http.get('https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty')
			.success(function(data){
				$scope.storyList = data;
				$scope.selectedStory;
			});
			
		$scope.update = function(id){
			var URI = 'https://hacker-news.firebaseio.com/v0/item/' + id + '.json?print=pretty';
				
				$http.get(URI)
					.success(function(storyData){
						$scope.storyInfo = storyData;
					});		
		};
		
		$scope.gotoStory = function (url){
			$window.open(url);
		};
	}
);