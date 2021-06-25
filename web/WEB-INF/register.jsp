<%-- 
    Document   : register
    Created on : Jun 20, 2021, 11:16:00 PM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            <label>Username:</label>
            <input type="text" id="" name="registerName" value="${username}">
            <input type="submit" value="Register Name" action="register">
            <p> ${message}</p>
        </form>
    </body>
</html>
