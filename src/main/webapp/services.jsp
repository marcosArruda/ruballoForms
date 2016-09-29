<!-- %@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" % -->
<html>
    <head>
        <title>Forms do Ruballo</title>
        <style>
            body {
                background-color: linen;
            }

            h1 {
                color: maroon;
                margin-left: 40px;
            }
        </style>
    </head>
    <body>
    <h1>Formulário</h1>
    <p>Escolha o Office:</p>

    <form style="padding-left: 30px;" action="form" method="post">
        Office:<select id="officeId" name="officeId">
                    ${param.get("officeSelect")}
               </select>
        <br/>
        <hr/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="Enviar" /></form>

    </body>
</html>