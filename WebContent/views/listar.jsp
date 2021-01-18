<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Listar mascotas</h1>

	<table border="1">
		<tr>
			<td>Id Mascota</td>
			<td>Rut dueno</td>
			<td>Nombre Mascota</td>

			<td>Fecha Creacion</td>
			<td>Accion</td>
		</tr>
		<c:forEach var="mascota" items="${lista}">
			<tr>
				<td><a
					href="mascotas?opcion=meditar&idMascota=<c:out value="${ mascota.idMascota}"></c:out>">
						<c:out value="${ mascota.idMascota}"></c:out>
				</a></td>

				<td><c:out value="${ mascota.rutDueno}"></c:out></td>
				<td><c:out value="${ mascota.nombreMascota}"></c:out></td>
				<td><c:out value="${ mascota.creado}"></c:out></td>
				<td><a
					href="mascotas?opcion=eliminar&idMascota=<c:out value="${ mascota.idMascota}"></c:out>">
						Eliminar </a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>