<%-- 
    Document   : novoProduto
    Created on : 26/04/2018, 23:47:05
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<div>
<h2>Novo Produto</h2>
    <form method="post">
        <label>Nome do Produto:<input type="text" name = "nomeProduto" value = ""/></label>
        <label>Preço:<input type="number" step ="0.01" min="0" name = "precoProduto" value = "0.00"/></label>
        <input type="submit" value="Criar Produto"/>
    </form>

<%@include file="../jspf/footer.jspf" %>
</div>