package com.upperdev.sof.service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upperdev.sof.entity.Funcionario;
import com.upperdev.sof.repository.FuncionarioRepository;


@Service
public class FuncionarioService {

	private static final Logger log = LoggerFactory.getLogger( FuncionarioService.class );
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;


	public FuncionarioService() {
	}

	//-----------------------------//
	

	public List<Funcionario> pegarTodosOsFuncionarios(){
		
		
		List<Funcionario> listaDeFuncionarios = new ArrayList<Funcionario>();
		
		
		listaDeFuncionarios = funcionarioRepository.findAll();
		
		return listaDeFuncionarios;

	}

	//----
	
	
	public void salvarFuncionarioNoBanco( Funcionario funcionario ){
		
		funcionarioRepository.save( funcionario );
		
	}

	//----
	
	public void deletarFuncionario(Long id) {
		
		funcionarioRepository.deleteById(id);
		
	}

	//----
	
	public Funcionario buscarFuncionarioPeloId( Long id) {
		
		Funcionario funcionario = new Funcionario();
		
		try {
			
			funcionario = funcionarioRepository.findById(id).get();
			
		}catch(Exception e){
			
			log.info("Funcionario nao encontrado'");
			
			return null;
			
		}

		return funcionario;
	}
	
	//----
	
	
	
}