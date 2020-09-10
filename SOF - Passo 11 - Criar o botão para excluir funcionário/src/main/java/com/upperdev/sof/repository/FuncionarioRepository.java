package com.upperdev.sof.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upperdev.sof.entity.Funcionario;

//O código abaixo vai cria diversos formas de manuseio de dados da nossa tabela "Funcionario" lá do nosso banco de dados.
public interface FuncionarioRepository extends JpaRepository< Funcionario, Long >{

}