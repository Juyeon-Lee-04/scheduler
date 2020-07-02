<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>회원가입</title>


<style>
#wrap {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
}

btt {
/* 	width: 85px;
	float: center;
	padding: 3px */
  display: block;
  margin-left: 330px;
  /* margin-left: auto;  */
  width: 44%;
}
</style>

</head>
<body class style="background-color: #87AFEB;">
	<div id="wrap">
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
			integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
			crossorigin="anonymous">
		<div class="mx-auto" style="width: 200px;">
			<a class="navbar-brand ml-4"><img src="../images/내일로고.jpg" width="140"; height="80"></a>
		</div>
		<br>
		<div class="container"
			style="background-color: WHITE; width: 450px; height: 420px; border-radius: 30px 30px 30px 30px;">
			<b>
				<form action="/member/register" method="post">
					<div id="wrap">
						<br> <b><font class = "letter ml-3" size="6" color="gray"> 회원가입</font></b> <br>
						<br> <br>
						<table class="table table-hover ml-2" style="width: 380px;">
						<colgroup>
						<col width="50%" />
						<col width="50%" />
							<tr scope="col">
								<td id="title">아이디</td>
								<td><input type="text" name="mem_id" maxlength="20"></td>
							</tr>

							<tr>
								<td id="title">비밀번호</td>
								<td><input type="password" name="mem_pw" maxlength="15">
								</td>
							</tr>

							<tr>
								<td id="title">비밀번호 확인</td>
								<td><input type="password" name="" maxlength="15">
								</td>
							</tr>

							<tr>
								<td id="title">이름</td>
								<td><input type="text" name="mem_name" maxlength="40"></td>
							</tr>

						</table>
						<br>
						<btt><input type="submit"
							class="btn btn-outline-info btn-sm" style="clear: right;" value="가입" /> </btt>
				</form>
				
				
		</div>

	</div>
</body>

</html>