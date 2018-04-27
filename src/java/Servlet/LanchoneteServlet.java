/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Pedido;
import Classes.Mesas;
import Classes.ProdutoPedido;
import ListagemInicial.ListaMesas;
import ListagemInicial.ListaPedido;
import ListagemInicial.ListaProduto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "indexServlet", urlPatterns = {"/index.html","/mesa.html"})
public class LanchoneteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/index.html".equals(request.getServletPath())) {
            listarPedidos(request, response);            
        }else if("/mesa.html".equals(request.getServletPath())){
            listarMesas(request,response);
        }
    }

    private void listarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = ListaPedido.getInstance();
        request.setAttribute("pedidos", pedidos);
        
        List<Mesas> mesas = ListaMesas.getInstance();
        request.setAttribute("mesas", mesas);
        
        if(request.getParameter("id") != null){
            int i = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("mesaExibida",pedidos.get(i));
            
        }
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
        despachante.forward(request, response);    
        
        
    }

    private void listarMesas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mesas> mesas = ListaMesas.getInstance();
        request.setAttribute("mesas", mesas);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/mesa.jsp");
        despachante.forward(request, response);
    }

   

   
}
