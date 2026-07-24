package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        return ResponseEntity.ok(estadoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorCodigo(@PathVariable Long id) {
        Estado estado = estadoRepository.findById(id).orElse(null);

        if (estado != null) {
            return ResponseEntity.ok(estado);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Estado> salvar(@RequestBody Estado estado) {
        return ResponseEntity.ok(cadastroEstadoService.salvar(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Estado estado, @PathVariable Long id) {
        Estado estadoAtual = estadoRepository.findById(id).orElse(null);

        if (estadoAtual == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(estado, estadoAtual, "id");
        return ResponseEntity.ok(estadoRepository.save(estadoAtual));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            cadastroEstadoService.excluir(id);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
