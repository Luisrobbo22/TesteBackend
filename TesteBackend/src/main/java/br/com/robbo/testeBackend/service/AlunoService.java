package br.com.robbo.testeBackend.service;

import br.com.robbo.testeBackend.model.Aluno;
import br.com.robbo.testeBackend.repository.AlunoRepositoy;
import br.com.robbo.testeBackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepositoy alunoRepositoy;

    public Aluno findById(Integer id) {
        Optional<Aluno> aluno = alunoRepositoy.findById(id);
        return aluno.orElseThrow(() -> new ObjectNotFoundException(
                "Aluno não encontrado! ID: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    public List<Aluno> findAll() {
        return alunoRepositoy.findAll();
    }

    public Aluno save(Aluno aluno) {
        aluno = alunoRepositoy.saveAndFlush(aluno);
        return aluno;
    }

    public void deleteById(Integer id) {

        alunoRepositoy.delete(findById(id));
    }

    public Aluno update(int id, Aluno alunoUpdated) {

        Aluno aluno = findById(id);

        if (aluno != null) {

            aluno.setIdade(alunoUpdated.getIdade());
            aluno.setNome(alunoUpdated.getNome());
            alunoRepositoy.save(aluno);
        }

        return aluno;
    }
}
