package com.algaworks.algafood.domain.infrastructure.spec;

import com.algaworks.algafood.domain.model.Restaurante;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;


public class RestauranteComFreteGratisSpec implements Specification<Restaurante> {

    private static final long serialVersionUID = 1L;

    @Override
    public @Nullable Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query,
                                           CriteriaBuilder criteriaBuilder) {

        return criteriaBuilder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
    }
}
