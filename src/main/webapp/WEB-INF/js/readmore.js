// var $j = jQuery.noConflict();
// $j('.entry-content').each(function() {
//     var $pTag = $(this).find('p');
//     if($pTag.text().length > 100){
//         var shortText = $pTag.text();
//         shortText = shortText.substring(0, 100);
//         $pTag.addClass('fullArticle').hide();
//         shortText += '<a href="#" class="read-more-link">Show more text ></a>';
//         $pTag.append('<a href="#" class="read-less-link">&lt; Show less text</a>');
//         $(this).append('<p class="preview">'+shortText+'</p>');
//     }
// });
//
// $(document).on('click', '.read-more-link', function () {
//     $(this).parent().hide().prev().show();
// });
//
// $(document).on('click', '.read-less-link', function () {
//     $(this).parent().hide().next().show();
// });

(function ( $ ) {
    // Global method
    jQuery.readMore = function(options) {
        // Default selector
        var settings = $.extend({
            selector: ".read-more"
        }, options);

        // Run read more
        $(settings.selector).readMore(options);
    };

    // Selector method
    $.fn.readMore = function( options ) {
        // This is the easiest way to have default options.
        var settings = $.extend({
            // These are the defaults.
            previewHeight: 120,
            expandTrigger: ".prompt",
            fadeColor1: "rgba(255,255,255,0)",
            fadeColor2: "rgba(255,255,255,1)"
        }, options );

        // Run this on the container
        return this.each(function() {
            // Get elements
            var $container = $(this);
            var $expand = $container.find(settings.expandTrigger);

            // Get the height of the container
            var totalHeight = $container[0].scrollHeight;

            // Check if total height is too big
            if(totalHeight <= $container.height()) {
                // Does not require read-more
                $container.css('max-height', 'none');
                $expand.hide();
            } else {
                // Set the preview window height
                $container.css('max-height', settings.previewHeight + 'px');
                $expand.css('padding-top', (settings.previewHeight/2) + 'px');
            }

            // Set the fade color
            $expand.css({
                'background-image':
                    'linear-gradient(to bottom, ' + settings.fadeColor1 + ', ' + settings.fadeColor2 + ')'
            });

            $expand.on('click', function() {
                // Set height to prevent instant jump-down when max height is removed
                $container
                    .css({ "height": $container.height(), "max-height": 99999 })
                    .animate({ "height": totalHeight });

                $expand.fadeOut(); // fade out prompt
                return false; // prevent default jump-down action
            });
        });
    };

}( jQuery ));