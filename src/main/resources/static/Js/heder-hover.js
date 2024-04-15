$(document).ready(function () {
  $(".nav-content-item").hide();
  $(".nav-content-item:first-child").fadeIn();
  $(".gender-left .gender-item").hover(
    function () {
      var act = $(this).attr("data-active");
      if (act == "false") {
        $(".gender-left .gender-item").removeClass("active");
        $(this).addClass("active");

        $(".gender-left .gender-item").attr("data-active", "false");
        $(this).attr("data-active", "true");

        //show tab-content item
        let id_nav_content = $(this).attr("href");
        localStorage.setItem("id_nav_cotent", id_nav_content);

        $(".nav-content-item").hide();
        $(id_nav_content).fadeIn();
        return false;
      }
    },
    function () {
      // $(".gender-left .gender-item:first-child").addClass("active");
      $(".gender-left .gender-item").removeClass("active");
    }
  );
});

$(document).ready(function () {
  $(".option-content-item").hide();
  $(".menu-left .nav-item").hover(
    function () {
      $(".nav-content .nav-content-item:first-child").css("display", "flex");
      $(".gender-left .gender-item:first-child").addClass("active");

      var act = $(this).attr("data-option");
      if (act == "false") {
        $(".menu-left .nav-item").removeClass("active");
        $(this).addClass("active");

        $(".menu-left .nav-item").attr("data-option", "false");
        $(this).attr("data-option", "true");

        //show tab-content item
        let id_ops_content = $(this).attr("href");
        localStorage.setItem("id_ops_content", id_ops_content);
        // alert(id_tab_content)
        $(".option-content .option-content-item").hide();
        $(id_ops_content).fadeIn();

        return false;
      }
    },
    function () {
      $(".menu-left .nav-item").removeClass("active");

      // $(".menu-left .nav-item").attr("data-option", "false");
      // $(this).attr("data-option", "false");
    }
  );
});
$(document).ready(function () {
  $("section").hover(function () {
    $(".option-content-item").hide();
  });
});
