<%-- 
    Document   : shoppingList
    Created on : Jun 20, 2021, 11:16:16 PM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout" >Logout</a>

        <form method="post" action="">
            <h2>Add Item</h2>
            <input type="text"name="itemName">
            <input type="submit" value="Add" name="action">

        </form>

        <c:if test="${itemIsAdded}">

            
            <form method="post" action="">
                <c:forEach var="item" items="${itemsInList}">
                    <ul>
                        <li> <input type="radio" name="buttons" value="${item}" > ${item}</li>

                    </ul>
                </c:forEach>

                            <input type="submit" value="Delete" name="action">

            </form>

        </c:if>   

    </body>
</html>
