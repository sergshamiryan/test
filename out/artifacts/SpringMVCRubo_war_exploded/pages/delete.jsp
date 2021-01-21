<%--
  Created by IntelliJ IDEA.
  User: Sergs
  Date: 12/29/2020
  Time: 3:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Please write username and password to delete the page</h1>

<% if (request.getAttribute("message") != null ){%>
<%=request.getAttribute("message")%>
<% } %>

<form method="post" action="/delete">
    username: <input type="text" name="username"><br/>
    password: <input type="text" name="password"><br>
    <input type="submit" name="submit"><br>
</form>


</body>
</html>
