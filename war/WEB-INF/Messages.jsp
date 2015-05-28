<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="messageHandling.*" %>
<%@ page import="java.util.List.*" %>
<html>
<head>
<style type="text/css">
.myButton {
	background-color:#ededed;
	-moz-border-radius:33px;
	-webkit-border-radius:33px;
	border-radius:33px;
	border:1px solid #dcdcdc;
	display:inline-block;
	cursor:pointer;
	color:#777777;
	font-family:Verdana;
	font-size:12px;
	font-weight:bold;
	padding:3px 8px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffffff;
}

</style>
<script type="text/javascript">
function reply_click(clicked_id){
	document.getElementById("selectedNumberId").value  = clicked_id;
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bgimg.png">
<form action='/chat' target='body' >
    <input type="hidden" name="mobileId" value="${myNumber}"/>
    <input type='text' id='selectedNumberId' name='selectedNumber' style='visibility:hidden'>
	<c:forEach items="${msgs}" var="messages">
	
	    <b><c:set var="tno" value="${messages.toNumber}"/><c:set var="fno" value="${messages.fromNumber}"/><c:set var="myNo" value="${myNumber}"/>
	    <c:if test="${fno == myNo}">
	     <button id= ${messages.toNumber} onClick='reply_click(this.id)' style='width:100%;height:65px;text-align:left;background-color: white;'>
	    	<table width=100% ><tr><td>${messages.toNumber}</td><td align="right"><div class="myButton"> ${messages.time}</div></td></tr></table>
	   	</c:if>
	     <c:if test="${tno == myNo}">
	   		<button id= ${messages.fromNumber} onClick='reply_click(this.id)' style='width:100%;height:65px;text-align:left;background-color: white;'>
		    <table width=100%><tr><td>${messages.fromNumber}</td><td align="right"><div class="myButton"> ${messages.time}</div></td></tr></table>
	   	</c:if></b>
	   <hr> ${messages.messageText}
	   </button>
		<br><br>
	</c:forEach>
</form>
</body>
</html>