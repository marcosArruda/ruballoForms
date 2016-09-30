<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Forms do Ruballo</title>
    </head>
    <body>
        <br/><br/>
        <h1>Seu formul&aacute;rio foi salvo com sucesso!</h1>
        <br/><br/>
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <a href="${context}/form">Preencher novamente</a>
        <a href="${context}/dashboard">Ver o Dashboard</a>
    </body>
</html>