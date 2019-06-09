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
				layui.use(['table','layer','laydate'], function(){
						var layer = layui.layer;
						var table=layui.table;
						var laydate=layui.laydate;
						laydate.render({
							elem: '#dinnerDateStart' //指定元素
						});
						laydate.render({
							elem: '#dinnerDateEnd' //指定元素
						});
						
						
						table.render({
							elem: '#sendMealDataShow'
							,url:'/ordersystem/sendMealManage/selSendMealDate'
							,height: 380
							,limit: 9
							,cols: [[
								{field:'orderNumber', width:110, title: '订单单号', sort: true}
								,{field:'dinnerTime', width:80, title: '就餐段'}
								,{field:'dinnerNumber', width:90, title: '就餐人数'}
								,{field:'restaurantName', title: '派餐餐厅', width: 90}//之后特殊处理
								,{field:'personnelName', width:80, title: '订餐人'}
								,{field:'personnelPhone', width:130, title: '订餐人电话'}
								,{field:'dinnerWay', width:100, title: '就餐方式'}
								,{field:'dinnerDate', width:130, title: '派餐日期'}
								,{field:'dinnerInstructions', title: '就餐说明'}
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
						
						$("input[type=button]").click(function(){
							var dinnerDateStart=$("#dinnerDateStart").val();
							var dinnerDateEnd=$("#dinnerDateEnd").val();
							//alert(dinnerDateStart+":"+dinnerDateEnd);
							table.reload('sendMealDataShow',{
								url:'/ordersystem/sendMealManage/search',
								where:{dinnerStartDate:dinnerDateStart,
										dinnerEndDate:dinnerDateEnd}
							});
						});
						
						$("#add_sm").click(function(){
							layer.open({
								type: 2,
								title: '添加餐厅',
								area: ['470px', '500px'],
								offset: 'auto',
								closeBtn: 1,
								content: '/ordersystem/sendMealManage/selRestaurant'
						});
					});  	
				});
			})
		</script>
		<style type="text/css">
			#divselect_sm {

				width: 100%;
				margin-bottom: 10px;
			}

			input {
				width: 15%;
				height: 30px;
				border: solid #999999 1px;
				font-size: 16px;
				padding-left: 2px;
				padding-right: 2px;
			}

			font,
			input {
				margin-top: 10px;
				margin-left: 15px;
				margin-right: 5px;
				
			}
		</style>
	</head>
	<body>
		<!-- 派餐管理 -->
		<div id="divselect_sm">
			<form id="sendMealForm">
				<font size="4px" color="">查找条件：</font><br>


				<font size="4px" color="" style="margin-left: 10%;">就餐日期：</font>

				<input type="text" id="dinnerDateStart" name="dinnerDateStart" placeholder="开始日期">&nbsp;&nbsp;&nbsp;———
				<input type="text" id="dinnerDateEnd" name="dinnerDateEnd" placeholder="结束日期">
				<input type="button" value="查询" style="height: 33px; background-color: #009688; border-radius: 4px; border: none;color: white;" />
			</form>
		</div>
		
			
		
		<button type="button" class="layui-btn" style="width: 100%;" id="add_sm">增加订单</button>
		
		<table class="layui-hide" id="sendMealDataShow"></table>
		
		<!-- <table class="layui-table">
			<colgroup>
				<col width="100">
				<col width="80">
				<col width="120">
				<col width="90">
				<col width="200">
				<col width="100">
				<col width="150">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>就餐日期</th>
					<th>就餐段</th>
					<th>就餐餐厅</th>
					<th>就餐人数</th>
					<th>就餐说明</th>
					<th>负责人</th>
					<th>负责人电话</th>
					<th>派单日期</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
				<tr>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
					<td>2</td>
				</tr>
			</tbody>
		</table>
		<button type="button" class="layui-btn" style="width: 20%;position: absolute;left: 15px;bottom: 15px;">上一页</button>
		<button type="button" class="layui-btn" style="width: 20%;position: absolute;right: 15px;bottom: 15px;">下一页</button>
	 -->
	 </body>
</html>