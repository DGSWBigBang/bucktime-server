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
            Capacity[index].innerHTML = element.capacity;
            Price[index].innerHTML = element.price;
        })
    },

    error: function (error) {
        console.log(error)
    }
})

// 주문 가져오기
getOrder();

// 메뉴 추가 이벤트
document
    .getElementById("AddBox")
    .addEventListener("submit", function (event) {
        event.preventDefault();

        const menuName = document.getElementById("menuName").value;
        const menuDescription = document.getElementById("menuDescription").value;
        const menuPrice = document.getElementById("menuPrice").value;

        fetch("http://timebucks.kro.kr/menu/create", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authorization: "Bearer " + localStorage.getItem("accessToken"),
            },
            body: JSON.stringify({
                menuName: menuName,
                menuDescription: menuDescription,
                menuPrice: parseInt(menuPrice, 10),
                cafeIdx: 0,
            }),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(
                        "Network response was not ok " + response.statusText
                    );
                }
                return response.json();
            })
            .then((data) => {
                console.log(data);

                window.location.href =
                    "http://localhost:5500/src/owner/menu/menu.html";
            })
            .catch((error) => {
                console.error(
                    "There has been a problem with your fetch operation:",
                    error
                );
            });
    });

// Add 버튼을 눌렀을 때
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

                LocalOrder.innerHTML = `
                  <div class="Order">
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