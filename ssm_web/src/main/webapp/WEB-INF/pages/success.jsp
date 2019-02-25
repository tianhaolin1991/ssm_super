<%--
  Created by IntelliJ IDEA.
  User: tianhaolin1991
  Date: 2019/2/23
  Time: 下午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${products}" var="product">
       id:${product.id},productNum:${product.productNum},productDesc:${product.productDesc}<br/>
    </c:forEach>
</body>
</html>
