package com.desafio_banco.Models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banco {

    private String nome;
	private List<Conta> contas;
}
