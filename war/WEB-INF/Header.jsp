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
	if(isNaN(num)|| num==""){
		document.getElementById("settings").style.visibility = "hidden";
		alert("Wrong Input")
		document.getElementById("num").value="";	
	}
	else
		{
		document.getElementById("settings").style.visibility = "visible";
		document.getElementById("h1").value=num;
		document.getElementById("h2").value=num;
		document.getElementById("h3").value=num;
		document.getElementById("h4").value=num;
		document.getElementById("h5").value=num;
		}
    }
</script>

</head>
<body bgcolor="#E0E0E0 ">

  <form action="/submitMobileNumber" target="body">
	<table style="width:100%">
  		 <tr>
    		<td><img src="imgs/sms2.jpg" height="60" width="60" title="Message Handling"/></td>
    		<td><h1> SHORT MESSAGE SERVICE </h1></td>
  				<td align="right"><input type="text" id="num" name="mobileNumber"  placeholder="MobileNumber"><input type="submit" value="Submit" id="button" onclick="myFunction()">
  			</td> 
  		</tr>
   </table>
 </form>
     
   <hr>
    <div id="settings" style="visibility:hidden">
     <table><tr>
     
     <td>
	     <form action="/createMessage" target="body"><input type="hidden" name="mobileId" id="h1"/>
		  &nbsp&nbsp&nbsp&nbsp
	 	 <input type="image" src="imgs/newMsg.png" alt="Submit" style='width:30px;height:30px' title="Create Message">
	 	 </form>
 	 </td>
 	    
 	 <td>
 	      <form action="/search" target="body"><input type="hidden" name="mobileId" id="h2"/>
		  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 	 <input type="image" src="imgs/Search.png" alt="Submit" style='width:30px;height:30px' title="Search Message">
	 	 </form>
 	 
 	 </td>
 	 
 	 <td>
 	      <form action="/settings" target="body"><input type="hidden" name="mobileId" id="h3"/>
		   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 	 <input type="image" src="imgs/settings.png" alt="Submit" style='width:30px;height:30px' title="Settings">
	 	 </form>
	 	 
 	 </td>
 	 
 	  <td>
 	      <form action="/block" target="body"><input type="hidden" name="mobileId" id="h4"/>
		   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 	 <input type="image" src="imgs/block.png" alt="Submit" style='width:30px;height:30px' title="Blocked Numbers">
	 	 </form>
 	 </td>
 	 
 	 <td>
 	      <form action="/backHome" target="body"><input type="hidden" name="mobileId" id="h5"/>
		   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 	 <input type="image" src="imgs/refresh.png" alt="Submit" style='width:30px;height:30px' title="Refresh">
	 	 </form>
 	 </td>
 	</tr></table>
    </div>

</body>
</html>