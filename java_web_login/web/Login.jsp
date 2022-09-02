<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/9/2
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="login" method="post">
    <table>

        <tr>
            <td>用户名：</td><td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="password" name="password"/></td>
        </tr>
        <tr><span style="color: #ff7f8e">${requestScope.msg}</span></tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="submit"/>
                <input type="reset" value="reset">
            </td>
        </tr>
    </table>
</form>


</body>
</html>
