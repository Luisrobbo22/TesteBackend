package br.com.robbo.testeBackend.repository;

import br.com.robbo.testeBackend.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositoy  extends JpaRepository<Aluno, Integer> {

}
