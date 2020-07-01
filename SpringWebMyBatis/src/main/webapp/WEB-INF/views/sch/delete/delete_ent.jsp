<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 정보 삭제</title>
<style>
#tmp {
	margin-left: 50%;
	color: #81898E;
}
</style>
</head>
<body>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">

	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #87AFEB;">
	<div class="container">
		<a class="navbar-brand"><img src="../images/내일로고.jpg" height="40"
			width="70"></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link" href="../">홈 <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="../lecture">수강
						정보</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="../enterprise">지원 기업</a></li>


			</ul>
			<!-- <form class="form-inline my-2 my-lg-0">
			      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form> -->
		</div>
	</div>

	</nav>

	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #E3EEFC;">
	<div class="container">

		<span id="tmp" class="navbar-item">기업 정보 삭제</span>
	</div>
	</nav>

	<form action="<c:url value='/enterprise/delete'/>" method="post">
		<br>
		<div class="container">

			<table class="table table-hover">
				<colgroup>
					<col width="15%" />
					<col width="85%" />

				</colgroup>
				<%-- <tr>
					<th scope="col">기업 ID</th>
					<td>${ent.ent_id}</td>
				</tr> --%>
				<tr>
					<th scope="col">기업명</th>
					<td>${ent.ent_name}</td>
				</tr>
				<tr>
					<th scope="col">서류마감일</th>
					<td>${ent.paper_end}</td>
				</tr>
				<tr>
					<th scope="col">1차 면접일</th>
					<td>${ent.interview1}</td>
				</tr>
				<tr>
					<th scope="col">2차 면접일</th>
					<td>${ent.interview2}</td>
				</tr>
				<tr>
					<th scope="col">3차 면접일</th>
					<td>${ent.interview3}</td>
				</tr>
			</table>

			<!-- hidden으로 값넘겨주기 -->
			<input type="hidden" name="ent_id" value="${ent.ent_id}"> <br>
			<input class="btn btn-outline-info btn-sm" type="submit" value="삭제">
			<a class="btn btn-outline-info btn-sm" href="../enterprise">취소</a>





		</div>
	</form>
</body>
</html>