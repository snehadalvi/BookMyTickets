<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body bgcolor="#D0A9F5">
<h3 align="center">BookMyTickets</h3>
<center>Search for available movie shows in Athens and Book your tickets online!
<hr>
<h2>Registration</h2>
<s:form method="post" name="register" action="Register">
<s:textfield name="username" label="Username" size="25" />
<s:password name="password" label="Password" size="25" />
<s:textfield name="email" label="Email" size="25" />
<s:textfield name="address" label="Address" size="25" />
<s:textfield name="phone" label="Phone" size="25" />
<s:textfield name="first" label="First" size="25" />
<s:textfield name="last" label="Last" size="25" />
<s:submit align="center" value="Register"></s:submit>
</s:form>
</center>
</body>
</html>