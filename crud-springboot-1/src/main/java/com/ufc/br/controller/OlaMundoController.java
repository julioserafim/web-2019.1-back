package com.ufc.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	
	@RequestMapping("/olamundo")
	public String olaMundo() {
		return "OlaMundo";
	}
	

}
