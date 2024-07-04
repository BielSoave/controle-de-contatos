package com.api.controle_de_contatos.model;

import com.api.controle_de_contatos.enums.ContatoTipoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "tb_contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ContatoTipoEnum tipo;
    @Column(nullable = false)
    private String contato;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    @JsonIgnoreProperties("contatos")
    private Pessoa pessoa;

    public Contato() {
    }

    public Contato(Long id, ContatoTipoEnum tipo, String contato, Pessoa pessoa) {
        this.id = id;
        this.tipo = tipo;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Contato(ContatoTipoEnum tipo, String contato, Pessoa pessoa) {
        this.tipo = tipo;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContatoTipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ContatoTipoEnum tipo) {
        this.tipo = tipo;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", contato='" + contato + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
