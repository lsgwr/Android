<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>浏览赢取的全部物品</title>
	<!-- 导入Bootstrap 3的CSS样式的样式  -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />	
	<!-- 导入Bootstrap 3的JS插件所依赖的jQuery库  -->
	<script src="jquery/jquery-3.1.1.js"></script>
	<!-- 导入Bootstrap 3的JS插件库 -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div id="data" style="margin-top: 10px;">
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">您赢取的所有物品</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered">
					<thead>
						<tr align="center">
							<th style="text-align: center;">物品名</th>
							<th style="text-align: center;">物品种类</th>
							<th style="text-align: center;">赢取价格</th>
							<th style="text-align: center;">物品描述</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${items}" var="im">
						<tr align="center">
							<td>${im.name}</td>
							<td>${im.kind}</td>
							<td>${im.maxPrice}</td>
							<td>${im.desc}</td>
						</tr>
						</c:forEach>				
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>