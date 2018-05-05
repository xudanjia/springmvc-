<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="./js/jquery.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function getdata(){
	$.ajax({
		type:"GET",
		url:"./ajaxdemo4",
		dataType:"text",
		contentType:"text/plain;charset=utf-8",
		success:function(data){
			var data = data;
			$("#show").text(data);
		},
		error:function(r){
			alert("error");
		}
	})	
}
</script>
</head>
<body>

	<div id="showme">
		<button id="press" onclick="getdata()"> showList</button>
	</div>

	<div id="show"></div>

	<tr id="list">
		<td id="departure_add1"></td>
	</tr>

</body>
</html>