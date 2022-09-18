<html>
<body>
<h2>Log in</h2>

<form action="login">
    <label for="username">Username or Email:</label><br>
    <input type="text" id="username" name="username" placeholder="Enter your username or email" required><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" placeholder="Enter your password" required><br><br>
    <% if (request.getAttribute("loginStatus") != null){ %>
    <%  if (request.getAttribute("loginStatus").equals("wrong uname")) {%>
    <label form="login-form"> Invalid username or mail </label>
    <% }else if(request.getAttribute("loginStatus").equals("incorrect pass")) { %>
    <label form="login-form"> Password incorrect </label>
    <% }}%>
    <br>
    <input type="submit" value="Log in">
    <br>
    <br>
    <a href="Registration.jsp">New to here? Sign up!</a>
</form>
</body>
</html>
