<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
<script>
	(function()
	{

		function Work(someArgument)
		{
			alert("do some work");
		}
		function Person(name,age)
		{
			this.name = name;
			this.age = age;
		}
		function Student(name,age,grade)
		{
			Person.apply(this, arguments); ///////aply很方便地将argument传递，这句话相当于是java构造函数中的super.(...)
			Work.call(this, "someArgument"); ///////call
			this.studentWork = Work.bind(this,"someArgument");
			this.grade = grade; /////定义自己的属性。

		}
		//创建一个学生  
		var student = new Student("zhangsan", 21, "一年级");
		student.studentWork();
// 		alert("name:" + student.name + "\n" + "age:" + student.age + "\n" + "grade:" + student.grade);




// 		var first_object = { num : 42 };
// 		var second_object = { num : 24 };
// 		function multiply(mult)
// 		{
// // 			alert(multiply.caller);///调用者
// // 			alert(arguments.callee); ///正在执行者，就是其本身。
// 			return this.num * mult;
// 		}
// 		var first_multiply = multiply.bind(first_object);///意思是将first_object作为multiply函数中的this！所以之后函数执行时this代表的就是first_object
// 		alert(first_multiply(5)); // returns 42 * 5 
// 		var second_multiply = multiply.bind(second_object);
// 		alert(second_multiply(5)); // returns 24 * 5 
		/////////bind函数原理
// 		Function.prototype.bind = function(obj)
// 		{
// 			var method = this, temp = function()
// 			{
// 				return method.apply(obj, arguments);
// 			};
// 			return temp;
// 		}
		
		
	})();
</script>
</head>
<body>
</body>
</html>



