<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
function user_check(){
if(f.username.value==""){
	alret("고객명을 입력하세요.");
}else if(f.usertel.value==""){
	alert("전화번호를 입력하세요");
}else{
	f.submit();
}
	
}

</script>
<meta charset="UTF-8">
<title>나이스 인증 체크페이지</title>
</head>
<body>

<form name="f" id="f" method="POST" action="nice_joinok.do" enctype="application/x-www-form-urlencoded">
고객명 <input type="text" name="username"> <br>
고객전화번호 <input type="text" name="usertel"> ※ "-"없이 숫자만 입력하시길 바랍니다. <br>
<input type="button" value="본인인증" onclick="user_check()">


</form>


</body>
</html>