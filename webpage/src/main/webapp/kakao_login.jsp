<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오로그인 -API 연동 및 자회사몰 가입 + joinpart.java</title>
</head>
<body>

<input type="button" value="자회사몰 회원가입" onclick="join();">


<!-- 카카오 로그인 및 회원가입 -->
	<img src="./login.png" onclick="abc();">
	<input type="button" value="로그아웃" onclick="logout();">


<form name="kakao" method="POST" action="kakaojoin.do">
<input type="hidden" name="userid" value="">
<input type="hidden" name="username" value="">
<input type="hidden" name="useremail" value="">
</form>

<!-- 소셜은 배열값으로 보내서 get으로 보내면절대안됨!!!!!! -->


</body>
</html>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
//로그인 및 로그아웃
//웹 + 하이브리드앱 : API
// 웹 전용 : Auth

function join(){
	location.href="./join.do";
}

Kakao.init('3fb411ffadb12b1bf5339cfb8f7cc092');
	function abc() {
		Kakao.Auth.login({   //로그인 및 회원가입
			success : function(response) {
				Kakao.API.request({
					url : '/v2/user/me',
					success:function(response){
				//console.log(response["id"]);     //사용자 정보 API 배열
				//console.log(response["kakao_account"]["email"]); 
				kakao.userid.value=response["id"];
				kakao.username.value=response["kakao_account"]["email"];
				kakao.useremail.value=response["kakao_account"]["email"];	
				kakao.submit(); //kakaojoin.do로 날아감
				//카카오 로그인 시 카카오의 정보를 찾아서 태워 보내기. 
					},
					
					fail:function(error){
						console.log(error);
					}
				});
			
			},
			fail : function(error) {
			console.log(error);
			},
		});

	}
	
	//카카오 로그아웃 
	function logout() { 
		
		
		if(Kakao.Auth.getAccessToken()){
				Kakao.API.request({
					url : '/v1/user/unlink',
					success:function(response){
				console.log(response);
					},
					fail:function(error){
						console.log(error);
					}
				});
			
			Kakao.Auth.setAccessToken(undefined);
			
		}
	}
	
</script>

