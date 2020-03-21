<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		pageContext.setAttribute("ctp", request.getContextPath());
	%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工列表</title>
	<script type="text/javascript" src="${ctp}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h1>员工列表</h1>
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Birth</th>
			<th>Salary</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.gender==0?"女":"男"}</td>
				<td>${emp.birth}</td>
				<td>${emp.salary}</td>
				<td>${emp.department.departmentName}</td>
				<td>
					<a href="${ctp}/emp/${emp.id}">Edit</a>
				</td>
				<td>
					<a href="${ctp}/emp/${emp.id}" class="delBtn">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${ctp}/toaddpage">添加员工</a>
	
	<form id="deleteForm" action="${ctp}/emp/${emp.id}" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	<script type="text/javascript">
		$(function() {
			$(".delBtn").click(function() {
				//1.改变表单的action指向
				$("#deleteForm").attr("action",this.href);
				//2.提交表单
				$("#deleteForm").submit();
				return false;
			});
		});
	</script>
</body>
</html>