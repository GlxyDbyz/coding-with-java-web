<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>登录</title>   
        <link href="${pageContext.request.contextPath}/common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
        <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
        <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/commom/bootstrap/js/html5shiv.3.7.0.js"></script>
        <script src="${pageContext.request.contextPath}/commom/bootstrap/js/respond.1.4.2.min.js"></script>
        <![endif]-->
    </head>
    <body>
	    <div class="container">
	    <h1 class="text-center">后台管理系统</h1>
		    <form >
		    	<div class="row">
						<div class="col-md-4"></div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
								 	<input type="text" class="form-control" placeholder="用户名">
								</div>
							</div>
						<div class="col-md-4"></div>
		    	</div>
		    	<div class="row">
		    		<div class="col-md-12">&nbsp;</div>
		    	</div>
		    	<div class="row">
						<div class="col-md-4"></div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
								 	<input type="password" class="form-control" placeholder="密码" >						 	
								</div>
							</div>
						<div class="col-md-4"></div>
		    	</div>
		    	<div class="row">
		    		<div class="col-md-12">&nbsp;</div>
		    	</div>
		    	<div class="row">
			    	<div class="col-md-4"></div>
			    	<div class="col-md-3">
				    	<div class="center-block">
			    			<a class="btn btn-primary">登 录</a><a class="btn btn-default btn-md ml20">重 置</a>
				    	</div>
			    	</div>
			    	<div class="col-md-5"></div>
		    	</div>
		    </form>
		</div>
		
        <script src="${pageContext.request.contextPath}/common/js/jquery.2.2.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/common/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>