package com.example.projetose.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetose.entities.Especialidade;
import com.example.projetose.services.EspecialidadeService;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {
    
    @Autowired
    EspecialidadeService especialidadeService;

    @GetMapping("/{idEspecialidade}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_GESTOR" })
    public Especialidade getEspecialidade(@PathVariable Integer idEspecialidade) {
        return especialidadeService.getEspecialidade(idEspecialidade);
    }

    @PostMapping
    @Secured(value = { "ROLE_GESTOR" })
    public void salvar(@RequestBody Especialidade especialidade) {
        especialidadeService.salvar(especialidade);
    }

    @PutMapping
    @Secured(value = { "ROLE_GESTOR" })
    public void atualizar(@RequestBody Especialidade especialidade) {
        especialidadeService.salvar(especialidade);
    }

    @DeleteMapping
    @Secured(value = { "ROLE_GESTOR" })
    public void remover(@PathVariable Integer idEspecialidade) {
        especialidadeService.remover(idEspecialidade);
    }

}
