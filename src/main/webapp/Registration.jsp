<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 12.09.2022
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign up</title>

  <h2>Register</h2>

  <form action="registration-Servlet" >
    <div class="container">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" placeholder="Enter your username" ><br><br>
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" placeholder="Enter your email" ><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" placeholder="Password"><br><br>
    <label for="repeatpassword">Please, confirm password:</label><br>
    <input type="password" id="repeatpassword" name="repeatpassword" placeholder="Repeat password"><br><br>
    <label for="name">Enter your name:</label><br>
    <input type="text" id="name" name="name" placeholder="Name" ><br><br>
    <label for="surname">Enter your surname:</label><br>
    <input type="text" id="surname" name="surname" placeholder="Surname" ><br><br>
    <label for="profession">Enter Your Profession</label><br>
    <input type="text" id="profession" name="profession" placeholder="Profession" ><br><br>

    <%if(request.getAttribute("status") != null){%>
    <% if(request.getAttribute("status").equals("username taken")){%>
    <label form="registration-form"> Username already taken! </label>
    <%} else if(request.getAttribute("status").equals("email taken")){%>
    <label form="registration-form"> Mail already taken! </label>
    <%}else if(request.getAttribute("status").equals("password does not match")){%>
    <label form="registration-form"> passwords don't match </label><br><br>
    <%}}%>

     <button type="submit" class="regbtn" href="userPage.jsp" value="Register" >Register</button>
    <br>
    <br>
  </form>
  <div class="container logIn">
    <p>Already have an account? <a href="index.jsp">Log in</a></p>
  </div>
</head>
<body>

</body>
</html>
