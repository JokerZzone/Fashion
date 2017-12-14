//左上角分类部分数据添加
$.ajax({
	type:"get",
	url:"http://118.89.25.129:8080/Fashion/category/findOne",
	async:true,
	success: function(data){
		var content = '<div id="smallType"><ul>';
		for(var i=0;i<data.length;i++){
			content += `
					<li>
						<h3>
							<span class="faceType"></span>${data[i].firstCategory[0].firstName}<span class="smallNumber">(420)</span>
						</h3>	
						
								${addSmallDropTop(data[i])}					
					</li>`;
			}
			var aaa = content + "</ul></div>";
			$(".oneOne").html(aaa);
			smallLeft();
	}
});
//左上角
function addSmallDropTop(ele){
	var content = '<div class="dropown"><ol>';
	for(var i=0;i<ele.Desc.length;i++){
		content +=`<li>
						<a href="http://118.89.25.129:8080/Fashion/resource/static/html/sample.html?catId=${ele.Desc[i].secondId}"><span>${ele.Desc[i].secondName}</span><span class="smallNumber">(14)</span></a>
				</li>`;
	} 
	return content + "</ol></div>";
  }

//商品
//判断是哪个接口进来的页面
var urlOne = window.location.href;
if(urlOne.indexOf("titleId=2")>=0){
	//从导航栏超值小样进入
	$.ajax({
		type: "get",
		url: "http://118.89.25.129:8080/Fashion/goods/title?titleId=2&chooseId=0&pageId=1&sortId=0",
		async: true,
		success: function(data){
			console.log(data);
			var content = `${goods(data)}`;
			$(".three").html(content);
			$(".goodsNumTotal").html(data.total);
			$(".goodsNumPage1").html(data.totalPage);
			//判断页数
			console.log($(".goodsNumPage1").html());
			page();
			//品牌
			var content1 = `${addBrandTop(data)}`;
			$(".two").html(content1);
			brandLiss();
			//分类下面具体的
			var content2 = `${addBrandBottom(data)}`;
			$(".twoTwo").html(content2);
			brandLiss()
			var content3 = `${addGoodsPrice(data,'价格')}`;
			$(".four").html(content3);
			fenYe(data.totalPage);
			var title = "title";
			var titleId = "titleId";
			jiaGe(title,titleId,"2");
		}
	})
}

if(urlOne.indexOf("titleId=5")>=0){
	//从导航栏新品上架进入
	$.ajax({
		type: "get",
		url: "http://118.89.25.129:8080/Fashion/goods/title?titleId=5&chooseId=0&pageId=1&sortId=0",
		async: true,
		success: function(data){
			var content = `${goods(data)}`;
			$(".three").html(content);
			$(".goodsNumTotal").html(data.total);
			$(".goodsNumPage1").html(data.totalPage);
			page();
			var content1 = `${addBrandTop(data)}`;
			$(".two").html(content1);
			brandLiss();
			//分类下面具体的
			var content2 = `${addBrandBottom(data)}`;
			$(".twoTwo").html(content2);
			brandLiss()
			var content3 = `${addGoodsPrice(data,'价格')}`;
			$(".four").html(content3);
			fenYe(data.totalPage);
			var title = "title";
			var titleId = "titleId";
			jiaGe(title,titleId,'5');
		}
	})
}
//从分类进入超值小样
var urlTwo = window.location.href;
var urlS = urlTwo.slice(67);
var urlSS = urlTwo.slice(73);

