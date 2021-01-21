<%@ page import="am.rubo.SpringMVCRubo.model.Comment" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Sergs
  Date: 1/4/2021
  Time: 2:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<a href="/home">Home</a>

<% if (request.getAttribute("message") != null ){%>
<%=request.getAttribute("message")%>
<% } %>

<%
    List<Comment> comments = (List<Comment>) request.getAttribute("commentList");
%>

<table border="solid ipx" >

<%
        for (Comment comment:comments){
%>

    <tr>

        <td>
            <form method="post" action="/secure/comments/edit">
                <input type ="hidden" name="id" value="<%=comment.getId()%>">
                <input type ="text" name="name" value="<%=comment.getName()%>">
                <input type ="text" name="description" value="<%=comment.getDescription()%>">
                <input type="submit"  name="submit" value="delete">
                <input type="submit"  name="submit" value="update">
            </form>
        </td>

<%
            }
%>

</table>

<form method="post" action="/secure/comments/add">
    Comment: <input type="text" name = "name"><br>
    Description:  <input type = "text" name="description"> <br>
    <input type="submit" value="add">
</form>



</body>
</html>
