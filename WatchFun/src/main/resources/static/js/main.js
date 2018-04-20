
function main() {

(function () {
   'use strict';
   
  	$('a.page-scroll').click(function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
          var target = $(this.hash);
          target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
          if (target.length) {
            $('html,body').animate({
              scrollTop: target.offset().top - 40
            }, 900);
            return false;
          }
        }
      });

	// affix the navbar after scroll below header
$('#nav').affix({
      offset: {
        top: $('header').height()
      }
});	

	
  	// Watchfun isotope movie filter
    $(window).load(function() {
        var $container = $('.watchfun-movies');
        $container.isotope({
            filter: '.mov-all',
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        $('.mov a').click(function() {
            $('.mov .active').removeClass('active');
            $(this).addClass('active');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });
        
        

    });
	

    // Nivo Lightbox 
    $('.watchfun-movie a').nivoLightbox({
            effect: 'slideDown',  
            keyboardNav: true,                            
        });
    
    
 // Watchfun isotope novel filter
    $(window).load(function() {
        var $container = $('.watchfun-novels');
        $container.isotope({
            filter: '.nov-all',
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        $('.nov a').click(function() {
            $('.nov .active').removeClass('active');
            $(this).addClass('active');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });
        
        

    });
	

    // Nivo Lightbox 
    $('.watchfun-novel a').nivoLightbox({
            effect: 'slideDown',  
            keyboardNav: true,                            
        });
    
    
 // Watchfun isotope tvseries filter
    $(window).load(function() {
        var $container = $('.watchfun-tvseriess');
        $container.isotope({
            filter: '.tvs-all',
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        $('.tvs a').click(function() {
            $('.tvs .active').removeClass('active');
            $(this).addClass('active');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });
        
        

    });
	

    // Nivo Lightbox 
    $('.watchfun-tvseries a').nivoLightbox({
            effect: 'slideDown',  
            keyboardNav: true,                            
        });
 

}());


}
main();