package com.ex.ers.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REIMBURSEMENT_REQUEST")
public class ReimbursementRequest implements Serializable {
  
  private static final long serialVersionUID = 2990044923805766363L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="requestSeq")
  @SequenceGenerator(allocationSize=1, name="requestSeq", sequenceName="REQUEST_SEQ")
  @Column(name="REQUEST_ID")
  private int id;
  
  @Column(name="REQUEST_STATUS")
  private String status;
  
  @Column(name="REQUEST_AMOUNT")
  private BigDecimal amount;
  
  @Column(name="REQUEST_CREATION_TIMESTAMP")
  private LocalDateTime dateTimeRequested;
  
  @Column(name="REQUEST_RESOLUTION_TIMESTAMP")
  private LocalDateTime dateTimeResolved;
  
  @Column(name="REQUEST_PURPOSE")
  private String purpose;
  
  @Column(name="REQUEST_NOTE")
  private String note;
  
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="REQUESTER")
  private User requester;
  
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="RESOLVER")
  private User resolver;

  public ReimbursementRequest() {}

  public ReimbursementRequest(String status, BigDecimal amount, LocalDateTime dateTimeRequested, String purpose,
      User requester) {
    super();
    this.status = status;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.purpose = purpose;
    this.requester = requester;
  }

  public ReimbursementRequest(int id, String status, BigDecimal amount, LocalDateTime dateTimeRequested, String purpose,
      User requester) {
    super();
    this.id = id;
    this.status = status;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.purpose = purpose;
    this.requester = requester;
  }

  public ReimbursementRequest(String status, BigDecimal amount, LocalDateTime dateTimeRequested,
      LocalDateTime dateTimeResolved, String purpose, String note, User requester, User resolver) {
    super();
    this.status = status;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.dateTimeResolved = dateTimeResolved;
    this.purpose = purpose;
    this.note = note;
    this.requester = requester;
    this.resolver = resolver;
  }

  public ReimbursementRequest(int id, String status, BigDecimal amount, LocalDateTime dateTimeRequested,
      LocalDateTime dateTimeResolved, String purpose, String note, User requester, User resolver) {
    super();
    this.id = id;
    this.status = status;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.dateTimeResolved = dateTimeResolved;
    this.purpose = purpose;
    this.note = note;
    this.requester = requester;
    this.resolver = resolver;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public LocalDateTime getDateTimeRequested() {
    return dateTimeRequested;
  }

  public void setDateTimeRequested(LocalDateTime dateTimeRequested) {
    this.dateTimeRequested = dateTimeRequested;
  }

  public LocalDateTime getDateTimeResolved() {
    return dateTimeResolved;
  }

  public void setDateTimeResolved(LocalDateTime dateTimeResolved) {
    this.dateTimeResolved = dateTimeResolved;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public User getRequester() {
    return requester;
  }

  public void setRequester(User requester) {
    this.requester = requester;
  }

  public User getResolver() {
    return resolver;
  }

  public void setResolver(User resolver) {
    this.resolver = resolver;
  }

  @Override
  public String toString() {
    return "ReimbursementRequest [id=" + id + ", status=" + status + ", amount=" + amount + ", dateTimeRequested="
        + dateTimeRequested + ", dateTimeResolved=" + dateTimeResolved + ", purpose=" + purpose + ", note=" + note
        + ", requester=" + requester + ", resolver=" + resolver + "]";
  }

}
