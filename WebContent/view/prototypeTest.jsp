<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
<script>
	(function()
	{
		prototypeTest();

// 		+function(i){alert(i)}("this is ");
		
	})();


	function prototypeTest()
	{
		function foo()
		{
			this.foofunctiontype = "small";
		}
		;

		foo.fooName = "TL";
		foo.prototype.fooPrototypeage = 21;

		var bar = new foo();
		bar.name = "tangli";
		bar.jolia = "jolia";
		console.info('name' in bar);                                    // 	 true 
		console.info('foofunctiontype' in bar);                         // 	 true 
		console.info('fooPrototypeage' in bar);                         // 	 true 
		console.info('fooName' in bar);                                 // 	 false
		console.info(bar.hasOwnProperty("name"));                        // 	 true 
		console.info(bar.hasOwnProperty("foofunctiontype"));             // 	 true 
		console.info(bar.hasOwnProperty("fooPrototypeage"));             // 	 false
		console.info(bar.hasOwnProperty("fooName"));                     // 	 false
		delete bar.name;                                                
		console.info('name' in bar);                                   // 	 false  
		console.info(bar.hasOwnProperty("name"));                      // 	 false  

		var tem = function myFun()
		{
			this.Tnam = "tNam";
		};
	}

</script>
</head>
<body>
</body>
</html>



