<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inicio página de administradores</title>
</head>
<body>
	<h3>Página de inicio solo para administradores</h3> 
	<strong><sec:authentication property="principal.username"/></strong> conectado 
	<a href="<c:url value="/j_spring_security_logout"/>">Cerrar sesión</a>
	<p>
	Nombre y apellidos del usuario conectado:
	<strong> 
	<sec:authentication property="principal.nombre"/> 
	<sec:authentication property="principal.apellidos"/>
	</strong>  
	</p> 
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p>
	Usted tiene acceso además al <a href="<c:url value="/secured/stf/index.htm"/>">Portal de Empleados</a>
	</p>
	</sec:authorize>
	
</body>
</html>
