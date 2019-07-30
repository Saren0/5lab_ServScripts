<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Индексная страница</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>Лаборатоная №5 - Точки</h1><hr>
	<a href='<c:url value='<%="/ViewDataController"%>'/>' 
		title="Показать всех данные БД">Показать все данные БД</a><br>
	<a href='<c:url value="task1-preview.jsp"/>' title="Задача 1">Задача 1</a><br>
	<a href='<c:url value="task3.jsp"/>' title="Задача 2">Задача 2</a><br>
	<a href='<c:url value="task4.jsp"/>' title="Задача 3">Задача 3</a><br>
	
    <c:if test="${not empty errorMessage}">
    	<div class="error">
	        <c:out value="${errorMessage}"/>
    	</div><hr>
    </c:if>
 
	<div>
		<h2>Вставить точки</h2>
		<form action="InsertDotsCoordinates" method="GET" accept-charset="utf-8">
			<label for="idInsertGalaxyName">Точка Х:</label>
			<input id="idInsertGalaxyName" type="text" name="xDot" 
				value="" placeholder="точка х" required><br>
			<label for="idInsertGalaxyName">Точка Y:</label>
			<input id="idInsertGalaxyName" type="text" name="yDot" 
				value="" placeholder="точка у" required><br>
			<input type="submit" name="Submit1">
		</form>
	</div><hr>
</body>
</html>