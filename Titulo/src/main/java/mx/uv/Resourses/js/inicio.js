$('.form').find('imput', 'txtarea').on('keyup blus focus', function(e){
    var $this = $(this),
    label = $this.prev('label');

    if(e.type ==='keyup'){
        if($this.val()===''){
            label.removeClass('active highlight');
        }else{
            label.addClass('active highlight');
        }
    }else if(e.type ==='blur'){
        if($this.val()===''){
            label.removeClass('active highlight');
        }else{
            label.removeClass('highlight');
        }
    }else if(e.type ==='blur'){
        if($this.val()===''){
            label.removeClass('highlight');
        }else if ($this.val()!=='');{
            label.addClass("highlight")
        }
    }
});

$('.tab a').on('click', function(e){
    e.preventDefault();

    $(this).parent().addClass('active');
    $(this).parent().sublings().removeClass('active');
    target=$(this).attr('href');
    $('.tab contect > div').not(target).hide();
    $(target).fadeIn(600);
});