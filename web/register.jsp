<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form action="RegisterServlet" method="post">
        Name: <input type="text" name="name"><br>
        Address: <input type="text" name="address"><br>
        NIC: <input type="text" name="nic"><br>
        Phone Number: <input type="text" name="phoneNumber"><br>
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Register">
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
</body>
</html>