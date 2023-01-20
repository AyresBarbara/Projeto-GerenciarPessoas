package com.ayres.pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ayres.pessoas.model.PessoaModel;
import com.ayres.pessoas.model.RespostaGenerica;
import com.ayres.pessoas.repository.PessoaRepository;
import com.ayres.pessoas.service.PessoaService;

import io.swagger.annotations.ApiOperation;



@Validated
@RestController
@RequestMapping("/pessoa") 
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation(value = "Descrição do recurso", notes = "Notas adicionais sobre o recurso")
	@GetMapping("/{id}") 
	public ResponseEntity<PessoaModel> getPessoaById(@PathVariable Long id) {
		return pessoaService.getPessoa(id);
	}
	
	@ApiOperation(value = "Descrição do recurso", notes = "Notas adicionais sobre o recurso")
	@GetMapping("/listar") 
	public List<PessoaModel> getPessoalist() throws Exception{
		return pessoaService.getPessoalist();
	}
	
	@ApiOperation(value = "Descrição do recurso", notes = "Notas adicionais sobre o recurso")
	@PostMapping ("/cadastrar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RespostaGenerica postPessoa(@RequestBody PessoaModel pessoa) {
		return pessoaService.postPessoa(pessoa);
	}
	
	@ApiOperation(value = "Descrição do recurso", notes = "Notas adicionais sobre o recurso")
	@PutMapping("/atualizar/{id}")
	public PessoaModel putPessoa(@RequestBody PessoaModel pessoa, @PathVariable Long id) {
		return pessoaService.putPessoa(pessoa, id);
		
	}
}
		

