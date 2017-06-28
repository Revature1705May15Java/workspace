var app = angular.module('sortingApp', []);

app.controller('mergeSortController', function($scope) {
  $scope.unsorted = [];
  $scope.sorted = [];
  $scope.append = function(num) {
    $scope.unsorted.push(num);
    $scope.sort();
  };
  $scope.enterNumber = function(ev, num) {
    if (event.keyCode === 13) {
      $scope.append(num);
    }
  };
  $scope.sort = function() {
    $scope.sorted = $scope.mergeSort($scope.unsorted.slice(0));
  }
  $scope.mergeSort = function(list) {
    if (list.length <= 1) {
      return list;
    } else {
      var left = [];
      var right = [];
      for (let i = 0; i < list.length; i++) {
        if (i < list.length /2) {
          left.push(list[i]);
        } else {
          right.push(list[i]);
        }
      }
      return $scope.merge($scope.mergeSort(left), $scope.mergeSort(right));
    }
  };
  $scope.merge = function(left, right) {
    console.log('merging [' + left.join(', ') + '] with [' + right.join(', ') + ']')
    var output = [];
    while (left.length > 0 || right.length > 0) {
      if (left.length > 0 && right.length > 0) {
        if (left[0] <= right[0]) {
          output.push(left.shift());
        } else {
          output.push(right.shift());
        }
      } else if (left.length > 0) {
        output.push(left.shift());
      } else if (right.length > 0) {
        output.push(right.shift());
      }
    }
    return output;
  }
});

app.controller('insertionSortController', function($scope) {
  $scope.unsorted = [];
  $scope.sorted = [];
  $scope.append = function(num) {
    $scope.unsorted.push(num);
    $scope.sort();
  };
  $scope.enterNumber = function(ev, num) {
    if (event.keyCode === 13) {
      $scope.append(num);
    }
  };
  $scope.sort = function() {
    $scope.sorted = $scope.insertionSort($scope.unsorted.slice(0));
  }
  $scope.insertionSort = function(list) {
    var n = list.length;
    list = list;
    for (let i = 1; i < n; i++) {
      for (let j = i; j > 0; j--) {
        if (list[j - 1] > list[j]) {
          var tmp = list[j - 1];
          list[j - 1] = list[j];
          list[j] = tmp;
        } else {
          break;
        }
      }
    }
    return list;
  };
});