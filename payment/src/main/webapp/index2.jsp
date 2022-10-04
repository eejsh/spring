<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String m1 = "mid";
String m2 = "mname";
String m3 = "mtel";
String m4 = "memail";


/*
//방식1 : string
String mid1 = (String)session.getAttribute("mid");
String mname1 = (String)session.getAttribute("mname");
*/

//방식2 : object 

//index.jsp 에서 값 받아서 session 올림
Object mid2 = session.getAttribute(m1);
Object mname2 = session.getAttribute(m2);
Object mtel2 = session.getAttribute(m3);
Object memail2 = session.getAttribute(m4);

String pd_code = request.getParameter("product_code");
String pd_name = request.getParameter("product_name");
String pd_money = request.getParameter("product_money");
String pd_ea = request.getParameter("product_ea");

/*
//①
int m = Integer.parseInt(pd_money);
DecimalFormat dc = new DecimalFormat("###,###"); 
String money = dc.format(m);
*/




//DecimalFormat 금액에 , 찍기 위해 사용함. 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제자 정보 확인 및 배송 정보 확인 페이지</title>
</head>

<body>
<form name="frm" id="frm" enctype="application/x-www-form-urlencoded">
<!-- 정해진 히든값 :  결제 카드사에서 정해준 필수 히든값임 
https://manual.inicis.com/pay/stdpay_pc.html 메뉴얼
-->

<!-- PG사에 제공되는 hidden값! -->
<input type ="hidden" name="version" value="1.0">
<input type="hidden" name="mid" value="">
<input type="hidden" name="oid" value="">

<!-- 결제금액 -->
<input type="hidden" name="price" value="<%=pd_money%>"> <!-- 실제 결제금액 -->
<input type="hidden" name="timestamp" value="">
<input type="hidden" name="currency" value="WON">

<!-- 상품명 -->
<input type="hidden" name="goodname" value="<%=pd_name %>">

<!-- 결제자 정보 -->
<input type="hidden" name="buyername" value="<%=mname2 %>"> 
<input type="hidden" name="buyertel" value="<%=mtel2 %>">
<input type="hidden" name="buyeremail" value="<%=memail2 %>">
<input type="hidden" name="goodcode" value="<%=pd_code%>">

<input type="hidden" name="goodea" value="<%=pd_ea%>">


<!-- session hidden -->
<input type="hidden" name="buyerid" value="<%=mid2 %>">


상품코드 : <%=pd_code %> <br>
상품명 :  <%=pd_name %><br>
상품수량 : <%=pd_ea %>EA<br>
<%--①번째 방법 결제금액 : <%=money --%> 
결제금액 : <span id="m"></span>  원<br>

<br><br>

<p>-------------------배송정보 입력 및 최종 결제 금액확정-------------------</p>
수령인 : <input type="text" name="rec_name" value="<%=mname2 %>"><br>
수령인 연락처 : <input type="text" name="rec_tel" value="<%=mtel2 %>"><br>
배송지 주소 : <input type="text" name="rec_addr" value=""><br>
적립금 사용 : <input type="text" name="point" value="0"><br>

최종결제금액 : <span id="total"></span>원 

<br><br><br><br>

<p>------------------------------ 결제 파트 ------------------------------</p>
<input type="radio" name="gopaymethod" value="CARD" checked> 신용카드 <br>
<input type="radio" name="gopaymethod" value="Directbank"> 계좌이체 <br>
<input type="radio" name="gopaymethod" value="vbank"> 가상계좌 <br>
<input type="button" value="결제하기" id="payment">

</form>

</body>
<!-- ECMA 형태의 script -->
<script type="module">
	var money = <%=pd_money%>; //상품 고유금액 값이 변할 수 없음..

	import {gopayment} from "./js/index.js";

	console.log(money);
	document.getElementById("m").innerText = money.toLocaleString(); 
    document.getElementById("total").innerText = money.toLocaleString();

	document.querySelector("#payment").addEventListener("click", function(){
 	gopayment(money);   });


</script>
</html>
<!-- toLocaleString() : 금액에 , 찍기 위해 money에 사용함  -->
<!-- index 출력 후 index2 출력시키면 홍길동으로 바뀜.  -->
<!-- 
결제파트!
무통장 입금은 api로 태우지않음
휴대폰 결제 시 별도의 api 구축해야됨! (모바일결제시스템은 별도로 있음)

 -->