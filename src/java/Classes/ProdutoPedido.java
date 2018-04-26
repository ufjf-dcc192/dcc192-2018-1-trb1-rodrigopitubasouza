/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author rodri
 */
public class ProdutoPedido {
    private Pedido numPedido;
    private Produtos numProduto;
    private int quantidade;
    private double valorUni;
    private double valorTotal;

    public ProdutoPedido(Pedido numPedido, Produtos numProduto, int quantidade, double valorUni, double valorTotal) {
        this.numPedido = numPedido;
        this.numProduto = numProduto;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
        this.valorTotal = valorTotal;
    }

    public ProdutoPedido() {
    }

    public Pedido getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Pedido numPedido) {
        this.numPedido = numPedido;
    }

    public Produtos getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(Produtos numProduto) {
        this.numProduto = numProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
     @Override
    public String toString() {
        return  numPedido.getNumero() + " - " + numProduto.getNome()+ " | " + quantidade + " * " + valorUni + " = " + valorTotal;
    }
    
}
