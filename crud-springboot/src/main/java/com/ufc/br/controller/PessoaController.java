package com.ufc.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufc.br.model.Pessoa;

@Controller
public class PessoaController {
	
	@RequestMapping("/pessoa/formulario")
	public String form() {
		return "Formulario";
	}
	
	@PostMapping("/pessoa/salvar")
	public String salvar(Pessoa pessoa) {
		System.out.println("NOME:" + pessoa.getNome());
		return "OlaMundo";
	}
	
}
