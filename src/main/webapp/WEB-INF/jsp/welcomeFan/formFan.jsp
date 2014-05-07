<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bem-vindo ao Quiz GreNAL</title>
</head>

<body>
	<form method="post" action="${linkTo[WelcomeFanController].welcome}">
		<label for="fanName">Nome Completo:</label>
		<input type="text" name="fan.name"/>
		<select name="fan.team">
			<option value="Internacional">Internacional</option>
			<option value="Gremio">Grêmio</option>
		</select>
		
		<input type="submit" value="Iniciar Quiz"/>
		<input type="reset" value="Limpar"/>
	</form>
</body>
</html>