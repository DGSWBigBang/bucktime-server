const Table = document.querySelectorAll(".Table");
const Capacity = document.querySelectorAll(".Capacity");
const Price = document.querySelectorAll(".Price");

$.ajax({
    url: "/desk/show/owner",
    method: "get",
    contentType: "application/json; charset=utf-8",
    async: true,

    success: function (response) {
        response.forEach((element, index) => {
            Table[index].innerHTML = element.deskName;
            Capacity[index].innerHTML = `${element.capacity} 인용`;
            Price[index].innerHTML = `${element.price}원/시`;
        })
    },

    error: function (error) {
        console.log(error)
    }
})

// 주문 가져오기
getOrder();

const addButton = document.getElementById("Add");
const shadowBox = document.getElementById("ShadowBox");

addButton.addEventListener("click", () => {
    shadowBox.classList.toggle("hidden");
});

function getOrder() {
    const OrderBox = document.getElementById("OrderBox");

    $.ajax({
        url: "/order/show/owner",
        method: "get",
        contentType: "application/json; charset=utf-8",

        success: function (response) {
            response.forEach((element) => {
                let LocalOrder = document.createElement("div");

                LocalOrder.classList.add("eachOrder")

                LocalOrder.innerHTML = `
                  <div class="Order">
                    <div class="Complete" onclick="complete(${element.orderIdx})">V</div>
                    <span class="orderNum">No. ${element.orderIdx}</span>
                    <p class="orderContent">${element.menuName}</p>
                    <span class="orderPrice">3000 원</span>
                  </div>
                `;

                OrderBox.appendChild(LocalOrder);
            })
        },

        error: function (error) {
            console.log(error);
        }
    })
}

function complete(orderIdx) {
    $.ajax({
        url: "/order/modify/completion",
        method: "put",
        data: {'order-idx' : orderIdx},

        success: function (response) {
            location.href="/front/cafe/order";
            location.reload();
        },

        error: function (error) {
            console.log(error);
        }
    });
}