console.log(urlSS);
if(urlOne.indexOf("catId")>=0){
	$.ajax({
		type: "get",
		url: "http://118.89.25.129:8080/Fashion/goods/secondTitle?"+urlS+"&chooseId=0&pageId=1&sortId=0",
		async: true,
		success: function(data){
			console.log(data);
			//点击超值小样后
			$(".brandGoods").css({
				display: "block",
			})
			var content = `${goods(data)}`;
			$(".three").html(content);
			$(".goodsNumTotal").html(data.total);
			$(".goodsNumPage1").html(data.totalPage);
			page();
			//品牌
			var content1 = `${addBrandTop(data)}`;
			$(".two").html(content1);
			brandLiss();
			//分类下面具体的
			var content2 = `${addBrandBottom(data)}`;
			$(".twoTwo").html(content2);
			brandLiss();
			var content3 = `${addGoodsPrice(data,'类别')}`;
			var content4 = `${addGoodsPrice(data,'产地')}`;
			var content5 = `${addGoodsPrice(data,'包装')}`;
			var content6 = `${addGoodsPrice(data,'功效')}`;
			var content7 = `${addGoodsPrice(data,'肌龄')}`;
			var content8 = `${addGoodsPrice(data,'价格')}`;
			var content9 = `${addGoodsPrice(data,'肤质')}`;
			var content10 = `${addGoodsPrice(data,'香调')}`;
			var content11 = `${addGoodsPrice(data,'规格')}`;
			$(".four").html(content3+content4+content5+content6+content7+content8+content9+content10+content11);
			
			fenYe2(data.totalPage,urlSS);
			arrAi();
			buXian();
			var secondTitle = "secondTitle";
			var catId = "catId";
			jiaGe(secondTitle,catId,urlSS);
			
		}
	})
}
//从导航栏超值小样进入具体商品
function goods(data){
	var content = "";
	
	for(var i=0;i<data.goodList.length;i++){
		content += `<div class="goodsContent">
						<div class="goodsPicBox">
							<a href="http://118.89.25.129:8080/Fashion/resource/static/html/goods.html?goodsId=${data.goodList[i].goodsId}"><img src="http://118.89.25.129:8080/Fashion/resource/${data.goodList[i].imgDesc}" alt="" class="goodsPic"></a>
						</div>
						<div class="dot goodsWord"><a href="" data-goodid = ${data.goodList[i].goodsId}>${data.goodList[i].goodsName}</a></div>
						<div class="goodsPrices">￥<span class="goodsPrice1">${data.goodList[i].shopPrice}.00</span>(<span class="goodsPrice2">${data.goodList[i].discount}</span>折)</div>
						<div>
							<a href="" class="goodsAddCar">加入购物车</a>
							<a href="" class="goodsCollection">收藏</a>
						</div>
				</div>`;
	}
	return content;
}
function addBrandTop(data){
	var content = '<ol><li class="otherBrand otherBrands">不限<span class="brandTriangle"></span></li>';
	for(i in data.goodsAttrMap.goodsBrands){
		content +=`<li class="brandLi brandLiss">${i}</li>`;
	}
	return content + "</ol>";
}
function addBrandBottom(data){
	var content = '';
	for(i in data.goodsAttrMap.goodsBrands){
		content +='<div class="brandListOne aa">';
		for(j in data.goodsAttrMap.goodsBrands[i]){
				content += `
								<div class="brandBoxOne dot"><a href="http://118.89.25.129:8080/Fashion/resource/static/html/sample.html?catId=${data.goodsAttrMap.goodsBrands[i][j].brandId}">${data.goodsAttrMap.goodsBrands[i][j].brandName}</a></div>
							`;
		}
		content += '</div>';
	
	}
	return content;
}
function addGoodsPrice(data,ele,num1,num2,isNum){
	if(isNum){
		if(data.goodsAttrMap.goodsAttributes[ele] != undefined) {
			if(data.goodsAttrMap.goodsAttributes[ele].length == 0){
					var content = "";
					return content;
			}else{
				var content = '<div class="brandType float_left brandType1"><p class="brandName">'+ele+':</p><ol><li class="otherBrand otherBrandr1">不限</li>';
				for(i in data.goodsAttrMap.goodsAttributes[ele]){
					if(num1 == data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrId){
						content +=`
								<li class="brandLi brandLis" style="background:#02a3f0;color:#fff;"><a class= "goodsAttrId" data-goodsattrid=${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrId} data-goodsattrtype=${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrType}>${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrName}</a></li>
								`;	
					}else{
						content +=`
								<li class="brandLi brandLis"><a class= "goodsAttrId" data-goodsattrid=${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrId} data-goodsattrtype=${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrType}>${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrName}</a></li>
								`;
					}
					
				}
				content += '</ol></div>';
				return content;
			}
		} else {
			var content = "";
			return content;
		}
	}else{
		if(data.goodsAttrMap.goodsAttributes[ele] != undefined) {
			if(data.goodsAttrMap.goodsAttributes[ele].length == 0){
					var content = "";
					return content;
			}else{
				var content = '<div class="brandType float_left brandType1"><p class="brandName">'+ele+':</p><ol><li class="otherBrand otherBrandr1">不限</li>';
				for(i in data.goodsAttrMap.goodsAttributes[ele]){
					content +=`
								<li class="brandLi brandLis"><a class= "goodsAttrId" data-goodsattrid=${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrId} data-goodsattrtype=${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrType}>${data.goodsAttrMap.goodsAttributes[ele][i].goodsAttrName}</a></li>
								`;
				}
				content += '</ol></div>';
				return content;
			}
		} else {
			var content = "";
			return content;
		}
	}
	
}



