//Ajax

var data=JSON.parse('{"countory":{"1":[{"braId":9,"braName":"Avene 雅漾","braImg":null,"braDesc":"Y1"},{"braId":13,"braName":"Benefit 贝玲妃","braImg":null,"braDesc":"B1"},{"braId":15,"braName":"BIODERMA 贝德玛","braImg":null,"braDesc":"B1"},{"braId":17,"braName":"Biotherm 碧欧泉","braImg":null,"braDesc":"B1"},{"braId":19,"braName":"Borghese 贝佳斯","braImg":null,"braDesc":"B1"},{"braId":20,"braName":"Boss 波士","braImg":null,"braDesc":"B1"},{"braId":23,"braName":"Burberry 博柏利","braImg":null,"braDesc":"B1"},{"braId":25,"braName":"Bvlgari 宝格丽","braImg":null,"braDesc":"B1"},{"braId":27,"braName":"Calvin Klein 卡尔文.克莱","braImg":null,"braDesc":"K1"},{"braId":37,"braName":"Clinique 倩碧","braImg":null,"braDesc":"Q1"},{"braId":41,"braName":"Coppertone 水宝宝","braImg":null,"braDesc":"S1"},{"braId":53,"braName":"Dior 迪奥","braImg":null,"braDesc":"D1"},{"braId":59,"braName":"Elizabeth Arden 雅顿","braImg":null,"braDesc":"Y1"},{"braId":64,"braName":"Eydis 欧苔诗","braImg":null,"braDesc":"O1"},{"braId":109,"braName":"L’Occitane 欧舒丹","braImg":null,"braDesc":"O1"},{"braId":110,"braName":"LA MER 海蓝之谜","braImg":null,"braDesc":"H1"},{"braId":111,"braName":"La prairie 莱珀妮","braImg":null,"braDesc":"L1"},{"braId":121,"braName":"LOREAL 欧莱雅","braImg":null,"braDesc":"O1"}],"2":[{"braId":50,"braName":"DHC 蝶翠诗","braImg":null,"braDesc":"D2"},{"braId":66,"braName":"Fancl 无添加","braImg":null,"braDesc":"W2"},{"braId":72,"braName":"freeplus 芙丽芳丝","braImg":null,"braDesc":"F2"},{"braId":96,"braName":"It°S SKIN 伊思","braImg":null,"braDesc":"Y2"},{"braId":107,"braName":"Kose 高丝","braImg":null,"braDesc":"G2"},{"braId":116,"braName":"Laneige 兰芝","braImg":null,"braDesc":"L2"},{"braId":132,"braName":"MISSHA 谜尚","braImg":null,"braDesc":"M2"},{"braId":152,"braName":"Prettia 花王","braImg":null,"braDesc":"H2"},{"braId":156,"braName":"Rice Day 思美兰","braImg":null,"braDesc":"S2"},{"braId":161,"braName":"润之町","braImg":null,"braDesc":"R2"},{"braId":168,"braName":"Shiseido 资生堂","braImg":null,"braDesc":"Z2"},{"braId":169,"braName":"Shu Uemura 植村秀","braImg":null,"braDesc":"Z2"},{"braId":171,"braName":"SK-Ⅱ","braImg":null,"braDesc":"S2"},{"braId":172,"braName":"SKIN FOOD 思亲肤","braImg":null,"braDesc":"S2"},{"braId":182,"braName":"思原丽","braImg":null,"braDesc":"S2"},{"braId":184,"braName":"THE FACE SHOP 菲诗小铺","braImg":null,"braDesc":"F2"}],"3":[{"braId":7,"braName":"AUPRES 欧珀莱","braImg":null,"braDesc":"O3"},{"braId":84,"braName":"HERBORIST 佰草集","braImg":null,"braDesc":"B3"},{"braId":145,"braName":"OLAY 玉兰油","braImg":null,"braDesc":"Y3"},{"braId":146,"braName":"OMI 近江兄弟","braImg":null,"braDesc":"J3"},{"braId":158,"braName":"ROMINZ 诺曼姿","braImg":null,"braDesc":"L3"},{"braId":202,"braName":"章子一族","braImg":null,"braDesc":"Z3"},{"braId":203,"braName":"我的秘密日志","braImg":null,"braDesc":"W3"},{"braId":204,"braName":"GF 高夫","braImg":null,"braDesc":"G3"},{"braId":205,"braName":"Xuemary 雪玛丽","braImg":null,"braDesc":"X3"}]},"letter":{"A":[{"braId":1,"braName":"A.H.C","braImg":null,"braDesc":"A"},{"braId":2,"braName":"ABOUT ME","braImg":null,"braDesc":"A"},{"braId":3,"braName":"爱茉莉","braImg":null,"braDesc":"A"},{"braId":4,"braName":"Anna Sui 安娜苏","braImg":null,"braDesc":"A"},{"braId":5,"braName":"AP-AU","braImg":null,"braDesc":"A"},{"braId":6,"braName":"ARDELL 艾黛尔","braImg":null,"braDesc":"A"},{"braId":8,"braName":"Aveeno 艾维诺","braImg":null,"braDesc":"A"},{"braId":75,"braName":"Giorgio Armani 阿玛尼","braImg":null,"braDesc":"A"},{"braId":85,"braName":"Hermes 爱马仕","braImg":null,"braDesc":"A"},{"braId":91,"braName":"I.myss 爱蜜诗","braImg":null,"braDesc":"A"}],"B":[{"braId":10,"braName":"BALDESSARINI  巴萨瑞尼","braImg":null,"braDesc":"B"},{"braId":11,"braName":"Banila co芭妮兰","braImg":null,"braDesc":"B"},{"braId":12,"braName":"Bb LABORATORIES","braImg":null,"braDesc":"B"},{"braId":13,"braName":"Benefit 贝玲妃","braImg":null,"braDesc":"B1"},{"braId":15,"braName":"BIODERMA 贝德玛","braImg":null,"braDesc":"B1"},{"braId":16,"braName":"Biore碧柔","braImg":null,"braDesc":"B"},{"braId":17,"braName":"Biotherm 碧欧泉","braImg":null,"braDesc":"B1"},{"braId":19,"braName":"Borghese 贝佳斯","braImg":null,"braDesc":"B1"},{"braId":20,"braName":"Boss 波士","braImg":null,"braDesc":"B1"},{"braId":21,"braName":"BOSSDUN.MEN 波斯顿","braImg":null,"braDesc":"B"},{"braId":23,"braName":"Burberry 博柏利","braImg":null,"braDesc":"B1"},{"braId":25,"braName":"Bvlgari 宝格丽","braImg":null,"braDesc":"B1"},{"braId":84,"braName":"HERBORIST 佰草集","braImg":null,"braDesc":"B3"},{"braId":100,"braName":"KAI 贝印","braImg":null,"braDesc":"B"}],"C":[{"braId":28,"braName":"canmake","braImg":null,"braDesc":"C"},{"braId":32,"braName":"Charmzone 婵真","braImg":null,"braDesc":"C"},{"braId":33,"braName":"chez moi","braImg":null,"braDesc":"C"},{"braId":45,"braName":"长寿里","braImg":null,"braDesc":"C"},{"braId":70,"braName":"For Beloved One 宠爱之名","braImg":null,"braDesc":"C"},{"braId":113,"braName":"Labo Labo 城野医生","braImg":null,"braDesc":"C"},{"braId":148,"braName":"Papa recipe春雨","braImg":null,"braDesc":"C"},{"braId":153,"braName":"Pure Smile 纯微笑","braImg":null,"braDesc":"C"}],"D":[{"braId":46,"braName":"Daiso 大创","braImg":null,"braDesc":"D"},{"braId":47,"braName":"Davidoff 大卫杜夫","braImg":null,"braDesc":"D"},{"braId":48,"braName":"Deonatulle","braImg":null,"braDesc":"D"},{"braId":49,"braName":"豆腐盛田屋","braImg":null,"braDesc":"D"},{"braId":50,"braName":"DHC 蝶翠诗","braImg":null,"braDesc":"D2"},{"braId":51,"braName":"DIA FORCE","braImg":null,"braDesc":"D"},{"braId":52,"braName":"Dimples 杜碧丝","braImg":null,"braDesc":"D"},{"braId":53,"braName":"Dior 迪奥","braImg":null,"braDesc":"D1"},{"braId":55,"braName":"DMC","braImg":null,"braDesc":"D"},{"braId":56,"braName":"Dot free","braImg":null,"braDesc":"D"},{"braId":57,"braName":"Dote On My Face 宠爱我的脸","braImg":null,"braDesc":"D"},{"braId":58,"braName":"Dr.jart+ 蒂佳婷","braImg":null,"braDesc":"D"},{"braId":83,"braName":"HERBACIN 德国小甘橘","braImg":null,"braDesc":"D"},{"braId":162,"braName":"S.T.Dupont 都彭","braImg":null,"braDesc":"D"},{"braId":185,"braName":"the SAEM 得鲜","braImg":null,"braDesc":"D"}],"E":[{"braId":60,"braName":"Elizavecca milky Piggy 小黑猪","braImg":null,"braDesc":"E"},{"braId":114,"braName":"Lacoste 鳄鱼","braImg":null,"braDesc":"E"}],"F":[{"braId":67,"braName":"FASCY 发希","braImg":null,"braDesc":"F"},{"braId":68,"braName":"菲尔 fere","braImg":null,"braDesc":"F"},{"braId":69,"braName":"Ferragamo 菲拉格慕","braImg":null,"braDesc":"F"},{"braId":71,"braName":"forencons","braImg":null,"braDesc":"F"},{"braId":72,"braName":"freeplus 芙丽芳丝","braImg":null,"braDesc":"F2"},{"braId":73,"braName":"Fresh 馥蕾诗","braImg":null,"braDesc":"F"},{"braId":74,"braName":"Fumakilla Vape","braImg":null,"braDesc":"F"},{"braId":151,"braName":"Phyto 发朵","braImg":null,"braDesc":"F"},{"braId":184,"braName":"THE FACE SHOP 菲诗小铺","braImg":null,"braDesc":"F2"},{"braId":189,"braName":"Van Cleef Arpels 梵克雅宝","braImg":null,"braDesc":"F"},{"braId":192,"braName":"Versace 范思哲","braImg":null,"braDesc":"F"}],"G":[{"braId":42,"braName":"Coreana 高丽雅娜","braImg":null,"braDesc":"G"},{"braId":44,"braName":"Crabtree&Evelyn 瑰珀翠","braImg":null,"braDesc":"G"},{"braId":78,"braName":"Gucci 古驰","braImg":null,"braDesc":"G"},{"braId":80,"braName":"GypsophilA","braImg":null,"braDesc":"G"},{"braId":103,"braName":"Kenzo 高田贤三","braImg":null,"braDesc":"G"},{"braId":107,"braName":"Kose 高丝","braImg":null,"braDesc":"G2"},{"braId":204,"braName":"GF 高夫","braImg":null,"braDesc":"G3"}],"H":[{"braId":65,"braName":"faceyarn 花妍丽","braImg":null,"braDesc":"H"},{"braId":81,"braName":"HABA","braImg":null,"braDesc":"H"},{"braId":82,"braName":"HERA 赫拉","braImg":null,"braDesc":"H"},{"braId":86,"braName":"韩国","braImg":null,"braDesc":"H"},{"braId":87,"braName":"Hipitch 黑龙堂","braImg":null,"braDesc":"H"},{"braId":88,"braName":"Holikaholika","braImg":null,"braDesc":"H"},{"braId":89,"braName":"House of Rose","braImg":null,"braDesc":"H"},{"braId":90,"braName":"HR 赫莲娜","braImg":null,"braDesc":"H"},{"braId":110,"braName":"LA MER 海蓝之谜","braImg":null,"braDesc":"H1"},{"braId":152,"braName":"Prettia 花王","braImg":null,"braDesc":"H2"},{"braId":177,"braName":"SpongeBob海绵宝宝","braImg":null,"braDesc":"H"},{"braId":196,"braName":"Wakodo和光堂","braImg":null,"braDesc":"H"},{"braId":197,"braName":"Whoo 后","braImg":null,"braDesc":"H"}],"I":[],"J":[{"braId":26,"braName":"California baby 加州宝宝","braImg":null,"braDesc":"J"},{"braId":35,"braName":"Clarins 娇韵诗","braImg":null,"braDesc":"J"},{"braId":39,"braName":"CLOUD9 九朵云","braImg":null,"braDesc":"J"},{"braId":43,"braName":"CPB肌肤之钥","braImg":null,"braDesc":"J"},{"braId":76,"braName":"Givenchy 纪梵希","braImg":null,"braDesc":"J"},{"braId":79,"braName":"Guerlain 娇兰","braImg":null,"braDesc":"J"},{"braId":94,"braName":"IPSA 茵芙莎","braImg":null,"braDesc":"J"},{"braId":97,"braName":"JAY JUN","braImg":null,"braDesc":"J"},{"braId":146,"braName":"OMI 近江兄弟","braImg":null,"braDesc":"J3"}],"K":[{"braId":27,"braName":"Calvin Klein 卡尔文.克莱","braImg":null,"braDesc":"K1"},{"braId":29,"braName":"Carolina Herrera 卡罗琳娜","braImg":null,"braDesc":"K"},{"braId":36,"braName":"Clinie 可莱丝","braImg":null,"braDesc":"K"},{"braId":38,"braName":"Clio珂莱欧","braImg":null,"braDesc":"K"},{"braId":101,"braName":"Karen Murrell","braImg":null,"braDesc":"K"},{"braId":102,"braName":"kate凯朵","braImg":null,"braDesc":"K"},{"braId":104,"braName":"KERASTASE 卡诗","braImg":null,"braDesc":"K"},{"braId":105,"braName":"Kiehl’s 科颜氏","braImg":null,"braDesc":"K"},{"braId":106,"braName":"koji 蔻吉","braImg":null,"braDesc":"K"},{"braId":108,"braName":"Kracie 葵缇亚","braImg":null,"braDesc":"K"}],"L":[{"braId":18,"braName":"Blue Lizard 蓝蜥蜴","braImg":null,"braDesc":"L"},{"braId":111,"braName":"La prairie 莱珀妮","braImg":null,"braDesc":"L1"},{"braId":112,"braName":"LA roche-posay 理肤泉","braImg":null,"braDesc":"L"},{"braId":115,"braName":"Lancome 兰蔻","braImg":null,"braDesc":"L"},{"braId":116,"braName":"Laneige 兰芝","braImg":null,"braDesc":"L2"},{"braId":117,"braName":"LANVIN 浪凡","braImg":null,"braDesc":"L"},{"braId":118,"braName":"Leaders 丽得姿","braImg":null,"braDesc":"L"},{"braId":119,"braName":"lexni","braImg":null,"braDesc":"L"},{"braId":120,"braName":"LG","braImg":null,"braDesc":"L"},{"braId":154,"braName":"RE:CIPE 莱斯璧","braImg":null,"braDesc":"L"},{"braId":155,"braName":"Revlon 露华浓","braImg":null,"braDesc":"L"},{"braId":157,"braName":"ROHTO 乐敦","braImg":null,"braDesc":"L"},{"braId":158,"braName":"ROMINZ 诺曼姿","braImg":null,"braDesc":"L3"},{"braId":198,"braName":"Yanagiya 柳屋","braImg":null,"braDesc":"L"}],"M":[{"braId":14,"braName":"Bigen 美源发采","braImg":null,"braDesc":"M"},{"braId":22,"braName":"Bour jois妙巴黎","braImg":null,"braDesc":"M"},{"braId":122,"braName":"mac","braImg":null,"braDesc":"M"},{"braId":123,"braName":"Mandom 曼丹","braImg":null,"braDesc":"M"},{"braId":124,"braName":"Mane\'n tail 箭牌","braImg":null,"braDesc":"M"},{"braId":125,"braName":"Marc Jacobs 马克·雅各布斯","braImg":null,"braDesc":"M"},{"braId":126,"braName":"Mary Kay 玫琳凯","braImg":null,"braDesc":"M"},{"braId":127,"braName":"Max Factor 蜜丝佛陀","braImg":null,"braDesc":"M"},{"braId":128,"braName":"Mayllie 玛贝拉","braImg":null,"braDesc":"M"},{"braId":129,"braName":"美国","braImg":null,"braDesc":"M"},{"braId":130,"braName":"MICCOSMO","braImg":null,"braDesc":"M"},{"braId":131,"braName":"MINON","braImg":null,"braDesc":"M"},{"braId":132,"braName":"MISSHA 谜尚","braImg":null,"braDesc":"M2"},{"braId":133,"braName":"MiuMiu","braImg":null,"braDesc":"M"},{"braId":134,"braName":"玛姬儿","braImg":null,"braDesc":"M"},{"braId":135,"braName":"moMan 魔漫","braImg":null,"braDesc":"M"},{"braId":137,"braName":"Moroccanoil","braImg":null,"braDesc":"M"},{"braId":138,"braName":"Moschino 莫斯奇诺","braImg":null,"braDesc":"M"},{"braId":183,"braName":"The body shop 美体小铺","braImg":null,"braDesc":"M"}],"N":[{"braId":34,"braName":"Christine Kou na 娜蔻丝汀","braImg":null,"braDesc":"N"},{"braId":139,"braName":"NARS","braImg":null,"braDesc":"N"},{"braId":140,"braName":"NATURE REPUBLIC 自然乐园","braImg":null,"braDesc":"N"},{"braId":141,"braName":"Netharria 妮塔莉雅","braImg":null,"braDesc":"N"},{"braId":142,"braName":"NIVEA妮维雅","braImg":null,"braDesc":"N"},{"braId":143,"braName":"Nursery","braImg":null,"braDesc":"N"},{"braId":149,"braName":"PARASOLA 娜丽丝","braImg":null,"braDesc":"N"}],"O":[{"braId":7,"braName":"AUPRES 欧珀莱","braImg":null,"braDesc":"O3"},{"braId":64,"braName":"Eydis 欧苔诗","braImg":null,"braDesc":"O1"},{"braId":109,"braName":"L’Occitane 欧舒丹","braImg":null,"braDesc":"O1"},{"braId":121,"braName":"LOREAL 欧莱雅","braImg":null,"braDesc":"O1"},{"braId":144,"braName":"Nuxe 欧树","braImg":null,"braDesc":"O"}],"P":[{"braId":150,"braName":"PeterThomasRoth 彼得罗夫","braImg":null,"braDesc":"P"}],"Q":[{"braId":37,"braName":"Clinique 倩碧","braImg":null,"braDesc":"Q1"}],"R":[{"braId":160,"braName":"日妆","braImg":null,"braDesc":"R"},{"braId":161,"braName":"润之町","braImg":null,"braDesc":"R2"}],"S":[{"braId":30,"braName":"CETAPHIL 丝塔芙","braImg":null,"braDesc":"S"},{"braId":41,"braName":"Coppertone 水宝宝","braImg":null,"braDesc":"S1"},{"braId":95,"braName":"Issey Miyake 三宅一生","braImg":null,"braDesc":"S"},{"braId":147,"braName":"Panasonic 松下","braImg":null,"braDesc":"S"},{"braId":156,"braName":"Rice Day 思美兰","braImg":null,"braDesc":"S2"},{"braId":159,"braName":"ROSETTE诗留美屋","braImg":null,"braDesc":"S"},{"braId":163,"braName":"SANA 珊娜","braImg":null,"braDesc":"S"},{"braId":164,"braName":"SASAME","braImg":null,"braDesc":"S"},{"braId":165,"braName":"山本汉方","braImg":null,"braDesc":"S"},{"braId":166,"braName":"SEVEN 7","braImg":null,"braDesc":"S"},{"braId":171,"braName":"SK-Ⅱ","braImg":null,"braDesc":"S2"},{"braId":172,"braName":"SKIN FOOD 思亲肤","braImg":null,"braDesc":"S2"},{"braId":173,"braName":"SNP","braImg":null,"braDesc":"S"},{"braId":174,"braName":"Sonia Rykiel 桑丽卡","braImg":null,"braDesc":"S"},{"braId":175,"braName":"Spa-Treatment","braImg":null,"braDesc":"S"},{"braId":176,"braName":"SPC","braImg":null,"braDesc":"S"},{"braId":178,"braName":"STONE 司顿","braImg":null,"braDesc":"S"},{"braId":179,"braName":"SU:M37°  苏秘","braImg":null,"braDesc":"S"},{"braId":181,"braName":"Super Gloss","braImg":null,"braDesc":"S"},{"braId":182,"braName":"思原丽","braImg":null,"braDesc":"S2"}],"T":[{"braId":54,"braName":"DKNY 唐可娜儿","braImg":null,"braDesc":"T"},{"braId":77,"braName":"GRACEWELL 婷美","braImg":null,"braDesc":"T"},{"braId":186,"braName":"Tom Ford汤姆福特","braImg":null,"braDesc":"T"},{"braId":187,"braName":"TOUS 淘气小熊","braImg":null,"braDesc":"T"}],"U":[],"V":[{"braId":190,"braName":"VANT 36.5","braImg":null,"braDesc":"V"},{"braId":191,"braName":"VDL","braImg":null,"braDesc":"V"}],"W":[{"braId":66,"braName":"Fancl 无添加","braImg":null,"braDesc":"W2"},{"braId":136,"braName":"MONT BLANC 万宝龙","braImg":null,"braDesc":"W"},{"braId":193,"braName":"Vichy 薇姿","braImg":null,"braDesc":"W"},{"braId":194,"braName":"Victoria\'s Secret 维多利亚的秘密","braImg":null,"braDesc":"W"},{"braId":195,"braName":"Victorinox 维氏","braImg":null,"braDesc":"W"},{"braId":203,"braName":"我的秘密日志","braImg":null,"braDesc":"W3"}],"X":[{"braId":24,"braName":"Burt’s Bees 小蜜蜂","braImg":null,"braDesc":"X"},{"braId":31,"braName":"Chanel 香奈儿","braImg":null,"braDesc":"X"},{"braId":40,"braName":"CLVTIL 筱维说","braImg":null,"braDesc":"X"},{"braId":167,"braName":"Shinyakoso 新谷","braImg":null,"braDesc":"X"},{"braId":170,"braName":"Sisley 希思黎","braImg":null,"braDesc":"X"},{"braId":180,"braName":"Sulwhasoo 雪花秀","braImg":null,"braDesc":"X"},{"braId":205,"braName":"Xuemary 雪玛丽","braImg":null,"braDesc":"X3"}],"Y":[{"braId":9,"braName":"Avene 雅漾","braImg":null,"braDesc":"Y1"},{"braId":59,"braName":"Elizabeth Arden 雅顿","braImg":null,"braDesc":"Y1"},{"braId":61,"braName":"Estee Lauder 雅诗兰黛","braImg":null,"braDesc":"Y"},{"braId":62,"braName":"ETUDE HOUSE伊蒂之屋","braImg":null,"braDesc":"Y"},{"braId":63,"braName":"Evian 依云喷雾","braImg":null,"braDesc":"Y"},{"braId":92,"braName":"innisfree 悦诗风吟","braImg":null,"braDesc":"Y"},{"braId":93,"braName":"IOPE 亦博","braImg":null,"braDesc":"Y"},{"braId":96,"braName":"It°S SKIN 伊思","braImg":null,"braDesc":"Y2"},{"braId":145,"braName":"OLAY 玉兰油","braImg":null,"braDesc":"Y3"},{"braId":188,"braName":"Utena佑天兰","braImg":null,"braDesc":"Y"},{"braId":199,"braName":"YSL 伊夫圣罗兰","braImg":null,"braDesc":"Y"},{"braId":200,"braName":"悠仙美地","braImg":null,"braDesc":"Y"}],"Z":[{"braId":98,"braName":"Jo Malone祖马龙","braImg":null,"braDesc":"Z"},{"braId":99,"braName":"Jurlique 茱莉蔻","braImg":null,"braDesc":"Z"},{"braId":168,"braName":"Shiseido 资生堂","braImg":null,"braDesc":"Z2"},{"braId":169,"braName":"Shu Uemura 植村秀","braImg":null,"braDesc":"Z2"},{"braId":201,"braName":"Zippo 芝宝","braImg":null,"braDesc":"Z"},{"braId":202,"braName":"章子一族","braImg":null,"braDesc":"Z3"}]}}');
console.log(data["letter"]);



