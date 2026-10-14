package com.taxseer_demo.Cart;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Setter
@Getter
@Table("filings")
public class Filing {

    @Id
    private Long id;

    @Column("filer_id")
    private Long filerId;

    @Column("filer_name")
    private String filerName;

    private String ein;

    @Column("tax_year")
    private String taxYear;

    @Column("form_type")
    private String formType;

    @Column("total_forms")
    private Integer totalForms;

    @Column("total_box1")
    private BigDecimal totalBox1;

    @Column("total_federal_withheld")
    private BigDecimal totalFederalWithheld;
}