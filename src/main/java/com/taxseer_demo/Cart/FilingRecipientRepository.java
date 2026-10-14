package com.taxseer_demo.Cart;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FilingRecipientRepository extends R2dbcRepository<FilingRecipient, Long> {
}
