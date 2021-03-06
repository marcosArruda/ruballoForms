<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Forms do Ruballo</title>
        <style type="text/css">
            body {
                background-color: linen;
            }

            h1 {
                color: maroon;
                margin-left: 40px;
            }
            .tg  {border-collapse:collapse;border-spacing:0;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg .tg-yw4l{vertical-align:top}

        </style>
    </head>
    <body>
    <h1>Formul&aacute;rio</h1>
    <p>Escolha YES/NO/OTHERS para cada Servi&ccedil;o:</p>

    <form style="padding-left: 30px;" action="finish" method="post">
        <c:if test="${not empty services}">
            <table class="tg">

                <tr>
                    <th class="tg-yw4l">Service ID</th>
                    <th class="tg-yw4l">Office ID</th>
                    <th class="tg-yw4l">Service Name</th>
                    <th class="tg-yw4l">STATUS</th>
                </tr>
                <c:forEach items="${services}" var="service">
                    <tr>
                        <td>
                            <c:out  value="${service.id}" />
                        </td>
                        <td>
                            <c:out value="${service.officeId}" />
                        </td>
                        <td>
                            <c:out value="${service.name}" />
                        </td>
                        <td>
                            <input type="radio" name="service${service.id}" value="yes"> YES
                            <input type="radio" name="service${service.id}" value="no"> NO
                            <input type="radio" name="service${service.id}" value="others"> OTHERS
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>


        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="Enviar" /></form>

    </body>
</html>