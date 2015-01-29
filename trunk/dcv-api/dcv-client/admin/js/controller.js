var dcvController = angular.module('dcvController', []);

dcvController.controller('HeaderController', ['$scope', 'CompanyService', 'UserService', function($scope, CompanyService, UserService){
	
	$scope.user = USER;
	CompanyService.getCompanyInfo().then(function(result){
		$scope.company = result.data;
	});

	$scope.logout = function(){
		UserService.logout(ACCESS_TOKEN).then(function(result){
			if(result.status){
				$.removeCookie('user');
				$.removeCookie('access_token');
				window.location.href = "index.html";
			}else{
				window.location.href = "index.html";
			}
		});
	}
}]);


dcvController.controller('ProfileCtrl', ['$scope', 'UserService', function($scope, UserService){
	$scope.user = USER;

	$scope.save = function(){

		var oldPass = $('#profile .old-password').val();
		var newPass = $('#profile .new-password').val();
		var confirmNewPassword = $('#profile .confirm-new-password').val();

		if(oldPass == ''){
			$('#profile .old-password').focus();
			$('#profile .old-password').next().removeClass('hide');
			return;
		}else{
			$('#profile .old-password').next().addClass('hide');
		}

		if(newPass == '' || newPass.length < 6){
			$('#profile .new-password').focus();
			$('#profile .new-password').next().removeClass('hide');
			return;
		}else{
			$('#profile .new-password').next().addClass('hide');
		}

		if(confirmNewPassword != newPass){
			$('#profile .confirm-new-password').focus();
			$('#profile .confirm-new-password').next().removeClass('hide');
			return;
		}else{
			$('#profile .confirm-new-password').next().addClass('hide');
		}

		UserService.changePassword(ACCESS_TOKEN, oldPass, newPass).then(function(result){
			var rs = result.data.result;
			if(rs == 2){
				$('#profile .old-password').focus();
				$('#profile .old-password').next().removeClass('hide');
				$('#profile .msg').removeClass('hide').removeClass('msg-success').text('Mật khẩu cũ không đúng');
				setTimeout(function(){
					$('#profile .msg').addClass('hide');
				}, 3000);
			}else if(rs == 0){
				$('#profile .msg').removeClass('hide').addClass('msg-success').text('Thay đổi mật khẩu thành công');
				setTimeout(function(){
					$('#profile .msg').addClass('hide');
				}, 3000);
			}
		});


	}
}]);

dcvController.controller('HomeCtrl', ['$scope', function($scope){
	
}]);