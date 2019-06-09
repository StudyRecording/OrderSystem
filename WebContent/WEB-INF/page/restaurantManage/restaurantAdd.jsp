<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				
				$("#search").click(function(){
					var managerPhone=$("#managerPhone").val();
					//alert(managerPhone);
					$.post("/ordersystem/restaurantManage/searchManager",
						{phone:managerPhone},
						function(data){
							$("#managerName").val(data);
							
					});	
					 
					/* $.ajax({
			               type: "POST",
			               url:'/ordersystem/restaurantManage/searchManager',
			               dataType: "json",
			               data: {phone:managerPhone},
			               success: function(data){
			                    alert(data);
			               },
			               error:function(){
			            	   alert("error");
			               }
			               	
			           }); */
				});
				
				layui.use('form', function() {
					var form = layui.form;
					
					
					
					
					//监听提交
					form.on('submit(formDemo)', function(data) {
						//将JavaScript对象或值转换为JSON字符串
						//var json=JSON.stringify(data.field)
						//解析JSON字符串
						//var obj=JSON.parse(json);
						//获得键的值
						//layer.msg(obj.name);
						window.parent.location.reload();
						var index = parent.layer.getFrameIndex(window.name); 
						parent.layer.close(index);
						
						return true;
					});
				});
			})		
		</script>
	
	</head>
	<body>
		<!-- 餐厅添加页面 -->
		<form class="layui-form" action="/ordersystem/restaurantManage/addRestaurant" method="post" style="margin-top: 40px;margin-left: 50px;">
			<div class="layui-form-item" style="margin-top:10px;">
				<label class="layui-form-label">餐厅名称</label>
				<div class="layui-input-inline">
					<input type="text" name="restaurantName"  placeholder="请输入餐厅名称" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			
			<div class="layui-form-item" style="margin-top:20px;">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-inline">
					<input type="text" name="restaurantAddr"  placeholder="请输入地址" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			
			
			<div class="layui-form-item" >
				<label class="layui-form-label">负责人电话(账户)</label>
				<div class="layui-input-block">
					<div class="layui-input-inline" >
						<input id="managerPhone" type="text" name="restaurantManagerphone"  placeholder="请输入负责人电话" autocomplete="off" class="layui-input">	
					</div>
					<button type="button" id="search" class="layui-btn">查询</button>
				</div>
			</div>
			
			<div class="layui-form-item" style="margin-top:20px;">
				<label class="layui-form-label">负责人</label>
				<div class="layui-input-inline">
					<input id="managerName" type="text" name="restaurantManager"  placeholder="请输入负责人姓名" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			
			<div class="layui-form-item" style="margin-top:20px;">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo" style="margin-left: 40px;">立即提交</button>
					<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
				</div>
			</div>
		</form>
	</body>
</html>