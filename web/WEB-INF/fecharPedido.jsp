<%-- 
    Document   : fecharPedido
    Created on : 27/04/2018, 12:50:36
    Author     : rodri
--%>

<%@page import="Classes.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<%
                Pedido p = (Pedido) request.getAttribute("pedido");
                
                
            %>
            <h2><label>Pedido do Cliente <%=p.getCliente()%> Fechado</label></h2>
            <h3><label>Horário de Fechamento : <%=p.getFechamento()%> Total a Pagar : R$ <%=p.getTotal()%></label></h3>
            <h4> 
                <label>Pedido: <%=p.getNumero() %> </label> <br>
                <label>Data / Hora:  <%=p.getData() %> </label> <br>
                <label>Mesa: <%=p.getMesa().getDescricao() %> </label> <br>
                <label>Cliente : <%=p.getCliente() %> </label> <br>
                
            </h4>
            <table>
                <thead>
                    <th>Produto</th>
                    <th>Quantidade</th>
                    <th>Preço Unitário</th>
                    <th>Preço Total</th>
                </thead>
                <tbody>
                     <%
                double vTotal = 0;
                                
                for(int j = 0; j < p.getProdPedido().size(); j++) {
            %>
            <tr>
                <td><%=p.getProdPedido().get(j).getNumProduto().getNome()%></td>
                <td><%=p.getProdPedido().get(j).getQuantidade() %></td>
                <td>R$ <%=p.getProdPedido().get(j).getValorUni() %></td>
                <td>R$ <%=p.getProdPedido().get(j).getValorTotal() %></td>
                
            </tr>
            <%
                    vTotal = vTotal + p.getProdPedido().get(j).getValorTotal();
                }            
            %> 
            <tr>
                <td></td>
                <td></td>                
                <td><b>Total Geral Mesa: </b></td>
                <td><b>R$ <%=vTotal %></b></td>
                
            </tr>
            
                <tbody>
            </table>
            
            <%@include file="../jspf/footer.jspf" %>