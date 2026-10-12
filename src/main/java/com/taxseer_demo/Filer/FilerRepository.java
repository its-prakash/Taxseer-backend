package com.taxseer_demo.Filer;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilerRepository extends R2dbcRepository<Filers, Long> {
}
