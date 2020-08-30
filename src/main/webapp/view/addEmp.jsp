<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	Welcome ${name} !! <br><br>
	<form action="/api/emp/add" method="get">
	Name :	<input type="text" name="name"/ Value='Ajay'> <br>
	Age  :	<input type="text" name="age"/ value='28'  style='margin-left: 10px;'> <br><br>
			<input type="submit" value="Save" style='margin-left: 48px;'/> 
	</form>
</body>
</html>