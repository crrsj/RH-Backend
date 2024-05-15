package com.empresa.dto;

import java.time.LocalDate;

import com.empresa.entity.Funcionario;
import com.empresa.enums.Status;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioDto(
		
		Long id,
		@NotBlank
		String nome,
		@NotBlank
		String telefone,
		@NotBlank
		String cpf,
		@NotBlank
		String email,
		@NotBlank
		String cargo,
		
		double salario,
		
		LocalDate dataAdmissao,
		
		LocalDate dataDemissao,
		
		Status status) {

	public FuncionarioDto(Funcionario cadastre) {
		this(
			cadastre.getId(),
			cadastre.getNome(),
			cadastre.getTelefone(),
			cadastre.getCpf(),
			cadastre.getEmail(),
			cadastre.getCargo(),
			cadastre.getSalario(),
			cadastre.getDataAdmissao(),
			cadastre.getDataDemissao(),
			cadastre.getStatus());
	}

}
