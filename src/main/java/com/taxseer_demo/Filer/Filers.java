package com.taxseer_demo.Filer;

import lombok.Getter;
import lombok.Setter;
import org.apache.el.stream.StreamELResolverImpl;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Setter
@Getter
@Table("filers")
public class Filers {

    @Id
    private Long id;
    private String name;
    private String ein;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String stateNo;
    private LocalDate date;

    private String form_used;    // Added from DB (text)
    private Integer recent; // Added from DB (integer)
    private Integer pending;// Added from DB (integer)
    private Integer filed;  // Added from DB (integer)
    private String warn;    // Added from DB (text)




}
