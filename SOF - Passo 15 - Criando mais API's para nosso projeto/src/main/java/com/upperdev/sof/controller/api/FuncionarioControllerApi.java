package com.upperdev.sof.controller.api;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upperdev.sof.entity.Funcionario;
import com.upperdev.sof.service.FuncionarioService;

@RestController 
@RequestMapping(value="/api/funcionario", produces="application/json")
@CrossOrigin(origins = "*")
public class FuncionarioControllerApi {
	

	@Autowired
	FuncionarioService funcionarioService;

	
	public FuncionarioControllerApi(){
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
	
	
	@DeleteMapping(value = "/deletar/{id}") 
	public ResponseEntity< Funcionario > deletarFuncionarioPorId ( @PathVariable("id") Long id) {
		
	
		Funcionario funcionarioDeletado = funcionarioService.buscarFuncionarioPeloId( id );
		
		if (funcionarioDeletado == null){
			
			return ResponseEntity.badRequest().body( funcionarioDeletado );
		}
		

		funcionarioService.deletarFuncionario( id );
		
		return ResponseEntity.ok( funcionarioDeletado );
	}	

	
	@PostMapping(value = "/adicionar") 
	public ResponseEntity< Funcionario > adicionar( @RequestBody Funcionario funcionario ){
		

		funcionarioService.salvarFuncionarioNoBanco( funcionario );
		
		URI uriParaPegarACategoria = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                                                .path("/buscarFuncionarioPorId/{id}")
                                                                .buildAndExpand( funcionario.getId() )
                                                                .toUri();
		
		return ResponseEntity.created( uriParaPegarACategoria ).body( funcionario );
	}

	
	@PutMapping(value = "editar/{id}")   
	public ResponseEntity< Funcionario > editar(@PathVariable("id") Long id, 
			                                    @RequestBody        Funcionario funcionario ){
		
		Funcionario funcionarioAux = funcionarioService.buscarFuncionarioPeloId( id );		
		
		if( funcionarioAux == null){
			
			return ResponseEntity.badRequest().body( funcionario );
		}
		
		funcionario.setId(id);
		funcionarioService.salvarFuncionarioNoBanco( funcionario );
				
		return ResponseEntity.ok().body( funcionario );
	}

}