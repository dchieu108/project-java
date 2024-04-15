var listProduct = [
    {
      id: 1,
      name: "ELENI",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2F2%2F0%2F2023-07-18_08-44-10_b_radius8_smoothing4_.png&w=640&q=75",
      priceBefore: "320.000",
      priceAfter: "500.000",
    },
    {
      id: 2,
      name: "CHIARA",
      sales: "-30%",
      
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fe%2Fl%2Feleni_1_.png&w=1920&q=75",
      priceBefore: "200.000",
      priceAfter: "400.000",
    },
    {
      id: 3,
      name: "HELIA",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fg%2Fh%2Fgh-05-001.png&w=1920&q=75",
      priceBefore: "100.000",
      priceAfter: "150.000",
    },
    {
      id: 4,
      name: "LUCIA",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fg%2Fh%2Fgh-01-001.png&w=1920&q=75",
      priceBefore: "300.000",
      priceAfter: "235.000",
    },
  
    {
      id: 5,
      name: "STELLA",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fc%2Fu%2Fcuff-stella-sil.png&w=640&q=75",
      priceBefore: "600.000",
      priceAfter: "425.000",
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