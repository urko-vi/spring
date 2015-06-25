<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h3>login page</h3>
	<%	if ( session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")!= null) { %>
		<label class="error">Error en el proceso login</label>
	<%	} 
		session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION"); 
	%>
	<form class="navbar-form navbar-right" name="f" method="post" action="<%=request.getContextPath() %>/j_spring_security_check">
    	<div class="form-group">
            <input type="text" class="form-control"  id="j_username" name="j_username" />
        </div>
        <div class="form-group">
        	<input type="password"  class="form-control"  name="j_password">
        </div>
        <button type="submit" class="btn btn-success">Entra!</button>
    </form>
</body>
</html>
