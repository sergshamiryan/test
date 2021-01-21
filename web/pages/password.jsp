<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% if (request.getAttribute("message") != null ){%>
<%=request.getAttribute("message")%>
<% } %>



</body>
</html>