package com.upperdev.sof.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upperdev.sof.entity.Funcionario;
import com.upperdev.sof.service.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	public FuncionarioController(){
	}

	//--------------------------------//

	@RequestMapping("/")
	public String exibirPaginaInicial( Model model ){

		
		List<Funcionario> listaDeFuncionarios = funcionarioService.pegarTodosOsFuncionarios();
		
		//model é um objeto fornecido pelo proprio spring.
		model.addAttribute("listaDeFuncionarios", listaDeFuncionarios);


		return "inicio";
	}	
	

}