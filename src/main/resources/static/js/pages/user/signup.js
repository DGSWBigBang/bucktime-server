

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
					},
					
					fail: function(xhr) {
						console.log(xhr);
					}
				});
			}
		},
		
		checkInput: function() {
			$("#theForm [name='userMail']").checkRequired();
			
			return false;
		},
		
	};
	
	
	agent.init();
		
	
})();