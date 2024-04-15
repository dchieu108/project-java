var listProduct = [
    {
      id: 1,
      name: "DÂY CAO SU",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fm%2Fe%2Fmesh-sil.png&w=640&q=75",
      priceBefore: "320.000",
      priceAfter: "500.000",
    },
    {
      id: 2,
      name: "DÂY Mạ Vàng",
      sales: "-30%",
      
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fv%2F_%2Fv_ng_bi6433-edit_2.png&w=640&q=75",
      priceBefore: "200.000",
      priceAfter: "400.000",
    },
    {
      id: 3,
      name: "DÂY DA",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fd%2F_%2Fd.mykonos.browns.png&w=640&q=75",
      priceBefore: "100.000",
      priceAfter: "150.000",
    },
    {
      id: 4,
      name: "DÂY KIM LOẠI",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fm%2Fe%2Fmesh.rosegold_1.png&w=640&q=75",
      priceBefore: "300.000",
      priceAfter: "235.000",
    },
  
    {
      id: 5,
      name: "DÂY VẢI",
      sales: "-30%",
     
      avatar:
        "https://curnonwatch.com/_next/image/?url=https%3A%2F%2Fshop.curnonwatch.com%2Fmedia%2Fcatalog%2Fproduct%2Fc%2Fa%2Fcaramel.rosegold.png&w=640&q=75",
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