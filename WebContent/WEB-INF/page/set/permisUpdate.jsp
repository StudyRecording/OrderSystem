<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script type="text/javascript">
			
			$(function(){
				
				layui.use('form', function() {
					var form = layui.form;
					//监听提交
					form.on('submit(formDemo)', function(data) {
						//layer.msg(JSON.stringify(data.field));
						$.ajax({   
                			url:'/ordersystem/set/permissionAssignment',
                			method:'post',
							contentType: 'application/json',
                			data:JSON.stringify(data.field),       
                			success:function(num){       
                     			if(num>0){
                        			layer.msg('权限分配成功');
                        		}else{
									layer.msg('权限分配失败1');
								}
                    		},              
                    		error:function (num) {
                        		layer.msg('权限分配失败2');
                    		}           
                    	});
						return false;
					});
				});
			})
		
		
			
		</script>
		<style type="text/css">
			hr{
				color: #000000;
			}
		</style>
	</head>
	<body>
		<div id="">
			<font size="4px" color="" style="position: relative;top: 7px;bottom: 4px;left: 5px;">基本资料</font>
			<hr>
			<label class="layui-form-label" style="position: relative;left: 20%;width: 20%;">用户名(手机号):</label>
			<label style="position: relative;left:21%;top:11px">${accountPermis.loginName }</label> <!-- 在jsp中需要追加用户名 -->
		</div>
		
		
		<div id="" style="margin-top: 4%;">
			<form class="layui-form" action="" >
				<input type="hidden" name="loginName" value="${accountPermis.loginName }">
				<div class="layui-form-item" >
					<label class="layui-form-label" style="margin-left: 32%;">姓名:</label>
					<div class="layui-input-inline">
						<input type="text" id="persionName" name="persionName" value="${accountPermis.persionName }" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item" >
					<label class="layui-form-label" style="margin-left: 32%;">性别:</label>
					<div class="layui-input-inline">
						<select name="persionSex" lay-verify="required">
							<c:if test="${accountPermis.persionSex=='男' }">
								<option value="0">女</option>
								<option value="1" selected="selected">男</option>
							</c:if>
							<c:if test="${accountPermis.persionSex=='女' }">
								<option value="0" selected="selected">女</option>
								<option value="1" >男</option>
							</c:if>
							<c:if test="${accountPermis.persionSex=='' }">
								<option value=""></option>
								<option value="0">女</option>
								<option value="1" >男</option>
							</c:if>
								
						</select>
					</div>
				</div>
				
				<div class="layui-form-item" >
					<label class="layui-form-label" style="margin-left: 32%;">部门:</label>
					<div class="layui-input-inline">
						<select name="persionDepart" lay-verify="required">
							<option value=""></option>
							<!-- <option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option> -->
							<c:forEach items="${allDepart }" var="depart">
								<%-- <option value="${depart.id }">${depart.departName }</option> --%>
								<c:choose>
									<c:when test="${depart.departName==accountPermis.persionDepart }">
										<option value="${depart.id }" selected="selected">${depart.departName }</option>
									</c:when>
									<c:otherwise>
										<option value="${depart.id }">${depart.departName }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
			
						</select>
					</div>
				</div>
			
				<div class="layui-form-item" >
					<label class="layui-form-label" style="margin-left: 32%;">身份证号:</label>
					<div class="layui-input-inline">
						<input type="text" name="persionIdnum" value="${accountPermis.persionIdnum }" required lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<font size="4px" color="" style="position: relative;top: 7px;bottom: 4px;left: 5px;">角色</font>
				<hr >
				<div id="" style="margin-left: 11%;margin-bottom: 3%;">
					<c:choose>
						<c:when test="${accountPermis.role=='admin' }">
							<input type="radio" style="width: 10%;" name="role" title="普通用户" lay-skin="primary" >
							<input type="radio" style="width: 10%;" name="role" value="admin" title="系统管理员" lay-skin="primary" checked>
						</c:when>
						<c:otherwise>
							<input type="radio" style="width: 10%;" name="role" title="普通用户" lay-skin="primary" checked>
							<input type="radio" style="width: 10%;" name="role" value="admin" title="系统管理员" lay-skin="primary" >
						</c:otherwise>
					</c:choose>
					
				</div> 
			
				<input type="hidden" name="hava" value="${accountPermis.hava }">
			
				<div class="layui-form-item" style="margin-left: 32%;">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
					</div>
				</div>
			</form>
		</div>





		

	</body>
</html>