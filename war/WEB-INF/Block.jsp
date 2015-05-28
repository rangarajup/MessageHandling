<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script type="text/javascript">
function reply_click(clicked_id){
document.getElementById("selectedNumberId").value  = clicked_id;
}

function block() {
	var num=document.getElementById("num").value;
	if(isNaN(num)|| num=="" ){
		alert("Wrong Input");
	    document.getElementById("num").value="";
	    }
		};


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bgimg.png">

 	<table>
  	 	<tr><td>
			<form action="/backHome" target="body"><input type="hidden" name="mobileId" value="${myNumber}"/>
	 	   		<input type="image" src="back.png" alt="Submit" style='width:50px;height:30px' title="Back">
			</form>
		</td>	
		<td align="right">
		<form action="/blockThisNumber" target="body" method="post" ><input type="hidden" name="mobileId" value="${myNumber}"/>
    	 <h2><p><input type="text" id="num" name="Number"  placeholder="BlockNumber"/><input type="submit" value="BlockThisNumber" onClick="block()"/></p></h2>
    	</form></td>
    	 </tr>
    </table><hr>

<form action="/unBlockThisNumber" target="body" method="post" >
	<input type="hidden" name="mobileId" value="${myNumber}"/>
    <input type='text' id='selectedNumberId' name='selectedNumber' style='visibility:hidden'><br>
	<c:forEach items="${list}" var="num">
	   <input type='text' id='selectedNumberId' value="${num.blockedNumber}" readonly><input type="submit" id= "${num.blockedNumber}" onClick='reply_click(this.id)' value="UnBlock">
		<br><br>
	</c:forEach>
</form>
</body>
</html>