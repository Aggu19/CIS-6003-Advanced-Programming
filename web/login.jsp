<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    
    <h1>Login</h1>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
    
</body>
</html>