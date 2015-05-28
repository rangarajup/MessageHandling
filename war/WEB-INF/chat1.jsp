<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="messageHandling.*" %>
<html>
<head>
<script type="text/javascript">
function reply_click(clicked_id){
	document.getElementById("selectedNumberId").value  = clicked_id;
}</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
JdoOperations jdo=new JdoOperations();
long frmNum=Long.parseLong(request.getAttribute("myNumber").toString());
long toNum=Long.parseLong(request.getAttribute("chatNumber").toString());
%>

<style>
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

</head>


<body onLoad="window.scrollBy(0,10000)" background="bgimg.png">
	<input type="text" id="count" style='visibility:hidden'>
		<script>
 			var count=<%=jdo.displayChatCount(toNum,frmNum) %>;
 			document.getElementById("count").value=count;
		</script>
    <h3>${chatNumber}</h3><hr>
    <table width=100%><tr HEIGHT=500 valign='top'><td>
     <table width=100%>
     <c:forEach items="${chatMsgs}" var="messages">
	    <b><c:set var="tno" value="${messages.toNumber}"/><c:set var="fno" value="${messages.fromNumber}"/><c:set var="myNo" value="${myNumber}"/>
	    <c:if test="${fno == myNo}">
	  		 <tr align='right'><td>
	    </c:if>
	   <c:if test="${tno == myNo}">
	  		 <tr align='left'><td>
	   </c:if></b>
	  
        <button id="btn" name="${messages.id}"  style='width:70%;text-align:left;background-color: white;'>
	   ${messages.messageText}	<br><table width=100%><tr><td align="right"> <div class="myButton"> ${messages.time}</div> </td></tr></table>
	   </button><br><br>
        
	  
	</c:forEach>
    </table>
  	</td></tr><tr><td><hr>
  	 
  	<table width=100%><tr>
  	<td align='left'>
  	<form action="/backHome" target="body"><input type="hidden" name="mobileId" value="${myNumber}"/>
	 	 <input type="image" src="back.png" alt="Submit" style='width:50px;height:50px' title="Back">
	</form>
	</td>
  	 <form action="/sendChatMessages" >
  	 <input type='text'  name="msgNumber"  style='visibility:hidden' value=${chatNumber} >
  	 <input type="hidden" name="mobileId" value="${myNumber}"/>
	  	<td align="right"><table><tr>
	  	<td><textarea rows='3' cols='50' name='msgText'></textarea></td>
	  	<td><input type="image" src="imgs/send.png" alt="Submit" style='width:75px;height:70px'></td>
	  	<td><input type="image" src="imgs/refresh.png" id="refresh" alt="Submit" style='width:75px;height:70px'></td>
	    </tr></table></td>
    </form>	
  	</tr></table>
  	
  	</td></tr></table>
  	
  	 
  	<script type="text/javascript">
  	var refresh=setInterval(getCount, 3000);
    function getCount(){
	   var oldCount=document.getElementById("count").value;
	   var newCount=<%=jdo.displayChatCount(toNum,frmNum) %>
		   if(oldCount != newCount)
			   {
			   document.getElementById("refresh").click();
			   }
     }
</script>
</body>
</html>