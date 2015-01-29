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

}]);;

dcvServices.factory('UserService', ['$http', function($http){
	var factory = {};
	factory.logout = function(access_token){
		return $http({
			url: BASE_URL + 'user/logout',
			method: 'POST',
			data:$.param({
				access_token: access_token
			}),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		});
	};

	factory.changePassword = function(access_token, old_pass, new_password){
		return $http({
			url: BASE_URL + 'user/changePassword',
			method: 'POST',
			data: $.param({
				access_token: access_token,
				old_pass: old_pass,
				new_pass: new_password
			}),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		});
	};

	return factory;
}]);