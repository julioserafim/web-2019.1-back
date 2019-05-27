package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepo;
	
	
	public void cadastrar(Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		
	}


	public List<Pessoa> listarTodos() {
		return pessoaRepo.findAll();
	}


	public void excluirPessoa(Long codigo) {
		pessoaRepo.deleteById(codigo);
		
	}
}
