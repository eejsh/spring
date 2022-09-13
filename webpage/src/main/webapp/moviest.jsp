<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 영화순위 공작소 + movie_api.java</title>
</head>
<body>

	<table border ="1" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
			<th width="80">순위</th>
			<th width="200">진입</th>
			<th width="100">영화제목</th>
			</tr>
		</thead>

		<tbody id="listview">
		</tbody>


	</table>
</body>


<script>
//movie_abc : key값으로 전달받음. 

var today ="2022-09-08"; //mysql 저장된 날짜
var ajax = new XMLHttpRequest();
ajax.open("GET", "http://localhost:8080/webpage/movie?apikey=movie_abc&apidate=" + today, true);
ajax.send();
//front(ajax)는 apikey의 날짜를 파라미터에 적용하여 get으로 전달
//ajax.open("post") => 405에러 발생

ajax.onreadystatechange = function(){
	if(ajax.status==200 && ajax.readyState==XMLHttpRequest.DONE){
		//console.log(ajax.response);
		var mdata = ajax.response;
		//var mdate2 = mdata.replace('n/g', "" );
		//console.log(mdata2)
		var mdata = JSON.parse(ajax.response);
	//console.log(mdata);
	html_print(mdata);
	}
}


function html_print(mdata){
	console.log(mdata);
	var pt = document.getElementById("listview");
	var ea = mdata.length;
	var k=0;
	var htmlcode = "";
	var icon ="";  //신규 진입 아이콘 , 여기에 아이콘 이미지 넣으면됨.
	do{
		
		if(mdata[k]['arankpart']=="NEW"){
				icon ="[신규]";
		}else{
			icon ="";
		}
		
		htmlcode += "<tr>";
		htmlcode += "<td>"+ mdata[k]['arank']+"</td>";
		htmlcode += "<td>"+ mdata[k]['anm']+ icon + "</td>";
		htmlcode += "<td>"+ Number(mdata[k]['aperson']).toLocaleString()+" 명</td>";
		htmlcode += "<tr>";
		k++;
	}while(k<ea);
	
   pt.innerHTML = htmlcode;
   
}


</script>
</html>