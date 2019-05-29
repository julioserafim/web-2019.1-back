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
	
	public void cadastrar(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
	}
	
	
	public List<Pessoa> retonarTodasAsPessoas(){
		return pessoaRepository.findAll();
	}


	public void excluirPessoa(Long codigo) {
		pessoaRepository.deleteById(codigo);
		
	}


	public Pessoa buscarPorId(Long codigo) {
		return pessoaRepository.getOne(codigo);
	}
	
	
	
	

}
