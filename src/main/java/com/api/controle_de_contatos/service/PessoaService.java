package com.api.controle_de_contatos.service;

import com.api.controle_de_contatos.dto.PessoaMalaDiretaDto;
import com.api.controle_de_contatos.dto.PessoaDto;
import com.api.controle_de_contatos.model.Pessoa;
import com.api.controle_de_contatos.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public PessoaMalaDiretaDto findByIdMalaDireta(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            String malaDireta = String.format("%s – CEP: %s – %s/%s",
                    pessoa.getEndereco(),
                    pessoa.getCep(),
                    pessoa.getCidade(),
                    pessoa.getUf()
            );
            return new PessoaMalaDiretaDto(pessoa.getId(), pessoa.getNome(), malaDireta);
        }
        return null;
    }

    public Pessoa save(PessoaDto pessoaDto) {

        Pessoa pessoaToSave = new Pessoa();

        pessoaToSave.setNome(pessoaDto.nome());
        pessoaToSave.setCidade(pessoaDto.cidade());
        pessoaToSave.setUf(pessoaDto.uf());
        pessoaToSave.setCep(pessoaDto.cep());
        pessoaToSave.setEndereco(pessoaDto.endereco());

        return pessoaRepository.save(pessoaToSave);
    }

    public Pessoa update(Long id, PessoaDto pessoaDto) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            Pessoa pessoaToUpdate = pessoaOptional.get();
            pessoaToUpdate.setNome(pessoaDto.nome());
            pessoaToUpdate.setEndereco(pessoaDto.endereco());
            pessoaToUpdate.setCep(pessoaDto.cep());
            pessoaToUpdate.setUf(pessoaDto.uf());
            pessoaToUpdate.setCidade(pessoaDto.cidade());
            return pessoaRepository.save(pessoaToUpdate);
        }
        return null;
    }

    public void deleteById(Long id) {

        pessoaRepository.deleteById(id);
    }
}
