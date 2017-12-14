//Ajax
var imgheader ="http://118.89.25.129:8080/Fashion/resource/";
//首屏
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/merge/2",
	data:{},
	success:function(data){
		var bgColor = ["(181,226,255)","(254,234,243)"];
		//轮播图侧边栏替换图片
		var sideUrl = [[imgheader+data.topic[1].ads[0].imgPre[0]+data.topic[1].ads[0].detailImg[0]+data.topic[1].ads[0].imgSuff[0],imgheader+data.topic[1].ads[0].imgPre[1]+data.topic[1].ads[0].detailImg[1]+data.topic[1].ads[0].imgSuff[1],imgheader+data.topic[1].ads[0].imgPre[2]+data.topic[1].ads[0].detailImg[2]+data.topic[1].ads[0].imgSuff[2]],[imgheader+data.topic[1].ads[0].imgPre[3]+data.topic[1].ads[0].detailImg[3]+data.topic[1].ads[0].imgSuff[3],imgheader+data.topic[1].ads[0].imgPre[4]+data.topic[1].ads[0].detailImg[4]+data.topic[1].ads[0].imgSuff[4],imgheader+data.topic[1].ads[0].imgPre[5]+data.topic[1].ads[0].detailImg[5]+data.topic[1].ads[0].imgSuff[5]]];
		var amount = 0;
		var paginationTimer = setInterval(timer,2000);
		//轮播图后台替换图片
		$(".li1 img").attr('src',imgheader+data.topic[0].ads[0].imgPre[0]+data.topic[0].ads[0].detailImg[0]+data.topic[0].ads[0].imgSuff[0]);
		$(".li2 img").attr('src',imgheader+data.topic[0].ads[0].imgPre[1]+data.topic[0].ads[0].detailImg[1]+data.topic[0].ads[0].imgSuff[1]);
		//轮播图下边替换图片
		$(".lia img").attr('src',imgheader+data.topic[1].ads[0].imgPre[6]+data.topic[1].ads[0].detailImg[6]+data.topic[1].ads[0].imgSuff[6]);
		$(".lib img").attr('src',imgheader+data.topic[1].ads[0].imgPre[7]+data.topic[1].ads[0].detailImg[7]+data.topic[1].ads[0].imgSuff[7]);
		$(".lic img").attr('src',imgheader+data.topic[1].ads[0].imgPre[8]+data.topic[1].ads[0].detailImg[8]+data.topic[1].ads[0].imgSuff[8]);
		//限时抢购渲染
		getxsqg(data);
		$(".sliderWindow").mouseover(function(ev){
			clearInterval(paginationTimer);
		});
		$(".sliderWindow").mouseout(function(){
			clearInterval(paginationTimer);
			paginationTimer = setInterval(timer,2000);
		})
		$(".sliderPagination li").each(function(index,ele){
			ele.onmouseover = function(){
				amount=index;
				showTime();
			}
			ele.onmouseout = function(){
				clearInterval(paginationTimer);
				paginationTimer = setInterval(timer,2000);
			}
		});
		function timer(){
			amount++;
			if(amount==$(".sliderPics li").length){
				amount=0;
			}
			showTime();
		}
		function showTime(){
			$(".sliderPics li").each(function(index,ele){
				ele.style.opacity = 0;
				ele.style.position = "absolute";
			});
			$(".sliderPagination li").each(function(index,ele){
				ele.style.backgroundColor = "#e8e8e8";
			});
			$(".sliderPics li")[amount].style.opacity = 1;
			$(".sliderPagination li")[amount].style.backgroundColor="#00b5ff";
			$(".slider").css("backgroundColor","rgb"+bgColor[amount]);
			$(".sliderSide li a img").each(function(index,ele){
				ele.src = sideUrl[amount][index];
			});
		}
	}
})
//滚动加载
//封装对象向后台发送请求获取数据 定义一个变量保存数据加载的位置
//var Unit = {
//	//参数 第一个 发送请求的地址 第二个是数据加载完成之后的回调函数
//	ajax: function(url,callback){
//		var xhr = new XMLHttpRequest();
//		xhr.onload=function(){
//			var data =	this.responseText;
//			var data = JSON.parse(this.responseText);
//			console.log(data);
//			callback(data);
//		}
//		xhr.open("GET",url,true);
//		xhr.send(null);
//	},
//	num: 0
//}
////页面加载时发送的参数值放在一个数组
//var idArr=[4,9,10,11,12,13,14,16,17];
////页面加载时调用的函数获取数据
//var fnArr=[getbztj,pphd,hf,ca,xs,mans,mtmf,mrzx,lastBottom];
//var body = document.getElementsByTagName('body')[0];
//function upload(num){//获取数据的函数
//	//调用封装的对象里面的方法 第一个参数 地址和参数的拼接 第二个是得到数据之后处理数据的回调函数
//	Unit.ajax("http://118.89.25.129:8080/Fashion/topic/showTopic?id="+idArr[num],fnArr[num]);
//}
////鼠标滚动到最下边自动加载数据
//body.onscroll=function(ev){
//	//document.documentElement.scrollTop 页面滚动上去的高度
//	//this.innerHeight 屏幕的高度
//	//document.body.scrollHeight 网页正文全文高
//	console.log(document.documentElement.scrollTop + this.innerHeight,$("body").height()-50);
//	if(document.documentElement.scrollTop + this.innerHeight >= $("body").height()-50&&Unit.num<fnArr.length){
//		upload(Unit.num++); //满足条件 即滚动到页面最下端 执行获取数据的函数,下标加一，用来获取发送的参数值和函数名
//	}
//}

