package com.ayres.pessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayres.pessoas.mapper.BadRequestExceptionMapper;
import com.ayres.pessoas.model.Endereco;
import com.ayres.pessoas.model.PessoaModel;
import com.ayres.pessoas.model.RespostaGenerica;
import com.ayres.pessoas.repository.EnderecoRepository;
import com.ayres.pessoas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public ResponseEntity<PessoaModel> getPessoa(Long id) {
		ResponseEntity<PessoaModel> pessoa = pessoaRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		return pessoa;
	}
	
	public List<PessoaModel> getPessoalist() throws Exception{
		List<PessoaModel> pessoa = pessoaRepository.findAll();
			return pessoa;
	}
	
	public RespostaGenerica postPessoa(PessoaModel pessoa) {
        pessoaRepository.save(pessoa);
        for(Endereco endereco: pessoa.getEndereco()) {

            Endereco endereco1 =  new Endereco();
            endereco1.setId(endereco.getId());
            endereco1.setLogradouro(endereco.getLogradouro());
            endereco1.setCep(endereco.getCep());
            endereco1.setCidade(endereco.getCidade());
            endereco1.setNumero(endereco.getNumero());
            endereco1.setIsPrincipal(endereco.getIsPrincipal());

            enderecoRepository.save(endereco1);
        }
        return new RespostaGenerica( "200", "Pessoa cadastrada com sucesso!");
    }

	public PessoaModel putPessoa(PessoaModel pessoa, Long id) {
        Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
        return pessoaModel.map(p -> {
            p.setNome(pessoa.getNome());
            p.setDataNascimento(pessoa.getDataNascimento());
            p.setEndereco(pessoa.getEndereco());
            return pessoaRepository.save(p);
        })
         .orElseThrow(() -> new BadRequestExceptionMapper("Pessoa não pode ser atualizada"));
    }

	
}
