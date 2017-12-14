var urlTwo = window.location.href;
console.log(urlTwo);

var str = "http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=1";
console.log(str.split("=")[1]);
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/goods/detail",
	data:{id:1},
	success:function(data){
		console.log(data);
		var content = "";
		var content2 = "";
		var content3 = "";
		var content5 = `<li class="picli pic_on" id="sBox1">
				<img src=http://118.89.25.129:8080/Fashion/resource/${data.imgPre[0]}${data.leftImg[0]}${data.imgSuff[0]} alt="">
			</li>`
		var content6 = `<img src=http://118.89.25.129:8080/Fashion/resource/${data.imgPre[data.leftImg.length]}${data.detailImg[0]}${data.imgSuff[data.leftImg.length]} alt="">`
		var content4 =`<div id="magnifier"></div>
					<img class="showImg" src=http://118.89.25.129:8080/Fashion/resource/${data.imgPre[0]}${data.leftImg[0]}${data.imgSuff[0]} alt="" width="350" height="350">	`;
		for(var i = 1; i < data.leftImg.length; i++){
			content += `
			<li class="picli" id="sBox${i}">
				<img src=http://118.89.25.129:8080/Fashion/resource/${data.imgPre[i]}${data.leftImg[i]}${data.imgSuff[i]} alt="">
			</li>
			`
			content2 += `
			<img  src=http://118.89.25.129:8080/Fashion/resource/${data.imgPre[i]}${data.leftImg[i]}${data.imgSuff[i]} alt="" width="350" height="350">
			`
		
			$("#pic_id_box").html(content5+content);
			$("#pic_box").html(content4+content2);
		}
		for(i in data.leftImg){
			content3 += `
			<img src=http://118.89.25.129:8080/Fashion/resource/${data.imgPre[i]}${data.leftImg[i]}${data.imgSuff[i]} alt="" width="800" height="800">
			`
			$(".dis_box").html(content3);
		}
		
		$(".goods_part1_r h2").html(data.goodsName);
		$(".n_neir_id").html(data.goodsId);
		$(".prod_txt1").html("市场价：￥"+data.marketPrice+".00");
		$(".xsprice").html("￥"+data.shopPrice+".00");
		$(".exp_img1").html(content6);
		hover();
	}
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

// 鼠标移入让上次的元素的className= "picli" 这次的为 className="picli pic_on"
function hover() {
	var lastDiv = $("#pic_id_box li")[0];
	var lastImg = $("#pic_box img")[0];
	var lastZoomBox = $("#zoom_box .dis_box img")[0];
	$("#pic_id_box li").each(function(index,ele){
		$("#zoom_box .dis_box img")[index].style.display = "none";
		$("#zoom_box .dis_box img")[0].style.display = "block";
		$("#pic_box img")[index].style.display = "none";
		$("#pic_box img")[0].style.display = "block";
		ele.onmouseover = function(){
			// 放大图的src变化
			lastDiv.className = "picli";
			this.className += " pic_on";
			lastDiv = this;	
			lastImg.style.display = "none";
			$("#pic_box img")[index].style.display="block";
			lastImg = $("#pic_box img")[index];	
		
			lastZoomBox.style.display = "none";
			$("#zoom_box .dis_box img")[index].style.display="block";
			lastZoomBox = $("#zoom_box .dis_box img")[index];
		}
	});
}
//放大镜的效果
// 鼠标移入遮罩出现
// 放大镜出现
$("#pic_box").mouseover(function(){
	$("#magnifier").css("visibility","visible");
	$("#zoom_box").css("visibility","visible");
});
// 鼠标移出，遮罩消失，放大镜消失
$("#pic_box").mouseout(function(){
	$("#magnifier").css("visibility","hidden");
	$("#zoom_box").css("visibility","hidden");
});

$("#pic_box").mousemove(function(ev){
	var x = ev.pageX;
	var y = ev.pageY;
	var l = $("#pic_box")[0].offsetLeft;
	var t = $("#pic_box")[0].offsetTop;
	var _left = x - l -  $("#magnifier")[0].offsetWidth/2;
	var _top = y - t  - $("#magnifier")[0].offsetHeight/2;
	if(_left<0){
		_left=0;
	}else if(_left >= $("#pic_box")[0].offsetWidth - $("#magnifier")[0].offsetWidth){
		_left=$("#pic_box")[0].offsetWidth-$("#magnifier")[0].offsetWidth;
	}
	if(_top<0){
		_top = 0;
	}else if(_top >= $("#pic_box")[0].offsetHeight - $("#magnifier")[0].offsetHeight){
		_top=$("#pic_box")[0].offsetHeight-$("#magnifier")[0].offsetHeight;
	}
	$("#magnifier").css({
		top:_top,
		left:_left
	});

	var _left_ = -($("#zoom_box")[0].offsetWidth / $("#magnifier")[0].offsetWidth * $("#magnifier")[0].offsetLeft);
	var _top_ = -($("#zoom_box")[0].offsetHeight / $("#magnifier")[0].offsetHeight * $("#magnifier")[0].offsetTop);
	$(".dis_box").css({
		top:_top_,
		left:_left_
	});
});
// 分享功能
//三个参数，内容，网址，以及 图片，也就是我们想要分享的内容
// 分享到新浪微博
function shareToXl(title,url,picurl){
	var sharesinastring='http://v.t.sina.com.cn/share/share.php?title='+title+'&url='+url+'&content=utf-8&sourceUrl='+url+'&pic='+picurl;
	window.open(sharesinastring,'newwindow','height=400,width=400,top=100,left=100');
}
//分享到腾讯微博  
function shareToQQ(title,url,picurl)  
{  
 var shareqqstring='http://v.t.qq.com/share/share.php?title='+title+'&url='+url+'&pic='+picurl;  
 window.open(shareqqstring,'newwindow','height=500,width=500,top=100,left=100');    
}  
//分享到QQ空间  
function shareToQzone(title,url,picurl)  
{  
 var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary='+title+'&url='+url+'&pics='+picurl;  
 window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');  
}  
//分享到豆瓣
	
