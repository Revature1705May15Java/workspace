package com.revature.ers.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Request {

  private int id, requesterId, resolverId;
  private RequestState state;
  private BigDecimal amount;
  private LocalDateTime dateTimeRequested, dateTimeResolved;
  private String purpose, note;
  
  public Request() { super(); }

  public Request(int requesterId, RequestState state, BigDecimal amount, LocalDateTime dateTimeRequested,
      String purpose) {
    super();
    this.requesterId = requesterId;
    this.state = state;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.purpose = purpose;
  }

  public Request(int requesterId, int resolverId, RequestState state, BigDecimal amount,
      LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved, String purpose, String note) {
    super();
    this.requesterId = requesterId;
    this.resolverId = resolverId;
    this.state = state;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.dateTimeResolved = dateTimeResolved;
    this.purpose = purpose;
    this.note = note;
  }
  
  public Request(int id, int requesterId, int resolverId, RequestState state, BigDecimal amount,
      LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved, String purpose, String note) {
    super();
    this.id = id;
    this.requesterId = requesterId;
    this.resolverId = resolverId;
    this.state = state;
    this.amount = amount;
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

  public int getRequesterId() {
    return requesterId;
  }

  public void setRequesterId(int requesterId) {
    this.requesterId = requesterId;
  }

  public int getResolverId() {
    return resolverId;
  }

  public void setResolverId(int resolverId) {
    this.resolverId = resolverId;
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
    return "Request [id=" + id + ", requesterId=" + requesterId + ", resolverId=" + resolverId + ", state=" + state
        + ", amount=" + amount + ", dateTimeRequested=" + dateTimeRequested + ", dateTimeResolved=" + dateTimeResolved
        + ", purpose=" + purpose + ", note=" + note + "]";
  }
  
}
