<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>register</title>
</head>
<body>
<h1><%= "Welcome to register!" %></h1>
<br/>
<form action="hello-servlet" method="post">
  <tr>
    <td>username</td>
    <td>
      <input name="username" type="text" id="username">
      <br>
    </td>
  </tr>
  <tr>
    <td>password</td>
    <td>
      <input name="password" type="password" id="password">
      <br>
    </td>
  </tr>
  <input value="register" type="submit" id="reg_btn"><br>
</form>

</body>
</html>