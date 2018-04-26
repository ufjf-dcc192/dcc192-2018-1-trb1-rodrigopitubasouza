/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListagemInicial;

import Classes.Mesas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ListaMesas {
    private static List<Mesas> mesas;
    
    public static List<Mesas> getInstance(){
        if(mesas == null){
           mesas = new ArrayList<>();
           mesas.add(new Mesas(1, "Mesa 1"));
           mesas.add(new Mesas(2, "Mesa 2"));
           mesas.add(new Mesas(3, "Mesa 3"));                    
           mesas.add(new Mesas(4, "Mesa 4"));                    
           mesas.add(new Mesas(5, "Mesa 5"));                    
        }
        return mesas;
    }
}
