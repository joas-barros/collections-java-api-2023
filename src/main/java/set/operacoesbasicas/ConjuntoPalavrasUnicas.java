package main.java.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private final Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public Set<String> getPalavrasUnicas() {
        return palavrasUnicas;
    }

    public void adicionarPalavras(String palavra){
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra){
        if (!palavrasUnicas.isEmpty()){
            if (palavrasUnicas.contains(palavra)){
                palavrasUnicas.remove(palavra);
            } else {
                System.out.println("Palavra não encontrada no conjunto");
            }
        } else {
            System.out.println("O conjunto está vazio");
        }
    }

    public boolean verificarPalavra(String palavra){
        return palavrasUnicas.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        System.out.println(this.getPalavrasUnicas());
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoPalavrasUnicas
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavras("Java");
        conjuntoLinguagens.adicionarPalavras("Python");
        conjuntoLinguagens.adicionarPalavras("JavaScript");
        conjuntoLinguagens.adicionarPalavras("Python");
        conjuntoLinguagens.adicionarPalavras("C++");
        conjuntoLinguagens.adicionarPalavras("Ruby");

        // Exibindo as linguagens únicas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem do conjunto
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Swift");

        // Verificando se uma linguagem está no conjunto
        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

        // Exibindo as linguagens únicas atualizadas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();
    }
}
