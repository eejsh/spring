<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //nice_check.jsp에서 넘어옴
    
   String uname = request.getParameter("name");
   String mobile = request.getParameter("mobile_no");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
</head>
<body>

<form>
사용자 아이디 : <input type="text" name="userid" > <br>
사용자 명 : <input type="text" name="username" readonly ="readonly" value="<%=uname %>"> <br>
휴대전화번호 : <input type="text" name="usertel" readonly ="readonly" value="<%=mobile%>"><br>
<input type="button" value="회원가입">
</form>

</body>
</html>