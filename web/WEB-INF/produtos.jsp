<%-- 
    Document   : produtos
    Created on : 26/04/2018, 23:35:02
    Author     : rodri
--%>

<%@page import="Classes.Produtos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<h3>Lista de Produtos</h3>
        <div>
            <table>
                <thead>    
                    
                    <th>Descrição</th>
                    <th>Status</th>
                    
                </thead>
                <tbody>
                    <%
                        for(Produtos produtos : (List<Produtos>) request.getAttribute("produtos")) {
                    %>   
                    
                        <tr>
                            <td><%=produtos.getNome()%></td>
                            <td><%=produtos.getPreco()%></td>                         
                        </tr>
                    <%
                    }            
                    %>  
                    <tr><td><a href="novoProduto.html">Novo Produto</a></td></tr>
                </tbody>
            </table>
        </div>