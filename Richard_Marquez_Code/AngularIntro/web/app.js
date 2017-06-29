var app = angular.module('routingApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/home.html'
        })

        .when('/about', {
            templateUrl: 'views/about.html',
            controller:'AboutController'
        })

        .when('/contact', {
            templateUrl: 'views/contact.html'
        })

        .otherwise({
            redirectTo: '/'
        });

});

$(document).ready(function () {
    // console.log('asfdf');
});
