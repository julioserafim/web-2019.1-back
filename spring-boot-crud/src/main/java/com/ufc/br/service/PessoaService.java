package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}

	public void excluir(Long codigo) {
		pessoaRepository.deleteById(codigo);
		
	}

}
