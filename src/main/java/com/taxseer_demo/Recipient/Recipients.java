package com.taxseer_demo.Recipient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("recipients")
@lombok.Getter
@lombok.Setter
public class Recipients {
    @Id
    private Long id;
    private Long filer;
    private String type;        // SSN | EIN | Unknown
    private String tin;
    private String first;       // nullable
    private String middle;      // nullable
    private String last;        // nullable
    private String biz;         // nullable
    private String dba;         // nullable
    private String country;     // nullable
    private String addr;
    private String addr2;       // nullable
    private String city;
    private String st;
    private String zip;
    private String email;
    private Boolean econsent;   // nullable

    @Column("w9_status")
    private String w9;          // Submitted | Requested | Not requested

    @Column("w9_sent")
    private String sent;        // nullable — ISO date string

    @Column("w9_got")
    private String got;         // nullable — ISO date string

    @Column("w9_rem")
    private Integer rem;
}