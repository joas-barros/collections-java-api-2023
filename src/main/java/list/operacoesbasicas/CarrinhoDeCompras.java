package main.java.list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private final List<Item> listaDeItens;

    public CarrinhoDeCompras() {
        this.listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        listaDeItens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){

        List<Item> praSair = new ArrayList<>();
        for (Item i : listaDeItens){
            if (i.getNome().equalsIgnoreCase(nome)){
                praSair.add(i);
            }
        }
        listaDeItens.removeAll(praSair);
    }

    public double calcularValorTotal(){
        double soma = 0;
        double multiplicacao;
        for (Item i : listaDeItens){
            multiplicacao = i.getPreco() * i.getQuantidade();
            soma += multiplicacao;
        }

        return soma;
    }

    public void exibirItens(){
        System.out.println(listaDeItens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Cebola", 5, 3);
        carrinhoDeCompras.adicionarItem("carne", 2, 5);
        carrinhoDeCompras.adicionarItem("maca", 1, 6);
        carrinhoDeCompras.adicionarItem("cebola", 4, 2);
        carrinhoDeCompras.removerItem("cebola");
        carrinhoDeCompras.exibirItens();
        System.out.println(carrinhoDeCompras.calcularValorTotal());
    }
}
