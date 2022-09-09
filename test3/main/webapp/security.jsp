<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>security</title>
</head>
<body>

<!-- <form name="f" id="f" method="post" enctype="application/x-www-form-urlencoded" action="http://192.168.100.204:8080/test3/check_page.do"> -->
<form name="f" id="f" method="post" enctype="application/x-www-form-urlencoded" action="http://192.168.100.239:8080/test33/checkpage">
<input type="password" name="security">
<input type="submit" value="외부전송">
</form>




<br><br>


<form name="fa" id="fa" method="get" action="dataload.do">
<input type="text" name="users">
<input type="submit" value="내부전송">


</form>





</body>
</html>

<!--  "http://192.168.100.239:8080/test33/checkpage"  -->

