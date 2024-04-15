$(document).ready(function () {
    $('.image-slider').slick({
        slidesToShow: 5,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
       
        arrows: false,
        responsive: [{
            breakpoint: 768,
            settings: {
                arrows: false,
                centerMode: true,
                centerPadding: '2px',
                slidesToShow: 3,
            }
        }],
    });

    $('.CSKH-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        arrows: false,
        
    });

    $('.banner-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
       
        arrows: false,
        dots: true,
        
       
    });
    
    
})