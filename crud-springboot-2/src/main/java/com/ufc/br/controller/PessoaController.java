package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping("/pessoa/formulario")
	public String form() {
		return "Formulario";
	}
	
	@RequestMapping("/pessoa/salvar")
	public String salvarPessoa(Pessoa pessoa) {
		
			pessoaService.cadastrar(pessoa);

		return"OlaMundo";
	}
	
	@RequestMapping("/pessoa/listar")
	public String listarPessoas() {
		//trazer as pessoas do banco e mandar pra página
		
		return "PaginaListagem";
	}
	
	
	
	
} 
