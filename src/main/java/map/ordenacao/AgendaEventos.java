package main.java.map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> mapDeEventos;

    public AgendaEventos() {
        this.mapDeEventos = new HashMap<>();
    }

    public Map<LocalDate, Evento> getMapDeEventos() {
        return mapDeEventos;
    }

    public void setMapDeEventos(Map<LocalDate, Evento> mapDeEventos) {
        this.mapDeEventos = mapDeEventos;
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        this.getMapDeEventos().put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(mapDeEventos);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        /* Set<LocalDate> dateSet = this.getMapDeEventos().keySet();
        Collection<Evento> values = this.getMapDeEventos().values();
        this.getMapDeEventos().get(); */

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(mapDeEventos);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet() ){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O proximo evento: " + proximoEvento + " acontecera na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.SEPTEMBER, 14), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirAgenda();

        // Obtém e exibe o próximo evento na agenda
        agendaEventos.obterProximoEvento();
    }
}
