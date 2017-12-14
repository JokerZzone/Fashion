<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" id="a">
</body>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$("#a").click(function(){
		$.ajax({
			"url":"http://localhost:8080/Fashion/goods/secondTitle",
			method:"get",
			jsonType:"json",
			data:{
				"catId":8,
				"chooseId":1,
				"pageId":1,
				"sortId":0,
				"attr_idAndType":[1,1]
			},
			traditional:true,
			success:function(data){
				console.log(data)
			}
		})
	})
</script>
</html>