package com.desafio_banco.Models;

import java.time.format.DateTimeFormatter;

import com.desafio_banco.Interface.IConta;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Sobrenome: %s", this.cliente.getSobrenome()));
        System.out.println(String.format("CPG: %s", this.cliente.getCPF()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = this.cliente.getNascimento().format(formatter);
        System.out.println(String.format("Data de nascimento: %s", dataFormatada));

		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}