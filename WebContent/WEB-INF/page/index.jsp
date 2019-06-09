<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
<title>益阳铁路点餐系统</title>
<script src="/ordersystem/layui/layui.js"></script>
<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
<style>
#form div {
	margin: auto;
	margin-top: 5%;
	width: 30%;
	height: 40%;
}

#form input[type=submit] {
	width: 10%;
	position: relative;
	top: 25px;
	left: 55%;
}
</style>
</head>
<body>
	<div style="font-size: 40px; text-align: center; margin-top: 5%;">
		欢迎登录益阳铁路点餐系统
		<div
			style="color: darkorange; font-size: 20px; position: relative; left: 14%;">
			系统管理员端</div>
	</div>
	<form action="checkAdmin" method="get" id="form">
		<div>
			<input type="text" name="adminUsername" required lay-verify="required"
				placeholder="请输入用户名" class="layui-input">
		</div>
		<div>
			<input type="password" name="adminPwd" required lay-verify="required"
				placeholder="请输入密码" class="layui-input">
		</div>
		<input type="submit" value="登录" class="layui-btn" />


	</form>

</body>
</html>