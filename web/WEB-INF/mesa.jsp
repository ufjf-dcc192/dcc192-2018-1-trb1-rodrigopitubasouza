<%-- 
    Document   : mesa
    Created on : 26/04/2018, 20:32:50
    Author     : rodri
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Mesas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<h2>Lista de Mesas</h2>
        <div>
            <table>
                <thead>    
                    
                    <th>Descrição</th>
                    <th width = "10%">Status</th>
                    
                </thead>
                <tbody>
                    <%
                        int i = 0;
                        for(Mesas mesas : (List<Mesas>) request.getAttribute("mesas")) {
                    %>   
                    
                        <tr>
                            <td><%=mesas.getDescricao()%></td>
                            <%if(mesas.isAberta()){%><td>Aberta</td><%}else{%><td><a href="abrirMesa.html?id=<%=mesas.getCodigo()-1%>">Abrir Mesa</a></td><%}%>            
                        </tr>
                    <%
                        i++;
                    }            
                    %>  
                    <tr><td><a href="novaMesa.html?id=">Nova Mesa</a></td></tr>
                </tbody>
            </table>
        </div>
<%@include file="../jspf/footer.jspf" %>