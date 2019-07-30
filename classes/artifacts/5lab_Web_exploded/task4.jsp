<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Task 4</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>
		Вывести точки из множества, лежащие на одной прямой с заданной прямой.
	</h1><hr>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br>
	
	<div>
		<h2>Введите начальную точку отрезка точку</h2>
		<form action="Task4Controller" method="POST" accept-charset="utf-8">
			<label for="idXdot1">Точка Х:</label>
			<input id="idXdot1" type="text" name="xDot1" 
				value="" placeholder="точка х" required><br>
			<label for="idYdot1">Точка Y:</label>
			<input id="idYdot1" type="text" name="yDot1" 
				value="" placeholder="точка у" required><br>
			<h2>Введите конечную точку отрезка</h2>
			<label for="idXdot2">Точка Х:</label>
			<input id="idXdot2" type="text" name="xDot2" 
				value="" placeholder="точка х" required><br>
			<label for="idYdot2">Точка Y:</label>
			<input id="idYdot2" type="text" name="yDot2" 
				value="" placeholder="точка у" required><br>
			<input type="submit" name="Submit">
		</form>
	</div><hr>
</body>
</html>