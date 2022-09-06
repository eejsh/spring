<%@page import="mydb.model_dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="z" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl : taglib으로 생성하여 배열값을 출력시킴 pom에 jstl, taglib 설정하여야함! -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 IOC 형태 - dbquery.java (controller)</title>
</head>
<body>
데이터 총 갯수는 ${data_row}


<br><br>

<!-- controller에서 model 값으로 보내준 클래스 명으로 var 로 변환하여 key 로 출력 시킴 -->
<z:forEach items="${pso}" var ="test">
고객명 : ${test.mnm} <br>
고객전화번호 : ${test.mtel} <br>
고객연령 : ${test.mage } <br>
</z:forEach>

</body>
</html>