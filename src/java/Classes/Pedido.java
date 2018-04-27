/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class Pedido {
    private String numero;
    private String data;
    private Mesas mesa;
    private String cliente;
    private String fechamento;
    private double total;
    private List<ProdutoPedido> prodPedido;

    public Pedido(String numero, String data, Mesas mesa, String cliente, String fechamento, double total) {
        this.numero = numero;
        this.data = data;
        this.mesa = mesa;
        this.cliente = cliente;
        this.fechamento = fechamento;
        this.total = total;
        this.prodPedido = new ArrayList<>();
    }

    public Pedido() {
    }

    public List<ProdutoPedido> getProdPedido() {
        return prodPedido;
    }

    public void setProdPedido(List<ProdutoPedido> prodPedido) {
        this.prodPedido = prodPedido;
    }

    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Mesas getMesa() {
        return mesa;
    }

    public void setMesa(Mesas mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFechamento() {
        return fechamento;
    }

    public void setFechamento(String fechamento) {
        this.fechamento = fechamento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   @Override
    public String toString() {
        return  mesa.getDescricao() + " - " + cliente + " - " + total;
    }   

    
    
    
}
