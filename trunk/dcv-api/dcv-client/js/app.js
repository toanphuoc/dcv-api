var dcvApp = angular.module('dcvApp', [
  'ngRoute',
  'dcvController'
]);

dcvApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/', {
        templateUrl: 'templates/home.html',
        controller: 'HomeCtrl'
    }).
    otherwise({
        redirectTo: '/'
    });
}]);