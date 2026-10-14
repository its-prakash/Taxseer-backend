package com.taxseer_demo.Cart;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Table("cart")
public class Cart {

    @Id
    private Long id;

    @Column("filer_id")
    private Long filerId;

    @Column("filing_id")
    private Long filingId;

    @Column("total_amount")
    private BigDecimal totalAmount;

    @Column("item_status")
    private String itemStatus;

    @Column("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}