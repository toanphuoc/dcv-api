var dcvApp = angular.module('dcvApp', [
  'ngRoute',
  'dcvController', 
  'dcvServices'
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