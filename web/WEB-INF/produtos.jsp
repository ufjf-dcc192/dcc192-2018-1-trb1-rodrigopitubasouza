<%-- 
    Document   : produtos
    Created on : 26/04/2018, 23:35:02
    Author     : rodri
--%>

<%@page import="Classes.Produtos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<h2>Lista de Produtos</h2>
        <div>
            <table>
                <thead>    
                    
                    <th>Descrição</th>
                    <th>Preço</th>
                    
                </thead>
                <tbody>
                    <%
                        for(Produtos produtos : (List<Produtos>) request.getAttribute("produtos")) {
                    %>   
                    
                        <tr>
                            <td><%=produtos.getNome()%></td>
                            <td width = "15%">R$ <%=produtos.getPreco()%></td>                         
                        </tr>
                    <%
                    }            
                    %>  
                    <tr><td><a href="novoProduto.html">Novo Produto</a></td></tr>
                </tbody>
            </table>
        </div>
                    <%@include file="../jspf/footer.jspf" %>