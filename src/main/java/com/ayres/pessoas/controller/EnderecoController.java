package com.ayres.pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ayres.pessoas.model.Endereco;
import com.ayres.pessoas.model.PessoaModel;
import com.ayres.pessoas.model.RespostaGenerica;
import com.ayres.pessoas.repository.EnderecoRepository;
import com.ayres.pessoas.service.EnderecoService;

@Validated
@RestController
@RequestMapping("/endereco") 
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/listar") 
	public List<Endereco> getEnderecolist() throws Exception{
		return enderecoService.getEnderecolist();
	}
	@PostMapping ("/cadastrar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RespostaGenerica postEndereco(@RequestBody Endereco endereco) {
		return enderecoService.postEndereco(endereco);
	}
	@GetMapping("/enderecoPrincipal/{id}") 
	public Endereco getEnderecoPrincipalPessoa(@PathVariable Long id) {
		return enderecoService.getEnderecoPrincipalPessoa(id);
	}

}
