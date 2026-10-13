package com.taxseer_demo.Recipient;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RecipientRespository extends R2dbcRepository<Recipients, Long> {
    Flux<Recipients> findByFiler(String filer);

}
