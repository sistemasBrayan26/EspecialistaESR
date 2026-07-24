package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @GetMapping
    public ResponseEntity<List<Cidade>> buscar() {
        return ResponseEntity.ok(cidadeRepository.findAll());
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscarPorCodigo(@PathVariable Long cidadeId) {
        Cidade cidadeEncontrada = cidadeRepository.findById(cidadeId).orElse(null);

        if (cidadeEncontrada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cidadeEncontrada);
    }

    @PostMapping
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroCidadeService.salvar(cidade));
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> editar(@RequestBody Cidade cidade, @PathVariable Long cidadeId) {
        Cidade cidadeAtual = cidadeRepository.findById(cidadeId).orElse(null);

        if (cidadeAtual == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(cidade, cidadeAtual, "id");
        return ResponseEntity.ok(cadastroCidadeService.salvar(cidadeAtual));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCidade(@PathVariable Long id) {
        try {

            cadastroCidadeService.remover(id);
            return ResponseEntity.noContent().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
