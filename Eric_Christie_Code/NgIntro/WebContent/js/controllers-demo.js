var app = angular.module('myApp', []).controller('MyController', function($scope) {
  $scope.firstname = 'Your first name';
  $scope.lastname = 'Your last name';
  $scope.getFullName = function() {
    return $scope.firstname + ' ' + $scope.lastname;
  };
});
