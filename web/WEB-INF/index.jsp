<%-- 
    Document   : index
    Created on : 26/04/2018, 14:39:16
    Author     : rodri
--%>

<%@page import="Classes.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<h2>Pedidos </h2>
<div>
    <table>
        <thead> 
            <th>Mesa</th>
            <th>Cliente</th>
            <th>Total</th>
            <th>Opções</th>
        </thead> 
        <tbody>
            <%
                int i = 0;
                for (Pedido pedidos : (List<Pedido>) request.getAttribute("pedidos")) {
            %>
            <tr>
                <td><%=pedidos.getMesa().getDescricao()%></td>
                <td><%=pedidos.getCliente()%></td>
                <td><%=pedidos.getTotal()%></td>
                <td class="limpa" width ="20%"><a href="index.html?id=<%=i%>">Exibir </a><a href="inserir.html?id=<%=i%>">Inserir </a><a href="fechar.html?id=<%=i%>" class="delete">Fechar </a></td>  
            </tr>
            <%
                i++;
                }
            %>   
        </tbody>
    </table>
            <%
                Pedido p = (Pedido) request.getAttribute("mesaExibida");
                if(p != null){
                
            %>
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
            <%}%>
            
</div>
<%@include file="../jspf/footer.jspf" %>
