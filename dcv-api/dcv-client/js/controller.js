var dcvController = angular.module('dcvController', []);

dcvController.controller('HomeCtrl', ['$scope', function($scope){
	$scope.support = function(){
		$('#suportModal').modal('show');
	};
}]);