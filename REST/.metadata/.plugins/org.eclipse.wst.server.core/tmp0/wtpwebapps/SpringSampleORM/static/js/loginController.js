app.controller('loginController', function($scope, ajaxFactory) {
    $scope.credential = {};
    $scope.login = () => {
        console.log('Clicked the submit button and the credentials are:');
        console.log($scope.credential);
        ajaxFactory.getUserInfo($scope.credential,'login.do')
            .then((successResponse) => {
                console.log(successResponse.data);
            })
    }
});