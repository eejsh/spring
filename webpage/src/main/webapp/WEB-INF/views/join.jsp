<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자회사몰 회원가입</title>
</head>
<script>


function ok(){
if(f.userid.value=="" || f.username.value=="" || f.useremail.value=="" ){
	alert("빈칸을 모두 넣어주세요.");
	}else{
		f.submit();
	}
}

</script>
<body>

<form name="f" id="f" method="POST" action="./joinok.do" enctype="application/x-www-form-urlencoded" >
아이디 : <input type="text" name="userid"><br>
이름 : <input type="text" name="username"><br>
이메일 : <input type="text" name="useremail"><br>
<input type="button" value="회원가입" onclick="ok();">
</form>



</body>
</html>