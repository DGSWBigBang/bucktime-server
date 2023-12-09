let cafeInfo = {
    cafeIdx: 0,
    cafeName: "",
    cafeDescription: "",
    openTime: "",
    closeTime: "",
    callNumber: ""
}

function submit() {
    cafeInfo.cafeName = document.getElementById('cafeName').value;
    cafeInfo.cafeDescription = document.getElementById('cafeDescription').value;
    cafeInfo.openTime = document.getElementById('openTime').value;
    cafeInfo.closeTime = document.getElementById('closeTime').value;
    cafeInfo.callNumber = document.getElementById('cafeNumber').value;

    $.ajax({
        method: "put",
        url: "/cafe/modify",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(cafeInfo),

        success: function (response) {
            location.reload();
        },

        error: function (error) {
            console.log(error);
        }
    })
}

$.ajax({
    method: "get",
    url: "/cafe/show/owner",
    contentType: "application/json; charset=utf-8",

    success: function (response) {
        cafeInfo = response;
        document.getElementById('cafeName').value=`${cafeInfo.cafeName}`;
        document.getElementById('openTime').value=`${cafeInfo.openTime}`;
        document.getElementById('closeTime').value=`${cafeInfo.closeTime}`;
        document.getElementById('cafeDescription').value=`${cafeInfo.cafeDescription}`;
        document.getElementById('cafeNumber').value=`${cafeInfo.callNumber}`;
    },

    error: function (error) {
        console.log(error);
    }
})