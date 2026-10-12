package com.taxseer_demo.Order;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

@Table("order_forms")
public class OrderForm {
    @Id
    private Long id;
    private Long orderId;
    private String formType;
    private String recipientName;
    private String tin;
    private BigDecimal box1Amount;
    private String status;
    private String issueDesc;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getFormType() { return formType; }
    public void setFormType(String formType) { this.formType = formType; }
    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }
    public String getTin() { return tin; }
    public void setTin(String tin) { this.tin = tin; }
    public BigDecimal getBox1Amount() { return box1Amount; }
    public void setBox1Amount(BigDecimal box1Amount) { this.box1Amount = box1Amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getIssueDesc() { return issueDesc; }
    public void setIssueDesc(String issueDesc) { this.issueDesc = issueDesc; }
}