<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//setAttribute, getAttribute 같이 사용 금지 
	String mid, mname, memail, mtel ;
	mid = "hong";
	mname ="홍길동";
	memail = "eejsh08@naver.com";
	mtel = "01012345678";
	
	//휴대폰 번호는 무조건 - 빼고 숫자만 등록이 기본.
	//api에 사용하는 전화번호, 보여주기식 010-1234-5678 테이블 2개 사용하는 경우도 있음 
	
	session.setAttribute("mid",mid); //(닉네임, 본값)
	session.setAttribute("mname",mname);
	session.setAttribute("mtel", mtel);
	session.setAttribute("memail", memail);
	//index3.jsp 세션값필요. 
	
	
	/* //세션값 지우기 
	session.removeAttribute(mid);
	session.removeAttribute(mname);
	*/
	
	/* 상품코드 6자리 난수코드를 생성 (중복되면안됨) */
	Random rd = new Random();
	int number;
	String nb=""; 
	for(int a=1; a<7; a++){
		number = rd.nextInt(9);
		nb += number;
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택 부분</title>
</head>
<body>

<form name="frm" id="frm">

<!-- 결제시스템에는 상품코드는 최소 6자리~ 최대 12자리  
상품수량 : 무조건 숫자만 입력 
결제금액 : 무조건 숫자만 입력 : 25,000(x), 25000
결제금액 : 최소 1000원 부터 시작함
상품명 : 불필요한 단어 주의  (마약, 담배, 술.. 이런 상품명은 무조건 필터링)
-->

상품코드 : <input type="text" name="product_code" value="<%=nb %>" readonly="readonly"><br>
상품명 : <input type ="text" name="product_name" value=""><br>
상품수량 : <input type="text"  name="product_ea" value=""><br>
결제금액 : <input type="text" name="product_money" value=""><br>
<input type="button" value="상품구매확정" id="btn">
</form>
<!-- ECMA 형태의 script -->
<script type="module">
	import {gopage} from "./js/index.js";
	document.querySelector("#btn").addEventListener("click", gopage);
</script>
</body>
</html>
<!-- 
css파일? do 로 시작 하면 views→css폴더 만들어서 해야됨.
spring은 do로 만든 상태면 web-inf
do 안거치고 jsp로 css 면 webapp>css 폴더 만들어서 추가해야됨
경로중요함!
 -->