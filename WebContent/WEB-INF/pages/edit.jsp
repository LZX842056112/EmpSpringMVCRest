<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("ctp", request.getContextPath());
	%>
	<h1>员工修改页面</h1>
	<form:form action="${ctp}/emp/${employee.id}" 
		modelAttribute="employee" method="POST">
		<input type="hidden" name="_method" value="put"/>
		<input type="hidden" name="id" value="${employee.id}"/>
		Email:<form:input path="email"/><br/>
		Gender:&nbsp;&nbsp;&nbsp;
			男:<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
			女:<form:radiobutton path="gender" value="0"/><br/>
		Birth:<form:input path="birth"/><br/>
		Salary:<form:input path="salary"/><br/>
		Department:
			<form:select path="department.id" 
			items="${depts}"
			itemLabel="departmentName"
			itemValue="id"></form:select><br/>
		<input type="submit" value="修改"/>
	</form:form>
</body>
</html>