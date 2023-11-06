const createMenuRequest = () => {
    let postData = {
        menuName : document.getElementById("menuName").value,
        menuDescription : document.getElementById("menuDescription").value,
        menuPrice : document.getElementById("menuPrice").value
    }

    $.ajax({
        method: "put",
        url: "/menu/modify",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(postData),

        success: function(response) {
            console.log("response", response);
            location.href="/front/cafe/menu";
        },

        error: function(xhr) {
            console.log(xhr);
        }
    });
}