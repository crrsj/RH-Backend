package com.empresa.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.dto.FuncionarioDto;
import com.empresa.entity.Funcionario;
import com.empresa.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	
	
	public Funcionario cadastrarFuncionario(FuncionarioDto funcionario) {
		var cadastrar =  new Funcionario(funcionario);
		return funcionarioRepository.save(cadastrar);
	}

	public List<Funcionario>listar(){
		return funcionarioRepository.findAll();
	
	}
	
	public Funcionario buscarPorId(Long id) {
		Optional<Funcionario>buscarPorId = funcionarioRepository.findById(id);
		return buscarPorId.get();
	}

	
	public Funcionario atualizar(FuncionarioDto funcionario) {
		var atualizando  = new Funcionario(funcionario);	
	  	if(atualizando.getId() == null ) {
	  		throw new NoSuchElementException();
	  	}
	  
		return funcionarioRepository.save(atualizando);
	}
	
	
	public void excluir(Long id) {
		funcionarioRepository.deleteById(id);
	}
}
