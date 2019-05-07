package br.com.ufc.teste;

import br.com.ufc.dao.PessoaDAO;
import br.com.ufc.model.Pessoa;

public class Teste {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Matheus Vital");
		pessoa.setTelefone("76767676763434343");
		
		
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.adicionar(pessoa);
		
	}
}
