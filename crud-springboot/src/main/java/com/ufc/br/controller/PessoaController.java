package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	@RequestMapping("/pessoa/formulario")
	public String form() {
		return "Formulario";
	}
	
	@PostMapping("/pessoa/salvar")
	public String salvar(Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		return "OlaMundo";
}
	
}
