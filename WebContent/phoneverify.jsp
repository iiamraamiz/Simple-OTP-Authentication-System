<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone verification</title>
<script>
function validate()
{
	var otp=document.getElementById("otpid").value;
	
	if(otp=="")
		{
		  document.getElementById("otpError").innerHTML="Please enter OTP";
		  return false;
		}
	
	else
		{
		  document.getElementById("otpError").innerHTML=("");
		}
	
	if(isNaN(otp))
    {
	   document.getElementById("otpError").innerHTML=("Please enter numeric value");
       return false; 
    }
	 else
		{
		  document.getElementById("otpError").innerHTML=("");
		}
	return true;
}
</script>


</head>
<body>
     <div align="center">
     <h1>PHONE VERIFICATION</h1>
      
      <h3 style="color:red">We have sent you OTP on you Mobile.</h3>
       <form onsubmit="return validate()" action="SignUpServlet" method="post">
       
         <input type="hidden" name="action" value="phone">
        
         <p>Enter OTP : </p>
         <input type="text" id="otpid" name="otp" placeholder="Enter OTP" size="40">
         <span id="otpError" style="color:red">*</span>
         <br/><br/>
         <input type="submit" value="verify">               
       </form>
     </div>
     
     
    
</body>
</html>