<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- tiles.apache.org : backend가 유일하게 페이지레이아웃을 구성하는 라이브러리.
   
   tiles 라이브러리를 꼭 pom.xml 에 추가 하시고 and tiles.xml 를 생성하여 적용해 주도록 합니다.
   단, class 대한 경로 사용시 /가 아닌 . 으로 설정하여야 합니다.
   
    -->
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터<tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
<!-- header -->



<tiles:insertAttribute name="header"></tiles:insertAttribute>

<jsp:include page="../top.jsp"></jsp:include><!-- jsp:inculude 로 읽어오기.. -->
<section style="background-color: orange;">
고객센터 메인
</section>

<tiles:insertAttribute name="footer"></tiles:insertAttribute>
<!-- footer -->
</body>
</html>