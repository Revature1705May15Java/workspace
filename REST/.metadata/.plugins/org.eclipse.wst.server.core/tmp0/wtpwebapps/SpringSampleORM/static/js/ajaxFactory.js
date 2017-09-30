app.factory('ajaxFactory', function($http) {
    let factory = {};
    var domain = 'http://localhost:8023/SpringSampleORM/';
    // function returns the promise
    factory.getUserInfo = function(credential, controller) {
        return $http.post(domain + controller, credential);
    };
  
    return factory;
});