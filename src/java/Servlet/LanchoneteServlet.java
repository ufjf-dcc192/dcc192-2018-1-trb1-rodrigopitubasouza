/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Pedido;
import Classes.Mesas;
import Classes.ProdutoPedido;
import Classes.Produtos;
import ListagemInicial.ListaMesas;
import ListagemInicial.ListaPedido;
import ListagemInicial.ListaProduto;
import ListagemInicial.ListaProdutoPedido;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
@WebServlet(name = "indexServlet", urlPatterns = {"/index.html", "/mesa.html", "/abrirMesa.html", "/novaMesa.html", "/produto.html", "/novoProduto.html",
     "/inserir.html","/fechar.html","/pedidos.html"})
public class LanchoneteServlet extends HttpServlet {
    List<Pedido> pedidosfechados = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/index.html".equals(request.getServletPath())) {
            listarPedidos(request, response);
        } else if ("/mesa.html".equals(request.getServletPath())) {
            listarMesas(request, response);
        } else if ("/abrirMesa.html".equals(request.getServletPath())) {
            abrirMesa(request, response);
        } else if ("/novaMesa.html".equals(request.getServletPath())) {
            novaMesa(request, response);
        } else if ("/produto.html".equals(request.getServletPath())) {
            listarProdutos(request, response);
        } else if ("/novoProduto.html".equals(request.getServletPath())) {
            novoProduto(request, response);
        } else if ("/inserir.html".equals(request.getServletPath())) {
            editarPedido(request, response);
        } else if ("/fechar.html".equals(request.getServletPath())) {
            fecharPedido(request, response);
        } else if ("/pedidos.html".equals(request.getServletPath())) {
            mostrarPedidosFechados(request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/abrirMesa.html".equals(request.getServletPath())) {
            String cliente = request.getParameter("cliente");
            String numero = String.valueOf(ListaPedido.getInstance().size() + 1);
            Date dt = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
            String data = formatador.format(dt);
            Mesas m = ListaMesas.getInstance().get(Integer.parseInt(request.getParameter("id")));
            m.setAberta(true);
            ListaPedido.getInstance().add(new Pedido(numero, data, m, cliente, "", 0.00));
            response.sendRedirect("index.html");
        } else if ("/novaMesa.html".equals(request.getServletPath())) {
            ListaMesas.getInstance().add(new Mesas(ListaMesas.getInstance().size()+1, request.getParameter("nomeMesa")));
            response.sendRedirect("mesa.html");
        } else if ("/novoProduto.html".equals(request.getServletPath())) {
            ListaProduto.getInstance().add(new Produtos(request.getParameter("nomeProduto"), Double.parseDouble(request.getParameter("precoProduto"))));
            response.sendRedirect("produto.html");
        } else if ("/inserir.html".equals(request.getServletPath())) {
            if (Integer.parseInt(request.getParameter("quantidade")) > 0) {
                String produto;
                produto = request.getParameter("produtos");
                Pedido pedido = ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id")));
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                String[] split = produto.split("-");
                String nome = split[0];
                split = split[1].split("R");
                split = split[1].split("$");
                split = split[0].split(" ");
                double valorUni = Double.parseDouble(split[1]);
                double total = valorUni * quantidade;
                Produtos prod = new Produtos(nome, valorUni);
                ProdutoPedido pp = new ProdutoPedido(pedido, prod, quantidade, valorUni, total);
                pedido.getProdPedido().add(pp);
                ListaProdutoPedido.getInstance().add(pp);
                total = 0;
                for (int k = 0; k < pedido.getProdPedido().size(); k++) {
                    total = total + pedido.getProdPedido().get(k).getValorTotal();
                }
                pedido.setTotal(total);
            
            }
            response.sendRedirect("inserir.html?id=" + request.getParameter("id"));
        }
    }

    private void abrirMesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int i = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("mesa", ListaMesas.getInstance().get(i));
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/abrirMesa.jsp");
        despachante.forward(request, response);
    }

    private void listarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = ListaPedido.getInstance();
        request.setAttribute("pedidos", pedidos);

        List<Mesas> mesas = ListaMesas.getInstance();
        request.setAttribute("mesas", mesas);

        if (request.getParameter("id") != null) {
            int i = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("mesaExibida", pedidos.get(i));

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

    private void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produtos> produtos = ListaProduto.getInstance();
        request.setAttribute("produtos", produtos);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
        despachante.forward(request, response);
    }

    private void novaMesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novaMesa.jsp");
        despachante.forward(request, response);
    }

    private void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoProduto.jsp");
        despachante.forward(request, response);
    }

    private void editarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("prod") != null) {
            int j = Integer.parseInt(request.getParameter("prod"));
            ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id"))).setTotal(ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id"))).getTotal() - ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id"))).getProdPedido().get(j).getValorTotal());
            ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id"))).getProdPedido().remove(j);
        }

        Pedido pedidos = ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("pedidos", pedidos);

        List<Produtos> produtos = ListaProduto.getInstance();
        request.setAttribute("produtos", produtos);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inserirPedido.jsp");
        despachante.forward(request, response);
    }
    private void mostrarPedidosFechados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pedidos", pedidosfechados);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedidos.jsp");
        despachante.forward(request, response);
    }
    
    private void fecharPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pedido pedidos = ListaPedido.getInstance().get(Integer.parseInt(request.getParameter("id")));
        Date date = new Date();
        Mesas m = pedidos.getMesa();
        ListaMesas.getInstance().get(m.getCodigo()-1).setAberta(false);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        String data = formatador.format(date);
        pedidos.setFechamento(data);
        request.setAttribute("pedido", pedidos);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/fecharPedido.jsp");
        despachante.forward(request, response);
        pedidosfechados.add(pedidos);
        ListaPedido.getInstance().remove(Integer.parseInt(request.getParameter("id")));
    }
}
