<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Mascota</title>
</head>
<body>
<h1>Editar Mascota</h1>
<form action="mascotas" method="post">
<c:set var="mascota" value="${mascota}"> </c:set>
	<input type="hidden" name="opcion" value="editar">
	<input type="hidden" name="idMascota" value="${mascota.idMascota}">
		<table border="1">
			<tr>
				<td>Nombre Mascota:</td>
				<td><input type="text" name="nombreMascota" size="50" value="${mascota.nombreMascota}"></td>
			</tr>

				
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>