package com.empresa.controller;

import java.util.List;

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

import com.empresa.dto.FuncionarioDto;
import com.empresa.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("funcionario")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class FuncionarioController {
	
	private final FuncionarioService funcionarioService;
	
	
	  @PostMapping
	    @Operation(summary = "Rota responsável pelo cadastro de funcionários") 
	    @ApiResponse(responseCode = "201",description = "funcionário cadastrado com sucesso",content = {
	   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<FuncionarioDto>cadastrarFuncionario(@RequestBody @Valid FuncionarioDto funcionario){
		var cadastre = funcionarioService.cadastrarFuncionario(funcionario);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("funcionario/{id}")
				.buildAndExpand(funcionario.id()).toUri();
		return ResponseEntity.created(uri).body(new FuncionarioDto(cadastre));
	}
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os funcionários")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
    public ResponseEntity<List<FuncionarioDto>>listar(){
	   var lista = funcionarioService.listar().stream().map(FuncionarioDto::new).toList();
	   return ResponseEntity.ok(lista);
   }
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca do funcionário pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<FuncionarioDto>buscarId(@PathVariable Long id){
		var busca = funcionarioService.buscarPorId(id);
		return ResponseEntity.ok().body(new FuncionarioDto(busca));
	}
	@PutMapping		
	@Operation(summary = "Rota responsável pela atualização do funcionário")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<FuncionarioDto>atualizar(@RequestBody @Valid FuncionarioDto funcionario){
		var atualize = funcionarioService.atualizar(funcionario);
		return ResponseEntity.ok().body(new FuncionarioDto(atualize));
	}
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar funcionario")
	 @ApiResponse(responseCode = "204",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		funcionarioService.excluir(id);
		return ResponseEntity.noContent().build();
		
	}
}
