function test1()
 {
  
 
}
$(document).ready(function () {
  
  $(".tab-content-item").hide();
  $('.tab-content-item:first-child').fadeIn();
  $(".nav-tabs li").hover(function () {
   var act = $(this).attr("data-boolean");
 
  if (act == "false") {
    $(".nav-tabs li").removeClass("active");
    $(this).addClass("active");

    $(".nav-tabs li").attr("data-boolean", "false");
    $(this).attr("data-boolean", "true");
    //show tab-content item
    let id_tab_content = $(this).children("a").attr("href");
    localStorage.setItem("id_tab_cotent", id_tab_content);
    // alert(id_tab_content)
    $(".tab-content-item").hide();
    $(id_tab_content).fadeIn();
    return false;
  }
  }

  );
});



$(document).ready(function () {
  $("body").hover(function () {
    $(".option-content-item").hide();
  });
});
////////////////////////
// const $ = document.querySelector.bind(document);
// const $$ = document.querySelectorAll.bind(document);

// const tabs = $$(".tab-item");
// const panes = $$(".tab-content-item");

// const tabActive = $(".tab-item.active");

// // SonDN fixed - Active size wrong size on first load.
// // Original post: https://www.facebook.com/groups/649972919142215/?multi_permalinks=1175881616551340

// tabs.forEach((tab, index) => {
//   const pane = panes[index];

//   tab.onmouseover = function () {

//     $(".tab-item.active").classList.remove("active");
//     $(".tab-content-item.active").classList.remove("active");

//     this.classList.add("active");
//     pane.classList.add("active");
//   };
// });
//////////////////////////
