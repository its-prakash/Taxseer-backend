package com.taxseer_demo.Recipient;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRespository extends R2dbcRepository<Recipients, Long> {


}
