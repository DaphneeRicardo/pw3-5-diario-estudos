package br.com.daphnericardo.diario_estudos.service;

import br.com.daphnericardo.diario_estudos.entity.Tarefa;
import br.com.daphnericardo.diario_estudos.enums.PrioridadeEnum;
import br.com.daphnericardo.diario_estudos.enums.StatusEnum;
import br.com.daphnericardo.diario_estudos.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DiarioEstudosService {
    @Autowired
    private DiarioEstudosService diarioEstudosService;

    @Autowired
    private TarefaRepository tarefaRepository;

    public void calculoPrioridade(Tarefa tarefa) {
        Long diasfaltando = ChronoUnit.DAYS.between(LocalDate.now(), tarefa.getDataEntrega());

        if (diasfaltando <= 2) {
            tarefa.setPrioridade(PrioridadeEnum.ALTA);
        }
        else if (diasfaltando <= 5) {
            tarefa.setPrioridade(PrioridadeEnum.MEDIA);
        }
        else{
            tarefa.setPrioridade(PrioridadeEnum.BAIXA);
        }
    }

    public List<Tarefa> getTarefa() {
        return tarefaRepository.findAll();
    }

    public List<Tarefa> getTarefaById(Long id) {
        return diarioEstudosService.getTarefaById(id);
    }

    public List<Tarefa> saveTarefa(@RequestBody Tarefa tarefa) {
        diarioEstudosService.calculoPrioridade(tarefa);
        return diarioEstudosService.saveTarefa(tarefa);
    }

    public List<Tarefa> deleteTarefa(@PathVariable Long id) {
        return diarioEstudosService.deleteTarefa(id);
    }
    public List<Tarefa> updateTarefa(@RequestBody Tarefa tarefa) {
        return diarioEstudosService.updateTarefa(tarefa);
    }
    public List<Tarefa> concluirTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setStatus(StatusEnum.CONCLUIDO);
        return diarioEstudosService.concluirTarefa(tarefa);
    }
}
