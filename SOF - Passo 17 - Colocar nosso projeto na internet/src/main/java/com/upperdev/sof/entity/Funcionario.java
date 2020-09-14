package com.upperdev.sof.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario") 
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome")
    private String nome;	
	
    @Column(name = "idade")
    private Integer idade;	
    
    @Column(name = "salario")
    private Double salario;	   
 
    @Column(name = "email")
    private String email;    
	
    
	public Funcionario() {
	}

	//--------------------------------------------//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}