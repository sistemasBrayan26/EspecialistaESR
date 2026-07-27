package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhas;

    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return cozinhas.save(cozinha);
    }

    @Transactional
    public void excluir(Long id) {
        try {


          cozinhas.deleteById(id);


        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Cozinha vinculada a um restaurante. ");
        }

    }

}
