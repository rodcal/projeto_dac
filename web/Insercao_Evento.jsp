<%-- 
    Document   : Insercao_Evento
    Created on : 09/10/2020, 19:29:20
    Author     : RodrigoCavotre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de evento</title>
    </head>
    <body>
        <form action="Cria_Evento" method="post">
            <label>Nome:</label><br><br>
            <input type="text" name="nome"><br><br>
            <label>Sigla:</label><br><br>
            <input type="text" name="sigla"><br><br>
            <label>Área de Concentração:</label><br><br>
            <input type="text" name="area"><br><br>
            <label>Instituição Organizadora:</label><br><br>
            <input type="text" name="organizadora"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
