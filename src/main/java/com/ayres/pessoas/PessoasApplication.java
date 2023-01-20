package com.ayres.pessoas;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayres.pessoas.model.Endereco;
import com.ayres.pessoas.model.PessoaModel;
import com.ayres.pessoas.repository.EnderecoRepository;
import com.ayres.pessoas.repository.PessoaRepository;

@SpringBootApplication
public class PessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoasApplication.class, args);
	}
	/* @Bean
	CommandLineRunner initDatabase(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
		return args -> {
			pessoaRepository.deleteAll();
			
			Endereco endereco = new Endereco();
			endereco.setLogradouro("Rua rua");
			endereco.setNumero("123");
			endereco.setCidade("Recife");
			endereco.setCep("012345");
			
			
			PessoaModel pessoa = new PessoaModel();
			pessoa.setNome("Barbara");
			pessoa.setDataNascimento(LocalDate.of(1996,3, 21));
			pessoa.setEndereco(List.of(endereco));
			
			enderecoRepository.save(endereco);
			pessoaRepository.save(pessoa);
	};
	}*/
}

