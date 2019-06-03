package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("Formulario");
		mv.addObject(new Pessoa());
		return mv;
	}
	
	
	@PostMapping("/salvar")
	public String cadastrar(Pessoa pessoa, @RequestParam(value="imagem") MultipartFile imagem) {
		pessoaService.cadastrar(pessoa,imagem);
		
		
		return "OlaMundo";
	}
	
	@GetMapping("/listar")
	public ModelAndView listarPessoas() {
		List<Pessoa> pessoas = pessoaService.retonarTodasAsPessoas();
		ModelAndView mv = new ModelAndView("PaginaListagem");
		mv.addObject("listaDePessoas", pessoas);
	
		return mv;
	}
	
    @RequestMapping("/excluir/{codigo}")
    public ModelAndView excluirPessoa(@PathVariable Long codigo) {
    	pessoaService.excluirPessoa(codigo);
    	ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
    	return mv;
    }
	
    @RequestMapping("/atualizar/{codigo}")
    public ModelAndView atualizarPessoa(@PathVariable Long codigo) {
    	Pessoa pessoa = pessoaService.buscarPorId(codigo);
    	ModelAndView mv = new ModelAndView("Formulario");
    	mv.addObject("pessoa", pessoa);
    	return mv;
    	
    }
	
	
}
