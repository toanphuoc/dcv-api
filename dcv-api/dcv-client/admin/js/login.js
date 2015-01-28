jQuery(document).ready(function() {
	$('#admin .login').unbind('click').click(function(event) {
		var username = $('#admin .username').val();
		var password = $('#admin .password').val();
		if(username == null || username.trim() == ''){
			$('#admin .username').focus();
			return;
		}


		if(password == null || password.trim() == ''){
			$('#admin .password').focus();
			return;
		}

		$.ajax({
			method : 'POST',
			dataType: 'json',
			url: BASE_URL + 'user/login',
			data: {
				username: username,
				password: password
			},
			success: function(json){
				if(json.success){
					$.cookie('user', json.user.userName);
					$.cookie('access_token', json.access_token);
					window.location.href = "dashboard.html";
				}else{
					$('#admin .msg').removeClass('hide');
					setTimeout(function(){
						$('#admin .msg').addClass('hide');
					}, 3000);
				}
			}
		});
	});
});