<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
<script src="/ordersystem/layui/layui.js"></script>
<script type="text/javascript">
	layui.use([ 'form', 'layer' ], function() {
		var form = layui.form;
		var layer = layui.layer;

		form.on('submit(updPwd)', function(data) {
			var jsonStr = JSON.stringify(data.field);
			var json = JSON.parse(jsonStr);
			if (json.newPwd != json.confirmPwd) {
				layer.msg("两次密码不同", {
					time : 1000,
					icon : 2
				});
				return false;
			} /* else {
				$.ajax({
					url : 'updatePwd',
					methos : "post",
					contentType : "application/json",
					data : jsonStr,
					success : function(num) {
						if (num > 0) {
							layer.msg("修改成功");
						} else {
							layer.msg("失败");
						}
					},
					error : function() {
						layer.msg("修改失败");
					}

				});
				return true;
			} */
		});

	});
</script>

</head>
<body>
	<!-- 密码更改 -->
	<div id="" style="padding-left: 32%; margin-top: 10%;">
		<form class="layui-form" action="/ordersystem/set/updatePwd"
			method="post">


			<div class="layui-form-item" style="margin-top: 7%;">
				<label class="layui-form-label">新密码:</label>
				<div class="layui-input-inline">
					<input type="text" name="newPwd" required lay-verify="required"
						placeholder="请输入新密码" autocomplete="off" class="layui-input">
				</div>
			</div>


			<div class="layui-form-item" style="margin-top: 7%;">
				<label class="layui-form-label">确认新密码:</label>
				<div class="layui-input-inline">
					<input type="text" name="confirmPwd" required lay-verify="required"
						placeholder="请再次确认密码" autocomplete="off" class="layui-input">
				</div>
			</div>



			<div class="layui-form-item" style="margin-top: 7%;">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="updPwd">确定修改</button>

					<!--  					<input type="submit" class="layui-btn" value="提交修改">
 -->
				</div>
			</div>
		</form>
	</div>
</body>
</html>