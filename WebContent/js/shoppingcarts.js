$(function(){
	$('button[value="delete"]').click(function(){
		$(this).parent().parent().empty();
	})
	$('input[value="+"]').click(function(){
		var n = $(this).prev().attr('value');
		$(this).prev().attr("value",parseInt(n) + 1);
		$('.quantity').trigger('click');
		TotalPrice();
	})
	$('input[value="-"]').click(function(){
		var n = $(this).next().attr('value');
		if(n==1){
			alert("Please Delete It！")
		}else{
			$(this).next().attr("value",parseInt(n) - 1);
			$('.quantity').trigger('click');
			TotalPrice();
		}
	})
	$('.quantity' ).click(function() {
		var prr = $(this).parent().prev().children().text();
		var cont = $(this).attr("value");
		$(this).parent().next().children().html(prr * cont * 1)
	})
	function TotalPrice() {
		var total = 0;
		$('.toalprie').each(function() {
			total += parseInt(($(this).text()));
		});
		$('.shopingcarts_total').children().text(total);
	}
})