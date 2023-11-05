

(() => {
	
	
	const agent = {
		init: function() {
			this.setEventHandlers();
		},
		
		setEventHandlers: function() {
			$("#btn_login").on("click", () => {
				this.doLogin();
			});
		},
		
		doLogin: function() {
			const valid = this.checkInput();

			if (valid) {
				const data = $("#theForm").serializeObject();
				
				$.ajax({
					method: "post",
					url: "/user/login",
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify(data),
					
					success: function(response) {
						console.log("token", response.accessToken);
						$.cookie('tokens', response.accessToken, { expires: 7, path: '/' });
					},
					
					error: function(xhr) {
						console.log(xhr);
						if (xhr.responseJSON.message == "User not found") {
							alert("등록된 사용자가 아닙니다.");
						} else if (xhr.responseJSON.message == "Password mismatch") {
							alert("비밀번호가 올바르지 않습니다");
						} else {
							alert("로그인에 실패하였습니다.");
						}
						
					}
				});
			}
		},
		
		checkInput: function() {
			let valid = true;
			
			valid &= $("#theForm [name='userMail']").checkRequired(valid);
			valid &= $("#theForm [name='password']").checkRequired(valid);
			
			return valid;
		},
		
	};
	
	
	agent.init();
		
	
})();