$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=4",
	data:{},
	success:function(data){
		getbztj(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=5",
	data:{},
	success:function(data){
		getxpsj(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=6",
	data:{},
	success:function(data){
		getczxy(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=7",
	data:{},
	success:function(data){
		getrpsp(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=8",
	data:{},
	success:function(data){
		getmxtj(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=9",
	data:{},
	success:function(data){
		pphd(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=10",
	data:{},
	success:function(data){
		hf(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=11",
	data:{},
	success:function(data){
		ca(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=12",
	data:{},
	success:function(data){
		xs(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=13",
	data:{},
	success:function(data){
		mans(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=14",
	data:{},
	success:function(data){
		mtmf(data);
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=16",
	data:{},
	success:function(data){
		mrzx();
	}
})
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/topic/showTopic?id=17",
	data:{},
	success:function(data){
		lastBottom();
	}
})
// 动态的小消息
var box = $(".notice div")[0];
var index = 1;
var moveTimer;
function next(){
	index++;
	if(index==$(".notice div ul").length){
		index=1;
		box.style.top = "0";
	}
	moveIndex();
}
var autoPlay = setInterval(function(){
	next();
},2000);
function moveIndex(){
	var l = index* -$(".notice div ul")[0].offsetHeight - box.offsetTop;
	var count = 0;
	clearInterval(moveTimer);
	moveTimer=setInterval(function(){
		count++;
		box.style.top = box.offsetTop + l/10 + 'px';
		if(count>=10){
			clearInterval(moveTimer);
			box.style.top = index * -$(".notice div ul")[0].offsetHeight + 'px';
		}
	},40);
}
$(".sliderWindow").css("left",$(".first_list").offset().left+$(".first_list").outerWidth()+"px");
$($(".sliderSide")[0]).css("left",$(".sliderWindow")[0].offsetWidth+$(".sliderWindow")[0].offsetLeft+20);
$(window).resize(function(){
	$($(".sliderSide")[0]).css("left",$(".sliderWindow")[0].offsetWidth+$(".sliderWindow")[0].offsetLeft+20);
	$(".sliderWindow").css("left",$(".first_list").offset().left+$(".first_list").outerWidth()+"px");
})
//页面滚动到一定位置导航栏相对浏览器定位
$(window).scroll(function(){
	if($(this).scrollTop()>=600) {
		$(".header_nav").css({
			position:"fixed",
			top:0,
			left:0,
			zIndex:999
		})
		list();
	}else {
		$(".header_nav").css({
			position:"static"
		})
		$(".left_list").css("display","block");
	}
});
//移入list分类显示移出
function list() {
	$(".left_list").css("display","none");
	//移入全部商品分类
	$(".first_list dl").mouseover(function(){
		$(this).children("dd").css("display","block");
	})
	$(".first_list dl").mouseout(function(){
		$(this).children("dd").css("display","none");
	})
	$(".first_list").mouseover(function(){
		$(".left_list").css("display","block");
	})
	$(".first_list").mouseout(function(){
		$(".left_list").css("display","none");
	})
}
//滚动加载时的执行的渲染函数
//限时抢购渲染函数
function getxsqg(data) {
	var dataInfo = data["topic"][2]["goods"];
	console.log(dataInfo);
	var content=`<div class="xianshiqianggou"><div class="title">
			<img src="../img/xsqg_2.jpg" alt=${data["topic"][2]["title"]}>
		</div>
		<ul class="goodsUL">`;
	for(i in dataInfo) {
		content +=
`
<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}">
	<li class="goodsLI">
		<div class="border">
			<div class="countdown">
				剩余 <span class="hour">00</span> 
				小时 <span class="minute">00</span> 分 <span class="second">00</span> 秒
			</div>
			<img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[i]["imgDesc"]}"/>
			<div class="goodsKnow">${dataInfo[i]["goodsDesc"]}</div>
			<div class="snapUp">
				<div>￥</div>
				<div class="price">${dataInfo[i]["shopPrice"]}</div>
			</div>
		</div>
		<div class="buy">
			<span class="number">${dataInfo[i]["virtualSales"]}</span>人已购买
		</div>
	</li>
</a>
`;
	}
	content+"</div>";
	$(".one").html(content+"</ul>");
	setInterval(function(){
		var nowDate = new Date();
		var endtime = Date.parse(data["topic"][2]["endTime"]);
		var times = endtime-nowDate.getTime();
		var s = parseInt(times/1000);
		var second = s%60;
		var minute = parseInt(s/60)%60;
		var hour = parseInt(s/60/60);
		$(".hour").html(checktime(hour));
		$(".minute").html(checktime(minute));
		$(".second").html(checktime(second));
		function checktime(i) {
			if(i<10&&i>=0) {
				return "0"+i;
			}else {
				return i;
			}
		}
	},1000);
}
//循环生成的card列表放入了本周特价里面
function cardHover(arr){
	var content="";
	var num=0;
	for(i in arr) {
		content +=
`
<li class="card${++num}">
	${arr[i]}
	<div class="triangle"></div>
</li>`;
	}
	return content;
}
//本周特价渲染函数
function getbztj(data) {
	console.log("本周特价");
	var dataInfo = data["goods"];
	var arr=["本周特价","明星推荐","新品上架","热评商品","超值小样"];
	var content=
`
<div class="chooseCard">
	<!--可以hover的选项-->
	<ul class="card">
		${cardHover(arr)}	
	</ul>
	<div class="box">
		${three(1,dataInfo)}
	</div>
</div>`;
	$(".two").html(content);
	chooseCards();
}
//本周特价、新品上架、超值小样使用同一个three渲染
function three(odd,dataInfo) {
	var content =
`
<div class="card${odd}_goods card_goods card135">
	<div class="goods1 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[0]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[0]["imgDesc"]}" /></a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[0]["goodsId"]}">${dataInfo[0]["goodsName"]}</a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[0]["goodsId"]}">维多利亚的秘密保湿身体乳Temptation</a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[0]["goodsId"]}">${dataInfo[0]["goodsDesc"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[0]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[0]["discount"]}折)</span>
		</div>
	</div>
	<div class="goods2 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[1]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[1]["imgDesc"]}" /></a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[1]["goodsId"]}">${dataInfo[1]["goodsName"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[1]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[1]["discount"]}折)</span>
		</div>
	</div>
	<div class="goods3 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[2]["goodsId"]}">${dataInfo[2]["goodsName"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[2]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[2]["discount"]}折)</span>
		</div>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[2]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[2]["imgDesc"]}" /></a>
	</div>
	<div class="goods4 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[3]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[3]["imgDesc"]}" /></a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[3]["goodsId"]}">${dataInfo[3]["goodsName"]}</a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[3]["goodsId"]}">维多利亚的秘密保湿身体乳Temptation</a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[3]["goodsId"]}">${dataInfo[3]["goodsDesc"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[3]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[3]["discount"]}折)</span>
		</div>
	</div>
	<div class="goods5 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[4]["goodsId"]}">${dataInfo[4]["goodsName"]}</a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[4]["goodsId"]}">维多利亚的秘密保湿身体乳Temptation</a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[4]["goodsId"]}">${dataInfo[4]["goodsDesc"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[4]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[4]["discount"]}折)</span>
		</div>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[4]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[4]["imgDesc"]}" /></a>
	</div>
	<div class="goods6 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[5]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[5]["imgDesc"]}" /></a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[5]["goodsId"]}">${dataInfo[5]["goodsName"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[5]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[5]["discount"]}折)</span>
		</div>
	</div>
	<div class="goods7 goodS">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[6]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[6]["imgDesc"]}" /></a>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[6]["goodsId"]}">${dataInfo[6]["goodsName"]}</a>
		<div class="price">
			<span>￥</span>
			<span class="price1">${dataInfo[6]["shopPrice"]}</span>
			<span class="price2">.00</span>
			<span class="zhekou">(${dataInfo[6]["discount"]}折)</span>
		</div>
	</div>
</div>`;
	return content;
}
//新品上架渲染
function getxpsj(data) {
	console.log("新品上架");
	var dataInfo = data["goods"];
	$(".box").html($(".box").html()+three(3,dataInfo));
}
//超值小样渲染
function getczxy(data) {
	console.log("超值小样");
	var dataInfo = data["goods"];
	$(".box").html($(".box").html()+three(5,dataInfo));
}
//热评商品渲染函数
function getrpsp(data) {
	console.log("热评商品");
	var dataInfo = data["goods"];
	var content =`<div class="card4_goods card_goods"><ul>`;
	for(i in dataInfo) {
		content +=
`
		<li class="goods1 goods">
			<!--图片-->
			<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[i]["imgDesc"]}" /></a>
			<!--详情-->
			<div class="jieshao">${dataInfo[i]["goodsName"]}</div>
			<!--评价-->
			<ul class="pingjia">
				<li class="pingjia1"><span class="name">吉雪卧堂</span>真心喜欢，是正品，一直用这个牌子，朋友都说我用过皮肤比以前好多了，还帮朋友买了好几个</li>
				<li class="pingjia2"><span class="name">吉雪卧堂</span>真心喜欢，是正品，一直用这个牌子，朋友都说我用过皮肤比以前好多了，还帮朋友买了好几个</li>
				<li class="pingjia3"><span class="name">吉雪卧堂</span>真心喜欢，是正品，一直用这个牌子，朋友都说我用过皮肤比以前好多了，还帮朋友买了好几个</li>
			</ul>
		</li>`;
	}
	$(".box").html($(".box").html()+content+"</ul></div>");
}
//明星推荐渲染函数
function getmxtj(data) {
	console.log("明星推荐");
	var dataInfo = data["goods"];
	var content =`<div class="card2_goods card_goods"><div class="flex">`;
	for(i in dataInfo) {
		var a=i;
		if(i%2==1) {
			content+=`<div class="goods${++a} goods">
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[i]["imgDesc"]}" /></a>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}" class="know">${dataInfo[i]["goodsName"]}</a>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}" class="name">女人我最大</a>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}" class="gongxiao">若肤质年轻，毛孔因油脂过多而呈现圆形，选择添加果酸、水杨酸、酵素类等成分的化妆品可帮助毛孔保持畅通，若已步入轻熟龄，毛孔呈现拉长水滴状，搭配刺激胶原蛋白新生的紧肤配方，延缓老化松弛。Estee Lauder细嫩修护精华露，能溶解阻塞于毛孔内的脏污，并促进已撑开的毛孔内壁紧致回缩。 </a>
					</div>`;
		}else {
			content +=	`<div class="goods${++a} goods">
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}" class="know">${dataInfo[i]["goodsName"]}</a>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}" class="name">女人我最大</a>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}" class="gongxiao">若肤质年轻，毛孔因油脂过多而呈现圆形，选择添加果酸、水杨酸、酵素类等成分的化妆品可帮助毛孔保持畅通，若已步入轻熟龄，毛孔呈现拉长水滴状，搭配刺激胶原蛋白新生的紧肤配方，延缓老化松弛。Estee Lauder细嫩修护精华露，能溶解阻塞于毛孔内的脏污，并促进已撑开的毛孔内壁紧致回缩。 </a>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${dataInfo[i]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${dataInfo[i]["imgDesc"]}" /></a>
						</div>`;
		}
	}
	$(".box").html($(".box").html()+content+`</div></div>`);
}
// 品牌活动渲染函数
function pphd(data){
	console.log("品牌活动");
	var asa = data.ads[0].imgPre;
	var content = `<div id="brandActivity">
			<div class="start startS">
				<!-- 左边部分 -->
				<div class="leftPart brandWord">品牌活动</div>
				<!-- 右边部分 -->
				<div class="rightPart">
					<ul>
						<li>
							<a href="">高丝雪肌精4.3折起</a>
						</li>
						<li class="li">
							<a href="">兰蔻专场1.6折起</a>
						</li>
						<li class="li">
							<a href="">科颜氏3.3折起</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="brandMain">
				${addBrandMain(asa,data)}
			</div>
		</div>`;
		$(".three").html(content);
}
// 品牌活动里面的循环
function addBrandMain(asa,data){
	var content = "";
	for(var i=0;i<asa.length;i++){
		content += `<a href="###"><img src="http://118.89.25.129:8080/Fashion/resource/${asa[i]}${data.ads[0]["detailImg"][i]}${data.ads[0]["imgSuff"][i]}"/></a>`;
	}
	return content;
}
// 护肤渲染函数
function hf(data){
	console.log("护肤");
		var ads = data.ads[0];
		var asa1 = data.goods;
		var brands = data.brands;
		// 护肤
		var content1 = `<div id="skinCare">
			<!-- 头部 -->
			<div class="start">
				<!-- 左边部分 -->
				<div>
					<img src="http://photo.no5.com.cn/page_2014/images/hufu.jpg" alt=""  class="leftPart">
				</div>
				<!-- 右边部分 -->
				<div class="rightPart">
					<ul>
						<li>
							<a href="">红石榴</a>
						</li>
					</ul>
				</div>
			</div>
			<!--中间部分 -->
			<div class="middle">
				<!-- 最左边的图 -->
				<div>
					${addSkinLeft(ads)}
				</div>
				<!-- 中间的部分 -->
					${addSkinCare(asa1)}	
			</div>
			<div class="projectBrand">
					${addProjectBrand(brands)}
			</div>
		</div>`
	$(".four").html(content1);
	rexiao1();
}
// 护肤里面的循环
function addSkinLeft(ads){
	var content = "";
	content +=`<a href="###">
					<img src="http://118.89.25.129:8080/Fashion/resource/${ads.imgPre}${ads.detailImg}${ads.imgSuff}" class="leftPic" />
				</a>`;
	return content;
}
//护肤里面的循环
function addSkinCare(asa1){
	var content1 = `<div class="hotSales s"><h2>护肤热销</h2><ul>`;
	var content2 = `<div class="hufuList float_left"><ul>`;
	var content3 = "";
	var hotcount = 0;
	var count = 0;
	for(var i=0;i<asa1.length;i++){
		if(asa1[i].isHot==1){
			hotcount++;
			content1 +=`<!-- 最右边的部分 -->
			
					<li class="liHot">
						<!-- 不隐藏的部分 -->
						<div class="showPart showPartOne">
							<span>${hotcount}</span>
							<span>${asa1[i].goodsName}</span>
						</div>
						<!-- 隐藏的部分，鼠标移入则出现 -->
						<div class="hiddenPart hiddenPartOne">
							<div>
								<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}">
									<img src="http://118.89.25.129:8080/Fashion/resource/${asa1[i].imgDesc}" alt="" class="index_img2">
								</a>
							</div>
							<p>${asa1[i].goodsName}</p>
							<p>￥${asa1[i].shopPrice}</p>
						</div>
					</li>`;
		}else{
			if((count++)<=1){
				content2 +=`
				<li class="hufu_item${count}">
							<div class="float_left">
								<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}"><img src="http://118.89.25.129:8080/Fashion/resource/${asa1[i].imgDesc}" alt="肌透修护精华胶囊"  class="index_img1"></a>
							</div>
							<div class="hufu_item1_word">
									<div class="hufu_word1">
										<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}">${asa1[i].goodsName}</a><br/>
									</div>
									<div class="hufu_word2 dot">
										<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}">${asa1[i].goodsDesc}</a>
									</div>
									<div class="hufu_price">
											￥<span class="hufu_price1">${asa1[i].shopPrice}.<span class="hufu_price2">00</span></span><span class="hufu_discount">${asa1[i].discount}</span>
									</div>
							</div>
						</li>`;
			}else{
				content3 +=`<li class="hufu_item${count}">
						<div class="hufu_function">
							<span class="hufu_function1"><a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}">${asa1[i].goodsName}</a></sapn><br/>
							<span class="hufu_function2"><a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}">${asa1[i].goodsDesc}</a></span>
						</div>
						<div class="hufu_price">
										￥<span class="hufu_price1">${asa1[i].shopPrice}.<span class="hufu_price2">00</span></span><span class="hufu_discount">(${asa1[i].discount}折)</span>
								</div>
						<div>
							<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${asa1[i]["goodsId"]}">
								<img src="http://118.89.25.129:8080/Fashion/resource/${asa1[i].imgDesc}" alt="略" class="index_img1">
							</a>
						</div>
					</li>`;
			}
		}
	
	}
	return content1+"</ul></div>"+content2+content3+"</ul></div>";
}
// 护肤底部的循环
	function addProjectBrand(brands){
		var content = "";
		for(var i=0;i<brands.length;i++){
			content +=`<a href="###">
				<img src="http://118.89.25.129:8080/Fashion/resource/${brands[i].imgDesc}" alt="">
			</a>`;
    	}
    	return content;
}
//彩妆渲染函数
function ca(data){
		var ads = data.ads[0];
		var goods = data.goods;
		var brands = data.brands;
		var caizhuang = 
	`<div id="skinCare">
		<div class="start">
			<!-- 左边部分 -->
			<div>
				<img src="http://photo.no5.com.cn/page_2014/images/caiz.jpg" alt=""  class="leftPart">
			</div>
			<!-- 右边部分 -->
			<div class="rightPart">
				<ul>
					<li>
						<a href="">红石榴</a>
					</li>
					<li class="li">
						<a href="">小棕瓶</a>
					</li>
					<li class="li">
						<a href="">保湿面膜</a>
					</li>
					<li class="li">
						<a href="">补水保湿</a>
					</li>
					<li class="li">
						<a href="">卸妆油</a>
					</li>
					<li class="li">
						<a href="">小黑瓶</a>
					</li>
					<li class="li">
						<a href="">倩碧三部曲</a>
					</li>	
				</ul>
			</div>
		</div>
		<!--中间部分 -->
		<div class="middle">
			<!-- 最左边的图 -->
			<div>
				<a href="###">
					<img src="http://118.89.25.129:8080/Fashion/resource/${ads.imgPre}${ads.detailImg}${ads.imgSuff}" alt=""  class="leftPic">
				</a>
			</div>
			${czgoods(goods)}	
		</div>
		<div class="projectBrand">
			${goodsqj(brands)}
		</div>
	</div>
	`;
	$(".five").html(caizhuang);
	rexiao2();
}
//彩妆里面的循环
function czgoods(goods){
	var content1=`<div class="hufuList float_left"><ul>`;
	var content3=`<div class="hotSales a"><h2>彩妆热销</h2><ul>`;
	var content2 = "";
	var count=0;
	var hotcount = 0;
	for(i in goods){
		if(goods[i].isHot==1){
			hotcount++;
			content3 +=
`
<li class="liHot">
	<!-- 不隐藏的部分 -->
	<div class="showPart showPartOne">
		<span>${hotcount}</span>
		<span>${goods[i].goodsName}</span>
	</div>
	<!-- 隐藏的部分，鼠标移入则出现 -->
	<div class="hiddenPart hiddenPartOne">
		<div>
			<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
				<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img2">
			</a>
		</div>
		<p>${goods[i].goodsName}</p>
		<p>￥${goods[i].shopPrice}</p>
	</div>
</li>
`;
		}else{
			if((count++)<2){
			content1 +=
`
<li class="hufu_item${count}">
	<div class="float_left">
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
			<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="图片暂时未存在"  class="index_img1">
		</a>
	</div>
	<div class="hufu_item1_word">
			<div class="hufu_word1">
				<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">${goods[i].goodsName}</a><br/>
			</div>
			<div class="hufu_word2 dot">
				<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">${goods[i].goodsDesc}</a>
			</div>
			<div class="hufu_price">
					￥<span class="hufu_price1">${goods[i].shopPrice}.<span class="hufu_price2">00</span></span><span class="hufu_discount">(${goods[i].discount}折)</span>
			</div>
	</div>
</li>`;
		}else {
			content2 += 
`
<li class="hufu_item${count}">
	<div class="hufu_function">
		<span class="hufu_function1">
			<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}"> ${goods[i].goodsName}</a>
		</span>
		<br/>
		<span class="hufu_function2"><a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">${goods[i].goodsDesc}</a></span>
	</div>
	<div class="hufu_price">
		￥<span class="hufu_price1">${goods[i].shopPrice}.<span class="hufu_price2">00</span></span><span class="hufu_discount">(${goods[i].discount}折)</span>
	</div>
	<div>
		<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
			<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img1">
		</a>
	</div>
</li>
`;
			}
		}
	}
	return content1+content2+"</ul></div>"+content3+"</ul></div>";
}
//彩妆里面的循环
function goodsqj(brands){
	var content = "";
	for(i in brands){
		content += 
`
<a href="###">
	<img src="http://118.89.25.129:8080/Fashion/resource/${brands[i].imgDesc}" alt="" width="75" height="36">
</a>
`
	}
	return content;
}
// 男士的渲染函数
function mans(data){	
	console.log("男士");
	var ads = data.ads[0];
	var goods = data.goods;
	var brands = data.brands;
	var content2 = `	
		<div id="skinCare">
			<div class="start">
				<div>
					<img src="http://photo.no5.com.cn/page_2014/images/men.jpg" alt=""  class="leftPart">
				</div>
				<div class="rightPart">
					<ul>
						<li>
							<a href="">红石榴</a>
						</li>
						<li class="li">
							<a href="">小棕瓶</a>
						</li>
						<li class="li">
							<a href="">保湿面膜</a>
						</li>
						<li class="li">
							<a href="">补水保湿</a>
						</li>
						<li class="li">
							<a href="">卸妆油</a>
						</li>
						<li class="li">
							<a href="">小黑瓶</a>
						</li>
						<li class="li">
							<a href="">倩碧三部曲</a>
						</li>	
					</ul>
				</div>
			</div>
			
			<div class="middle">
				<!-- 最右边的图 -->
					${addMenRight(goods)}
				<div class="float_left menPic">
						${addMenPic(ads)}
				</div>
				
				
			</div>
			<div class="projectBrand">
				${addMenBottom(brands)}
			</div>
		</div>`;
		$('.seven').html(content2);
		rexiao4();
}
//男士里面的循环
function addMenPic(ads){
	var content = "";
	content +=`<a href="###"><img src="http://118.89.25.129:8080/Fashion/resource/${ads.imgPre[0]}${ads.detailImg[0]}${ads.imgSuff[0]}" alt="" class="index_img5"></a>`;
	return content;
}
//男士里面的循环
function addMenRight(goods){
	var content1 = `<div class="hotSales c"><h2>护肤热销</h2><ul>`;
	var content2 = `<div class="menList float_left" style="width: 615px;height: 480px;"><ul>`;
	var Mencount = 0;
	for(var i=0;i<goods.length;i++){
		if(goods[i].isHot==1){
			Mencount++;
			content1 +=`<!-- 最右边的部分 -->
						<li class="liHot">
						<!-- 不隐藏的部分 -->
						<div class="showPart showPartOne">
							<span>${Mencount}</span>
							<span>${goods[i].goodsName}</span>
						</div>
						<!-- 隐藏的部分，鼠标移入则出现 -->
						<div class="hiddenPart hiddenPartOne">
							<div>
								<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
									<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="略" class="index_img2">
								</a> 
							</div>
							<p>${goods[i].goodsName}</p>
							<p>￥${goods[i].shopPrice}</p>
						</div>
					</li>`;
		}else{
				content2 += `
					<li>
						<div>
							<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
								<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="略" class="index_img4">
							</a>
						</div>
						<div class="dot"><a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">${goods[i].goodsName}</a></div>
						<div>
							<span class="menPrice1">￥${goods[i].shopPrice}.00</span>
							<span class="menPrice2">(${goods[i].discount}折)</span>
						</div>
					</li>`;
			
		}
	}	
	return content1+"</ul></div>"+content2+"</ul></div>";
}
// 男士护肤底部循环
function addMenBottom(brands){
	var content = "";
	for(var i=0;i<brands.length;i++){
		content += `<a href="###">
					<img src="http://118.89.25.129:8080/Fashion/resource/${brands[i].imgDesc}" alt="">
				</a>`;
  }
  return content;
}
//香水渲染函数
function xs(data){
	console.log("香水");
	var ads = data.ads[0];
	var brands = data.brands;
	var goods = data.goods;
	var xiangshui = 
	`
	<!-- 香水 -->
		<div id="perfume">
			<!-- 头部 -->
			<div class="start">
				<!-- 左边部分 -->
				<div>
					<img src="http://photo.no5.com.cn/page_2014/images/xiangs.jpg" alt=""  class="leftPart">
				</div>
				<!-- 右边部分 -->
				<div class="rightPart">
					<ul>
						<li>
							<a href="">红石榴</a>
						</li>
						<li class="li">
							<a href="">小棕瓶</a>
						</li>
						<li class="li">
							<a href="">保湿面膜</a>
						</li>
						<li class="li">
							<a href="">补水保湿</a>
						</li>
						<li class="li">
							<a href="">卸妆油</a>
						</li>
						<li class="li">
							<a href="">小黑瓶</a>
						</li>
						<li class="li">
							<a href="">倩碧三部曲</a>
						</li>	
					</ul>
				</div>
			</div>
			<!--中间部分 -->
			<div class="middle">
				${xsgoods(ads,goods)}
			</div>
			<div class="projectBrand">
				${goodsqj(brands)}
			</div>
		</div>
		`;
	$(".six").html(xiangshui);
	rexiao3();
}
//香水里面的循环
function xsgoods(ads,goods){
	var content1 = "";
	var content2 = `<div class="hufuList perfumeList float_left">`; 
	var content3 = "";
	var content4 = `<div class="hotSales b"><h2>彩妆热销</h2><ul>`;
	content1+=
`
<div class="mr1" style="width:326px; height:480px;">
	<a href="###">
		<img src="http://118.89.25.129:8080/Fashion/resource/${ads.imgPre[0]}${ads.detailImg[0]}${ads.imgSuff[0]}" alt=""  class="perfumeLeftPic" width="326" height="480">
	</a>
</div>
`;	
	var count = 0;
	var hotcount = 0;	
	for(i in goods){
		// ishot!=1
		if(goods[i].isHot==0){
			count++;
			if(count==1){
				content2 +=
`
<div class="float_left mb1 mr1">
	<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
		<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" width="355" height="276">
	</a>
</div>
`;
			}
			if(count==2){
				content2+=
`
<div class="float_left mr1">
	<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
		<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img3" width="177" height="203">
	</a>
</div>
`;
			}
			if(count==3){
				content2+=
`
<div class="float_left">
	<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
		<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img3" width="177" height="203">
	</a>
</div>
`;
			}
		}else if(goods[i].isHot==1){
			hotcount++;
			content4 +=
`
<li class="liHot">
	<!-- 不隐藏的部分 -->
	<div class="showPart showPartOne">
		<span>${hotcount}</span>
		<span>${goods[i].goodsName}</span>
	</div>
	<!-- 隐藏的部分，鼠标移入则出现 -->
	<div class="hiddenPart hiddenPartOne">
		<div>
			<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
				<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img2" width="160" height="160">
			</a>
		</div>
		<p>${goods[i].goodsName}</p>
		<p>￥${goods[i].shopPrice}</p>
	</div>
</li>
`;
		}
	}
	content3+=
`
<div class="float_left ml1" style="width:275px; height="480px";>
	<a href="###">
		<img src="http://118.89.25.129:8080/Fashion/resource/${ads.imgPre[1]}${ads.detailImg[1]}${ads.imgSuff[1]}" alt=""  class="" width="275" height="480">
	</a>
</div>
`;
return content1+content2+"</div>"+content3+content4+"</ul></div>";
} 
//美体美发渲染函数
function mtmf(data){
	console.log("美体美发");
	var ads = data.ads[0];
	var goods = data.goods;
	var brands = data.brands;
	var content3 = `<!-- 美体美发 -->
		<div id="skinCare">
			<!-- 头部 -->
			<div class="start">
				<!-- 左边部分 -->
				<div>
					<img src="http://photo.no5.com.cn/page_2014/images/body.jpg" alt=""  class="leftPart">
				</div>
				<!-- 右边部分 -->
				<div class="rightPart">
					<ul>
						<li>
							<a href="">红石榴</a>
						</li>
						<li class="li">
							<a href="">小棕瓶</a>
						</li>
						<li class="li">
							<a href="">保湿面膜</a>
						</li>
						<li class="li">
							<a href="">补水保湿</a>
						</li>
						<li class="li">
							<a href="">卸妆油</a>
						</li>
						<li class="li">
							<a href="">小黑瓶</a>
						</li>
						<li class="li">
							<a href="">倩碧三部曲</a>
						</li>	
					</ul>
				</div>
			</div>
			
			<div class="middle">
				<!-- 最左边的图 -->
				<div class="float_left menPic">
					${addBodyLeft(ads)}
						
				</div>
				<!-- 最右边的部分 -->
				${addBodyRight(goods)}
				
				
			</div>
			<div class="projectBrand">
				${addBodyBottom(brands)}
			
			</div>
		</div>`;
		$(".eight").html(content3);
		rexiao5();
}
// 美体美发最左边的循环
function addBodyLeft(ads){
	var content = "";
	content +=`<a href="###">
						<img src="http://118.89.25.129:8080/Fashion/resource/${ads.imgPre[0]}${ads.detailImg[0]}${ads.imgSuff[0]}" alt="" class="index_img5">
					</a>`;
	return content;
}
//美体美发里面的循环
function addBodyRight(goods){
	var content1 = `<div class="hotSales d"><h2>护肤热销</h2><ul>`;
	var content2 = `<div class="menList float_left" style="width: 615px;height: 480px;"><ul>`;
	var bodyCount = 0;
	var count = 0;
	for(var i=0;i<goods.length;i++){
		if(goods[i].isHot==1){
			bodyCount++;
			content1 +=`
					<li class="liHot">
						<!-- 不隐藏的部分 -->
						<div class="showPart showPartOne">
							<span>${bodyCount}</span>
							<span>${goods[i].goodsName}</span>
						</div>
						<!-- 隐藏的部分，鼠标移入则出现 -->
						<div class="hiddenPart hiddenPartOne">
							<div>
								<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
									<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img2">
								</a>
							</div>
							<p>${goods[i].goodsName}</p>
							<p>￥${goods[i].shopPrice}</p>
						</div>
					</li>`;
		}else{
			content2 +=`
					<li>
						<div>
							<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">
								<img src="http://118.89.25.129:8080/Fashion/resource/${goods[i].imgDesc}" alt="" class="index_img4">
							</a>
						</div>
						<div class="dot"><a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${goods[i]["goodsId"]}">${goods[i].goodsName}</a></div>
						<div>
							<span class="menPrice1">￥${goods[i].shopPrice}.00</span>
							<span class="menPrice2">(${goods[i].discount}折)</span>
						</div>
					</li>`;
		}
	}
	return content1+"</ul></div>"+content2+"</ul></div>";
}
// 美体美发底部
function addBodyBottom(brands){
	var content = "";
	for(var i=0;i<brands.length;i++){
		content += `<a href="###">
					<img src="http://118.89.25.129:8080/Fashion/resource/${brands[i].imgDesc}" alt="">
				</a>`;
  }
  return content;
}

//美容咨询
function mrzx(){
	var content =`<!--美容资讯-->
	<div class="beauty clearfix">
		<div class="beautyinfo fl clearfix">
			<h2>
				<a href="###">美容资讯</a>
			</h2>
			<div class="info_left fl">
				<dl class="clearfix">
					<dt class="fl">
						<a href="###">
							<img src="../img/16042916161141818825.png" alt="" width="250" height="330">
						</a>
					</dt>
					<dd class="title fl">根据场合选择防晒指数 这些新品帮你度</dd>
					<dd class="neir fl">很多女生在夏天最担心的一件事就是晒黑了，而这些今年春夏新出的防晒新品，...
						<a href="###">[查看更多]</a>
					</dd>
				</dl>
			</div>
			<div class="info_right fl">
				<dl>
					<dt class="fl">
						<a href="###">
							<img src="../img/16031817181464983497.png" alt="" width="154" height="118">
						</a>
					</dt>
					<dd class="title fl">
						<span>香水</span>上万种香水类型 据说只有1%的人会选
					</dd>
					<dd class="neir fl">
						性感女人的标志除了恨天高，就是香水了。常在圈里混，撞衫撞脸已不新鲜，现在最新潮的就是“撞香”。跟美女撞了，叫高逼格有品位，跟豪放大妈...
						<a href="###">[查看更多]</a>
					</dd>
				</dl>
				<dl>
					<dt class="fl">
						<a href="###">
							<img src="../img/16031817181464983497.png" alt="" width="154" height="118">
						</a>
					</dt>
					<dd class="title fl">
						<span>香水</span>上万种香水类型 据说只有1%的人会选
					</dd>
					<dd class="neir fl">
						性感女人的标志除了恨天高，就是香水了。常在圈里混，撞衫撞脸已不新鲜，现在最新潮的就是“撞香”。跟美女撞了，叫高逼格有品位，跟豪放大妈...
						<a href="###">[查看更多]</a>
					</dd>
				</dl>
				<dl>
					<dt class="fl">
						<a href="###">
							<img src="../img/16031817181464983497.png" alt="" width="154" height="118">
						</a>
					</dt>
					<dd class="title fl">
						<span>香水</span>上万种香水类型 据说只有1%的人会选
					</dd>
					<dd class="neir fl">
						性感女人的标志除了恨天高，就是香水了。常在圈里混，撞衫撞脸已不新鲜，现在最新潮的就是“撞香”。跟美女撞了，叫高逼格有品位，跟豪放大妈...
						<a href="###">[查看更多]</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="beautyshare fr">
			<h2>编辑推荐</h2>
			<dl class="first_dl clearfix">
				<dt class="fr">
					<a href="http://www.no5.com.cn/product/28848.html">
						<img src="../img/prod_28848_S_150130152610_62035042.jpg" alt="" width="80" height="80">
					</a>
				</dt>
				<dd class="title fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank" class="">AUPRES欧珀莱 男士俊士JS眼部沁凉滚珠精华液/眼霜 15ml</a>
				</dd>
				<dd class="neir fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank"><span>编辑推荐：</span>用了这款没多久，感觉眼袋跟黑眼圈的问题缓解了不少</a>
				</dd>
			</dl>
			<dl class="clearfix">
				<dt class="fr">
					<a href="http://www.no5.com.cn/product/28848.html">
						<img src="../img/prod_28848_S_150130152610_62035042.jpg" alt="" width="80" height="80">
					</a>
				</dt>
				<dd class="title fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank" class="">AUPRES欧珀莱 男士俊士JS眼部沁凉滚珠精华液/眼霜 15ml</a>
				</dd>
				<dd class="neir fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank"><span>编辑推荐：</span>用了这款没多久，感觉眼袋跟黑眼圈的问题缓解了不少</a>
				</dd>
			</dl>
			<dl class="clearfix">
				<dt class="fr">
					<a href="http://www.no5.com.cn/product/28848.html">
						<img src="../img/prod_28848_S_150130152610_62035042.jpg" alt="" width="80" height="80">
					</a>
				</dt>
				<dd class="title fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank" class="">AUPRES欧珀莱 男士俊士JS眼部沁凉滚珠精华液/眼霜 15ml</a>
				</dd>
				<dd class="neir fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank"><span>编辑推荐：</span>用了这款没多久，感觉眼袋跟黑眼圈的问题缓解了不少</a>
				</dd>
			</dl>
			<dl class="clearfix">
				<dt class="fr">
					<a href="http://www.no5.com.cn/product/28848.html">
						<img src="../img/prod_28848_S_150130152610_62035042.jpg" alt="" width="80" height="80">
					</a>
				</dt>
				<dd class="title fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank" class="">AUPRES欧珀莱 男士俊士JS眼部沁凉滚珠精华液/眼霜 15ml</a>
				</dd>
				<dd class="neir fl">
					<a href="http://www.no5.com.cn/product/28848.html" target="_blank"><span>编辑推荐：</span>用了这款没多久，感觉眼袋跟黑眼圈的问题缓解了不少</a>
				</dd>
			</dl>
		</div>
	</div>`;
	$(".nine").html(content);
}

//底部渲染
function lastBottom() {
	var content=
`
<div class="footer clearfix fl">
	<div class="footer_top clearfix">
		<div class="footer_top_one fl">
			<div class="tel">
				<p class="num">010-51666655</p>
				<p class="time">9:00-18:00</p>
			</div>
			<p class="weibo">新浪官方微博
				<a href="http://weibo.com/no5fashion" target="_blank"><img src="http://photo.no5.com.cn/page_2014/images/guanzhu.jpg"></a>
			</p>
			<p class="dingyue">
				<input type="text" placeholder="请输入您的Email地址">
				<img src="http://photo.no5.com.cn/page_2014/images/ding.jpg">
			</p>
			<p class="ps">最新美容资讯，新品及促销信息</p>
		</div>
		<dl class="howto fl">
			<dt>
				<a href="http://www.no5.com.cn/help/about_order.html" target="_blank">如何订购</a>
			</dt>
			<dd>
				<a href="http://www.no5.com.cn/help/about_order.html#1" target="_blank">网上下单</a>
			</dd>
			<dd>
				<a href="http://www.no5.com.cn/help/about_order.html#2" target="_blank">电话订购网上下单</a>
			</dd>
			<dd>
				<a href="http://www.no5.com.cn/help/about_order.html#3" target="_blank">邮寄订购</a>
			</dd>
			<dd>
				<a href="http://www.no5.com.cn/help/about_order.html#4" target="_blank">传真订购</a>
			</dd>
		</dl>
		<dl class="howto fl">
			<dt>
				<a href="http://www.no5.com.cn/help/about_deliver.html" target="_blank">如何送货</a>
			</dt>
        	<dd>
        		<a href="http://www.no5.com.cn/help/about_deliver.html#1" target="_blank">送货上门</a>
        	</dd>
        	<dd>
        		<a href="http://www.no5.com.cn/help/about_deliver.html#2" target="_blank">快递</a>
        	</dd>
   		 </dl>
		<dl class="howto fl">
			<dt>
				<a href="http://www.no5.com.cn/help/about_payment.html" target="_blank">如何付款</a>
			</dt>
            <dd>
            	<a href="http://www.no5.com.cn/help/about_payment.html#1" target="_blank">货到付款</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/about_payment.html#4" target="_blank">在线支付</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/about_payment.html#2" target="_blank">邮政汇款</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/about_payment.html#3" target="_blank">银行汇款</a>
            </dd>
    	</dl>
    	<dl class="howto fl">
			<dt>
				<a href="http://www.no5.com.cn/help/inquire_order.html" target="_blank">订单查询</a>
			</dt>
            <dd>
            	<a href="http://www.no5.com.cn/help/inquire_order.html#1" target="_blank">订单状态</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/inquire_order.html#2" target="_blank">查询订单</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/inquire_order.html#3" target="_blank">无效订单</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/inquire_order.html#4" target="_blank">支付失败</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/oosregister.html" target="_blank">缺货登记</a>
            </dd>
   		 </dl>
   		 <dl class="howto fl">
			<dt>
				<a href="http://www.no5.com.cn/help/member_service.html" target="_blank">会员服务</a>
			</dt>
            <dd>
            	<a href="http://www.no5.com.cn/help/member_service.html#1" target="_blank">N°5会员级别</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/member_service.html#3" target="_blank">N°5购物保障</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/member_service.html#4" target="_blank">N°5贴心服务</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/member_service.html#5" target="_blank">账户积分使用</a>
            </dd>
        </dl>
        <dl class="howto lastdl fl">
			<dt>
				<a href="http://www.no5.com.cn/help/contact_us.html" target="_blank">联系我们</a>
			</dt>
            <dd>
            	<a href="http://www.no5.com.cn/help/contact_us.html#1" target="_blank">关于N°5</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/contact_us.html#2" target="_blank">加入N°5</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/help/contact_us.html#3" target="_blank">团购加盟</a>
            </dd>
            <dd>
            	<a href="http://www.no5.com.cn/join/join.html" target="_blank">网站加盟</a>
            </dd>
            <dd>
            	<a href="javascript:void(0);" onclick="javascript:LINK.onlineService(1);">投诉</a><a href="javascript:void(0);" onclick="javascript:LINK.onlineService(2);">建议</a>
            </dd>
        </dl>
        <div class="wei fl"><img src="http://photo.no5.com.cn/page_2014/images/2wm.jpg"></div>
	</div>
	
</div>
<div class="footer_middle clearfix">
	<dl class="footer_middle_list fl">
		<dt>
			<img src="http://photo.no5.com.cn/page_2014/images/f_04.jpg">
		</dt>
		<dd>足不出户 享受网购乐趣</dd>
		<dd>北京城区次日送达</dd>
	</dl>
	<dl class="footer_middle_list fl">
		<dt>
			<img src="http://photo.no5.com.cn/page_2014/images/f_05.jpg">
		</dt>
		<dd>品质保证</dd>
		<dd>15天不满意退换货</dd>
	</dl>
	<dl class="footer_middle_list fl">
		<dt>
			<img src="http://photo.no5.com.cn/page_2014/images/f_06.jpg">
		</dt>
		<dd>价格实惠  购物有积分</dd>
		<dd>积分抵现金</dd>
	</dl>
	<dl class="footer_middle_list fl">
		<dt>
			<img src="http://photo.no5.com.cn/page_2014/images/f_07.jpg">
		</dt>
		<dd>1800多城市送货上门</dd>
		<dd>货到付款</dd>
	</dl>
</div>
<p class="footer_bottom">Copyright @ 2001-2012 N°5.com.cn All Rights Reserved 京ICP备11045170号</p>`;
	$(".ten").html(content);
}
//热销选项卡
function rexiao1(){
	var liHot = document.querySelectorAll(".s .liHot");
	var showPart = document.querySelectorAll(".s .showPart");
	var hiddenPart = document.querySelectorAll(".s .hiddenPart");
	for(var i=0;i<liHot.length;i++){
		liHot[i].index = i;
		hiddenPart[i].style.display = "none";
		hiddenPart[0].style.display = "block";
		showPart[i].style.display="block";
		showPart[0].style.display = "none";
		liHot[i].onmouseover = function(){
			for(var j=0;j<liHot.length;j++){
				showPart[j].style.display = "block";
				hiddenPart[j].style.display = "none";
			}
			showPart[this.index].style.display = "none";
			hiddenPart[this.index].style.display = "block";
		}
	}
}
function rexiao2() {
	var liHotA = document.querySelectorAll(".a .liHot");
	var showPartA = document.querySelectorAll(".a .showPart");
	var hiddenPartA = document.querySelectorAll(".a .hiddenPart");
	for(var i=0;i<liHotA.length;i++){
		liHotA[i].index = i;
		hiddenPartA[i].style.display = "none";
		hiddenPartA[0].style.display = "block";
		showPartA[i].style.display="block";
		showPartA[0].style.display = "none";
		liHotA[i].onmouseover = function(){
			for(var j=0;j<liHotA.length;j++){
				showPartA[j].style.display = "block";
				hiddenPartA[j].style.display = "none";
			}
			showPartA[this.index].style.display = "none";
			hiddenPartA[this.index].style.display = "block";
		}
	}
}
function rexiao3() {
	var liHotB = document.querySelectorAll(".b .liHot");
	var showPartB = document.querySelectorAll(".b .showPart");
	var hiddenPartB = document.querySelectorAll(".b .hiddenPart");
	for(var i=0;i<liHotB.length;i++){
		liHotB[i].index = i;
		hiddenPartB[i].style.display = "none";
		hiddenPartB[0].style.display = "block";
		showPartB[i].style.display="block";
		showPartB[0].style.display = "none";
		liHotB[i].onmouseover = function(){
			for(var j=0;j<liHotB.length;j++){
				showPartB[j].style.display = "block";
				hiddenPartB[j].style.display = "none";
			}
			showPartB[this.index].style.display = "none";
			hiddenPartB[this.index].style.display = "block";
		}
	}
}
function rexiao4() {
	var liHotC = document.querySelectorAll(".c .liHot");
	var showPartC = document.querySelectorAll(".c .showPart");
	var hiddenPartC = document.querySelectorAll(".c .hiddenPart");
	for(var i=0;i<liHotC.length;i++){
		liHotC[i].index = i;
		hiddenPartC[i].style.display = "none";
		hiddenPartC[0].style.display = "block";
		showPartC[i].style.display="block";
		showPartC[0].style.display = "none";
		liHotC[i].onmouseover = function(){
			for(var j=0;j<liHotC.length;j++){
				showPartC[j].style.display = "block";
				hiddenPartC[j].style.display = "none";
			}
			showPartC[this.index].style.display = "none";
			hiddenPartC[this.index].style.display = "block";
		}
	}
}
function rexiao5() {
	var liHotD = document.querySelectorAll(".d .liHot");
	var showPartD = document.querySelectorAll(".d .showPart");
	var hiddenPartD = document.querySelectorAll(".d .hiddenPart");
	for(var i=0;i<liHotD.length;i++){
		liHotD[i].index = i;
		hiddenPartD[i].style.display = "none";
		hiddenPartD[0].style.display = "block";
		showPartD[i].style.display="block";
		showPartD[0].style.display = "none";
		liHotD[i].onmouseover = function(){
			for(var j=0;j<liHotD.length;j++){
				showPartD[j].style.display = "block";
				hiddenPartD[j].style.display = "none";
			}
			showPartD[this.index].style.display = "none";
			hiddenPartD[this.index].style.display = "block";
		}
	}
}
//倒计时
//function daojishi() {
//	var time = "10:01:10";
//	var timeArr = time.split(":");
//	timeArr[0]=Number(timeArr[0]);
//	timeArr[1]=Number(timeArr[1]);
//	var hour = timeArr[0];
//	var countdownTimer=setInterval(function(){
//		timeArr[2]-=0.1;
//		if(timeArr[2]<0) {
//			timeArr[2]=59.9;
//			timeArr[1]-=1;
//			if(timeArr[1]<0) {
//				timeArr[1]=59;
//				timeArr[0]-=1;
//				if(timeArr[0]<0) {
//					timeArr[0]= hour;
//				}
//			}
//		}
//		$(".hour").html(checktime(timeArr[0]));
//		$(".minute").html(checktime(timeArr[1]));
//		$(".second").html(checktime(timeArr[2].toFixed(1)));
//		function checktime(i) {
//			if(i<10&&i>=0) {
//				return "0"+i;
//			}else {
//				return i;
//			}
//		}
//	},100)
//}
//本周特价模块选项卡
function chooseCards() {
$(".chooseCard .card li").on("mouseenter",function(){
	$(".chooseCard .card li").css("border-bottom","2px solid #d0d0d0");
	$(".chooseCard .card li .triangle").css("display","none");
	$(this).css("border-bottom","2px solid #0094ff");
	$(this).children(".triangle").css("display","block");
	$(".chooseCard .card_goods").css("display","none");
	$(".chooseCard .card"+($(this).index(".chooseCard .card li")+1)+"_goods").css("display","block");
})
}
