$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/city/province",
	data:{id:0},
	success:function(data){
		console.log(data);
		var content = "";
		var content2 = `<option value="">请选择...</option>`;
		for(i in data){
			content += `<option value=${data[i].cityId}>${data[i].cityName}</option>`
		}
		$("#province").html(content2+content);
	}
})
$("#province").bind("change",function(){
	$.ajax({
		type:"get",
		url:"http://118.89.25.129:8080/Fashion/city/province",
		data:{id:$("#province").find("option:selected").val()},
		success:function(data){
			var content3 = "";
		var content4 = `<option value="">请选择...</option>`;
		for(i in data){
			content3 += `<option value=${data[i].cityId}>${data[i].cityName}</option>`
		}
		$("#city").html(content4+content3);
		}
	})
	
})
$("#city").bind("change",function(){
	$.ajax({
		type:"get",
		url:"http://118.89.25.129:8080/Fashion/city/province",
		data:{id:$("#city").find("option:selected").val()},
		success:function(data){
			var content3 = "";
		var content4 = `<option value="">请选择...</option>`;
		for(i in data){
			content3 += `<option value=${data[i].cityId}>${data[i].cityName}</option>`
		}
		$("#area").html(content4+content3);
		}
	})
	
})
$("input[name='submit1']").on("click",function(){
	console.log($("input[name='realname']").val());
	console.log($("input[name='cellphone']").val());
	console.log($("input[name='email']").val());
	console.log($("#province").find("option:selected").val());
	console.log($("#city").find("option:selected").val());
	console.log($("#city").find("option:selected").val());
	console.log($("#area").find("option:selected").val());
	console.log($("input[name='address']").val());
	console.log($("input[name='youbian']").val());
	$.ajax({
		type:"get",
		url:"http://118.89.25.129:8080/Fashion/address/add",
		data:{
			"address.consignee": "王浩",
			"address.mobile":"18895702010",
			"address.email":"1171084136@qq.com",
			"address.province":2,
			"address.city":1,
			"address.country":3,
			"address.address":"安徽六安金寨县差点死掉",
			"address.zipcode":"237200"
		},
		success:function(data){
			console.log(1111);
		}
	})
})
//移入全部商品分类
$(".first_list dl").mouseover(function(){
	$(this).children("dd").css("display","block");
})
$(".first_list dl").mouseout(function(){
	$(this).children("dd").css("display","none");
})
$(".left_list").css("display","none");
$(".first_list").mouseover(function(){
	$(".left_list").css("display","block");
})
$(".first_list").mouseout(function(){
	$(".left_list").css("display","none");
})

//管理收货单地址

