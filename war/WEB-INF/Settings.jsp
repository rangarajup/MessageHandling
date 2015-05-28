<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function getColor()
{
	var color=document.getElementById("selectColor").value;
	document.getElementById("color").style.background=color;
}
</script>
</head>
<body background="bgimg.png">   <form action='/changeSettings' target='body' method='post' >
<table>
 
  	<tr><td>
	<form action="/backHome" target="body"><input type="hidden" name="mobileId" value="${myNumber}"/>
	 	 <input type="image" src="back.png" alt="Submit" style='width:50px;height:30px' title="Back">
	</form>
	</td>
    <td> <h2><p>Message  settings</p></h2></td>
 </tr></table>
  <hr>
  <br>
  <table border="1" width="50%">
    <tr>
  		<td width="65%"> Delete Old Messages</td>
  		<td><input type="radio" name="deleteOldMsg" value="yes" >Yes<input type="radio" name="deleteOldMsg" value="No">NO</td>
  	</tr>
  	<tr>
  		<td>Text Message Limit</td>
  		<td><input type="text" name="textMsgLimit" value="100" >
  	</tr>
  		<tr>
  		<td>Multimedia Message Limit</td>
  		<td><input type="text" name="multimediaMsgLimit" value="100" >
  	</tr>
  	</tr>
  		<tr>
  		<td>BackGroungColor</td>
  		<td><select id="selectColor" name="selectColor" onclick="getColor()">
			  <option value="AliceBlue">AliceBlue </option>
			  <option value="Black">Black </option>
			  <option value="Blue">Blue</option>
			  <option value="BlueViolet">BlueViolet</option>
			  
			  <option value="Brown">Brown</option>
			  <option value="DarkOrange">DarkOrange </option>
			  <option value="DarkRed">DarkRed</option>
			  <option value="DeepPink">DeepPink</option>
			  
			  <option value="Green">Green</option>
			  <option value="Pink">Pink</option>
			  <option value="Red">Red</option>
			  <option value="White">White</option>
			</select><input type="button" id="color" value="color"/>
  	</tr>
  	<tr>
  		<td> Text Message Backup</td>
  		<td><input type="radio" name="backUp" value="yes" >Yes<input type="radio" name="backUp" value="No">NO</td>
  	</tr>
  	<tr>
  		<td>SMS Delivery Confirmation</td>
  		<td><input type="radio" name="smsDelivery" value="yes" >Yes<input type="radio" name="smsDelivery" value="No">NO</td>
  	</tr>
  	<tr>
  		<td>MMS Delivery Confirmation</td>
  		<td><input type="radio" name="mmsDelivery" value="yes" >Yes<input type="radio" name="mmsDelivery" value="No">NO</td>
  	</tr>
  	<tr>
  		<td>Send MMS Acknowledgement</td>
  		<td><input type="radio" name="mmsAck" value="yes" >Yes<input type="radio" name="mmsAck" value="No">NO</td>
  	</tr>
  	<tr>
  		<td>Sms Center Number</td>
  		<td><input type="text" name="smsCenterNumber" value="9999999999" >
  	</tr>
  	<tr>
  		<td colspan="2" align="center"><input type="button" value="save Changes"></td>
  	</tr>
  </table></form>
</body>
</html>