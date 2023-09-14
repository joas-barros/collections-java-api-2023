package main.java.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> mapDePalavras;

    public ContagemPalavras() {
        this.mapDePalavras = new HashMap<>();
    }

    public Map<String, Integer> getMapDePalavras() {
        return mapDePalavras;
    }

    public void setMapDePalavras(Map<String, Integer> mapDePalavras) {
        this.mapDePalavras = mapDePalavras;
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        this.getMapDePalavras().put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!this.getMapDePalavras().isEmpty()){
            this.getMapDePalavras().remove(palavra);
        } else {
            System.out.println("O set está vazio");
        }
    }

    public int exibirContagemPalavras(){
        return this.getMapDePalavras().size();
    }

    public String encontrarPalavrasMaisFrequente(){
        String linguagemMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : mapDePalavras.entrySet()){
            if (entry.getValue() > maiorContagem){
                maiorContagem = entry.getValue();
                linguagemMaisFrequente = entry.getKey();
            }
        }
        return linguagemMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavrasMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
