// 登录页面的功能
$($(".logBox")[0]).find("form .input input").each(function(index,ele){
	ele.onfocus = function(){
		$(this).addClass("input_onfocus");
		$(this).removeClass("input_failure");
		$($(this).nextAll(".tip")[0]).html("");
	}
	ele.onblur = function(){
		$(this).removeClass("input_onfocus");
	}
})
//请求页面的功能
$($(".regBox")[0]).find("form .input input").each(function(index,ele){
	ele.onfocus = function(){
		$(this).addClass("input_onfocus");
		$(this).removeClass("input_failure");
	}
	ele.onblur = function(){
		$(this).removeClass("input_onfocus");
	}
})


// 注册用户名的聚焦事件
$($(".regBox")[0]).find("form .input input")[0].onfocus = function(){
	$(this).addClass("input_onfocus");
	$(this).removeClass("input_failure");
	$(this).nextAll(".tip").removeClass("logError");
	$(this).nextAll(".tip").html("3~30位，由汉字、字母、数字、点、减号、下划线及“@”组成");
}
// 注册用户名的失焦事件
$($(".regBox")[0]).find("form .input input")[0].onblur = function(){
	checkformname();
	$(this).removeClass("input_onfocus");
}
// 注册密码的聚焦事件
$($(".regBox")[0]).find("form .input input")[1].onfocus = function(){
	$(this).addClass("input_onfocus");
	$(this).removeClass("input_failure");
	$(this).nextAll(".tip").removeClass("logError");
	$(this).nextAll(".tip").html("6~16位,建议使用字母、数字、特殊字符组合");
}
// 注册密码的失焦事件
$($(".regBox")[0]).find("form .input input")[1].onblur = function(){
	$(this).removeClass("input_onfocus");
	checkpwd();
}
// 重复密码的聚焦事件
$($(".regBox")[0]).find("form .input input")[2].onfocus = function(){
	$(this).addClass("input_onfocus");
	$(this).removeClass("input_failure");
	$(this).nextAll(".tip").removeClass("logError");
}
// 重复密码的失焦事件
$($(".regBox")[0]).find("form .input input")[2].onblur = function(){
	$(this).removeClass("input_onfocus");
	rcheckpwd();
}
// 电子邮箱的聚焦事件
$($(".regBox")[0]).find("form .input input")[3].onfocus = function(){
	$(this).addClass("input_onfocus");
	$(this).removeClass("input_failure");
	$(this).nextAll(".tip").removeClass("logError");
}
$($(".regBox")[0]).find("form .input input")[3].onblur = function(){
	$(this).removeClass("input_onfocus");
	checkemail();
}
// 验证用户名的函数
function checkformname(){
	var regname=/^[a-zA-Z0-9_\.-@\u4e00-\u9fa5]{3,30}$/;
	var fname = document.getElementById("txtRegUserName");
	var ftname = document.getElementById("usersName");
	// 输入的必须是3-30并且不能为空
	if(fname.value==""|| fname.value.length<3||fname.value.length>30){
		ftname.className += " logError";
		ftname.innerHTML="用户名的长度应为3～30个字符之间(汉字占两个字符)!";
	}
	// 不能为纯数字
	else if(!isNaN(fname.value)){
		ftname.className += " logError";
		ftname.innerHTML="不能为纯数字!";
	}
	// 符合正则表达式
	else if(regname.test(fname.value)){
		ftname.innerHTML = "";
		// 验证成功发送请求
		$.ajax({
			type:"get",
			data:{},
			url:"http://118.89.25.129:8080/Fashion/user/focusUsername.do?user.username="+fname.value,
			success:function(data){
				if(data=="success"){
					$(".img_right")[0].style.display = "inline";
					return true;
				}else{
					ftname.className += " logError";
					ftname.innerHTML = "用户名已存在!";
				}
			}
		});
	}
	else{
		ftname.innerHTML="×用户名格式输入错误，请检查！";
		ftname.className += " logError";
	}
}


// 验证密码的函数
function checkpwd(){
	var fpwd=document.getElementById("txtRegPassword");
	var ftpwd=document.getElementById("sRegpwd");
	if(fpwd.value==""||fpwd.value.length<6||fpwd.value.length>16){
		ftpwd.className +=" logError";
		ftpwd.innerHTML="密码的长度应该为6～16个字符之间！";
	}else if(!isNaN(fpwd.value)){
		ftpwd.className +=" logError";
		ftpwd.innerHTML="密码过于简单，为保证您的帐户安全请重设密码！";
	}else{	
		$(".img_right")[1].style.display = "inline";
		ftpwd.innerHTML = "";	
		return true;
	}
}


// 验证重复密码的函数
function rcheckpwd(){
	var fpwd=document.getElementById("txtRegPassword");
	var frpwd=document.getElementById("txtRePassword");
	var ftrpwd=document.getElementById("sRePwd");
	if(frpwd.value==""){
		ftrpwd.className +=" logError";
		ftrpwd.innerHTML="请输入您的重复密码！";
	}else if(frpwd.value!=fpwd.value){
		ftrpwd.className +=" logError";
		ftrpwd.innerHTML="两次输入的密码不一致，请重新输入！";
	}else{
		$(".img_right")[2].style.display = "inline";
		ftrpwd.innerHTML="";
		return true;
	}
}

