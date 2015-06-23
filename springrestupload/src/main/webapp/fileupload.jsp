<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>

	<header>Subida de ficheros</header>
	
	<form action="resource/restwb/upload" method="post" enctype="multipart/form-data">
 		 <div><label for="upload">Archivo:</label> <input type="file" id="upload" name="upload" size="50" /></div>

 	   <input type="submit" value="Upload" />
	</form>



</body>
</html>