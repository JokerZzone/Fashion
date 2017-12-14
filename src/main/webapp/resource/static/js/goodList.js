//点击快速录入和添加新商品
$(".luru").click(function(){
	var bg_position =$(this).css("backgroundPosition");
	if(bg_position=="-66px -1162px") {
		$(this).css("background","url(../img/goodsList/sprit.png) no-repeat -66px -1109px");
	}else {
		$(this).css("background","url(../img/goodsList/sprit.png) no-repeat -66px -1162px");
	}
})
$(".tianjia").click(function(){
	var bg_position =$(this).css("backgroundPosition");
	if(bg_position=="-66px -1213px"){
		$(this).css("background","url(../img/goodsList/sprit.png) no-repeat -66px -1258px");
	}else {
		$(this).css("background","url(../img/goodsList/sprit.png) no-repeat -66px -1213px");
	}
	
})
//点击编号全选
$("#chooseAll").click(function(){
	$(".choose").prop("checked", this.checked);
})
//点击单选
$(".choose").click(function(){
	$("#chooseAll").prop("checked",$(".choose:checked").length==$(".choose").length);
})
//点击删除
$(".remove").click(function(){
	$(this).parents("tr").remove();
})
