package com.upperdev.sof.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FuncionarioController {


	public FuncionarioController() {
	}


	//----------------------------------//
	
	@RequestMapping("/")
	public String exibirPaginaInicial(){
		
		return "inicio";
	}	
	
}