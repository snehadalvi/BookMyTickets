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
<center>Search for available movie shows in Athens and Book your tickets online!
<hr>
<h3>You have successfully booked tickets for the following show! Thank You!</h3>

<h3>Booking Summary</h3>
<b>Movie Show Information:</b>
<table>
<tr><td>
Movie: <s:property value="#session.bookshow.movie"/><br>
Theatre: <s:property value="#session.bookshow.theatre"/><br>
Date and Time: <s:property value="#session.bookshow.date"/>, <s:property value="#session.bookshow.time"/><br>
Price: $<s:property value="#session.bookshow.price"/><br>

<br>
<b>Billing Information:</b>
<br>
Booked by: <s:property value="#session.user.username"/><br>
Number of tickets: <s:property value="#session.billing.ntickets"/><br>
Total cost: $<s:property value="#session.billing.tcost"/>
</td></tr>
</table>
<br>
<a href="Logout.action">Logout</a>
</center>
</body>
</html>