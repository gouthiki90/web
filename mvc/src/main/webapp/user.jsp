<%@page import= "java.util.List"%>
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
	<%
	List<MyUser> myUsers = (List<MyUser>) request.getAttribute("myUsers");
		for(int i = 0; i < myUsers.size(); i++){
	%>
	
	아이디 : <%=myUsers.get(i).getId() %>
	유저네임 : <%=myUsers.get(i).getUsername() %>
	패스워드 : <%=myUsers.get(i).getPassword() %>
	이메일 : <%=myUsers.get(i).getEmail() %>
	
	<% } %>
</body>
</html>