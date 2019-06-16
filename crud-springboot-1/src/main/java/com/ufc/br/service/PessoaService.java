package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.util.AulaFileUtils;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void cadastrar(Pessoa pessoa, MultipartFile imagem) {
		
		System.out.println("SENHA ANTES:" + pessoa.getSenha());
		
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
		
		System.out.println("SENHA DEPOIS:" + pessoa.getSenha());
		
		
		String caminho = "images/" + pessoa.getNome() + ".png";
		
		AulaFileUtils.salvarImagem(caminho,imagem);
		
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