$("#site_sina").click(function(){
	shareToXl("这是一个宝贝链接","http://www.no5.com.cn/","http://c.hiphotos.baidu.com/image/pic/item/500fd9f9d72a60593732e1d02134349b023bbadd.jpg");
});
$("#site_qzone").click(function(){
	shareToQQ("这是一个宝贝链接","http://www.no5.com.cn/","http://c.hiphotos.baidu.com/image/pic/item/500fd9f9d72a60593732e1d02134349b023bbadd.jpg");
});
$("#site_QQ").click(function(){
	shareToQzone("这是一个宝贝链接","http://www.no5.com.cn/","http://c.hiphotos.baidu.com/image/pic/item/500fd9f9d72a60593732e1d02134349b023bbadd.jpg");
});

// 选项卡的功能
// 点击商品详情#tab_box_0,1,2 display:block; #tab_box_3 display:none
// 点击购物须知#tab_box_0,1,2 display:none; #tab_box_3 display:block
// 点击购买评论#tab_box_1 display:block 其他都为none
// 点击商品咨询#tab_box_2 dispaly:block 其他都为none
var tab_box_arr = [$("#tab_box_0"),$("#tab_box_1"),$("#tab_box_2"),$("#tab_box_3")];


var lastBar = $("#tabBar ul li")[0];
$("#tabBar ul li").each(function(index,ele){
	$(ele).click(function(){
		lastBar.className = "";
		this.className = "tabson";
		lastBar = this;
		if(index==0){
			for(var j=0;j<3;j++){
				tab_box_arr[j].css("display","block");
			}
			tab_box_arr[3].css("display","none");
		}else{
			for(z in tab_box_arr){
				tab_box_arr[z].css("display","none");
			}
			tab_box_arr[index].css("display","block");
		}
	})
});
$(window).scroll(function(){
	if($(this).scrollTop() >= $("#con_two_1").offset().top){
		$("#tabBar").css({
			position:"fixed",
			top:0,
		});
	}else{
		$("#tabBar").css({
			position:"relative",
		});
	}
});




//点击加减控制数量
$(".box_buy .jian").on("click",function(){
	var amount = Number($("#buyAnt").val());
	if(amount>0) {
		amount--;
		$("#buyAnt").val(amount);
	}
})
$(".box_buy .jia").on("click",function(){
		var amount = Number($("#buyAnt").val());
		amount++;
		$("#buyAnt").val(amount);
})



//点击加入购物车将数据存入localStorage
//设置window.localStorage.setItem("user","a")
//获取window.localStorage.getItem("user")
var goodsArr = [];
var numArr = [];
$(".box_buy #btnBuy").on("click",function(){
	var imgsrc = $("#pic_box .showImg")[0].src;
	var name = $(".goods_part1_r h2").html();
	var price = $(".n_neir .xsprice").html().split(".")[0].split("￥")[1];
	var amount = $("#buyAnt").val();
	var goodId = "good"+$(".n_neir").html();
	var good = {
		"imgsrc":imgsrc,
		"name":name,
		"price":price,
		"amount":amount
	}
	goodsArr.push(Number($(".n_neir").html()));
	numArr.push(Number(amount));
	console.log(cookie.get("aaa"));
	console.log(goodsArr,numArr);
	if(cookie.get("username")) {
		console.log("存数据到后台");
		$.ajax({
			type:"get",
			url:"http://118.89.25.129:8080/Fashion/cart/cart",
			traditional:true,
			data:{"goods[]":goodsArr,"num[]":numArr},
			success:function(data){
				
			}
		})
	}else {
		console.log("存数据到cookie");
		//取出cookie 的goods所有信息
		var cookieGoods = $.JSONCookie("goods");
		//如果不存在商品，添加这条商品的信息到cookie 的 goods 里面
		if(!cookieGoods[goodId]) {
			console.log("cookie没有存本商品");
			//添加该商品的信息到取出的cookie的goods里面
			cookieGoods[goodId]=good;
			//把取出并添加了该商品信息的cookie的goods数据重新存到cookie里面
			$.JSONCookie("goods", cookieGoods, { path: '/', expires: 24 });
		}else {
			console.log("cookie存了本商品");
			//如果cookie里面存在该商品的信息，那就number加上本次操作的number
			for(i in cookieGoods) {
				//如果cookie的goods里面有该商品(该商品id能与cookie里面的goods里面的id相等)
				if(i==goodId) {
					//cookie的goods里面的该商品数量加上本次操作的数量
					cookieGoods[i].amount=Number(cookieGoods[i].amount)+Number(amount);
					//再次把修改了数量的cookie的goods存到cookie里面
					$.JSONCookie("goods", cookieGoods, { path: '/', expires: 24 });
				}
			}
		}
//		document.cookie = "goods="+ JSON.stringify(goods);
	}
})


