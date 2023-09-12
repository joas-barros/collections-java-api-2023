package main.java.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> conjuntoAlunos;

    public Set<Aluno> getConjuntoAlunos() {
        return conjuntoAlunos;
    }

    public void setConjuntoAlunos(Set<Aluno> conjuntoAlunos) {
        this.conjuntoAlunos = conjuntoAlunos;
    }

    public GerenciadorAlunos() {
        this.conjuntoAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        conjuntoAlunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        if (!this.getConjuntoAlunos().isEmpty()){
            for (Aluno a : conjuntoAlunos){
                if (a.getMatricula() == matricula){
                    conjuntoAlunos.remove(a);
                    break;
                }
            }
        } else {
            System.out.println("Conjunto vazio");
        }
    }

    public void exibirAlunos(){
        if (!this.getConjuntoAlunos().isEmpty()) {
            System.out.println(this.getConjuntoAlunos());
        } else {
            System.out.println("conjunto vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunoPorNome = new TreeSet<>(this.getConjuntoAlunos());
        return alunoPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorPorNota());
        alunoPorNota.addAll(this.getConjuntoAlunos());
        return alunoPorNota;
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.getConjuntoAlunos());

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println(gerenciadorAlunos.getConjuntoAlunos());

        // Exibindo alunos ordenados por nome
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        // Exibindo alunos ordenados por nota
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
    }

}
