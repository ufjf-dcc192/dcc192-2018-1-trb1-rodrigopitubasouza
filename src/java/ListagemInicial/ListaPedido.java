/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListagemInicial;

import Classes.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ListaPedido {
    private static List<Pedido> pedidos;
    
    
    public static List<Pedido> getInstance(){
        if(pedidos == null){
            pedidos = new ArrayList<>();
            pedidos.add(new Pedido("0001", "26/04/2018 - 06:00", ListaMesas.getInstance().get(0), "Rodrigo Pituba", "12:00",40.00));                  
            pedidos.add(new Pedido("0002", "26/04/2018 - 06:00", ListaMesas.getInstance().get(1), "Karen Araujo", "12:00",90.00));                  
            pedidos.add(new Pedido("0003", "26/04/2018 - 06:00", ListaMesas.getInstance().get(2), "Igor Knop", "12:00",58.00));                  
            ListaMesas.getInstance().get(0).setAberta(true);
            ListaMesas.getInstance().get(1).setAberta(true);
            ListaMesas.getInstance().get(2).setAberta(true);
    
            pedidos.get(0).getProdPedido().add(ListaProdutoPedido.getInstance().get(0));
            pedidos.get(0).getProdPedido().add(ListaProdutoPedido.getInstance().get(1));
            
            pedidos.get(1).getProdPedido().add(ListaProdutoPedido.getInstance().get(2));
            pedidos.get(1).getProdPedido().add(ListaProdutoPedido.getInstance().get(3));
            
            pedidos.get(2).getProdPedido().add(ListaProdutoPedido.getInstance().get(4));
            pedidos.get(2).getProdPedido().add(ListaProdutoPedido.getInstance().get(5));
            
        }
        return pedidos;
    }
}
