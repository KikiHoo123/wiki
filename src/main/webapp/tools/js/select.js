$(function() {
    
    /*妯℃嫙select鍔熻兘銆€begin*/
    (function() {


        var $startLi, //绉诲姩鐨勫垵濮嬭妭鐐�
        $currentLi, //绉诲姩鐨勫綋鍓嶈妭鐐�
        currentIndex, //褰撳墠鑺傜偣鐨勭储寮�
        startIndex, //鍒濆绱㈠紩
        maxIndex, //鏈绉诲姩鐨勬渶澶х储寮�
        minIndex, //鏈绉诲姩鏈€灏忕储寮�
        isMoving;//鏄惁鍦ㄧЩ鍔ㄤ腑
        
        //閬垮厤閲嶅缁戝畾锛屽厛瑙ｇ粦浜嬩欢銆�
        $('body').off('.ul_select_event');
        
        //鏁版嵁鍚屾銆備粎浠呮槸浠庢ā鎷熺殑鍚屾鍒板師鐢熺殑銆�
        function setSelectVal() {
            $(".ori_select").val('');
            $('.ul_select .choosed').each(function(index, el) {
                var val = $.trim($(this).attr('value'));
                $('.ori_select option[value="' + val + '"]').prop('selected', true);
            });
        }

        //涓嶄娇鐢╟trl,鍗曢€夌殑鏃跺€欓€変腑閫夐」
        $("body").on('click.ul_select_event', '.ul_select li', function(event) {
            $(this).toggleClass('choosed');
            setSelectVal();
        });

        //榧犳爣鎸変笅鍘荤殑浜嬩欢銆�
        $("body").on('mousedown.ul_select', '.ul_select li', function(event) {
            
            //mousedown鐨勬椂鍊欙紝閮ㄥ垎鏁版嵁闇€瑕佸垵濮嬪寲銆�
            $startLi = $(this);
            startIndex = maxIndex = minIndex = $startLi.index();

            //寤舵椂涓€鐐广€傜粦瀹氥€備竴瀹氱▼搴﹂伩鍏嶇偣鍑讳簨浠惰窡绉诲姩浜嬩欢鐨勫啿绐併€�
            setTimeout(function() {
                $(".ul_select li").on('mousemove', function(event) {

                    isMoving = true;

                    $currentLi = $(this);
                    currentIndex = $currentLi.index();

                    if (currentIndex > maxIndex) {
                        maxIndex = currentIndex;
                    }

                    if (currentIndex < minIndex) {
                        minIndex = currentIndex;
                    }

                    for (var i = minIndex; i <= maxIndex; i++) {
                        $('.ul_select li').eq(i).removeClass('choosed');
                    }
                   
                    if (currentIndex >= startIndex) {

                        for (var i = startIndex; i <= currentIndex; i++) {
                            $('.ul_select li').eq(i).addClass('choosed');
                        }

                    } else {                        

                        for (var i = startIndex; i >= currentIndex; i--) {
                            $('.ul_select li').eq(i).addClass('choosed');
                        }

                    }

                })
            }, 50)

        });

        //缁撴潫绉诲姩鐘舵€�
        $("body").on('mouseup.ul_select_event', function(event) {
            $(".ul_select li").off('mousemove');
            if (isMoving) {
                isMoving = false;
                setSelectVal();
            }

        });

    })();
    /*妯℃嫙select鍔熻兘銆€end*/
});