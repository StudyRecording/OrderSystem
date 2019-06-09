<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
				layui.use(['form','laydate'], function() {
					var form = layui.form;
					var laydate = layui.laydate;
					
					laydate.render({
						elem: '#dinnerDate' //指定元素
					});
		
					//监听提交
					form.on('submit(add_sm_form)', function(data) {
						/* //将JavaScript对象或值转换为JSON字符串
						var json=JSON.stringify(data.field)
						//解析JSON字符串
						var obj=JSON.parse(json);
						//获得键的值
						layer.msg(obj.name); */
						window.parent.location.reload();
						var index = parent.layer.getFrameIndex(window.name); 
						parent.layer.close(index);
						return true;
					});
				});
		</script>
			
	</head>
	<body>
		<!-- 派餐添加页面 -->
		<form class="layui-form" action="/ordersystem/sendMealManage/addSendMeal" method="post" style="margin-top: 20px;margin-left: 50px;">
			<div class="layui-form-item">
				<label class="layui-form-label">就餐日期</label>
				<div class="layui-input-inline">
					<input type="text" name="dinnerDate" id="dinnerDate" required lay-verify="required" placeholder="请输入就餐日期" autocomplete="off"
					 class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">就餐段</label>
				<div class="layui-input-inline">
					<select name="dinnerTime" lay-verify="required">
						<option value=""></option>
						<option value="0">早餐</option>
						<option value="1">午餐</option>
						<option value="2">晚餐</option>
						
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">就餐餐厅</label>
				<div class="layui-input-inline">
					<select name="restaurantId" lay-verify="required">
						<option value=""></option>
						<c:forEach items="${restaurantList }" var="restaurant">
							<option value="${restaurant.id }">${restaurant.restaurantName }</option>
						</c:forEach>
						<!-- <option value=""></option>
						<option value="0">餐厅1</option>
						<option value="1">餐厅2</option>
						<option value="2">餐厅3</option>	 -->
					</select>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">就餐人数</label>
				<div class="layui-input-inline">
					<input type="text" name="dinnerNumber" required lay-verify="required" placeholder="请输入就餐人数" autocomplete="off"
					 class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">就餐说明</label>
				<div class="layui-input-inline">
					<input type="text" name="dinnerInstructions" required lay-verify="required" placeholder="请输入就餐说明" autocomplete="off"
					 class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">订餐人</label>
				<div class="layui-input-inline">
					<input type="text" name="personnelName" required lay-verify="required" placeholder="请输入订餐人" autocomplete="off"
					 class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">订餐人电话</label>
				<div class="layui-input-inline">
					<input type="text" name="personnelPhone" required lay-verify="required" placeholder="请输入订餐人电话" autocomplete="off"
					 class="layui-input">
				</div>
			</div>


			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="add_sm_form" style="margin-left: 40px;">立即提交</button>
					<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
				</div>
			</div>
		</form>
	</body>
</html>