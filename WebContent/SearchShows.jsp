<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book My Ticket</title>
</head>
<body bgcolor="#D0A9F5">
<h3 align="center">BookMyTickets</h3>
<center>Search for available movie shows in Athens and Book your tickets online!</center>
<hr>
<br>
<center>
<h2 align="center">Search Shows</h2>

<table align="center">
	<s:form method="post" name="searchShows" action="SearchShows">
	<s:select name="movie" label="Search by Movie" list="#session.movies_list" 
					 headerKey="-1" headerValue="Select Movie"/>
	<s:select name="theatre" label="Search by Theatre" list="#session.theatres_list" 
					headerKey="-1" headerValue="Select Theatre"/>
	<s:submit align="center" value="Search Shows"></s:submit>


	</s:form>
</table>
<br> 
<s:property value="#session.status"/><br>

<table border="1" cellspacing="0">
<s:if test="%{#session.shows_list != null}">
	<tr><td>Movie</td><td>Theatre</td><td>Date and Time</td><td>Price</td><td></td>
	</tr>
</s:if>

<s:iterator value="#session.shows_list" id="show"> 
	<tr>
		<td><s:property value="#show.movie"/>
		<td><s:property value="#show.theatre"/>
		<td><s:property value="#show.date"/>  <s:property value="#show.time"/></td>
		<td>$<s:property value="#show.price"/></td>
		<td>
		<a href="BookShow.action?showid=<s:property value="#show.showid"/>">Book</a>
		</td>
	</tr>
</s:iterator> 
</table>
<br>
Note: You will have to login for booking tickets.<br>
<a href="login.jsp">Go to Login</a><br>
New user? <a href="register.jsp">Click here to Register</a>
</center>
</body>
</html>