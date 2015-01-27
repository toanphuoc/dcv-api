var dcvController = angular.module('dcvController', []);


dcvController.controller('SiteMasterCtrl', ['$scope', 'CompanyService', function($scope, CompanyService){

	CompanyService.getCompanyInfo().then(function(result){
		$scope.company = result.data;
	});

	$scope.support = function(){
		$('#suportModal').modal('show');
	};
}]);

dcvController.controller('HomeCtrl', ['$scope', function($scope){
	
}]);