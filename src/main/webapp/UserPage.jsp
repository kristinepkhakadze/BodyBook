<%@ page import="com.example.BodyBook.User" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 12.09.2022
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
    <form action="UserServlet">
    <h1> Welcome, <%=((User) request.getSession().getAttribute("user")).getUsername()%> </h1>
        <div class="container">
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" placeholder="Enter your username " ><br><br>
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
        <input type="submit" value="Update"><br>
        </div>
    </form>
    <div class="container signOut">
        <p>Want to sign out? <a href="index.jsp">Sign out</a></p>
    </div>
</body>
</html>
