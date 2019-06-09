<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script type="text/javascript">
		
			layui.use('form', function() {
				var form = layui.form;
		
				//监听提交
				form.on('submit(formSearchAccount)', function(data) {
					//layer.msg(JSON.stringify(data.field));
					return true;
				});
			});
		</script>
	</head>
	<body>
		<!-- 权限分配查找account页面 -->
		<div id="" style="padding-left: 26%;margin-top: 20%;">
			<form class="layui-form" action="/ordersystem/set/searchAccount" >
				<div class="layui-form-item" style="margin-top: 5%;">
					<label class="layui-form-label" style="width: 25%;">请输入用户名(手机号):</label>
					<div class="layui-input-inline">
						<input type="text" name="loginUser" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" >
					</div>
				</div>
				

			
				<div class="layui-form-item" style="margin-top: 5%;">
					<div class="layui-input-block">
						<button class="layui-btn" style="margin-left:7%;"  lay-submit lay-filter="formSearchAccount">下一步</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>