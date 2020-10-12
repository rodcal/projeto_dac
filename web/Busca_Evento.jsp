<%-- 
    Document   : Busca_Evento
    Created on : 12/10/2020, 18:03:34
    Author     : RodrigoCavotre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de eventos</title>
    </head>
    <body>
        <form action ="Busca_Servlet" method="post">
            Nome do evenmto: <input type="text" name="nome"><br></br>
            <input type="submit" value="Busca">
        </form>
    </body>
</html>
