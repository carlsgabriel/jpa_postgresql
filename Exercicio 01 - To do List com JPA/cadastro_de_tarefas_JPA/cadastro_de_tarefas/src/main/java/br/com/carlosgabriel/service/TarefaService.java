package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exceptions.TarefaException;
import br.com.carlosgabriel.model.Tarefa;
import br.com.carlosgabriel.repository.TarefaDAOImpl;

public class TarefaService {
    TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();
    String pendente = "pendente";
    String em_andamento = "em andamento";
    String concluida = "concluida";

    public void save(Tarefa tarefa) {
        if (tarefa.getDescricao() == null || tarefa.getDescricao().isBlank()) {
            throw new TarefaException("\nDescrição deve estar preenchida.");
        }
        if (!tarefa.getStatus().equalsIgnoreCase(pendente) && !tarefa.getStatus().equalsIgnoreCase(em_andamento)
                && !tarefa.getStatus().equalsIgnoreCase(concluida)) {
            throw new TarefaException("\nStatus inválido.");
        }
        if (tarefa.getUsuario() == null) {
            throw new TarefaException("\nUsuário inválido.");
        }

        System.out.println("\nTarefa cadastrada com sucesso.");
        tarefaDAO.save(tarefa);
    }

    public Tarefa findById(Long id) {

        if (id <= 0) {
            throw new TarefaException("\nValor de Id inválido.");
        }

        Tarefa tarefa = tarefaDAO.findById(id);

        if (tarefa == null) {
            throw new TarefaException("\nId incorreto ou valor de Id inexistente.");
        }

        return tarefa;

    }

    public List<Tarefa> findAll() {

        List<Tarefa> tarefas = tarefaDAO.findAll();

        if (tarefas.size() == 0) {
            throw new TarefaException("\nNão há Tarefas a serem listadas.");
        }

        return tarefas;

    }

    public void update(Tarefa tarefa) {
        if (tarefa == null) {
            throw new TarefaException("\nTarefa não existe.");
        } else {
            if (tarefa.getDescricao() == null || tarefa.getDescricao().isBlank()) {
                throw new TarefaException("\nDescrição deve estar preenchida.");
            }
            if (!tarefa.getStatus().equalsIgnoreCase(pendente) && !tarefa.getStatus().equalsIgnoreCase(em_andamento)
                    && !tarefa.getStatus().equalsIgnoreCase(concluida)) {
                throw new TarefaException("\nStatus da tarefa inválido.");
            }
            if (tarefa.getUsuario() == null) {
                throw new TarefaException("\nUsuário inválido.");
            }

            System.out.println("\nTarefa atualizada com sucesso.");
            tarefaDAO.update(tarefa);
        }
    }

    public void delete(Long id) {
        if (id <= 0) {
            throw new TarefaException("\nValor de Id inválido.");
        }

        System.out.println("\nTarefa deletada com sucesso.");
        tarefaDAO.delete(id);
    }

}
