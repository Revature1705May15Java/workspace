var app = angular.module('calcApp', []);

app.controller('calcController', function($scope) {
  $scope.varA = 0;
  $scope.varB = 0;
  $scope.history = [];
  $scope.add = function() {
    $scope.history.unshift('' + $scope.varA + ' + ' + $scope.varB + ' = ' + ($scope.varA + $scope.varB));
  };
  $scope.subtract = function() {
    $scope.history.unshift('' + $scope.varA + ' - ' + $scope.varB + ' = ' + ($scope.varA - $scope.varB));
  };
  $scope.multiply = function() {
    $scope.history.unshift('' + $scope.varA + ' * ' + $scope.varB + ' = ' + ($scope.varA * $scope.varB));
  };
  $scope.divide = function() {
    $scope.history.unshift('' + $scope.varA + ' / ' + $scope.varB + ' = ' + ($scope.varA / $scope.varB));
  };
  $scope.modulo = function() {
    $scope.history.unshift('' + $scope.varA + ' % ' + $scope.varB + ' = ' + ($scope.varA % $scope.varB));
  };
  $scope.exponentiate = function() {
    $scope.history.unshift('' + $scope.varA + ' ^ ' + $scope.varB + ' = ' + ($scope.varA ** $scope.varB));
  };
});