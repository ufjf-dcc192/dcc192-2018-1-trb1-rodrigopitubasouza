<%-- 
    Document   : abrirMesa
    Created on : 26/04/2018, 21:28:31
    Author     : rodri
--%>

<%@page import="ListagemInicial.ListaProduto"%>
<%@page import="ListagemInicial.ListaMesas"%>
<%@page import="Classes.Produtos"%>
<%@page import="java.util.List"%>
<%@page import="Classes.Mesas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<div>
    <h3>
        Abrir Pedido
        <%Mesas mesa = (Mesas) request.getAttribute("mesa");%>
        <label>Mesa: <%=mesa.getDescricao() %> </label>
    </h3>
    <form method="post">
        <label>Cliente: <input type="text" name="cliente" value="" /> </label>
 
        <input type="submit" value="Abrir Pedido" />  
    </form>

<%@include file="../jspf/footer.jspf" %>
