/*js파일에는 jsp 코드 사용이 안됨!*/

export function gopage(){
 // alert("test"); 테스트 확인
 
 if(frm.product_name.value==""){
 	alert("상품명을 입력하세요");
 }else if(frm.product_money.value==""){
    alert("상품 결제 금액을 입력하세요");
 }else if(frm.product_ea.value==""){
 		alert("상품 수량을 입력하세요");
 }else{
	if(frm.product_ea.value <= 0 ){
 			alert("상품 수량을 입력하세요");
 	}else{
 	
 	frm.method = "POST";
 	frm.action = "index2.jsp";
 	frm.submit();
  		}
  	}
 }
 
 /*기본 적립금 확인 및 실제 결제할 금액체크*/
 export function gopayment(money){
 //alert("test"); //test 확인
 
 var oksign = "no";
 
 if(frm.point.value > 0){
 
  var ori_m = frm.price.value;  //현재 상품금액
  var point = frm.point.value;  //사용자 사용할 적립금액
   
  var new_m = ori_m -point; //상품금액-적립금액

	frm.price.value = new_m;
	document.getElementById("total").innerText = new_m.toLocaleString();	
  	
  	oksign="ok";
  	
  	console.log(oksign);
  	
 }else if(frm.point.value=="" || frm.point.value=="0"){
 
 	frm.price.value = money;  //포인트 값이 0 일 경우 price 가격 그대로 출력시켜줘야함
	frm.point.value = 0; //point에 0값이 있었는데 지웟을 경우 경고창 대신 0 값 다시 넣기
	
	document.getElementById("total").innerText = money.toLocaleString()
	 
	 oksign="ok";
	console.log(oksign); 
	 }
	 
	 
 	 //oksign
 	if(oksign=="ok"){
 	 frm.method = "POST";  // 결제시스템은 get으로 보내는 경우 절대 없음 all post (get = 사용자 정보, 보안안좋음 )
 	 frm.action = "./index3.jsp";
 	 frm.submit();
 	
 	
 }
 
 }
 