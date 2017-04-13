<%@ page import="util.TestConnect" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='//css/login.css' />"/>
    <title>Login</title>
</head>
<body>
<b>${param["username"]} добро пожаловать в Онлайн Библиотеку</b>
<b>Ваш пароль: ${param["password"]}</b>
<%
    TestConnect testConnection = new TestConnect();
    testConnection.check();
    System.out.println("\"from login jsp\" = " + "from login jsp");
%>

</body>
</html>