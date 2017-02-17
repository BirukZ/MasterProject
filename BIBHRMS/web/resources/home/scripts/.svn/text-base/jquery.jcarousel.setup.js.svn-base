$(document).ready(function () {

    function mycarousel_initCallback(carousel) {
        jQuery('.jcarousel-control a').bind('click', function () {
            carousel.scroll(jQuery.jcarousel.intval(jQuery(this).text()));
            return false;
        });

        $('#featured-item-next').bind('click', function () {
            carousel.next();
            return false;
        });
        $('#featured-item-prev').bind('click', function () {
            carousel.prev();
            return false;
        });

        // Disable autoscrolling if the user clicks the prev or next button.
        carousel.buttonNext.bind('click', function () {
            carousel.startAuto(0);
        });

        carousel.buttonPrev.bind('click', function () {
            carousel.startAuto(0);
        });

        // Pause autoscrolling if the user moves with the cursor over the clip.
        carousel.clip.hover(function () {
            carousel.stopAuto();
        }, function () {
            carousel.startAuto();
        });

    };

    $('#featured_content').jcarousel({
        scroll: 1,
        //    auto: 5, // Sets the time delay between automatic scrolling of the panel
         wrap: 'last',
        initCallback: mycarousel_initCallback,
        // this sets the selected link style
        itemVisibleInCallback: {
            onAfterAnimation: function (c, o, i, s) {
                if(s!='init'){
                    if(i<9)i+=8;
                    else if(i>17)i-=10;
                    if(i==10)rotateNext();
                    else if(i==18)rotateNext();
                }
                i = (i - 1) % $('#featured_content ul li').size();
                jQuery('.jcarousel-control ul li a').removeClass('active').addClass('inactive');
                jQuery('.jcarousel-control ul li a:eq(' + i + ')').removeClass('inactive').addClass('active');


            }
        } ,
        // This tells jCarousel NOT to autobuild prev/next buttons
        buttonNextHTML: null,
        buttonPrevHTML: null
    });

});