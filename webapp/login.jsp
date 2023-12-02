<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="LoginSignInCSS.css">
    <title>Login</title>
</head>
<body>

	<div class="login-card2">
        <div class="login-content">
            <h1>Login</h1>
    <form action="login" method="post">
        <label for="username"></label>
        <input type="text" id="username" name="username" placeholder="Enter your username" required placeholder="Username">

        <label for="password"></label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required placeholder="Password">

        <input type="submit" name="submit" value="Login">
        <p>Don't have an account? <a href="customerinsert.jsp">Create an Account</a></p>
    </form>
</div>
</div>

</body>
</html>