// 验证电子邮箱的函数
function checkemail(){
	var regemail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*(;\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*$/;
	var femail=document.getElementById("txtEmail");
	var ftemail=document.getElementById("sEmail");
	if(femail.value==""){
		ftemail.className +=" logError";
		ftemail.innerHTML="× 电子邮箱不能为空！";
	}else if(femail.value.match(regemail)){
		ftemail.innerHTML = "";
		// 验证成功发送请求
		$.ajax({
			type:"get",
			data:{},
			url:"http://118.89.25.129:8080/Fashion/user/focusEmail.do?user.email="+femail.value,
			success:function(data){
				if(data=="success"){
					$(".img_right")[3].style.display = "inline";
					return true;
				}else{
					ftemail.className += " logError";
					ftemail.innerHTML = "邮箱已被注册!";
				}
			}
		});
	}else{
		ftemail.className +=" logError";
		ftemail.innerHTML="× 邮箱格式输入错误，请检查！";
	}
}
// 验证码的函数
var code1 ; //在全局定义验证码    
var code2 ; //在全局定义验证码    
function createCode1(){  
     code1 = "";     
     var codeLength = 4;//验证码的长度    
     var checkCode = document.getElementById("logCode");
     var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',    
     'S','T','U','V','W','X','Y','Z');//随机数    
     for(var i = 0; i < codeLength; i++) {//循环操作    
        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）    
        code1 += random[index];//根据索引取得随机数加到code上    
    }    
    checkCode.value = code1;//把code值赋给验证码    
}  

function createCode2(){  
     code2 = "";     
     var codeLength = 4;//验证码的长度    
     var checkCode = document.getElementById("regCode");     
     var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',    
     'S','T','U','V','W','X','Y','Z');//随机数    
     for(var i = 0; i < codeLength; i++) {//循环操作    
        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）    
        code2 += random[index];//根据索引取得随机数加到code上    
    }    
    checkCode.value = code2;//把code值赋给验证码    
}  
// 页面刷新会产生验证码
createCode1();
createCode2();




// 登录界面的请求，点击登录发送请求
$("#btnLogin").click(function(){
	if(!$($(".fixlogininput")[0]).val()){
		$($(".fixlogininput")[0]).next().html("请您输入用户名!");
		$($(".fixlogininput")[0]).addClass("input_failure");
	}else{
		$($(".fixlogininput")[0]).next().html("");
	}
	if(!$($(".fixlogininput")[1]).val()){
		$($(".fixlogininput")[1]).next().next().html("请您输入密码!");
		$($(".fixlogininput")[1]).addClass("input_failure");
	}else{
		$($(".fixlogininput")[1]).next().next().html("");
	}
	if(!$("#VerificationCode").find(".testCode").val()){
		$("#VerificationCode").find(".tip").html("请您输入用验证码!");
		$("#VerificationCode").find(".testCode").addClass("input_failure");
	}else{
		$("#VerificationCode").find(".tip").html("");
	}
	// 当用户名和密码不为空的时候，检测验证码是否正确
	var logverCode = $(".testCode")[0];
	if($($(".fixlogininput")[0]).val() && $($(".fixlogininput")[1]).val() && $("#VerificationCode").find(".testCode").val()){
		// 
		 var inputCode = $(".testCode")[0].value.toUpperCase(); //取得输入的验证码并转化为大写          
	    if(inputCode.length <= 0) { //若输入的验证码长度为0    
	        $("#logCode").nextAll(".tip").html("请您输入验证码"); //则弹出请输入验证码    
	    }else if(inputCode != code1) { //若输入的验证码与产生的验证码不一致时    
	       $("#logCode").nextAll(".tip").html("输入的验证码错误"); //则弹出验证码输入错误  
	        createCode1();//刷新验证码    
	        $("#logCode").prevAll(".testCode").val("");//清空文本框    
	    }else { //输入正确时    
	       	$("#logCode").nextAll(".tip").html("");
	       	// 正确的时候发送请求
	       	$.ajax({
			type:"post",
			url:"http://118.89.25.129:8080/Fashion/user/login.do",
			data:{"user.username":$(".fixlogininput")[0].value,"user.password":$(".fixlogininput")[1].value},
			success:function(data){
				if(data=="success"){
					// 成功的话跳转到首页
					window.location.href="../html/index.html";
				}else{
					// 失败，用户名或密码错误，请您重新输入！
					$($(".fixlogininput")[1]).next().next().html("用户名或密码错误，请您重新输入!");
				}
			}
		})
	    }  
	}
	
})
// 点击注册
$("#btnReg").click(function(){
	// 如果用户名密码重复密码邮箱都出现对号图片，判断验证码
	if($(".img_right")[0].style.display=="inline" && $(".img_right")[1].style.display=="inline" && $(".img_right")[2].style.display=="inline" && $(".img_right")[3].style.display=="inline"){
		var inputCode = $(".testCode")[1].value.toUpperCase(); //取得输入的验证码并转化为大写          
	    if(inputCode.length <= 0) { //若输入的验证码长度为0    
	        $("#regCode").nextAll(".tip").html("请您输入验证码"); //则弹出请输入验证码    
	    }else if(inputCode != code2) { //若输入的验证码与产生的验证码不一致时    
	       $("#regCode").nextAll(".tip").html("输入的验证码错误"); //则弹出验证码输入错误    
	        createCode2();//刷新验证码    
	        $("#regCode").prevAll(".testCode").val("");//清空文本框    
	    }else { //输入正确时    
	       		$("#regCode").nextAll(".tip").html("");
	       		// 正确的时候发送请求
		       	$.ajax({
				type:"post",
				url:"http://118.89.25.129:8080/Fashion/user/login.do",
				data:{
					'user.username':$(".fixlogininput")[2].value,
					'user.password':$(".fixlogininput")[3].value,
					'password2':$(".fixlogininput")[4].value,
					'user.email':$(".fixlogininput")[5].value
				},
				success:function(data){
					if(data=="success"){
						// 注册成功跳转到一个注册成功的页面
						window.location.href="../html/registerSuccess.html";
					}else{
						// 失败，
						$($(".fixlogininput")[4]).next().next().html("两次密码不一致！！!");
					}
				}
			})
	    }  
	}
});
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