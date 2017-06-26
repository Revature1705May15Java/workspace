package com.revature.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "REIMBURSEMENTREQUEST")
public class ReimbursementRequest {

    @Id
    @Column(name = "reimbursementrequestID")
    @SequenceGenerator(name = "REIMBURSEMENTREQUESTID_SEQ", sequenceName = "REIMBURSEMENTREQUESTID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REIMBURSEMENTREQUESTID_SEQ")
    int id;

    @Column(name = "requesterId", nullable = false)
    int requesterId;

    @Column(name = "handlerId")
    int handlerId;

    @Column(name = "status", nullable = false)
    String status;

    @Column(name = "amount", nullable = false)
    double amount;

    @Column(name = "purpose")
    String purpose;

    public ReimbursementRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public int getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
