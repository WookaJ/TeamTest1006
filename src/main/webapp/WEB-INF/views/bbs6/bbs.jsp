<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
	display: grid;
	grid-template-columns: 200px 1fr 200px;
	grid-template-rows: 50px 50px 50px 1fr 200px;
	gap: 0px 0px;
	grid-auto-flow: row;
	grid-template-areas: ". . ." ". pannel ." ". . ." ". main ." ". . .";
}

.pannel {
	grid-area: pannel;
	display: flex;
	flex-direction: row-reverse;
}

main {
	grid-area: main;
}

table {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

table td, table th {
	border: 1px solid #ddd;
	padding: 8px;
}

table tr:nth-child(even) {
	background-color: #f2f2f2;
}

table tr:hover {
	background-color: #ddd;
}

table th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #0335fc;
	color: white;
}
</style>
</head>

<body>
	<div class="container">
		<div class="pannel">
			<button id="btn1">글쓰기</button>
		</div>
		<main>
			<table>
				<thead>
					<tr>
						<th>id</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일/작성시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.id}</td>
							<td>${vo.category}</td>
							<td><a
								href="${pageContext.request.contextPath}/bbs6/bbs/${vo.id}">${vo.title}</a></td>
							<td>${vo.owner}</td>
							<td>${vo.createDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</div>
	<script type="text/javascript">
		document.getElementById("btn1").addEventListener("click",function(){
			location.href = "${pageContext.request.contextPath}/bbs6/bbs/set";
		});
	</script>
</body>

</html>