<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/head/tag.jsp" %>

<html>
<head>
<%@include file="/head/head.jsp" %>
<title>ajax</title>
<script type="text/javascript">
	$(function(){
		
		$.ajax({
// 			type:'post',
// 			type:'get',
			url:"http://localhost:8080/",
			success:function(data){
				alert(data); ///i will not be certain !! 
			},
			
		});
	});
	
</script>

</head>
<body>
	<div></div>
</body>
</html>