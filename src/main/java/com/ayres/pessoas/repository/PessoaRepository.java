package com.ayres.pessoas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayres.pessoas.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{

	Optional<PessoaModel> save(Optional<PessoaModel> pessoaModel);
	

}
