<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript" src="/ordersystem/js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" href="/ordersystem/layui/css/layui.css">
		<script src="/ordersystem/layui/layui.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#previousPage>button").click(function(){
					//alert("点击上一页");
					var total=${pageInfo.dataTotal};
					var pageStartId=${pageInfo.startId};
					var pageCount=${pageInfo.onePageCount};
					if(pageStartId!=1){
						pageStartId=pageStartId-pageCount;	
					}
					var pageEndId=pageStartId+pageCount-1;
					if(pageEndId>total){
						pageEndId=total;
					}
					if(pageStartId<0){
						pageStartId=1;
					}
					$("#previousPage").attr("href","/ordersystem/peoView/jumpPage?pageStartId="+pageStartId+"&pageEndId="+pageEndId);
				});
				
				$("#nextPage>button").click(function(){
					//alert("点击下一页");
					var total=${pageInfo.dataTotal};
					//alert(total);
					if(total > ${pageInfo.onePageCount }){
						var pageStartId=${pageInfo.startId};
						var pageCount=${pageInfo.onePageCount};
						pageStartId=pageStartId+pageCount;
						var pageEndId=pageStartId+pageCount-1;
						if(pageStartId>total){
							pageStartId=pageStartId-pageCount;
							pageEndId=total;
						}
					}else{
						var pageStartId=1;
						var pageEndId=total;
					}
					
					
					$("#nextPage").attr("href","/ordersystem/peoView/jumpPage?pageStartId="+pageStartId+"&pageEndId="+pageEndId);
				})
			})
		</script>
	</head>
	<style type="text/css">
		#divselect {
			
			width: 100%;
			height: 60px;
		}

		input {
			width: 15%;
			height: 30px;
			border: solid #999999 1px;
			font-size: 15px;
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
	<body>
		<!-- 人员查看 -->
		<div id="divselect">
			<form action="/ordersystem/peoView/selPersonnelByCondition" method="post">
				<font size="4px" color="">查找条件：</font>


				<input type="text" name="personnelName" placeholder="请输入姓名">
				<input type="text" name="personnelIdnum" placeholder="身份证号">
				<input type="text" name="departName" placeholder="所属部门">
				<input type="text" name="restaurantName" placeholder="所属食堂">
				<input type="submit" value="查询" style="height: 33px; background-color: #009688; border-radius: 4px; border: none;color: white;" />
			</form>
		</div>

		<div id="result_people_show">
			<h1 style="color: #01AAED;margin-left: 20px; ">查询结果如下：</h1>
			<table class="layui-table">
				<colgroup>
					<col width="100">
					<col width="150">
					<col width="80">
					<col width="200">
					<col width="150">
					<col width="150">
					<col>
				</colgroup>
				<thead>
					<tr>
						<th>姓名</th>
						<th>手机号</th>
						<th>性别</th>
						<th>身份证号</th>
						<th>所属部门</th>
						<th>就餐食堂</th>
						<th>创建时间</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${personnelList }" var="personnel">
						<tr>
							<td>${personnel.personnelName }</td>
							<td>${personnel.personnelPhone }</td>
							<c:choose>
								<c:when test="${personnel.personnelSex==1 }">
									<td>男</td>
								</c:when>
								<c:when test="${personnel.personnelSex==0 }">
									<td>女</td>
								</c:when>
								<c:when test="${personnel.personnelSex==3 }">
									<td></td>
								</c:when>
							</c:choose>
							
							<td>${personnel.personnelIdnum }</td>
							<td>${personnel.depart.departName }</td>
							<td>${personnel.restaurant.restaurantName }</td>
							<td>${personnel.personnelDate }</td>
						</tr>
					</c:forEach>
					<c:if test="${allQueryData.size()==0 && isQuery==true}">
						<tr><td colspan="6" rowspan="5"><h1 style="color:red;text-align: center;">查无此人</h1><td></tr>
					</c:if>
				</tbody>
				
			</table>
		</div>
		<a id="previousPage" href=""><button type="button" class="layui-btn" style="width: 20%;position: absolute;left: 15px;bottom: 15px;">上一页</button><a>
		<a id="nextPage" href=""><button type="button" class="layui-btn" style="width: 20%;position: absolute;right: 15px;bottom: 15px;">下一页</button></a>
	</body>
</html>