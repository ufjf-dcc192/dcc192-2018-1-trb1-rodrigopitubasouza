<%-- 
    Document   : novaMesa
    Created on : 26/04/2018, 22:52:47
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<div>
<h2>Nova Mesa</h2>
    <form method="post">
        <label>Nome da Mesa:<input type="text" name = "nomeMesa" value = ""/></label>
        <input type="submit" value="Criar Mesa"/>
    </form>
<%@include file="../jspf/footer.jspf" %>
</div>