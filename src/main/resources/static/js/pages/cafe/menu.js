

(() => {
	
	const agent = {
		init: function() {
			this.readList(() => {
				this.showList();
			});
		},
		
		
		readList: function(callback) {
			$.ajax({
				method: "GET",
				url: "/menu/show/owner",
				success: (response) => {
					console.log(response);
					this.list = response;
					callback();
				}
				
			});
		},
		
		showList: function() {
			$("#list_body").empty();
			
			for (let item of this.list) {
				let line = $("#listTemplate").tmpl(item);
				line.find("button.btn_modify").on("click", () =>{
					location.href = "/front/cafe/menu/modify?menu-idx=" + item.menuIdx;
				});
				$("#list_body").append(line);
			}
		}
		
	};
	
	
	agent.init();
	
	
})();