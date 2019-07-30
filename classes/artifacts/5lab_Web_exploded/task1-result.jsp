<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Task 1</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>
		Точка из множества, наиболее приближенную к заданной.
	</h1>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br><hr>
    
	<c:choose>
		<c:when test="${task1ResultList eq null or empty task1ResultList}">
			Нет приближенных точек.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Точки.</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>X</th>
						<th>Y</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="resultLine" items="${task1ResultList}">
						<tr>
						<c:forEach var="item" items="${resultLine}">
							<td><c:out value="${item}"/></td>
						</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>