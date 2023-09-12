package main.java.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> conjuntoTarefas;

    public ListaTarefas() {
        this.conjuntoTarefas = new HashSet<>();
    }

    public Set<Tarefa> getConjuntoTarefas() {
        return conjuntoTarefas;
    }

    public void setConjuntoTarefas(Set<Tarefa> setTarefas) {
        this.conjuntoTarefas = setTarefas;
    }

    public void adicionarTarefa(String descricao){
        this.conjuntoTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if (!this.getConjuntoTarefas().isEmpty()){
            for (Tarefa t : this.getConjuntoTarefas()){
                if (t.getDecricao().equalsIgnoreCase(descricao)){
                    tarefaParaRemover = t;
                    break;
                }
            }
            conjuntoTarefas.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio");
        }
        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas(){
        if (!this.getConjuntoTarefas().isEmpty()){
            System.out.println(this.getConjuntoTarefas());
        } else {
            System.out.println("Não tem tarefas para exibir");
        }
    }

    public int contarTarefas(){
        return getConjuntoTarefas().size();
    }

    public void limparListaTarefas(){
        conjuntoTarefas.clear();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : conjuntoTarefas){
            if(t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : conjuntoTarefas){
            if(!t.isConcluida()){
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for (Tarefa t : conjuntoTarefas){
            if (t.getDecricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t : conjuntoTarefas) {
            if (t.getDecricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(false);
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }

}
