package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.service.PessoaService;

@Controller
public class PessoaController {
	
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/olamundo")
	public String olaMundo() {
		return "OlaMundo";
	}
	
	
	@RequestMapping("/pessoa/formulario")
	public ModelAndView retornarForm() {
		ModelAndView mv = new ModelAndView("Formulario");
		mv.addObject(new Pessoa());
		return mv;
	}
	
	@PostMapping("/pessoa/cadastrar")
	public ModelAndView cadastrar(@Validated Pessoa pessoa, BindingResult result 
			,@RequestParam(value= "imagem") MultipartFile imagem) {
		
		ModelAndView mv = new ModelAndView("Formulario");
		
		if(result.hasErrors()) {
			return mv; //retorno pra mesma página, nem tento salvar pessoa
		}
		
		pessoaService.salvar(pessoa,imagem);
		
		
		
		
		mv.addObject("mensagem", "Título cadastrado com sucesso!");
		
		return mv;
	}
	
	
	@GetMapping("/pessoa/listar")
	public ModelAndView listar() {
		List<Pessoa> pessoas = pessoaService.listarPessoas();
		ModelAndView mv = new ModelAndView("Pagina-Listagem");
		mv.addObject("listaPessoas", pessoas);
		return mv;
	}
	
	@RequestMapping("/pessoa/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		pessoaService.excluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		return mv;
		
	}
	
	@RequestMapping("/pessoa/atualizar/{codigo}")
	public ModelAndView atualizar(@PathVariable Long codigo) {
		Pessoa pessoa = pessoaService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("Formulario");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	

	@RequestMapping("/pessoa/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("Login");
		return mv;
	}
	
	
	@RequestMapping("/")
	public ModelAndView pagInicial() {
		ModelAndView mv = new ModelAndView("OlaMundo");
		return mv;
	}
	
	

}
