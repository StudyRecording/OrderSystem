<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script type="text/javascript">

			layui.use(['layer','form'], function() {
				var form = layui.form;
				var layer=layui.layer;
				//刷新radio标签
				form.render('radio');

				//监听提交(利用ajax技术)
			 	form.on('submit(updAdmin)', function(data) {
					//layer.msg(JSON.stringify(data.field));
					$.ajax({   
                		url:'/ordersystem/set/updateAdmin',
                		method:'post',
						contentType: 'application/json',
                		data:JSON.stringify(data.field),       
                		success:function(num){       
                     		if(num>0){
                        		layer.msg('信息修改成功');
                        	}else{
								layer.msg('信息修改失败1');
							}
                    	},              
                    	error:function (num) {
                        	layer.msg('信息修改失败2');
                    	}           
                    });  

					return false; 
				}); 
			});
		</script>

	</head>
	<body>
		<!-- 设置个人资料 -->
		<div id="" style="padding-left: 32%;margin-top: 4%;">
			<form class="layui-form" action="" method="">
				<div class="layui-form-item" style="margin-top: 5%;">
					<label class="layui-form-label">姓名:</label>
					<div class="layui-input-inline">
						<input type="text" name="adminName" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item" style="margin-top: 5%;">
					<label class="layui-form-label">性别:</label>
					<div class="layui-input-inline">
						<select name="adminSex" lay-verify="required">
							<option value="0">女</option>
							<option value="1">男</option>	
						</select>
					</div>
				</div>
				
				<!-- <div class="layui-form-item" style="margin-top: 5%;">
					<label class="layui-form-label">部门:</label>
					<div class="layui-input-inline">
						<select name="persion_apart" lay-verify="required">
							<option value=""></option>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
			
						</select>
					</div>
				</div> -->
			
				<div class="layui-form-item" style="margin-top: 5%;">
					<label class="layui-form-label">身份证号:</label>
					<div class="layui-input-inline">
						<input type="text" name="adminIdnum" required lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
					</div>
				</div>
			
			
			
			
				<div class="layui-form-item" style="margin-top: 5%;">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="updAdmin">立即提交</button>
						
<!--  						<input type="submit" value="立即提交" class="layui-btn">
 -->					</div>
				</div>
			</form>
		</div>
		
	</body>
</html>