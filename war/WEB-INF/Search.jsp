<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function reply_click(clicked_id){
	document.getElementById("selectedNumberId").value  = clicked_id;
}

function myFunction() {
	var num=document.getElementById("num").value;
	if(isNaN(num)|| num==""){
		alert("Wrong Input")
		document.getElementById("num").value="";	
	}
}
</script>
</head>
<body background="bgimg.png">
	<table>
  	  <tr><td>
  	    <form action="/backHome" target="body"><input type="hidden" name="mobileId" value="${myNumber}"/>
	 	<input type="image" src="back.png" alt="Submit" style='width:50px;height:30px' title="Back">
	    </form>
  	    </td>
  	    
        <td align="right"><form action="/searchMessage" target="body" method="post" >
        <input type="hidden" name="mobileId" value="${myNumber}"/>
    	<h2><p><input type="text" id="num" name="mobileNumber"  placeholder="MobileNumber"/><input type="submit" value="Search" onclick="myFunction()"/></p></h2>
    	</form>
     </td></tr>
   </table><hr>

<form action='/chat' target='body' method='post' >
    <input type='text' id='selectedNumberId' name='selectedNumber' style='visibility:hidden'>
    <input type="hidden" name="mobileId" value="${myNumber}"/>
  <c:forEach items="${msgs}" var="messages">
	    <b><c:set var="tno" value="${messages.toNumber}"/><c:set var="fno" value="${messages.fromNumber}"/><c:set var="myNo" value="${myNumber}"/>
	    <c:if test="${fno == myNo}">
	     <button id= ${messages.toNumber} onClick='reply_click(this.id)' style='width:100%;height:55px;text-align:left;background-color: white;'>
	    ${messages.toNumber}
	   </c:if>
	     <c:if test="${tno == myNo}">
	   <button id= ${messages.fromNumber} onClick='reply_click(this.id)' style='width:100%;height:55px;text-align:left;background-color: white;'>
	   ${messages.fromNumber}
	   </c:if></b>
	   ( ${messages.time} )<br><hr> ${messages.messageText}	
	   </button>
		<br><br>
	</c:forEach>
</form>
</body>
</html>