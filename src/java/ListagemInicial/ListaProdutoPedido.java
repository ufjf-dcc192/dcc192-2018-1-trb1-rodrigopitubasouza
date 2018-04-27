/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListagemInicial;

import Classes.ProdutoPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class ListaProdutoPedido {
     private static List<ProdutoPedido> prodPedido;
    
    public static List<ProdutoPedido> getInstance(){
        if(prodPedido == null){
            prodPedido = new ArrayList<>();
            prodPedido.add(new ProdutoPedido(ListaPedido.getInstance().get(0), ListaProduto.getInstance().get(0), 1, ListaProduto.getInstance().get(0).getPreco(), ListaProduto.getInstance().get(0).getPreco() * 1));                  
            prodPedido.add(new ProdutoPedido(ListaPedido.getInstance().get(0), ListaProduto.getInstance().get(1), 5, ListaProduto.getInstance().get(1).getPreco(), ListaProduto.getInstance().get(1).getPreco() * 5));                  
            
            prodPedido.add(new ProdutoPedido(ListaPedido.getInstance().get(1), ListaProduto.getInstance().get(2), 10, ListaProduto.getInstance().get(2).getPreco(), ListaProduto.getInstance().get(2).getPreco() * 10));                  
            prodPedido.add(new ProdutoPedido(ListaPedido.getInstance().get(1), ListaProduto.getInstance().get(3), 1, ListaProduto.getInstance().get(3).getPreco(), ListaProduto.getInstance().get(3).getPreco() * 1));                  
            
            prodPedido.add(new ProdutoPedido(ListaPedido.getInstance().get(2), ListaProduto.getInstance().get(2), 1, ListaProduto.getInstance().get(4).getPreco(), ListaProduto.getInstance().get(4).getPreco() * 1));                  
            prodPedido.add(new ProdutoPedido(ListaPedido.getInstance().get(2), ListaProduto.getInstance().get(3), 4, ListaProduto.getInstance().get(2).getPreco(), ListaProduto.getInstance().get(2).getPreco() * 4));                  
            
        }
        return prodPedido;
    }
}
