package com.johan.tarefas.controllers;

import com.johan.tarefas.models.TarefaModel;
import com.johan.tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){

        TarefaModel request = tarefaService.criarTarefa(tarefaModel);

        URI uri = URI.create("/tarefas/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }


    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll(){
        List<TarefaModel> request = tarefaService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public void buscarTarefaPorId(@PathVariable Long id){
        tarefaService.buscarTarefaPorId(id);

    }

}