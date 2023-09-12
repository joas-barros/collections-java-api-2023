package main.java.set.pesquisa;

public class Tarefa {
    private String decricao;
    private boolean concluida;

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Tarefa(String decricao) {
        this.decricao = decricao;
        this.concluida = false;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "decricao='" + decricao + '\'' +
                ", concluida=" + concluida +
                '}';
    }
}
