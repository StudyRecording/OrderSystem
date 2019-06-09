<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script src="/ordersystem/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			input {
				height: 20px;
				width: 15%;
				padding-left: 2px;
				margin-left: 3px;
			}

			#order_time {
				margin-left: 15px;
			}
		</style>
	</head>
	<body>
		<!-- 就餐查看 -->
		<div id="">
			<form action="" method="post">
				<font size="4px" color="" style="margin-top: 3px;margin-bottom: 3px;">搜索条件：</font><br>


				<input type="text" name="PlaceOrder_time" placeholder="下单日期" id="order_time">
				<input type="text" name="order_number" placeholder="订单单号">
				<input type="text" name="user_name" placeholder="用户姓名">
				<input type="text" name="user_phone" placeholder="手机号">
				<input type="text" name="dinner_room" placeholder="就餐食堂">
				<input type="submit" value="查询" style="height: 24px; background-color: #009688; border-radius: 4px; border: none;color: white;" />
			</form>
		</div>
		<table class="layui-table">
			<colgroup>
				<col width="130">
				<col width="100">
				<col width="150">
				<col width="100">
				<col width="150">
				<col width="100">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th colspan="2">订单明细</th>
					<th colspan="2"></th>
					<th colspan="3">总金额:￥5000元</th>
				</tr>
				<tr>
					<th>订单单号</th>
					<th>用户姓名</th>
					<th>手机号</th>
					<th>就餐食堂</th>
					<th>就餐日期</th>
					<th>就餐段</th>
					<th>下单日期</th>
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
				</tr>
				<tr>
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
	</body>
</html>