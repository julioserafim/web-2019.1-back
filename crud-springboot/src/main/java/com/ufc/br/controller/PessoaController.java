package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping("/formulario")
	public String form() {
		return "Formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa) {
		pessoaService.cadastrar(pessoa);
		
		return "OlaMundo";
}
	
	
	@GetMapping("/listar")
	public ModelAndView listarPessoas() {
		List<Pessoa> pessoas = pessoaService.listarTodos();//devolve todas as pessoas
		ModelAndView mv = new ModelAndView("PaginaListagem");
		mv.addObject("listaPessoas", pessoas);
		
		
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo) {
		pessoaService.excluirPessoa(codigo);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
