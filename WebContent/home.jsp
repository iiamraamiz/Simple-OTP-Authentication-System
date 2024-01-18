<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
  body
  {
     background-image: url("M:/DonThinkStartCoding/youtube/OTP PROJECT/otpBcag.jpg");
  }
</style>
</head>
<body>
      <div align="center">
                    <%
                         String user=(String)request.getAttribute("user");
                    %>    
                    <br><br><br>
                    <h2 style="color:white;background-color: black" >Successfuly log in as <span style="color:red"><%=user%></span>.</h2> 
                    <br><br><br>
                    <h1 style="color:white;background-color: black">WELCOME <span style="color:red"><%=user%></span> to the home page</h1>                
      </div>
</body>
</html>