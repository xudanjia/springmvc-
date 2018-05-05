<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="./js/jquery.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	//function jasondemo(){
		/* var json_string={uname:"sspu",password:"abc"};
		$.ajax({
			type:"POST",
			url:"./ajaxdemo",
			data:JSON.stringify(json_string),
			contentType:"application/json;charset=utf-8",
			success:function(data){
				alert(data.uname);
				alert("this");
				$("#showjson").text(data.uname+" "+data.password);
			},
			error:function(r){
				alert("error");
			}
		}) */
	//}
	$.ajax({
			type:"GET",
			url:"./ajaxdemo2",
			data:"myname="+"shisis",
			dataType:"text",
			contentType:"text/plain;charset=utf-8",
			success:function(data){
				alert(data);
			},
			error:function(r){
				alert("error");
			}
		})
</script>
</head>
<body>
hellomaven
<p id="showjson"></p>
</body>
</html>