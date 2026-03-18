package com.johan.tarefas.controllers;

import com.johan.tarefas.models.TarefaModel;
import com.johan.tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

    @GetMapping
    public List<TarefaModel> listarTarefas() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarTarefaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }
}