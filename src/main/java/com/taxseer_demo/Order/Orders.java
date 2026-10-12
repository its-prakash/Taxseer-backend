package com.taxseer_demo.Order;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

@Table("orders")
@lombok.Getter
@lombok.Setter
public class Orders {
    @Id
    private Long id;
    private String orderNo;
    private String filer;
    private String placed;
    private String taxYear;
    private BigDecimal amount;
    private String status;
    private Integer rejections;
    private String copiesStatus;
    private String filesStatus;

    // Add this field for the Forms column count
    private Integer forms;
}