package com.ayres.pessoas.model;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class PessoaModel {

	@Id
	@Column(name= "pessoa_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Schema(example = "email@email.com.br")
	private String nome;
	
	private LocalDate dataNascimento;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> endereco;

	public PessoaModel() {
		
	}

	public PessoaModel(Long id, String nome, LocalDate dataNascimento, List<Endereco> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
}
