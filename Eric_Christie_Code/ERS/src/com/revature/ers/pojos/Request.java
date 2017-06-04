package com.revature.ers.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Request {

  private int id;
  private RequestState state;
  private String requesterEmail, resolverEmail;
  private BigDecimal amount;
  private LocalDateTime dateTimeRequested, dateTimeResolved;
  private String purpose, note;
  
  public Request() { super(); }

  public Request(RequestState state, String requesterEmail, String resolverEmail, BigDecimal amount,
      LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved, String purpose, String note) {
    super();
    this.state = state;
    this.requesterEmail = requesterEmail;
    this.resolverEmail = resolverEmail;
    this.amount = amount;
    this.dateTimeRequested = dateTimeRequested;
    this.dateTimeResolved = dateTimeResolved;
    this.purpose = purpose;
    this.note = note;
  }

  public Request(int id, RequestState state, String requesterEmail, String resolverEmail, BigDecimal amount,
      LocalDateTime dateTimeRequested, LocalDateTime dateTimeResolved, String purpose, String note) {
    super();
    this.id = id;
    this.state = state;
    this.requesterEmail = requesterEmail;
    this.resolverEmail = resolverEmail;
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
  

  public RequestState getState() {
    return state;
  }
  

  public void setState(RequestState state) {
    this.state = state;
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
    return "Request [id=" + id + ", state=" + state + ", requesterEmail=" + requesterEmail + ", resolverEmail="
        + resolverEmail + ", amount=" + amount + ", dateTimeRequested=" + dateTimeRequested + ", dateTimeResolved="
        + dateTimeResolved + ", purpose=" + purpose + ", note=" + note + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((dateTimeRequested == null) ? 0 : dateTimeRequested.hashCode());
    result = prime * result + ((dateTimeResolved == null) ? 0 : dateTimeResolved.hashCode());
    result = prime * result + id;
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
    result = prime * result + ((requesterEmail == null) ? 0 : requesterEmail.hashCode());
    result = prime * result + ((resolverEmail == null) ? 0 : resolverEmail.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Request other = (Request) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (dateTimeRequested == null) {
      if (other.dateTimeRequested != null)
        return false;
    } else if (!dateTimeRequested.equals(other.dateTimeRequested))
      return false;
    if (dateTimeResolved == null) {
      if (other.dateTimeResolved != null)
        return false;
    } else if (!dateTimeResolved.equals(other.dateTimeResolved))
      return false;
    if (id != other.id)
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
      return false;
    if (purpose == null) {
      if (other.purpose != null)
        return false;
    } else if (!purpose.equals(other.purpose))
      return false;
    if (requesterEmail == null) {
      if (other.requesterEmail != null)
        return false;
    } else if (!requesterEmail.equals(other.requesterEmail))
      return false;
    if (resolverEmail == null) {
      if (other.resolverEmail != null)
        return false;
    } else if (!resolverEmail.equals(other.resolverEmail))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    return true;
  }
  
}
