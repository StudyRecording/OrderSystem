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
				layui.use(['layer','table'], function(){
					  var table = layui.table;
					  var layer = layui.layer;
					  
					  table.render({
					    elem: '#restaurantData'
					    ,url:'/ordersystem/restaurantManage/getRestaurantData'
					    ,height: 440
					    ,limit: 10
					    ,cols: [[
					      {field:'restaurantName', width:200,edit: 'text', title: '餐厅名称'}
					      ,{field:'restaurantAddr', width:300,edit: 'text', title: '餐厅地址'}
					      ,{field:'restaurantManager', width:100,edit: 'text', title: '餐厅负责人'}
					      ,{field:'restaurantManagerphone', width:200,edit: 'text',title: '负责人电话'}
					      ,{ title:'操作', toolbar: '#restaurantBar'}
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
					  //编辑和删除按键响应
					  table.on('tool(test)', function(obj){
					  		var data = obj.data;
						    if(obj.event === 'del'){
						    	layer.confirm('真的删除行么', function(index){
						        	//obj.del();
						        	$.get("/ordersystem/restaurantManage/del",
						        			{id:data.id},
						        			function(num){
						        				if(num>0){
													parent.location.reload();
						        					//layer.msg("删除成功",{icon:1,time:1000});
						        				}else{
						        					layer.msg("删除失败",{icon:2,time:1000});
						        				}
						        			}
						        	)
						        	layer.close(index);
						      	});
						    	
						    } else if(obj.event === 'edit'){
						      	
						    	layer.confirm('确认修改吗？',
						    			{btn:['确认','取消']},
						    			function(){
						        			$.get("/ordersystem/restaurantManage/edit",
						        				{restaurantName:data.restaurantName,restaurantAddr:data.restaurantAddr,
						        				restaurantManager:data.restaurantManager,restaurantManagerphone:data.restaurantManagerphone,
						        				id:data.id},
						        				function(num){
						        					if(num>0){
						        						layer.msg("修改成功",{icon:1,time:1000});
						        					}else{
						        						layer.msg("修改失败",{icon:2,time:1000});
						        					}
						        				}
						        			)
						        		},
						        		function(){
						        			layer.msg("已选择取消");
						        		}
						    	);
						    }
						   
						});
					  
					  //监听单元格编辑修改
					  table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
  							//console.log(obj.value); //得到修改后的值
  							//console.log(obj.field); //当前编辑的字段名
  							//console.log(obj.data); //所在行的所有相关数据
  							alert(obj.field+":"+obj.value);
					  });
					  
					  //添加按键响应添加
					  $("#add_restaurant").click(function(){
							layer.open({
								type: 2,
								title: '添加餐厅',
								area: ['470px', '400px'],
								offset: 'auto',
								closeBtn: 1,
								content: '/ordersystem/restaurantManage/restaurantAdd'
							}); 
							
							//$("a").attr("href","/ordersystem/restaurantManage/restaurantAdd");
						});
					  
					});
				
			})
			
		</script>
		
	
 		<script type="text/html" id="restaurantBar">
  			<a class="layui-btn layui-btn-xs" lay-event="edit">确认修改</a>
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	</head>
	<body>
		<!-- 餐厅管理 -->
		<button class="layui-btn" style="width: 100%;" id="add_restaurant">添加餐厅</button>
		<!-- <table class="layui-hide" id="restaurantData"></table> -->
		<table id="restaurantData" lay-filter="test"></table>
	</body>
</html>