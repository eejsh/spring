<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.inicis.std.util.SignatureUtil"%>
<%@page import="java.util.*"%>
<%

	//PG사 가입시 발급되는 ID, Key값
	//id,와 signkey 값은 결제 회사에서 별도로 보내줍니다. 
	
	String mid					= "INIpayTest";		                    // 상점아이디 (임시 테스트로 발급 받은 아이디임)		
	String signKey			    = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";	// 웹 결제 signkey
	
	String goodcode = request.getParameter("goodcode"); //상품코드 
	
	
	String mKey = SignatureUtil.hash(signKey, "SHA-256");

	String timestamp			= SignatureUtil.getTimestamp();			// util에 의해서 자동생성
	String orderNumber			= mid+"_"+goodcode;	 //goodcode(상품코드) 받아서 설정   // 가맹점 주문번호(가맹점에서 직접 설정)
	String price				= request.getParameter("price");  // 값 받아서 처리해야됨  	// 상품가격(특수기호 제외, 가맹점에서 직접 설정)

	Map<String, String> signParam = new HashMap<String, String>();

	signParam.put("oid", orderNumber);
	signParam.put("price", price);
	signParam.put("timestamp", timestamp);

	String signature = SignatureUtil.makeSignature(signParam);
	
	//	out.print(signature); 

	/* index2.jsp 데이터 이관 
	goodcode, price는 위에서 받았으니 중복으로 가져오면안됨. 
	*/
	
	String version = request.getParameter("version");
	String currency = request.getParameter("currency");
	String goodname = request.getParameter("goodname");
	String goodea = request.getParameter("goodea");
	
	String buyername = request.getParameter("buyername");
	String buyertel = request.getParameter("buyertel");
	String buyeremail = request.getParameter("buyeremail");
	
	String rec_name = request.getParameter("rec_name");
	String rec_tel = request.getParameter("rec_tel");
	String rec_addr = request.getParameter("rec_addr");
	
	String point = request.getParameter("point");
	
	String gopaymethod = request.getParameter("gopaymethod"); //결제수단
  
	
	
	String buyerid = request.getParameter("buyerid");
//	out.print(buyerid); 값 넘어오는거 확인!
	
%>
<!-- 변수값 선언 다함. backend 역활끝~ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종결제 적용</title>
</head>

<script language="javascript" type="text/javascript" src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>
<script>
function payment() {
//alert("결제시스템 test"); //확인완료 
	INIStdPay.pay('pay');
}

//결제 회사에 IP 등록해서 test용으로 등록해서 local 가능!
//payment 회사 수수료율에 따라 회사 변경할수 있음,, 그때마다 결제시스템 변경할수있습니다. 

</script>
<body>
<br><br>

<!-- 결제 시스템에 필수값은 hidden으로 설정하여 보내주기  -->

<form name="pay" id="pay" enctype="application/x-www-form-urlencoded">

<input type="hidden" name="version" value="<%=version %>"> <!-- 카드사에 제공값 -->
<input type="hidden" name="gopaymethod" value="<%=gopaymethod %>">
<input type="hidden" name="mid" value="<%=mid %>"> <!-- 카드사에서 키 확인값 -->
<input type="hidden" name="oid" value="<%=orderNumber %>"> <!-- odi는 ordernumber로 -->
<input type="hidden" name="price" value="<%=price %>">
<input type="hidden" name="timestamp" value="<%=timestamp %>">
<input type="hidden" name="signature" value="<%=signature %>">
<input type="hidden" name="mKey" value="<%=mKey %>">
<input type="hidden" name="currency" value="<%=currency %>">
<input type="hidden" name="buyername" value="<%=buyername %>">
<input type="hidden" name="buyertel" value="<%=buyertel %>">
<input type="hidden" name="buyeremail" value="<%=buyeremail %>">


<input type="hidden" name="goodname" value="<%=goodname%>">

<!-- ~로컬~ 결제사에서 별도로 ip 풀어줘서 가능.. 집에서는 도메인으로~
<input type="hidden" name="returnUrl" value="http://localhost:8080/payment/INIstdpay_pc_return.jsp"> 
<input type="hidden" name="closeUrl" value="http://localhost:8080/payment/close.jsp">
-->

<input type="hidden" name="returnUrl" value="http://eejsh08.cafe24.com/payment/INIstdpay_pc_return.jsp"> 
<input type="hidden" name="closeUrl" value="http://eejsh08.cafe24.com/payment/INIstdpay_pc_return.jsp"> 


<p>----------------- 결제자 정보 -----------------</p>
고객아이디 : <%=buyerid %><br>
고객명 : <%=buyername %><br>
고객 연락처 : <%=buyertel %><br>
고객 이메일 : <%=buyeremail %><br>


<p>----------------- 상품 정보 -----------------</p>

상품코드 : <%=goodcode %><br>
상품명 : <%=goodname %><br>
상품갯수 : <%=goodea%><br>


<p>------------------ 배송 정보 ------------------</p>

수령인 : <%=rec_name %> <br>
수령인 연락처 : <%=rec_tel %><br>
배송지 주소 : <%=rec_addr %><br>
적립금 사용금액 :<%=point %> 원<br>


<p>----------- 결제 금액 및 결제 수단 -----------</p>

최종결제금액 : <%=price %> <br>
결제수단 : <%=gopaymethod %><br>


<br><br>
<input type="button" value="결제하기" onclick="payment()">

</form>

</body>
</html>

<!-- 

결제 시스템 return 에서 call 사인 ok 뜨면 DB 저장! (INIstdpay_pc_return.jsp 파일에서 이루어짐 )
	저장 후 결제완료페이지로 돌아감, 단 결제 명세서 이메일은 카드사에서 발송함 별도로 제작 안해도됨!
		return call no 사인 뜨면 결제정보로 돌아가기 만듬. (휴대폰번호, 신용카드 에러 등 )
 -->