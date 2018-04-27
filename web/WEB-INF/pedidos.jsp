<%-- 
    Document   : pedidos
    Created on : 27/04/2018, 13:16:05
    Author     : rodri
--%>

<%@page import="Classes.Pedido"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<table>
    <thead>
        <th>Pedido</th>
        <th>Horário de Abertura</th>
        <th>Mesa</th>
        <th>Cliente</th>
        <th>Horário de Fechamento</th>
        <th>Total Pago</th>
    </thead>
    <tbody>
       <%
                List<Pedido> p = (List<Pedido>) request.getAttribute("pedidos");
                                
                for(int j = 0; j < p.size(); j++) {
            %>
            <tr>
                <td><%=p.get(j).getNumero() %> </td> 
                <td><%=p.get(j).getData() %> </td> 
                <td><%=p.get(j).getMesa().getDescricao() %> </td> 
                <td><%=p.get(j).getCliente() %> </td> 
                <td><%=p.get(j).getFechamento()%></td>
                <td>R$ <%=p.get(j).getTotal()%></td>
                
            </tr>
            <%
                   
                }            
            %> 
    </tbody>
</table>
    <%@include file="../jspf/footer.jspf" %>