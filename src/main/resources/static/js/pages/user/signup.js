

(() => {
	
	
	const agent = {
		init: function() {
			this.setEventHandlers();
		},
		
		setEventHandlers: function() {
			$("#btn_save").on("click", () => {
				this.save();
			});
		},
		
		save: function() {
			const valid = this.checkInput();

			if (valid) {
				const data = $("#theForm").serializeObject();
				
				$.ajax({
					method: "post",
					url: "/user/create",
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify(data),
					
					success: function(response) {
						console.log("response", response);
						alert("회원 가입이 완료되었습니다.");
						location.href = "/front/user/signin";
					},
					
					fail: function(xhr) {
						console.log(xhr);
					}
				});
			}
		},
		
		checkInput: function() {
			let valid = true;
			
			valid &= $("#theForm [name='userMail']").checkRequired(valid);
			valid &= $("#theForm [name='userName']").checkRequired(valid);
			valid &= $("#theForm [name='phoneNumber']").checkRequired(valid);
			valid &= $("#theForm [name='userPassword']").checkRequired(valid);


			if (valid) {
				valid = 
						($("#theForm [name='userPassword']").val().trim() 
								== $("#theForm [name='userPasswordConfirm']").val().trim());
								
				if (!valid) {
					$("#theForm [name='userPasswordConfirm']").focus();
					alert("비밀번호를 확인하세요.");
				}								
			}
			
			return valid;
		},
		
	};
	
	
	agent.init();
		
	
})();