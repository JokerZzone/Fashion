
//验证码样式及验证是否成功
$('#mpanel2').codeVerify({
	type : 1,
	width : '400px',
	height : '50px',
	fontSize : '30px',
	codeLength : 6,
	btnId : 'check-btn',
	ready : function() {
	},
	success : function() {
		//如果用户名，邮箱，验证码，密码，重复密码全部正确点击这侧按钮生效
			$("#mpanel2").siblings(".tips").html("").css("color","red");
			//点击注册
			$("#check-btn").on("click",function(){
				if($(".right1").css("display")=="block"&&$(".right2").css("display")=="block"&&$(".right3").css("display")=="block"&&$(".right4").css("display")=="block") {
					$.ajax({
						type:"get",
						url:"http://118.89.25.129:8080/Fashion/user/reg",
						data:{"user.username":$("#username").val(),"user.password":$("#password").val(),"password2":$("#password2").val(),"user.email":$("#email").val()},
						success:function(data){
							if(data=="error") {
								$("#password2").siblings(".tips").html("两次输入的密码不一致，请重新输入！");
							}else{
								cookie.set("username",$("#username").val(),1);
								cookie.set("email",$("#email").val(),1);
								window.location.href = "http://118.89.25.129:8080/Fashion/resource/static/html/registerSuccess.html";
							}
						}
					})
				}
			})
	},
	error : function() {
		$("#mpanel2").siblings(".tips").html("验证码输入错误").css("color","red");
	}
});
//用户名失焦
$("#username").blur(function(){
	checkformname();
})
//用户名聚焦
$("#username")[0].onfocus = function(){
	console.log($(this).siblings(".tips"));
	$(this).siblings(".tips").removeClass("logError");
	$(this).siblings(".tips").html("3~30位，由汉字、字母、数字、点、减号、下划线及“@”组成");
}
//密码聚焦
$("#password")[0].onfocus = function(){
	$(this).siblings(".tips").removeClass("logError");
	$(this).siblings(".tips").html("6~16位,建议使用字母、数字、特殊字符组合");
}
//重复密码聚焦
$("#password2")[0].onfocus = function(){
	$(this).siblings(".tips").removeClass("logError");
}
//密码失焦
$("#password").blur(function(){
	checkpwd();
})
//重复密码失焦
$("#password2").blur(function(){
	rcheckpwd();
})
//邮箱失焦
$("#email").blur(function(){
	checkemail();
})
//用户名正则
function checkformname(){
	var regname=/^[a-zA-Z0-9_\.-@\u4e00-\u9fa5]{3,30}$/;
	var fname = $("#username")[0];
	var ftname = $("#username").siblings(".tips")[0];
	// 输入的必须是3-30并且不能为空
	if(fname.value==""|| fname.value.length<3||fname.value.length>30){
		$("#username").siblings(".right1").css("display","none");
		ftname.className += " logError";
		ftname.innerHTML="用户名的长度应为3～30个字符之间(汉字占两个字符)!";
	}
	// 不能为纯数字
	else if(!isNaN(fname.value)){
		$("#username").siblings(".right1").css("display","none");
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
			url:"http://118.89.25.129:8080/Fashion/user/focusUsername?username="+$("#username").val(),
			success:function(data){
				if(data=="success"){
					$("#username").siblings(".right1").css("display","block");
				}else{
					$("#username").siblings(".right1").css("display","none");
					ftname.className += " logError";
					ftname.innerHTML = "用户名已存在!";
				}
			}
		});
	}
	else{
		$("#username").siblings(".right1").css("display","none");
		ftname.innerHTML="×用户名格式输入错误，请检查！";
		ftname.className += " logError";
	}
}
//邮箱正则
function checkemail(){
	var regemail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*(;\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*$/;
	var femail=$("#email")[0];
	var ftemail=$("#email").siblings(".tips")[0];
	if(femail.value==""){
		$("#email").siblings(".right4").css("display","none");
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
					$("#email").siblings(".right4").css("display","block");
				}else{
					$("#username").siblings(".right4").css("display","none");
					ftemail.className += " logError";
					ftemail.innerHTML = "邮箱已被注册!";
				}
			}
		});
	}else{
		$("#email").siblings(".right4").css("display","none");
		ftemail.className +=" logError";
		ftemail.innerHTML="× 邮箱格式输入错误，请检查！";
	}
}
// 验证密码的函数
function checkpwd(){
	var fpwd=$("#password")[0];
	var ftpwd=$("#password").siblings(".tips")[0];
	if(fpwd.value==""||fpwd.value.length<6||fpwd.value.length>16){
		ftpwd.className +=" logError";
		ftpwd.innerHTML="密码的长度应该为6～16个字符之间！";
		$("#password").siblings(".right2").css("display","none");
	}else if(!isNaN(fpwd.value)){
		$("#password").siblings(".right2").css("display","none");
		ftpwd.innerHTML="密码过于简单，为保证您的帐户安全请重设密码！";
	}else{	
		$("#password").siblings(".right2").css("display","block");
		ftpwd.innerHTML = "";	
		return "a";
	}
}
// 验证重复密码的函数
function rcheckpwd(){
	var fpwd=$("#password")[0];
	var frpwd=$("#password2")[0];
	var ftrpwd=$("#password2").siblings(".tips")[0];
	if(frpwd.value==""){
		$("#password2").siblings(".right3").css("display","none");
		ftrpwd.className +=" logError";
		ftrpwd.innerHTML="请输入您的重复密码！";
	}else if(frpwd.value!=fpwd.value){
		$("#password2").siblings(".right3").css("display","none");
		ftrpwd.className +=" logError";
		ftrpwd.innerHTML="两次输入的密码不一致，请重新输入！";
	}else{
		$("#password2").siblings(".right3").css("display","block");
		ftrpwd.innerHTML="";
		return "a";
	}
}
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

//cookie的封装函数
var cookie = {
    set:function(key,val,time){//设置cookie方法
        var date=new Date(); //获取当前时间
        var expiresDays=time;  //将date设置为n天以后的时间
        date.setTime(date.getTime()+expiresDays*24*3600*1000); //格式化为cookie识别的时间
        document.cookie=key + "=" + val +";expires="+date.toGMTString()+";path=/";  //设置cookie
    },
    get:function(key){//获取cookie方法
        /*获取cookie参数*/
        var getCookie = document.cookie.replace(/[ ]/g,"");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
        var arrCookie = getCookie.split(";")  //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        var tips;  //声明变量tips
        for(var i=0;i<arrCookie.length;i++){   //使用for循环查找cookie中的tips变量
            var arr=arrCookie[i].split("=");   //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            if(key==arr[0]){  //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips=arr[1];   //将cookie的值赋给变量tips
                break;   //终止for循环遍历
            }
        }
        return tips;
      },
      delete:function(key){ //删除cookie方法
         var date = new Date(); //获取当前时间
         date.setTime(date.getTime()-10000); //将date设置为过去的时间
         document.cookie = key + "=v; expires =" +date.toGMTString();//设置cookie
      }
  }