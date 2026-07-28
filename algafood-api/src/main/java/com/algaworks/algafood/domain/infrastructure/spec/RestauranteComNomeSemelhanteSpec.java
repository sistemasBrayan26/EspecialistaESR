package com.algaworks.algafood.domain.infrastructure.spec;

import com.algaworks.algafood.domain.model.Restaurante;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante> {


    private String nome;


    @Override
    public @Nullable Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query,
                                           CriteriaBuilder criteriaBuilder) {

        return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
}
