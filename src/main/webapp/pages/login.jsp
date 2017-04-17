<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="../css/main.css"/>"/>
    <title>Login</title>
</head>
<body>
<%--контейнер логотипа--%>
<div class="image">
    <img src="../images/library-logo.gif" alt="Avatar" class="avatar">
</div>

<%--контейнер поля поиска--%>
<div class="search" >
    <img class="searchImg" src="../images/search.png" alt="Avatar" class="avatar">
    <form>
        <input type="text" name="search" placeholder="Search..">
    </form>
    <button type="submit">Поиск</button>
    <select>
        <option>Название</option>
        <option>Автор</option>
    </select>
</div>

<%--список авторов--%>
<div class="authorlist">
    <h3><strong>Список авторов:</strong></h3>
    <ul>
        <jsp:useBean id="authorList" class="beans.AuthorList"/>
        <c:forEach var="author" items="${authorList.authors}">
            <li><a href="a"/><c:out value="${author.name}"/></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>