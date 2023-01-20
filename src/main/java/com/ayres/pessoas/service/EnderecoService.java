package com.ayres.pessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayres.pessoas.model.Endereco;
import com.ayres.pessoas.model.PessoaModel;
import com.ayres.pessoas.model.RespostaGenerica;
import com.ayres.pessoas.repository.EnderecoRepository;
import com.ayres.pessoas.repository.PessoaRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Endereco> getEnderecolist() throws Exception{
		List<Endereco> endereco = enderecoRepository.findAll();
			return endereco;
	}
	public RespostaGenerica postEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
		return new RespostaGenerica( "200", "Endereço cadastrado com sucesso!");
	}
	public Endereco getEnderecoPrincipalPessoa(Long idPessoa) {
	    Optional<PessoaModel> pessoa = pessoaRepository.findById(idPessoa);
	    if (pessoa.isPresent()) {
	        for (Endereco endereco : pessoa.get().getEndereco()) {
	            if (endereco.getIsPrincipal()) {
	                return endereco;
	            }
	        }
	    }
	    return null;
	}

	}
	
