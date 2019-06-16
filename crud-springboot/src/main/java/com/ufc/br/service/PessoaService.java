package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.util.AulaFileUtils;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepo;
	
	
	public void cadastrar(Pessoa pessoa, MultipartFile imagem) {
		
		String caminho = "images/" + pessoa.getNome() + ".png";
		
		
		AulaFileUtils.salvarImagem(caminho, imagem);
		
		
		pessoaRepo.save(pessoa);
		
	}


	public List<Pessoa> listarTodos() {
		return pessoaRepo.findAll();
	}


	public void excluirPessoa(Long codigo) {
		pessoaRepo.deleteById(codigo);
		
	}


	public Pessoa buscarPorId(Long codigo) {
		return pessoaRepo.getOne(codigo);
	}
}
