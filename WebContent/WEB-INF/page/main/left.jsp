<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script type="text/javascript">
			layui.use('element', function(){
				var element = layui.element();
			}); 
		</script>
		<style type="text/css">
			a{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<ul class="layui-nav layui-nav-tree layui-inline layui-nav-side" lay-filter="demo" style="width: 100%;">
			<li class="layui-nav-item ">
				<a href="/ordersystem/peoView/peopleView" target="rFrame">人员查看</a>
				
			</li>
			<li class="layui-nav-item">
				<a href="/ordersystem/departManage/departManage" target="rFrame">部门管理</a>
			
			</li>
			<li class="layui-nav-item">
				<a href="/ordersystem/restaurantManage/restaurantManage" target="rFrame">餐厅管理</a>
				
			</li>
			<li class="layui-nav-item">
				<a href="/ordersystem/sendMealManage/sendMealManage" target="rFrame">就餐管理</a>
				
			</li>
			<!-- <li class="layui-nav-item">
				<a href="/ordersystem/dinnerView/dinnerView" target="rFrame">就餐查看</a>
				
			</li> -->
			<li class="layui-nav-item ">
				<a href="javascript:;">设置</a>
				<dl class="layui-nav-child">
					<dd><a href="/ordersystem/set/persionInfo" target="rFrame">个人资料</a></dd>
					<dd><a href="/ordersystem/set/pwdChange" target="rFrame">密码更改</a></dd>
					<dd><a href="/ordersystem/set/accountPrivileges" target="rFrame">账户权限分配</a></dd>
					<dd><a href="/ordersystem/set/backup" target="rFrame">备份</a></dd>
				</dl>
			</li>
			
			
		</ul>
	</body>
</html>