<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="menus.jsp" %>
<p>아이디 찾기 결과</p>

사용자명 : ${usernm} <br>
사용자이메일 : ${useremail} <br>
가입하신 아이디 : ${userid} <br>


 <br> <br> <br> <br> <br>



외부서버에서 값을 받음 : <%= request.getParameter("result") %>  <br>

내부서버에서 값을 받음 : ${call}

</body>
</html>