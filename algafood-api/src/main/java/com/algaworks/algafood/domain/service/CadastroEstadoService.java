package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Transactional
    public void excluir(Long id) {
        try {

            Estado estado = estadoRepository.findById(id).orElse(null);

            if (estado == null) {
                throw new EntidadeNaoEncontradaException(String.format("Estado de código %d não existe. ", id));
            }

            estadoRepository.delete(estado);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("O estado de código %d não pode ser excluida " +
                    "pois está vinculada a uma cidade. ", id));
        }
    }

}
