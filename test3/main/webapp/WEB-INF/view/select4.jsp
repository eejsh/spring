<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="z" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mydb_select4.java 연동</title>
</head>
<body>


<table border="1" cellspacing="0" cellpadding="0">

<tr>
<td>이름</td> 
<td>전화번호</td>
<td>나이</td>
</tr>
<z:forEach items="${list }" var="test">
<tr>
<td>${test.mnm}</td> 
<td>${test.mtel }</td>
<td>${test.mage }</td>
</tr>

<%-- 고객명 : ${test.mnm}<br> --%>
<%-- 연락처 : ${test.mtel }<br> --%>
<%-- 나이 : ${test.mage }<br> --%>
</z:forEach>
</table>

</body>
</html>

<!-- mybatis 사용시 taglib 사용 필수...ㅡ.,ㅠ -->