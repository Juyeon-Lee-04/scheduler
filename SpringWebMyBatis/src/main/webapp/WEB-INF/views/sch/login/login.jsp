<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="en">
<html>
<head>
<style>
#wrap {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
}
/* 
#button {
	 display: block;
	margin-left: 300px;

}
 */
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>내 일 스케줄러-로그인 페이지</title>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">

</head>
<body style="background-color: #87AFEB;">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<div class="mx-auto" style="width: 200px;">
		<!-- <span class="align-middle">middle</span>
	
	 -->
		<a class="navbar-brand ml-4"><img src="../images/내일로고.jpg" height="80"
			width="140"></a>


	</div>
	<br>
<div class="container" style="background-color: WHITE; width:450px; height:400; border-radius: 30px 30px 30px 30px; " text-align=center; >
		<form action="/member/login" method="post">
		<div id="wrap">
			<br> <b><font class = "letter ml-3" size="6" color="gray" >로그인</font> </b><br>
			<br>
			<br>

			
				<table class="table table-hover ml-2" style="width: 380px;">
					<colgroup>
						<col width="50%" />
						<col width="50%" />
					<tr scope="col">
						<td id="title">아이디</td>
						<td><input type="text" name="mem_id" maxlength="20"> <!--  <input type="button" class="btn btn-outline-info btn-sm" value="중복확인" >     -->
						</td>
					</tr>

					<tr>
						<td id="title">비밀번호</td>
						<td><input type="password" name="mem_pw" maxlength="15">
						</td>
					</tr>


				</table>
				<br>

				<button id="button" type="submit" class="btn btn-outline-info btn-sm" 
				style="margin-left: 240px"
					value="로그인">로그인</button>
				<button id= "button" type="button" class="btn btn-outline-info btn-sm"
					value="회원가입" onclick="location.href='register'" 
					>회원가입</button>
				<br> </br>
			</form>
			
		</div>
		
	</div>

</body>
</html>