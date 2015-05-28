<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function myFunction() {
	var num=document.getElementById("num").value;
	var msg=document.getElementById("msg").value;
	if(isNaN(num)|| num=="" || msg=="")
		alert("Wrong Input")
		};
</script>

</head>
<body background="bgimg.png">
     <form action="/backHome" target="body"><input type="hidden" name="mobileId" value="${myNumber}"/>
	 	 <input type="image" src="back.png" alt="Submit" style='width:50px;height:37px' title="Back">
	</form><hr>
	
  
    <form action="/sendMessage" target="body">
    <input type="hidden" name="mobileId" value="${myNumber}"/>
	<table>
		<tr>
			<td><b>To:</b></td>
			<td><input type="text" id="num" name="msgNumber"/></td>
		</tr>
		<tr>
			<td><b>Message Text:</b></td>
			<td><textarea rows='8' cols='50' id="msg" name='msgText'></textarea></td>
		</tr>
        <tr></tr><tr></tr>
     </table>
     <table>
		<tr>
			<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 			    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 			    <input type="Submit" value="Send"  onclick="myFunction()" style="width:150px;height:50px">
 			</td>
 		</tr>
 	</table>
  </form>


</body>
</html>