//点击排序========销量
function jiaGe(a,url,bb){
$(".goodsSales").on("click",function(){
	comment("http://118.89.25.129:8080/Fashion/goods/title?titleId=2&chooseId=0&pageId=1&sortId=1")
})
//点击排序=======价格
$(".goodsPrice").on("click",function(){
		if($(".goodsPrice b").css('backgroundPosition') == "-19px -234px"){
		$(".goodsPrice b").css({
			backgroundPosition: "-19px -246px",
		})
		comment("http://118.89.25.129:8080/Fashion/goods/"+a+"?"+url+"="+bb+"&chooseId=1&pageId=1&sortId=0")
	}else{
		$(".goodsPrice a").css({
			paddingRight: "10px",
		})
		$(".goodsPrice b").css({
			width: "9px",
			height: "11px",
			position: "absolute",
			top: "6px",
			right: "8px",
			background: "url(../img/xueBiTu1.jpg)",
			backgroundRepeat: "no-repeat",
			backgroundPosition: "-19px -234px",
			overflow: "hidden",
		})
		comment("http://118.89.25.129:8080/Fashion/goods/"+a+"?"+url+"="+bb+"&chooseId=1&pageId=1&sortId=1")
	}
})
}
//点击品牌下面的部分
var arrAttrId = [];
function arrAi(){
	
	$(".goodsAttrId").each(function(index,ele){
		$(".goodsAttrId").eq(index).on("click",function(){
		 var num1 = $(this).data("goodsattrid");
		arrAttrId.push(num1);
		var  num2 = $(this).data("goodsattrtype");
		var num3 = $(this).html();
		
		arrAttrId.push(num2);
		
		var obj = {
			a: num1,
			b: num2,
		}
		window.localStorage.setItem("demo",JSON.stringify(obj));
		var obj = window.localStorage.getItem("demo");
		var toObj = JSON.parse(obj);		
		console.log(arrAttrId);
		$.ajax({
			type:"get",
			data:{"catId":urlSS,"chooseId":0,"pageId":1,"sortId":0,"attr_idAndType":arrAttrId},
			url: "http://118.89.25.129:8080/Fashion/goods/secondTitle",
			async:true,
			//传送数组
			traditional:true,
			success: function(data){
				console.log(data);
				//点击超值小样后
				$(".brandGoods").css({
					display: "block",
				})
				var content = `${goods(data)}`;
				$(".three").html(content);
				$(".goodsNumTotal").html(data.total);
				$(".goodsNumPage1").html(data.totalPage);
				page();
				//品牌
				var content1 = `${addBrandTop(data)}`;
				$(".two").html(content1);
				brandLiss();
				//分类下面具体的
				var content2 = `${addBrandBottom(data)}`;
				$(".twoTwo").html(content2);
				brandLiss();
				var content3 = `${addGoodsPrice(data,'类别',num1,num2,1)}`;
				var content4 = `${addGoodsPrice(data,'产地',num1,num2,1)}`;
				var content5 = `${addGoodsPrice(data,'包装',num1,num2,1)}`;
				var content6 = `${addGoodsPrice(data,'功效',num1,num2,1)}`;
				var content7 = `${addGoodsPrice(data,'肌龄',num1,num2,1)}`;
				var content8 = `${addGoodsPrice(data,'价格',num1,num2,1)}`;
				var content9 = `${addGoodsPrice(data,'肤质',num1,num2,1)}`;
				var content10 = `${addGoodsPrice(data,'香调',num1,num2,1)}`;
				var content11 = `${addGoodsPrice(data,'规格',num1,num2,1)}`;
				$(".four").html(content3+content4+content5+content6+content7+content8+content9+content10+content11);
				fenYe2(data.totalPage);
				
				arrAi();
				}
			});
//			brandBottom();
	})
	})
}
function comment(ele){
	$.ajax({
		type: "get",
		url: ele,
		async: true,
		success: function(data){
			var content = `${goods(data)}`;
			$(".three").html(content);
		}
	})
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
// 左上角
function smallLeft(){
var dropown = document.getElementsByClassName('dropown');
$("h3").each(function(index,obj){
	$("h3").eq(index).on('click',function(){
		var ds = $(".dropown").eq(index).css('display');
		if(ds == "none"){
			dropown[index].style.display = "block";
			$(".faceType").eq(index).css({
			background: "url(../img/xueBiTu1.jpg) 0px -234px no-repeat",
		})
		}else{
			dropown[index].style.display = "none";
			$(".faceType").eq(index).css({
			background: "url(../img/xueBiTu1.jpg) 0px -248px no-repeat",
		})
		}
	})
})
}
// 不限
function buXian(){
	$(".otherBrands").on("click",function(){
		commenFor();
		$(".otherBrands").css({
				border: "1px solid #02a3f0",
				background: '#02a3f0',
				color: "white",
			})
			$(".brandTriangle").css({
				borderColor: "#02a3f0 transparent transparent",
			})
		$(".bb").css({
			display: "block",
		})
	})
}
// 商标
function brandLiss(){
	$(".brandLiss").each(function(index,obj){
		$(".brandLiss").eq(index).on("click",function(){
			commenFor();
			$(".otherBrands").css({
				border: "0px solid white",
				background: 'white',
				color: "#0066cc",
			})
			$(".brandTriangle").css({
				borderColor: "transparent transparent transparent",
			})
			$(".brandListTwo").css({
				display: "none",
			})
			$(".brandListOne").eq(index).css({
				display: "block",
			})
			$(".brandLiss").eq(index).css({
				background: "#02a3f0",
				color: "white",
			})
		})
	})
}
function brandBottom(){
	$(".brandType1").each(function(index,ele){
		$(".brandLis").each(function(i,ele2){
			$(".brandLis").eq(i).css({
				background: "white",
				color: "#0066cc",
			})
				$(".brandLis").eq(i).on("click",function(){
					$(".otherBrand").css({
						border: "0px solid white",
						background: 'white',
						color: "#0066cc",
					})
					$(this).css({
						background: "#02a3f0",
						color: "white",
					})
			})
		})
	})
}
// 更多
$(".brandMore").on('click',function(){
	commenFor();
	var sa = $(".brandListTwo").css('display');
	if(sa == "none"){
		$(".brandListTwo").css({
			display: "block",
		})
	}else{
			$(".brandListTwo").css({
				display: "none",
			})
			$(".bb").css({
			display: "block",
		})
	}	
	if($(".brandMore").html()=='更多'){
		$(".brandMore").html('收起');
		
		console.log($(".brandMore").html());
	}else{
		console.log("123");
		$(".brandMore").html('更多');
	}
})
// 排序
$(".goodsSort li").each(function(index,obj){
	$(".goodsSort li").eq(index).on("click",function(){
		for(var i=0;i<$(".goodsSort li").length;i++){
			$(".goodsSort li").eq(i).css({
				background: "#f6f6f6",
				border: "1px solid #cecbce",
				fontWeight: "normal",
			})
			$(".goodsSort li a").eq(i).css({
			color: "#333333",
			})
		}
		$(".goodsSort li").eq(index).css({
			background: "#fc1c5a",
			border: "1px solid #fc1c5a",
			fontWeight: "bold",
		})
		$(".goodsSort li a").eq(index).css({
			color: "white",
		})
	})
})
function commenFor(){
	for(var i=0;i<$(".brandLiss").length;i++){
			$(".brandListOne").eq(i).css({
				display: "none",
			})
			$(".brandLiss").eq(i).css({
				background: "white",
				color: "#0066cc",
			})
		}
}

//分页器
function fenYe(index){
	$('.M-box3').pagination({
		    pageCount:index,
		    jump:false,
		    coping:true,
		    keepShowPN:true,
		    prevContent:'上页',
		    nextContent:'下页',  
		   callback:function(api){
		          $.getJSON('http://118.89.25.129:8080/Fashion/goods/title',{titleId:"2",chooseId:"0",pageId:api.getCurrent(),sortId:"0",},function(json){
		          	console.log(json);
		            var content = `${goods(json)}`;
					$(".three").html(content);
					$(".goodsNumTotal").html(json.total);
					$(".goodsNumPage1").html(json.totalPage);
					var content1 = `${addBrandTop(json)}`;
					$(".two").html(content1);
					brandLiss();
					//分类下面具体的
					var content2 = `${addBrandBottom(json)}`;
					$(".twoTwo").html(content2);
					brandLiss();
					var content3 = `${addGoodsPrice(json)}`;
					$(".four").html(content3);
					var a = $(".M-box3 .active").html();
					$(".spanNum").html(a);
		        });
		    }
		});
}
//分页器2
function fenYe2(index,a){
	$('.M-box3').pagination({
		    pageCount:index,
		    jump:false,
		    coping:true,
		    keepShowPN:true,
		    prevContent:'上页',
		    nextContent:'下页',  
		   callback:function(api){
		          $.getJSON('http://118.89.25.129:8080/Fashion/goods/secondTitle',{catId:a,chooseId:"0",pageId:api.getCurrent(),sortId:"0",},function(json){
		          	console.log(json);
		            var content = `${goods(json)}`;
					$(".three").html(content);
					$(".goodsNumTotal").html(json.total);
					$(".goodsNumPage1").html(json.totalPage);
					var content1 = `${addBrandTop(json)}`;
					$(".two").html(content1);
					brandLiss();
					//分类下面具体的
					var content2 = `${addBrandBottom(json)}`;
					$(".twoTwo").html(content2);
					brandLiss();
					var content3 = `${addGoodsPrice(json)}`;
					$(".four").html(content3);
					var a = $(".M-box3 .active").html();
					$(".spanNum").html(a);
		        });
		    }
		});
}
//页数
function page(){
	if($(".goodsNumPage1").html()=="0"){
				$(".spanNum").html("0");
			}
}