// 左边的点击事件
var arrS = ["订单查询","账户余额","累积消费/积分","优惠券/礼品卡","收货人地址薄","个人资料","修改密码","我的评论","我的提问","收藏夹"];
$(".accountList1 a").each(function(index,obj){
	$(".accountList1 a").eq(index).on("click",function(){
		for(var i=0;i<$(".asa").length;i++){
			$(".asa").eq(i).css({
				display: "none",
			})
		}
		$(".accountContentList").css({
			display: "none",
		});
		$(".asa").eq(index).css({
			display: "block",
		})
		$(".accountRightTopWord").html(arrS[index]);
	})
})
// 订单查询
$(".accountRightOne li").each(function(index,obj){
	$(this).on("click",function(){	
		for(var i=0;i<$(".accountRightOne li").length;i++){
			$(".accountRightOne li").eq(i).css({
				backgroundPosition: "left -25px",
			})
			$(".accountRightTable1").eq(i).css({
				display: "none",
			})
		}
		$(".accountRightOne li").eq(index).css({
				backgroundPosition: "left top",
			})
		$(".accountRightTable1").eq(index).css({
				display: "block",
			})
	})
})
// 账户余额
$(".accountRightTwo li").each(function(index,obj){
	$(this).on("click",function(){	
		for(var i=0;i<$(".accountRightTwo li").length;i++){
			$(".accountRightTwo li").eq(i).css({
				backgroundPosition: "left -25px",
			})
			$(".accountRightTable2").eq(i).css({
				display: "none",
			})
		}
		$(".accountRightTwo li").eq(index).css({
				backgroundPosition: "left top",
			})
		$(".accountRightTable2").eq(index).css({
				display: "block",
			})
	})
})
// 累积消费，积分
$(".accountRightThree li").each(function(index,obj){
	$(this).on("click",function(){	
		for(var i=0;i<$(".accountRightThree li").length;i++){
			$(".accountRightThree li").eq(i).css({
				backgroundPosition: "left -25px",
			})
			$(".accountRightTable3").eq(i).css({
				display: "none",
			})
		}
		$(".accountRightThree li").eq(index).css({
				backgroundPosition: "left top",
			})
		$(".accountRightTable3").eq(index).css({
				display: "block",
			})
	})
})
// 优惠券
$(".accountRightFour li").each(function(index,obj){
	$(this).on("click",function(){	
		for(var i=0;i<$(".accountRightFour li").length;i++){
			$(".accountRightFour li").eq(i).css({
				backgroundPosition: "left -25px",
			})
			$(".accountRightTable4").eq(i).css({
				display: "none",
			})
		}
		$(".accountRightFour li").eq(index).css({
				backgroundPosition: "left top",
			})
		$(".accountRightTable4").eq(index).css({
				display: "block",
			})
	})
})
// 请输入充值码
$(".rechargeBtn").click(function(){
	if($(".cardnumber").html()==""){
		$(".amd1").css({
			display: "block",
		})
	}
})
// 聚焦充值码则隐藏
$(".cardnumber").focus(function(){
	console.log(123);
	$(".amd1").css({
			display: "none",
		})
}) 
/**********************************个人资料开始*******************************************************/
// 姓名的input框
//聚焦
$(".accountInput1").on("focus",function(){
	// 警告框消失
	$(this).next().hide();
});
// 失焦
$(".accountInput1").on("blur",function(){
	// 判定用户名是否合法
	dataName();
})
// 电子邮件
// 聚焦事件
$(".accountInput3").on("focus",function(){
	// 警告框消失
	$(this).next().hide();
});
// 失焦事件
$(".accountInput3").on("blur",function(){
	// 判定电子邮件是否合法
	dataMail();
});
// 手机
// 聚焦事件
$(".accountInput4").on("focus",function(){
	$(this).next().hide();
})
// 失焦事件
$(".accountInput4").on("blur",function(){
	// 判定手机是否合法
	checkPhone();	
})
// 地区的部分


// 函数的部分
// 姓名
function dataName(){
	var reg = /^[\u4E00-\u9FA5]{2,4}$/;
	// 名字的不为空
	if($(".accountInput1").val()==""){
		$(".accountSpan1").show();
		$(".accountSpan1").html("请您输入姓名");
	}else if(!reg.test($(".accountInput1").val())){
		$(".accountSpan1").show();
		$(".accountSpan1").html("您输入的名字不合法");
	}
}
// 电子邮件
function dataMail(){
	var Regex = /^(?:\w+\.?)*\w+@(?:\w+\.)*\w+$/;   
	if($(".accountInput3").val()==""){
		$(".accountSpan3").show();
		$(".accountSpan3").html("请您输入电子邮箱");
	}else if(!reg.test($(".accountInput3").val())){
		$(".accountSpan3").show();
		$(".accountSpan3").html("您输入的名字不合法");
	}
}
// 手机
function checkPhone(){ 
	var reg = /^1(3|4|5|7|8)\d{9}$/;
	if($(".accountInput4").val()==""){
		$(".accountSpan4").show();
		$(".accountSpan4").html("请您输入手机号");
	}else if(!(reg.test($(".accountInput4").val()))){
		$(".accountSpan4").show();
		$(".accountSpan4").html("您输入的手机号不合法");
	}
}
// 邮箱
function dataEmail(){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
}
/**********************************个人资料结束*******************************************************/
//修改密码
$(".buttonImg").on("click",function(){
	if($(".oldPassword").value == null){
		$(".hiddenSpan1").css({
			display: "block",
		})	
		}else{
		$(".hiddenSpan1").css({
			display: "none",
		})	
	}
	if($(".newPassword").value == null){
		$(".hiddenSpan2").css({
			display: "block",
		})
	}else{
		$(".hiddenSpan2").css({
			display: "none",
		})	
	}
})
$(".oldPassword").on("focus",function(){
	$(".hiddenSpan1").css({
			display: "none",
		})	
});
$(".newPassword").on("focus",function(){
	$(".hiddenSpan2").css({
			display: "none",
		})	
});

