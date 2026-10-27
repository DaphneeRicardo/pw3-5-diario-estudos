package br.com.daphnericardo.diario_estudos.repository;

import br.com.daphnericardo.diario_estudos.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> getTarefa();
    List<Tarefa> getTarefaById(@PathVariable Long id);
    List<Tarefa> saveTarefa(@RequestBody Tarefa tarefa);
    List<Tarefa> deleteTarefa(@PathVariable Long id);
    List<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa);
    List<Tarefa> concluirTarefa(@RequestBody Tarefa tarefa);
}
