
var listProduct = [
  {
    id: 1,
    name: "WANDER",
    sales: "-20%",
    category: "WHITESANDS",
    avatar:
      "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2F1%2F_%2F1_brown4_1_1.png&w=640&q=75",
    priceBefore: "6.560.000",
    priceAfter: "8.250.000",
  },
  {
    id: 2,
    name: "ASPIRE",
    sales: "-20%",
    category: "WHITESANDS",
    avatar:
      "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2F1%2F_%2F1_green5_2.png&w=640&q=75",
    priceBefore: "1.200.000",
    priceAfter: "3.000.000",
  },
  {
    id: 3,
    name: "ALTER",
    sales: "-20%",
    category: "WHITESANDS",
    avatar:
      "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2F1%2F_%2F1_white_blue8.png&w=640&q=75",
    priceBefore: "4.850.000",
    priceAfter: "5.300.000",
  },
  {
    id: 4,
    name: "FLOW",
    sales: "-20%",
    category: "WHITESANDS",
    avatar:
      "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fs%2Fh%2Fshift_-_1_.png&w=640&q=75",
    priceBefore: "1.200.000",
    priceAfter: "1.800.000",
  },

  {
    id: 5,
    name: "SHIFT",
    sales: "-20%",
    category: "WEIMAR",
    avatar:
      "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fr%2Fo%2Frove_1.png&w=640&q=75",
    priceBefore: "6.790.000",
    priceAfter: "7.950.000",
  },
  {
    id: 6,
    name: "ROVE",
    sales: "-20%",
    category: "WEIMAR",
    avatar:
      "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fv%2Fa%2Fvary_1.png&w=640&q=75",
    priceBefore: "6.300.000",
    priceAfter: "7.590.000",
  },
];

$(document).ready(function () {
  logView();
});
function logView() {
  for (var i = 0; i < listProduct.length; i++) {
    let view2 = ` <div class="product-item w-25 position-rel ">
                      <div class="product-cate position-rel">
                          <div><img src="${listProduct[i].avatar}" class="w-100" alt="cate"></div>
                          <div class="product-sale">${listProduct[i].sales}</div>
                      </div>
                      <div class="product-name text-center">
                          <h4>${listProduct[i].category}</h4>
                          <h3>${listProduct[i].name}</h3>
                          <p>
                              <span class="fw-900">${listProduct[i].priceBefore}</span>
                              <span class="text-through">${listProduct[i].priceAfter}</span>
                          </p>
                      </div>
                      <button class="btn">Thêm giỏ hàng</button>
                      </div>
                    </div>`;

    $(".list-product").append(view2);
  }
}






