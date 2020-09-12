package com.upperdev.sof.controller.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.upperdev.sof.entity.Funcionario;
import com.upperdev.sof.service.FuncionarioService;

@RestController 
@RequestMapping(value="/api/funcionario", produces="application/json")
@CrossOrigin(origins = "*")
public class FuncionarioControllerApi {
	

	@Autowired
	FuncionarioService funcionarioService;

	
	public FuncionarioControllerApi() {
	}
	
	
	@GetMapping(value = "/buscarFuncionarioPorId/{id}") 
	public ResponseEntity< Funcionario > buscarFuncionarioPorId( @PathVariable("id") Long id) {
		
		Funcionario funcionario = funcionarioService.buscarFuncionarioPeloId( id );
		
		return ResponseEntity.ok().body( funcionario );		

	}	
	
	
	@GetMapping(value = "/todos") 
	public ResponseEntity< List<Funcionario> > pegarTodosOsFuncionarios(){
		
		List<Funcionario> listaDeFuncionarios = funcionarioService.pegarTodosOsFuncionarios();
	
		return ResponseEntity.ok().body( listaDeFuncionarios );
	}	
	
	
}