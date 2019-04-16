package br.com.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.model.Pessoa;

public class PessoaDAO {
	
	private List<Pessoa> pessoas;
	
	public PessoaDAO() {
		pessoas = new ArrayList<Pessoa>();
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	@Override
	public String toString() {
		return "PessoaDAO [pessoas=" + pessoas.toString() + "]";
	}
	
	

}
