<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA<tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
<!-- header -->
<tiles:insertAttribute  name="header"></tiles:insertAttribute>
<section style="background-color: skyblue;">
QnA
</section>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
<!-- footer -->


</body>
</html>