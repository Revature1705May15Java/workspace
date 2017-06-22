package com.revature.ers.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Request {

  private int id, requesterId, resolverId;
  private String requesterEmail, requesterFirstname, requesterLastname, resolverEmail, resolverFirstname, resolverLastname;
  private RequestState state;
  private BigDecimal amount;
  private LocalDateTime dateTimeRequested, dateTimeResolved;
  private String purpose, note;
  
  public Request() { super(); }

  public Request(int id, int requesterId, String requesterEmail, String requesterFirstname, String requesterLastname,
      RequestState state, BigDecimal amount, LocalDateTime dateTimeRequested, String purpose) {
    super();
    this.id = id;
    this.requesterId = requesterId;
    this.requesterEmail = requesterEmail;
    this.requesterFirstname = requesterFirstname;
    this.requesterLastname = requesterLastname;
    this.state = state;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.purpose = purpose;
  }

  public Request(int id, int requesterId, int resolverId, String requesterEmail, String requesterFirstname,
      String requesterLastname, String resolverEmail, String resolverFirstname, String resolverLastname,
      RequestState state, BigDecimal amount, LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved,
      String purpose, String note) {
    super();
    this.id = id;
    this.requesterId = requesterId;
    this.resolverId = resolverId;
    this.requesterEmail = requesterEmail;
    this.requesterFirstname = requesterFirstname;
    this.requesterLastname = requesterLastname;
    this.resolverEmail = resolverEmail;
    this.resolverFirstname = resolverFirstname;
    this.resolverLastname = resolverLastname;
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

  public String getRequesterEmail() {
    return requesterEmail;
  }

  public void setRequesterEmail(String requesterEmail) {
    this.requesterEmail = requesterEmail;
  }

  public String getRequesterFirstname() {
    return requesterFirstname;
  }

  public void setRequesterFirstname(String requesterFirstname) {
    this.requesterFirstname = requesterFirstname;
  }

  public String getRequesterLastname() {
    return requesterLastname;
  }

  public void setRequesterLastname(String requesterLastname) {
    this.requesterLastname = requesterLastname;
  }

  public String getResolverEmail() {
    return resolverEmail;
  }

  public void setResolverEmail(String resolverEmail) {
    this.resolverEmail = resolverEmail;
  }

  public String getResolverFirstname() {
    return resolverFirstname;
  }

  public void setResolverFirstname(String resolverFirstname) {
    this.resolverFirstname = resolverFirstname;
  }

  public String getResolverLastname() {
    return resolverLastname;
  }

  public void setResolverLastname(String resolverLastname) {
    this.resolverLastname = resolverLastname;
  }

  @Override
  public String toString() {
    return "Request [id=" + id + ", requesterId=" + requesterId + ", resolverId=" + resolverId + ", state=" + state
        + ", amount=" + amount + ", dateTimeRequested=" + dateTimeRequested + ", dateTimeResolved=" + dateTimeResolved
        + ", purpose=" + purpose + ", note=" + note + "]";
  }
  
}
