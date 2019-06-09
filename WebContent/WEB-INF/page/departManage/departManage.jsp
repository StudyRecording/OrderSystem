<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
<script src="/ordersystem/layui/layui.js"></script>
<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
			
			$(function(){
				layui.use(['layer','table'], function(){
					var layer = layui.layer;
					var table = layui.table;
					
					table.render({
						  elem: '#depart'
						  ,height: 440
						  ,url: '/ordersystem/departManage/getDepatDate' //数据接口
					      ,page: {
					    	  layout: ['count', 'prev', 'page', 'next', 'skip']
							  ,groups: 1
					      } //开启分页
					      ,limit: 8
					      ,cols: [[ //表头
						      //{field: 'id', title: '编号', width:200,  fixed: 'left'}
					      	  //,
					      	  {field: 'departName', title: '部门名称', width:600, fixed: 'left'}
						      ,{ title:'操作', toolbar: '#barDemo'}
						  ]]
						  ,parseData: function(res){ //res 即为原始返回的数据
					    		return {
					      			"code": res.status, //解析接口状态
					      			"msg": res.msg, //解析提示文本
					      			"count": res.total, //解析数据长度
					      			"data": res.data //解析数据列表
					    		};
					  		}
					});
					
					
					  //监听行工具事件
					table.on('tool(test)', function(obj){
						var data = obj.data;
					    //console.log(obj)
					    if(obj.event === 'del'){
					    	layer.confirm('真的删除行么', function(index){
					        	obj.del();
					        	layer.close(index);
					        	
					        	$.get("/ordersystem/departManage/delete",
						    			{id:data.id},
						    			function(num){
						    				if(num>0){
						    					layer.msg("删除成功",{icon: 1,time:1000});
						    				}else{
						    					layer.msg("删除失败",{icon: 2,time:1000});
						    				}
						    			}
						    	); 
					        	
					        	
					      	});
					    } else if(obj.event === 'edit'){
					    	layer.prompt({
					        	formType: 0
					        	,title:'请修改部门名称'
					        	,value: data.departName
					      	}, 
					      	function(value, index){
					        	obj.update({
					        		departName: value
					        	});
					        	layer.close(index);
					        	
					        	$.get("/ordersystem/departManage/edit",
						    			{name:value,id:data.id},
						    			function(num){
						    				if(num>0){
						    					layer.msg("修改成功",{icon: 1,time:1000});
						    				}else{
						    					layer.msg("修改失败",{icon: 2,time:1000});
						    				}
						    			}
						    	);
					        	
					      	});
					    	
							
					    	
					   }
					})    
					
					//添加部门
					$("#add_apart").click(function(){
						layer.open({
							type: 2,
							title: '部门添加',
							area: ['360px', '300px'],
							offset: 'auto',
							closeBtn: 1,
							content: '/ordersystem/departManage/departAdd'
						});
					});  
	  
				});
				
			})
			
			
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<style type="text/css">
		.layui-table-cell {
            height: auto;
            line-height: 33px;
        }
	
</style>
</head>

<body>
	<!-- 部门管理 -->
	<button class="layui-btn" style="width: 100%;" id="add_apart">添加部门</button>
	<!-- 		<div id="depart_div">
			<table class="layui-table">
				<colgroup>
					<col width="300">
					<col >
					
				</colgroup>
				<thead>
					<tr>
						<th>部门名称</th>
						<th>操作</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td style="text-align: center;">
							<div class="layui-btn-group">	
								<button class="layui-btn">编辑</button>
								<button class="layui-btn">删除</button>
							</div>
						</td>
						
					</tr>
					<tr>
						<td>2</td>
						<td style="text-align: center;">
							<div class="layui-btn-group">	
								<button class="layui-btn">编辑</button>
								<button class="layui-btn">删除</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<button type="button" class="layui-btn" style="width: 20%;position: absolute;left: 15px;bottom: 15px;">上一页</button>
		<button type="button" class="layui-btn" style="width: 20%;position: absolute;right: 15px;bottom: 15px;">下一页</button>
	 -->
	<table id="depart" lay-filter="test"></table>

</body>
</html>