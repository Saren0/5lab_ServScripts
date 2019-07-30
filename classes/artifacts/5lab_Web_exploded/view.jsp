<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Просмотр всех данных БД</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>Просмотр всех данных БД</h1><hr>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br><hr>

	<c:choose>
		<c:when test="${dotsList eq null or empty dotsList}">
			Список точек пуст.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Таблица точек</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>X</th>
						<th>Y</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="currentDot" items="${dotsList}">
					<tr>
						<c:forEach var="item" items="${currentDot}">
							<td>
				    			<c:out value="${item}" />
						    </td>
					     </c:forEach>
				     </tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>