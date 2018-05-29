package br.com.s2it.incubadora.DojoSolucao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "sugestoes")
public class SugestaoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome")
    private String nome;

    private String email;

    private String sugestoes;
}
