package com.api.controle_de_contatos.service;

import com.api.controle_de_contatos.dto.ContatoDto;
import com.api.controle_de_contatos.dto.ContatoUpdateDto;
import com.api.controle_de_contatos.model.Contato;
import com.api.controle_de_contatos.model.Pessoa;
import com.api.controle_de_contatos.repository.ContatoRepository;
import com.api.controle_de_contatos.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository) {
        this.contatoRepository = contatoRepository;
        this.pessoaRepository = pessoaRepository;

    }

    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> findAllByPessoaId(Long idPessoa) {
        return contatoRepository.findAllByPessoaId(idPessoa);
    }

    public Contato save(ContatoDto contatoRequest) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(contatoRequest.pessoaId());

        if (pessoa.isEmpty()) {
            return null;
        }
        Contato contatoToSave = new Contato(contatoRequest.tipo(), contatoRequest.contato(), pessoa.get());
        return contatoRepository.save(contatoToSave);
    }

    public Contato update(Long id, ContatoUpdateDto contatoUpdateDto) {
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isEmpty()) {
            return null;
        }
        Contato contatoToUpdate = contatoOptional.get();
        contatoToUpdate.setTipo(contatoUpdateDto.tipo());
        contatoToUpdate.setContato(contatoUpdateDto.contato());

        return contatoRepository.save(contatoToUpdate);
    }

    public void deleteById(Long id) {
        contatoRepository.deleteById(id);
    }
}
