<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		
		<style type="text/css">
			input[type=text]{
				height: 40px; 
				width: 200px;
				margin-left: 10px;
				margin-top: 50px;
				font-size: 28px;
				
			}
			
		</style>
		<script type="text/javascript">
			$(function(){
				$("form").submit(function(){
					window.parent.location.reload();
					var index = parent.layer.getFrameIndex(window.name); 
					parent.layer.close(index);
				})
				
			})
		</script>
	</head>
	<body>
		<form action="/ordersystem/departManage/addDepart">
			<div style="text-align: center;">
				<font size="5" color="">部门名称:</font>
				<input type="text" id="departName" name="departName" >
			</div>
			<div style="text-align: center;">
				<input type="submit" style="width:100px;margin-top:70px" class="layui-btn" value="添加" />
			</div>
		</form>
		
	</body>
</html>