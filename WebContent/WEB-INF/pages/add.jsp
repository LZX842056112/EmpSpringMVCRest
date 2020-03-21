<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工添加页面</title>
</head>
<body>
	<%
		//项目路径
		pageContext.setAttribute("ctp", request.getContextPath());
	%>
	<h1>员工添加</h1>
	<!-- SpringMVC表单标签 -->
	<form:form action="${ctp}/emp" modelAttribute="employee" method="POST">
		LastName:<form:input path="lastName"/>
			<form:errors path="lastName"/>-->${errorInfo.lastName}
			<br/>
		Email:<form:input path="email"/>
			<form:errors path="email"/>-->${errorInfo.email}
			<br/>
		Gender:&nbsp;&nbsp;&nbsp;
			男：<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
			女：<form:radiobutton path="gender" value="0"/><br/>
		Birth:<form:input path="birth"/>
			<form:errors path="birth"/>-->${errorInfo.birth}
			<br/>
		Salary:<form:input path="salary"/>
			<form:errors path="salary"/>-->${errorInfo.salary}
			<br/>
		Department:
			<form:select path="department.id" 
				items="${depts}" 
				itemLabel="departmentName" 
				itemValue="id"></form:select><br/>
		<input type="submit" value="添加"/>
	</form:form>
</body>
</html>