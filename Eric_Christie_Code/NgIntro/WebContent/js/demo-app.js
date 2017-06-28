var app = angular.module("myApp", []);
app.controller("HelloController", function($scope) {
  $scope.message = "This is AngularJS!";
});

var notes = `AngularJS Notes:
-- HTML is loaded and evaluated by the browser
-- AngularJS is loaded and executed, creating the angular global object
-- the JS that creates the myApp module and registers the HomeController function is executed
-- AngularJS scans the HTML document, looking for apps and views. If AngularJS finds a view, it connects that view with the specified controller function
-- AngularJS executes the controller functions and updates the views with the daya from the model populated by the controller
-- At this point the HTML page is ready to be displayed
-- AngularJS now listens for browser events such as mouseover or click and modifies the views if the models are changed

-- compiler - a compiler parses the template and instantiates the directives and expressions
-- controllers - the business logic behind views
-- data binding - synchronizes data between models and views
-- dependency injection - creates and wires objects and functions
-- directives - extend HTML with custom attributes and elements
-- expressions - access variables and functions from the scope
-- filters - format the values of expressions for display
-- injector - a dependency injection container
-- model - the data shown to and interacted with by the user in the view
-- module - a container for the different parts of an app, including controllers, services, filters, and directives; configures the injector
-- scope - context where model is the context where the model is stored so that controllers, irectives and expressions can access it
-- view - what the user ultimately sees
-- service - reusable business logic that is independent of views
-- template - HTML with additional markup
`

app.controller("SecondController", function($scope) {});