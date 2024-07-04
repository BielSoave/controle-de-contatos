package com.api.controle_de_contatos.controller;

import com.api.controle_de_contatos.dto.PessoaMalaDiretaDto;
import com.api.controle_de_contatos.dto.PessoaDto;
import com.api.controle_de_contatos.model.Pessoa;
import com.api.controle_de_contatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/pessoas")
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Operation(summary = "Buscar todas pessoas")
    @GetMapping("")
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = this.pessoaService.findAll();
        if (pessoas == null || pessoas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pessoas);
    }

    @Operation(summary = "Buscar pessoa pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {

        Optional<Pessoa> pessoa = this.pessoaService.findById(id);
        if (pessoa.isPresent()) {
            return ResponseEntity.ok().body(pessoa.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Buscar pessoa maladireta")
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDto> findByIdMalaDireta(@PathVariable Long id) {
        PessoaMalaDiretaDto malaDiretaResponse = pessoaService.findByIdMalaDireta(id);
        if (malaDiretaResponse != null) {
            return ResponseEntity.ok().body(malaDiretaResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Salvar uma pessoa nova")
    @PostMapping("")
    public ResponseEntity<Pessoa> save(@RequestBody PessoaDto pessoaDto) {
        return ResponseEntity.ok(pessoaService.save(pessoaDto));
    }

    @Operation(summary = "Atualizar uma pessoa existente pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody PessoaDto pessoaDto) {

        Pessoa pessoaResponse = pessoaService.update(id, pessoaDto);
        if (pessoaResponse != null) {
            return ResponseEntity.ok().body(pessoaResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deletar uma pessoa pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        this.pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
