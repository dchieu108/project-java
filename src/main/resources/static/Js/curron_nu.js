var listProduct = [
    {
      id: 1,
      name: "MOONSTARE",
      sales: "-20%",
      category: "AURORA",
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fs%2Fe%2Fserene.png&w=640&q=75",
      priceBefore: "2.000.000",
      priceAfter: "5.000.000",
    },
    {
      id: 2,
      name: "CITRINE",
      sales: "-20%",
      category: "AURORA",
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2F2%2F_%2F2_1_.png&w=640&q=75",
      priceBefore: "8.000.000",
      priceAfter: "10.000.000",
    },
    {
      id: 3,
      name: "BELLINI",
      sales: "-20%",
      category: "AURORA",
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fb%2Fe%2Fbellini_2.png&w=640&q=75",
      priceBefore: "1.500.000",
      priceAfter: "3.000.000",
    },
    {
      id: 4,
      name: "GARI",
      sales: "-20%",
      category: "AURORA",
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fm%2Fa%2Fmassimo.png&w=640&q=75",
      priceBefore: "5.500.000",
      priceAfter: "8.000.000",
    },
  
    {
      id: 5,
      name: "MASSIMO",
      sales: "-20%",
      category: "AURORA",
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fs%2Fk%2Fsky.2.png&w=640&q=75",
      priceBefore: "4.600.000",
      priceAfter: "7.500.000",
    },
    {
      id: 6,
      name: "ROVE",
      sales: "-20%",
      category: "SICILY",
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fc%2Fo%2Fcora.1.png&w=640&q=75",
      priceBefore: "3.600.000",
      priceAfter: "6.000.000",
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
                        <button>Thêm giỏ hàng</button>
                        </div>
                      </div>`;
  
      $(".list-product").append(view2);
    }
  }