package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Cidade salvar (Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();

        Estado estado = estadoRepository.findById(estadoId).orElse(null);

        if (estado == null) {
            throw new EntidadeNaoEncontradaException(String.format("Não foi encontrado estado de c´codigo %d", estadoId));
        }

        cidade.setEstado(estado);
        return cidadeRepository.save(cidade);
    }

    @Transactional
    public void remover(Long cidadeId) {
        Cidade cidadeEncontrada = cidadeRepository.findById(cidadeId).orElse(null);

        if (cidadeEncontrada == null) {
            throw new EntidadeNaoEncontradaException(String.format("A cidade de código %d não foi encontrada. ", cidadeId));
        }

        cidadeRepository.delete(cidadeEncontrada);
    }
}
