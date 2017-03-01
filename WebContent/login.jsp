<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book My Ticket - Sign In</title>
</head>
<body bgcolor="#D0A9F5">
<h3 align="center">BookMyTickets</h3>
<center>Search for available movie shows in Athens and Book your tickets online!
<hr>
<br><br>
<a href="RetrieveData.action">Search Available Shows</a> (No need to Login for Search Only)
<br><br>
Login
<table border="0" bgcolor="#AC58FA" align="center">
	<tr>
		<th bgcolor="#AC58FA" align=center
			style="padding: 2; padding-bottom: 4"><font size=-1
			color="white" face="verdana,arial"><b>Enter Login Information</b></font></th>
	</tr>
	<tr>
		<td><s:form method="post" name="login" action="Login">

			<table align="center" bgcolor="#D0A9F5" cellpadding="5" width="30%">
				<!--			<caption align="left"><b>Login Credentials</b></caption>-->
				<tr>
					<td><s:textfield name="username" label="Username" size="25" />
					</td>
				</tr>
				<tr>
					<td><s:password name="password" label="Password" size="25" />
					</td>
				</tr>
				<tr>
					<td><s:submit align="center" value="Login"></s:submit></td>
				</tr>
			</table>

		</s:form></td>
	</tr>
</table>
New user? <a href="register.jsp">Click here to Register</a>
</center>
</body>
</html>