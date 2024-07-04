package com.api.controle_de_contatos.controller;

import com.api.controle_de_contatos.dto.ContatoDto;
import com.api.controle_de_contatos.dto.ContatoUpdateDto;
import com.api.controle_de_contatos.model.Contato;
import com.api.controle_de_contatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/contatos")
@RestController
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @Operation(summary = "Buscar o contato pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable("id") Long id) {
        Optional<Contato> contatoOptional = contatoService.findById(id);
        if (contatoOptional.isPresent()) {
            return ResponseEntity.ok().body(contatoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Buscar todos os contatos pelo id de uma pessoa")
    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Contato>> findAllByPessoaId(@PathVariable("idPessoa") Long idPessoa) {
        List<Contato> contatos = contatoService.findAllByPessoaId(idPessoa);
        if (contatos == null || contatos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(contatos);
    }

    @Operation(summary = "Salvar um contato novo")
    @PostMapping("")
    public ResponseEntity<Contato> save(@RequestBody ContatoDto contatoRequest) {
        Contato contato = contatoService.save(contatoRequest);
        if (contato != null) {
            return ResponseEntity.ok().body(contato);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Atualizar um contato existente pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable("id") Long id, @RequestBody ContatoUpdateDto contatoUpdateDto) {
        Contato contato = contatoService.update(id, contatoUpdateDto);
        if (contato != null) {
            return ResponseEntity.ok().body(contato);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deletar um contato pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        contatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