//循环外面的国家
country(data["countory"]);
function country(loop){
	var countryArr = ["欧美","日韩","中国"];
	var content = "";
	for(i in loop) {	
		content +=
`<div class="recommends recommendTwo">${countryArr[i-1]}</div>
<div class="trademarkOne">
	<div class="tradeWord">
		<ol class="tradeOl">
			${countryLI(loop[i])}
		</ol>
	</div>
</div>`;
	
	}
	$(".trademarkBox").html($(".trademarkBox").html()+content);
}


//循环国家里面的品牌
function countryLI(loop) {
	var content="";
	for(i in loop) {
		content +=
`<li class="tradeLi  dot">
	<a href="" class="tradeA" data-braId=${loop[i]["braId"]} data-braDesc=${loop[i]["braDesc"]}>${loop[i]["braName"]}</a>
</li>`;
	}
	return content;
}





//循环字母
letter(data["letter"]);
function letter(loop) {
	var content = "";
	for(i in loop) {
		content +=
`
<div class="recommends"><a class=${i}></a>${i}</div>
<div class="trademarkOne">
	<div class="tradeWord">
			${letterLI3(loop[i])}
	</div>
</div>`;
	}
	$(".trademarkBox").html($(".trademarkBox").html()+content);
}
//有图片的部分循环
//function letterLI2(loop) {
//	var content = `<div class="tradeDiv clearfixs">`;
//	for(i in loop) {
//		content +=
//`
//<div class="tradePic">
//	<a href=""><img src="" alt="${loop[i]['braName']}" class="tradeImg" data-braId=${} data-braName=${}>${}</a><br/>
//	<span class="tradeName"><a href="" data-braId=${} data-braName=${}>${}</a></span>
//</div>
//`;
//	}
//	return content+`</div>`;
//}
//文字的部分循环
function letterLI3(loop) {
	var content = `<ol class="tradeOl clearfixs qw">`;
	for(i in loop){
		content +=
`
<li class="tradeLi  dot">
	<a href="" class="tradeA" data-braId=${loop[i]["braId"]} data-braName=${loop[i]['braName']}>${loop[i]['braName']}</a>
</li>
`;
	}
	return content+`</ol>`;
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
//鼠标滚动导航悬浮
var topWords = document.getElementById('topWords');
var sss = topWords.offsetTop;
$(window).scroll(function(){
	var a = $(this).scrollTop();
	if(a>=200){
		$("#topWords").css({
			position: "fixed",
			top: 0,
			left: 0,
		})
	}else {
		$("#topWords").css({
			position: "static"
		});
		$(".topWords2").css("display","none");
	}
})
var wordContent = document.getElementsByClassName('wordContent')[0];
// 添加字母
//var arrS = ["a","b","c","d","e","f","g","h","i","j","k","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];
var arr = ["A","B","C","D","E","F","G","H","I","J","K","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
for(var i=0;i<arr.length;i++){
	var word = document.createElement('li');
	word.className = "wordList";
	wordContent.appendChild(word);
	var wordLink = document.createElement('a');
	wordLink.className = "wordLink";
	wordLink.innerHTML = arr[i];
//	wordLink.href = arrS[i];
	word.appendChild(wordLink);
	if(wordLink.innerHTML == "A"){
		word.className = "wordLink_one";
 	}
	wordLink.num = i;
	wordLink.onclick=function() {
		$("html").animate({scrollTop:$("."+arr[this.num]).offset().top-$("#topWords").outerHeight()},500);
//		$(".topWords2").css("display","block");
	}
}
