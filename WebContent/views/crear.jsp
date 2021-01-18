<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Mascota</title>
</head>
<body>


	<form action="mascotas" method="post">
	<input type="text" name="opcion" value="guardar">
		<table border="1">
			<tr>	
				<td>Nombre de la Mascota:</td>
				<td><input type="text" name="nombreMascota" size="50"></td>
			</tr>

			<tr>
				<td>Rut del Dueno:</td>
				<td><input type="text" name="rutDueno" size="50"></td>
			</tr>
				
		</table>
		<input type="submit" value="Guardar">
	</form>


</body>
</html>