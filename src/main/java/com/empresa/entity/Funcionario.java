package com.empresa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;

import com.empresa.dto.FuncionarioDto;
import com.empresa.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	private String nome;	
	private String telefone;	
	private String cpf;	
	private String email;	
	private String cargo;
	private double salario;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")    
	private LocalDate dataAdmissao;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")    
    private LocalDate dataDemissao;
    @Enumerated(EnumType.STRING)
    private Status status;
    
    
    
    
	
    public Funcionario(FuncionarioDto funcionario) {
    	this.id = funcionario.id();
		this.nome = funcionario.nome();
		this.telefone = funcionario.telefone();
		this.cpf = funcionario.cpf();
		this.email = funcionario.email();
		this.cargo = funcionario.cargo();
		this.salario = funcionario.salario();
		this.dataAdmissao = funcionario.dataAdmissao();
		this.dataDemissao = funcionario.dataDemissao();
		this.status = funcionario.status();
	}





	
}
