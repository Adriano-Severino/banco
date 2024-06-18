package com.desafio_banco.Models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private String nome;
    private String sobrenome;
    private String CPF;
    private LocalDate nascimento;
}
