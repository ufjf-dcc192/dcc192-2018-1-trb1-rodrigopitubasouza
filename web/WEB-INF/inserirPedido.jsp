<%-- 
    Document   : inserirPedido
    Created on : 26/04/2018, 23:58:11
    Author     : rodri
--%>

<%@page import="Classes.Pedido"%>
<%@page import="Classes.Produtos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
    <h3>Inserir Produtos</h3>
    <%
                Pedido p = (Pedido) request.getAttribute("pedidos");
                
                
            %>
            <h4> 
                <label>Pedido: <%=p.getNumero() %> </label> <br>
                <label>Data / Hora:  <%=p.getData() %> </label> <br>
                <label>Mesa: <%=p.getMesa().getDescricao() %> </label> <br>
                <label>Cliente : <%=p.getCliente() %> </label> <br>
            </h4>
    <form method="post">
        <label>Produtos: 
            <select name ="produtos" >
                <c:forEach var="prod" items="${produtos}">                
                    <option value="${prod}">${prod}</option>  
                </c:forEach>
            </select>
        </label>
        <label>Quantidade: <input type="text" value="0" name="quantidade"></label>
        <input type="submit" value="Inserir">
    </form>
                </table>
            
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
                <td><a href="inserir.html?id=<%=request.getParameter("id")%>&prod=<%=j%>">Remover</a></td>
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
                <td></td>
            </tr>
            
                <tbody>
            </table>
           
<%@include file="../jspf/footer.jspf" %>
