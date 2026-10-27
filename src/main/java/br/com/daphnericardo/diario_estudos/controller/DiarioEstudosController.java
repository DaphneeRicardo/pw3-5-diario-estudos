package br.com.daphnericardo.diario_estudos.controller;

import br.com.daphnericardo.diario_estudos.entity.Tarefa;
import br.com.daphnericardo.diario_estudos.service.DiarioEstudosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/diarioEstudos")
@CrossOrigin("*")
public class DiarioEstudosController {

    @Autowired
    private DiarioEstudosService diarioEstudosService;

    @GetMapping("/tarefas")
    public List<Tarefa> getTarefa() {return diarioEstudosService.getTarefa();}

    @GetMapping("/tarefas/{id}")
    public List<Tarefa> getTarefaById(@PathVariable Long id)
    {return diarioEstudosService.getTarefaById(id);}

    @PostMapping("/tarefas")
    public List<Tarefa> saveTarefa(@RequestBody Tarefa tarefa) {
        return  diarioEstudosService.saveTarefa(tarefa);
    }

    @PutMapping("/tarefas/{id}")
    public List<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return  diarioEstudosService.updateTarefa(tarefa);
    }

    @DeleteMapping("/tarefas/{id}")
    public List<Tarefa> deleteTarefa(@PathVariable Long id){return diarioEstudosService.deleteTarefa(id);}

    @PatchMapping("/tarefas/{id}/concluir")
    public  List<Tarefa> concluirTarefa(@RequestBody Tarefa tarefa){return diarioEstudosService.concluirTarefa(tarefa);}
}
