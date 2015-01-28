var dcvApp = angular.module('dcvApp', [
  'ngRoute',
  'dcvController', 
  'dcvServices'
]);

dcvApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/', {
        templateUrl: 'templates/company.html',
        controller: 'HomeCtrl'
    }).
    when('/profile', {
      templateUrl: 'templates/profile.html',
      controller: 'ProfileCtrl'
    }).
    otherwise({
        redirectTo: '/'
    });
}]);

var USER = $.cookie('user');
var ACCESS_TOKEN = $.cookie('access_token');


if(USER == undefined || ACCESS_TOKEN == undefined){
    window.location.href = 'index.html';
}