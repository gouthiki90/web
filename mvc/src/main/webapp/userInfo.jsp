<%@page import="site.metacoding.mvc.web.domain.MyUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 페이지 입니다.</h1>
	<hr />
	
	<%
		MyUser myUser = (MyUser) request.getAttribute("myUser");
	%>

	
	아이디 : <%=myUser.getId() %>
	유저네임 : <%=myUser.getUsername() %>
	패스워드 : <%=myUser.getPassword() %>
	이메일 : <%=myUser.getEmail() %>
</body>
</html>