var dcvServices = angular.module('dcvServices', ['ngResource']);

dcvServices.factory('CompanyService', ['$http', function($http){
	var factory = {};

	factory.getCompanyInfo = function(){
	 	return $http({
	 		url : BASE_URL + 'company/getInfo',
	 		method: 'GET',
	 		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	 	});	
	};
	return factory;

}])