<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="css/style_index.css" />" rel="stylesheet">
  <title>Login</title>
</head>
<body>
<form name="username" action="pages/main.jsp" method="post">
  <div class="imgcontainer">
    <img src="images/library-logo.gif" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>

</form>
</body>
</html>