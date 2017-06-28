var app = angular.module('todoApp', []);

app.controller('todoController', function($scope) {
  $scope.item = '';
  $scope.todoList = [];
  $scope.todoneList = [];
  $scope.addItem = function() {
    if (/sleep/.test($scope.item)) {
      window.alert("You can sleep when you're dead. Stop being lazy!");
    } else if ($scope.item === '') {
      window.alert("No! You can't just do nothing. Stop being lazy!");
    } else {
      $scope.todoList.push($scope.item);
    }
    $scope.item = '';
  };
  $scope.keyPressed = function(event) {
    if (event.keyCode === 13) {
      $scope.addItem();
    }
  }
  $scope.removeItem = function(ndx) {
    var finished = $scope.todoList.splice(ndx, 1);
    $scope.todoneList.push(finished[0]);
  };
});

app.filter('checkedItems', function() {
  return function(items, showComplete) {
    var resultArr = [];
    angular.forEach(function(element) {
      if (item.done === false || showComplete === true ) {
        resultArr.push(item);
      } else {
        resultArr.push(item);
      }
    });
    return resultArr;
  }
})