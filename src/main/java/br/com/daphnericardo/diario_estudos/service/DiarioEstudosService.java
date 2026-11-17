package br.com.daphnericardo.diario_estudos.service;

import br.com.daphnericardo.diario_estudos.entity.Tarefa;
import br.com.daphnericardo.diario_estudos.enums.PrioridadeEnum;
import br.com.daphnericardo.diario_estudos.enums.StatusEnum;
import br.com.daphnericardo.diario_estudos.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DiarioEstudosService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void calculoPrioridade(Tarefa tarefa) {

        Long diasfaltando = ChronoUnit.DAYS.between(
                LocalDateTime.now(),
                tarefa.getDataEntrega()
        );

        if (diasfaltando <= 2) {
            tarefa.setPrioridade(PrioridadeEnum.ALTA);
        }
        else if (diasfaltando <= 5) {
            tarefa.setPrioridade(PrioridadeEnum.MEDIA);
        }
        else {
            tarefa.setPrioridade(PrioridadeEnum.BAIXA);
        }
    }

    public List<Tarefa> getTarefa() {
        return tarefaRepository.findAll();
    }

    public Tarefa getTarefaById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public List<Tarefa> saveTarefa(Tarefa tarefa) {

        calculoPrioridade(tarefa);
        tarefaRepository.save(tarefa);

        return tarefaRepository.findAll();
    }

    public List<Tarefa> deleteTarefa(Long id) {

        tarefaRepository.deleteById(id);

        return tarefaRepository.findAll();
    }

    public List<Tarefa> updateTarefa(Long id, Tarefa tarefa) {

        Tarefa tarefaExistente = getTarefaById(id);

        tarefaExistente.setTitulo(tarefa.getTitulo());
        tarefaExistente.setMateria(tarefa.getMateria());
        tarefaExistente.setDataEntrega(tarefa.getDataEntrega());
        tarefaExistente.setStatus(tarefa.getStatus());

        calculoPrioridade(tarefaExistente);

        tarefaRepository.save(tarefaExistente);

        return tarefaRepository.findAll();
    }

    public List<Tarefa> concluirTarefa(Long id) {

        Tarefa tarefa = getTarefaById(id);

        tarefa.setStatus(StatusEnum.CONCLUIDO);

        tarefaRepository.save(tarefa);

        return tarefaRepository.findAll();
    }
}