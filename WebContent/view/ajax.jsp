<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/head/tag.jsp" %>

<html>
<head>
<%@include file="/head/head.jsp" %>
<title>ajax</title>
<script type="text/javascript">
	$(function(){
		
		ajaxRequest();
	});
	
	function ajaxRequest()
	{
		var i = 1;		//////ajax异步请求没有完成，变量i 将会一直在保存在 闭包中，即便当前函数ajaxRequest已经执行完成
		var str = "affffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
		$("body>div").html("begin");
		
		$.ajax({
			url:"${ctx}/ajaxServlet",
			success:function(data){
// 				alert(this.url);		////this 为局部变量 此处为 ajax函数的参数对象。
				alert(data+"-----"+i); ///i will not be certain !! 
				///。闭包的外层变量为什么还存在是因为闭包函数的scope还存有对其的引用。i在闭包中,data为局部变量，而此处没有访问str，因此，此处str已经很有可能被gc回收了（浏览器不同也有可能不会被回收。）！！！
			},
			
		});
		
		var begin = new Date();
		var end = new Date();
		while((end.getTime() - begin.getTime()) < 100){
			i++;
			end = new Date();
		}
		
		$("body>div").html("end");
	}
	
</script>

</head>
<body>
	<div></div>
</body>
</html>