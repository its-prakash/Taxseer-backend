package com.taxseer_demo.Cart;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Setter
@Getter
@Table("filing_recipients")
public class FilingRecipient {

    @Id
    private Long id;

    @Column("filing_id")
    private Long filingId;

    @Column("recipient_id")
    private Long recipientId;

    private String name;
    private String tin;

    private BigDecimal box1;
    private BigDecimal box4;
    private String box6;

    @Column("delivery_method")
    private String deliveryMethod;

    private String status;
}