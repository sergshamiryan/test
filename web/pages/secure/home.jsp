<%@ page import="am.rubo.SpringMVCRubo.model.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/logout" style="...">Logout</a>
<h1 style="background: cornflowerblue" > This is home page</h1>

<%
    User user = (User) session.getAttribute("user");
    response.getWriter().write("Hello dear " + user.getName() + " " + user.getSurname());
%>




<%if (request.getAttribute("message") != null) { %>
<%=request.getAttribute("message")%>
<% }%>
<br><br/>



<form method="post" action="/secure/password">
   <input type="hidden" name="username" value="<%=user.getUsername()%>"><br/>
    old password: <input type="text" name="old password"><br/>
    new password: <input type="text" name="new password"><br>
    <input type="submit" name="submit"><br>
</form>

<a href="delete">Delete Account</a>

<br><br>

<a href="/secure/comments">comments</a>



</body>
</html>



