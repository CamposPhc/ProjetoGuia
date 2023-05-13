package conta.controller;

import java.util.ArrayList;

import conta.model.conta;
import conta.repository.contaRepository;

public class contaController implements contaRepository {

	private ArrayList<conta> listaContas = new ArrayList<conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
	}

	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	public void cadastrar(conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta Numero: " + conta.getNumero() + "Foi criada com sucesso!");
	}

	@Override
	public void atualizar(conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");
	}

	public void deletar(int numero) {

	}

	public void sacar(int numero, float valor) {

	}

	public void depositar(int numero, float valor) {

	}

	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

	}

	public int gerarNumero() {
		return ++numero;
	}

	public conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}

	public int retornaTipo(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}

		return 0;
	}
}