/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListagemInicial;

import Classes.Produtos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ListaProduto {
    private static List<Produtos> prod;
    
    public static List<Produtos> getInstance(){
        if(prod == null){
            prod = new ArrayList<>();
            prod.add(new Produtos("Coxinha", 10));                  
            prod.add(new Produtos("Água 1L", 6));                  
            prod.add(new Produtos("Refrigerante", (double) 7.50));                  
            prod.add(new Produtos("Hamburguer", 15));                  
            prod.add(new Produtos("Pastel de Frango", 28));
        }
        return prod;
    }
}