//管理收货地址
$("#btn_addconsignee").on("click",function(){
	$("#tb_consignee_add").css("display","block");
	$(this).css("display","none");
})
$("input[name='realname']").focus(function(){
	$(this).next(".con_errline").css("visibility","hidden");
})
$("input[name='cellphone']").focus(function(){
	$(this).next(".con_errline").css("visibility","hidden");
})
$("input[name='youbian']").focus(function(){
	$(this).next(".con_errline").css("visibility","hidden");
})
function name(){
	var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
 	pattern.test($("input[name='realname']").val());
	if($("input[name='realname']").val()==""){
		$("input[name='realname']").next(".con_errline").html("请您输入收货人姓名。");
	}
	else if(pattern.test($("input[name='realname']").val())==false){
		$("input[name='realname']").next(".con_errline").html("收货人姓名只能输入汉字。");
	}
	else{
		$("input[name='realname']").next(".con_errline").html("正确");
		return true;
	}
	
}
function callphone(){
	var pattern = /^1[34578]\d{9}$/; 
 	// pattern.test(phone);
 	if($("input[name='cellphone']").val()==""){
		$("input[name='cellphone']").next(".con_errline").html("请您输入手机号。");
	}
	else if(pattern.test($("input[name='cellphone']").val())==false){
		$("input[name='cellphone']").next(".con_errline").html("手机号码无效。");
	}
	else{
		console.log(1);
		$("input[name='cellphone']").next(".con_errline").html("正确");
		return true;
	}
}

function youbians(){
	var pattern = /^[0-9][0-9]{5}$/;
	if($("input[name='youbian']").val()==""){
		$("input[name='youbian']").next(".con_errline").html("请您输入邮编。");
	}
	else if(pattern.test($("input[name='youbian']").val())==false){
		$("input[name='youbian']").next(".con_errline").html("邮编格式错误，请您重新输入。");
	}
	else{
		console.log(2);
		$("input[name='youbian']").next(".con_errline").html("正确");
		return true;
	}

}

function emails(){
	var pattern = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
	if($("input[name='email']").val()==""){
		$("input[name='email']").next(".con_errline").html("请您输入电子邮件。");
	}
	else if(pattern.test($("input[name='email']").val())==false){
		$("input[name='email']").next(".con_errline").html("电子邮件格式错误，请您重新输入。");
	}
	else{
		console.log(2);
		$("input[name='email']").next(".con_errline").html("正确");
		return true;
	}

}
$("input[name='realname']").blur(function(){
	name();
	$(this).next(".con_errline").css("visibility","visible");
})
$("input[name='cellphone']").blur(function(){
	callphone();
	$(this).next(".con_errline").css("visibility","visible");
})
$("input[name='youbian']").blur(function(){
	youbians();
	$(this).next(".con_errline").css("visibility","visible");
})
$("input[name='email']").blur(function(){
	emails();
	$(this).next(".con_errline").css("visibility","visible");
})

//console.log($("#province option"));
$("#province").bind("change",function(){
	console.log($("#province").find("option:selected").val());
	if($("#province").find("option:selected").text()=="请选择..."){
		$("#province").find("option:selected").text()=="";
		console.log(1);
		$("#address").val("");
	}else{
		$("#address").val($("#province").find("option:selected").text());
	}
	
})

$("#city").bind("change",function(){
	if($("#city").find("option:selected").text()=="请选择..."){
		$("#city").find("option:selected").text()=="";
		console.log(1);
		$("#address").val($("#province").find("option:selected").text()+"");
	}else{
		$("#address").val($("#province").find("option:selected").text()+$("#city").find("option:selected").text());
	}
})


$("#area").bind("change",function(){
	if($("#area").find("option:selected").text()=="请选择..."){
		$("#area").find("option:selected").text()=="";
		console.log(1);
		$("#address").val($("#province").find("option:selected").text()+$("#city").find("option:selected").text()+"");
	}else{
		$("#address").val($("#province").find("option:selected").text()+$("#city").find("option:selected").text()+$("#area").find("option:selected").text());
	}
	
})

$("input[name='submit1']").on("click",function(){
	$("#conRecord_774364").css("display","inline");
})


	