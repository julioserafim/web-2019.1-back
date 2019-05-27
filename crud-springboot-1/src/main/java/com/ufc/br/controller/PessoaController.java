package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	private PessoaService pessoaService;
	
	
	@RequestMapping("/formulario")
	public String form() {
		return"Formulario";
	}
	
	
	@PostMapping("/salvar")
	public String cadastrar(Pessoa pessoa) {
		pessoaService.cadastrar(pessoa);
		
		
		//retornar a página de sucesso
		
		return "OlaMundo";
	}

}
