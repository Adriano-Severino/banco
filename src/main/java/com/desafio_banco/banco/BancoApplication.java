package com.desafio_banco.banco;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio_banco.Models.Cliente;
import com.desafio_banco.Models.Conta;
import com.desafio_banco.Models.ContaCorrente;
import com.desafio_banco.Models.ContaPoupanca;

@SpringBootApplication
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);

		Cliente adriano = new Cliente();
		adriano.setNome("adriano");
		adriano.setSobrenome("sobrenome");
		adriano.setCPF("12345678901");
		LocalDate dataNascimento = LocalDate.of(2001,01,01);
		adriano.setNascimento(dataNascimento);

		Conta cc = new ContaCorrente(adriano);
		Conta poupanca = new ContaPoupanca(adriano);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
