package br.com.robbo.testeBackend.controller;

import br.com.robbo.testeBackend.model.Aluno;
import br.com.robbo.testeBackend.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
        Aluno aluno = service.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody Aluno aluno) {

        boolean success = service.save(aluno) != null;
        return ResponseEntity
                .status(success ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED)
                .body(success ? "Aluno salvo com sucesso" : "Falha ao salvar o Aluno");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno removido com sucesso!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Aluno aluno, @PathVariable Integer id) {

        Aluno alunoAtualizado = service.update(id, aluno);

        return ResponseEntity.
                status(alunoAtualizado != null ? HttpStatus.OK : HttpStatus.NOT_MODIFIED)
                .body(alunoAtualizado);
    }
}
