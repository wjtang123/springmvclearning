<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/queryUsers.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>id</td>
	<td>用户名</td>
	<td>密码</td>
	<td>余额</td>
</tr>
<c:forEach items="${UserList }" var="Users">
<tr>
	<td>${Users.id }</td>
	<td>${Users.name }</td>
	<td>${Users.password }</td>
	<td>${Users.money }</td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>