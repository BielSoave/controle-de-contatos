package com.api.controle_de_contatos.repository;

import com.api.controle_de_contatos.model.Contato;
import com.api.controle_de_contatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findAllByPessoaId(Long idPessoa);
}
