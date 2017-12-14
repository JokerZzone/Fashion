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


//ajax
//判断是否登录
//判断是否登录显示用户名
if(cookie.get("username")) {
	$(".vipuser").html(cookie.get("username"));
	$(".islogin").css("display","none");
}

var dlisrequest = [0,0,0,0,0,0,0];
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/category/findOne?id=1",
	data:{},
	success:function(data){
		var content = `<div class="left_list">`
		for(i in data){
			content += `<dl class="first_list_first clearfix">
								<dt class="fl">
				                    <strong style="background-position: -464px -62px;">
				                    	<a href="http://118.89.25.129:8080/Fashion/resource/static/html/sample.html?catId=${data[i].firstCategory[0].firstId}">${data[i].firstCategory[0].firstName}</a>
				                    </strong>
				                    <p>	
				                    	${a(data[i])}		                        
				                     </p>
				                    <b class="arrow-right"></b>
					            </dt>
						        <dd class="zz clearfix fl"></dd>
							</dl>`;
		}
		$('.first_list').html($('.first_list').html()+content+`</div>`);
		mouse();
	}
})

	function c(datas,index){
		var content = `<ul class="second_list">`;
		for(i in datas) {
			content += `
 				<li class="clearfix">
					<strong style="background-position: -464px -80px;">
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/sample.html?catId=${datas[i].catId}">${datas[i].catName}</a>
					</strong>
					<div class="float-list-cont clearfix">
 						${d(datas[i])}
		            </div>
 				</li>`;
		}
		$(".zz").eq(index).html(content+`</ul><div class="recommend">
				<h4>推荐品牌</h4>
				<ul>
					<li>
						<a href="###">兰蔻</a>
					</li>
				</ul>
				<a href="">
					<img src="http://photo.no5.com.cn/page_2014_images/14061114240797000404.jpg" title="倩碧匀净淡斑系列" alt="倩碧匀净淡斑系列" width="200" height="187">
				</a>
			</div>`);
	}
	function a(ele){
		var content = "";
		for(var j=0;j<ele.Desc.length;j++){
			
			 content += `<a href="http://118.89.25.129:8080/Fashion/resource/static/html/sample.html?catId=${ele.Desc[j].secondId}" class="">${ele.Desc[j].secondName}</a>`;
			
		}
		return content;
	}
	function d(ele){
		var content = "";
		for(i in ele.categories){
			 content += `<a href="http://118.89.25.129:8080/Fashion/resource/static/html/sample.html?catId=${ele.categories[i].catId}">${ele.categories[i].catName}</a>`;
		}
		return content;
	}

//鼠标移入购物车
$(".shopping_car").on("mouseenter",function(){
	$(".trigger").css({
		background:"url(http://photo.no5.com.cn/page_2014/images/detail.gif?v=20140610) no-repeat 0px -73px"
	})
})
$(".shopping_car").on("mouseleave",function(){
	$(".trigger").css({
		background:"url(http://photo.no5.com.cn/page_2014/images/detail.gif?v=20140610) no-repeat 0px -30px"
	})
})
//鼠标移入列表里面的小模块
function mouse() {
	$(".first_list dl").mouseenter(function(){
		$(this).children("dd").css("display","block");
		var id = $(this).index(".first_list dl");
		var Id = id+1;
		console.log(id,Id);
		if(dlisrequest[id]==0) {
			dlisrequest[id]=1;
			$.ajax({
				type:"get",
				url:"http://118.89.25.129:8080/Fashion/category/findTwo",
				data:{"id":Id},
				success:function(data){
					data = JSON.parse(data);
					c(data,id);
				}
			})
		}
	})
	$(".first_list dl").mouseleave(function(){
		$(this).children("dd").css("display","none");
	})
}
$(".shopping_car").on("mouseenter",function(){
	$(".shoplist").css("display","block");
	getshopcar();
})
$(".shopping_car").on("mouseleave",function(){
	$(".shoplist").css("display","none");
})
//console.log(JSON.stringify($.JSONCookie("username"))=="{}");s
//console.log($.JSONCookie("goods"));
//如果用户已登录，即cookie存在username，即username不为{}，发送ajax获取购物车数据渲染
function getshopcar() {
	if(cookie.get("username")) {
		console.log("从后台渲染");
		$.ajax({
			type:"get",
			url:"http://118.89.25.129:8080/Fashion/cart/showCart",
			data:{},
			success:function(data) {
				if(data.length==0) {
					$(".nogoods").css("display","block");
					$(".havegoods").css("display","none");
				}else {
					$(".nogoods").css("display","none");
					$(".havegoods").css("display","block");
					var content =``;
					var num =0;
					var price =0;
					for(i in data) {
						num += Number(data[i].goodsNumber);
						price += (data[i].goodsNumber)*(data[i].shopPrice);
						content +=`<li class="goodscarLi">
									<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?${data[i].goodsId}"><img src="118.89.25.129:8080/Fashion/resource/picture/goods/prod_goodsId_${data[i].goodsId}"></a>
									<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?${data[i].goodsId}" class="goodname">${data[i].goodsName}</a>
									<div class="right">
										<div class="xiaoji">
											<span class="price">￥${data[i].shopPrice}</span>
											<span>x</span>
											<span class="amount">${data[i].goodsNumber}</span>
										</div>
										<div class="del" data-goodid=${i}>删除</div>
									</div>
								</li>`;
					}
					$(".goodscarList").html(content);
					$(".shopping_car .num").html(num);
					$(".shopping_car .shoplist .havegoods .allamount").html(num);
					$(".shopping_car .shoplist .havegoods .allprice").html(price);
				}
			}
		});
	}else {	
		console.log("从cookie渲染");
		//如果用户未登录，从cookie拿数据渲染
		shopcar();
	}
}
function shopcar() {
	//获取cookie的goods数据
	var goods = $.JSONCookie("goods");
	//如果cookie有商品信息，就隐藏nogoods，出现havegoods
	if(!(JSON.stringify(goods)=="{}")) {
		$(".nogoods").css("display","none");
		$(".havegoods").css("display","block");
		var content =``;
		var num =0;
		var price =0;
		for(i in goods) {
			num += Number(goods[i].amount);
			price += (goods[i].amount)*(goods[i].price);
			content +=`<li class="goodscarLi">
						<a href="###"><img src=${goods[i].imgsrc}></a>
						<a href="###" class="goodname">${goods[i].name}</a>
						<div class="right">
							<div class="xiaoji">
								<span class="price">￥${goods[i].price}</span>
								<span>x</span>
								<span class="amount">${goods[i].amount}</span>
							</div>
							<div class="del" data-goodid=${i}>删除</div>
						</div>
					</li>`;
		}
		$(".goodscarList").html(content);
		$(".shopping_car .num").html(num);
		$(".shopping_car .shoplist .havegoods .allamount").html(num);
		$(".shopping_car .shoplist .havegoods .allprice").html(price);
		console.log(content);
	}else {
		$(".shopping_car .num").html(0);
		$(".shopping_car .shoplist .havegoods .allamount").html(0);
		$(".shopping_car .shoplist .havegoods .allprice").html(0);
		$(".nogoods").css("display","block");
		$(".havegoods").css("display","none");
	}
	$(".del").click(function(){
		var cookieGoods = $.JSONCookie("goods");
		for(i in cookieGoods) {
			if($(this).data("goodid")==i) {
				$(this).parents(".goodscarLi").remove();
				delete cookieGoods[i];
				$.JSONCookie("goods", cookieGoods, { path: '/', expires: 24 });
			}
		}
	})
}