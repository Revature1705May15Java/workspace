package com.revature.ers.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Request {

  private int id;
  private RequestState state;
  private BigDecimal amount;
  private String requesterEmail; 
  private String resolverEmail;
  private LocalDateTime dateTimeRequested, dateTimeResolved;
  private String purpose, note;
  
  public Request() { super(); }

  public Request(RequestState state, BigDecimal amount, String requesterEmail, String resolverEmail,
      LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved, String purpose, String note) {
    super();
    this.state = state;
    this.amount = amount;
    this.requesterEmail = requesterEmail;
    this.resolverEmail = resolverEmail;
    this.dateTimeRequested = dateTimeRequested;
    this.dateTimeResolved = dateTimeResolved;
    this.purpose = purpose;
    this.note = note;
  }

  public Request(int id, RequestState state, BigDecimal amount, String requesterEmail, String resolverEmail,
      LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved, String purpose, String note) {
    super();
    this.id = id;
    this.state = state;
    this.amount = amount;
    this.requesterEmail = requesterEmail;
    this.resolverEmail = resolverEmail;
    this.dateTimeRequested = dateTimeRequested;
    this.dateTimeResolved = dateTimeResolved;
    this.purpose = purpose;
    this.note = note;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public RequestState getState() {
    return state;
  }

  public void setState(RequestState state) {
    this.state = state;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getRequesterEmail() {
    return requesterEmail;
  }

  public void setRequesterEmail(String requesterEmail) {
    this.requesterEmail = requesterEmail;
  }

  public String getResolverEmail() {
    return resolverEmail;
  }

  public void setResolverEmail(String resolverEmail) {
    this.resolverEmail = resolverEmail;
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

  @Override
  public String toString() {
    return "Request [id=" + id + ", state=" + state + ", amount=" + amount + ", requesterEmail=" + requesterEmail
        + ", resolverEmail=" + resolverEmail + ", dateTimeRequested=" + dateTimeRequested + ", dateTimeResolved="
        + dateTimeResolved + ", purpose=" + purpose + ", note=" + note + "]";
  }

  
  
}
