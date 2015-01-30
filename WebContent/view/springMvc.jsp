<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/head/tag.jsp" %>
<html>
<head>
<title>mvc</title>


<script type="text/javascript">
	
</script>

</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-tabs">
				<li class="active">
					 <a href="#">首页</a>
				</li>
				<li>
					 <a href="#">简介</a>
				</li>
				<li class="disabled">
					 <a href="#">信息</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="#">操作</a>
						</li>
						<li>
							 <a href="#">设置栏目</a>
						</li>
						<li>
							 <a href="#">更多设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="#">分割线</a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div class="jumbotron well">
						<h1>
							Hello, world!
						</h1>
						<p>
							This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
						</p>
						<p>
							 <a class="btn btn-primary btn-large" href="#">Learn more</a>
						</p>
					</div>
				</div>
				<div class="col-md-4 column">
					 <address> <strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br /> San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123) 456-7890</address>
					<form role="form">
						<div class="form-group">
							 <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" />
						</div>
						<div class="form-group">
							 <label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
							<p class="help-block">
								Example block-level help text here.
							</p>
						</div>
						<div class="checkbox">
							 <label><input type="checkbox" />Check me out</label>
						</div> <button type="submit" class="btn btn-default">Submit</button>
					</form>
					
					<form role="form" action="${ctx}/aController/getText.do">
						<div class="form-group">
							 <label for="textd">Email address</label><input type="text" name="requestVal" class="form-control" id="textd" />
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>