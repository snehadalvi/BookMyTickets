<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="jquery-1.11.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#nooftickets").blur(function(){
		var tcost = 0.0;
		var ntickets = $("#nooftickets").val();
		var rate = $("#rate").val();
		tcost = ntickets * rate ;
		$("#cost").val(tcost);		
		});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book My Ticket</title>
</head>
<body bgcolor="#D0A9F5">
<h3 align="center">BookMyTickets</h3>
<center>Search for available movie shows in Athens and Book your tickets online!
<hr>
<b>You have selected following show </b><br>
<table>
<tr><td>Movie: </td><td><s:property value="#session.bookshow.movie"/></td></tr>
<tr><td>Theatre: </td><td><s:property value="#session.bookshow.theatre"/></td></tr>
<tr><td>Date and Time: </td><td><s:property value="#session.bookshow.date"/>, <s:property value="#session.bookshow.time"/></td></tr>
<s:textfield id="rate" label="Price $" value="%{#session.bookshow.price}" disabled="true" size="6"/>
<tr><td>Availability: </td><td><s:property value="#session.bookshow.availability"/></td></tr>
</table>
<br>
<b>Payment Information</b>
<table>
<s:form method="post" name="payandbook" action="PayAndBook">
	<s:textfield id="nooftickets" name="ntickets" label="Number of Tickets to be booked" size="5" />
	<s:textfield id="cost" name="tcost" label="Show Total Cost $" size="5" value="0.0" readonly="true" />
	<s:radio name="cardtype" label="Credit/Debit" list="#{1:'Credit',2:'Debit'}"/>
	<s:submit id="btn2" align="center" value="Pay and Book Tickets"></s:submit>
</s:form>
</table>
</center>
</body>
</html>