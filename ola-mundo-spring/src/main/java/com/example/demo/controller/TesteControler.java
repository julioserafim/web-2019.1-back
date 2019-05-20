package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteControler {
	
	@RequestMapping("/olamundo")
	@ResponseBody
	public String olaMundo() {
		return "OlaMundo";
	}

}
