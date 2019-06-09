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
			$(function(){
				$("#addBackup").click(function(){
					$.get("/ordersystem/set/addBackup", function(data){
				          if(data>0){
				        	  alert("备份成功");
				          }else{
				        	  alert("备份失败");
				          }
				          location.reload();
					});
				});
				
				
				layui.use('table', function(){
					var table = layui.table;
				  
					table.render({
				    	elem: '#backup'
				    	,url:'/ordersystem/set/getBackup'
				    	,title: '用户数据表'
				    	,cols: [[
				      		{field:'id', title:'ID', width:80, fixed: 'left',  sort: true}
				      		,{field:'backupDate', title:'备份日期', edit: 'text'}
				      		,{field:'backupName', title:'操作人', width:200, edit: 'text'}
				      		,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
				    	]]
				    	,page: true
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
		    			if(obj.event === 'restore'){
		      				layer.confirm('真的还原备份么', function(index){
		      					$.get("/ordersystem/set/restore",
		      							{id:data.id},
		      							function(num){
		      								if(num>0){
		      									alert("还原成功");
		      									location.reload();
		      								}else{
		      									alert("还原失败");
		      								}
		      								
		      							});
		        				layer.close(index);
		      				});
		    			}/*  else if(obj.event === 'edit'){
		      				layer.prompt({
		        				formType: 2
		        				,value: data.email
		      				}, function(value, index){
		        				obj.update({
		          					email: value
		        				});
		       					layer.close(index);
		      				});
		    			} */
		  			});
					
					
					
				});
				
				
				
				

	  			
				  
			})
			
		</script>
		<script type="text/html" id="barDemo">
  			<a class="layui-btn layui-btn-xs" lay-event="restore">还原</a>
		</script>
	</head>
	<body>
		<!-- 数据库备份 -->
		<button class="layui-btn" style="width: 100%;" id="addBackup">新增备份</button>
		<table class="layui-hide" id="backup" lay-filter="test"></table>
		
	</body>
</html>