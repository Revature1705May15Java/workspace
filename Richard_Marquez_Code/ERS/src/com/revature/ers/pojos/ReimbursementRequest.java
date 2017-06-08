package com.revature.ers.pojos;

import java.time.LocalDate;

public class ReimbursementRequest implements Comparable {
    int id;
    Integer requesterId;
    String requesterEmail;
    String handlerEmail;
    StateType state;
    double amount;
    String purpose;
    String note;
    LocalDate dateRequested;
    LocalDate dateResolved;
    public ReimbursementRequest() {
    }
    public ReimbursementRequest(int id, Integer requester, String handler, int stateTypeId, double amount, String purpose, String note, LocalDate dateRequested, LocalDate dateResolved) {
        this.id = id;
        this.requesterId = requester;
        this.handlerEmail = handler;

        this.state = StateType.values()[stateTypeId];

        this.amount = amount;
        this.purpose = purpose;
        this.note = note;
        this.dateRequested = dateRequested;
        this.dateResolved = dateResolved;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Integer requesterId) {
        this.requesterId = requesterId;
    }

    public String getHandlerEmail() {
        return handlerEmail;
    }

    public void setHandlerEmail(String handlerEmail) {
        this.handlerEmail = handlerEmail;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(LocalDate dateRequested) {
        this.dateRequested = dateRequested;
    }

    public LocalDate getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(LocalDate dateResolved) {
        this.dateResolved = dateResolved;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "id=" + id +
                ", requesterId=" + requesterId +
                ", handlerEmail=" + handlerEmail +
                ", state=" + state +
                ", amount=" + amount +
                ", purpose='" + purpose + '\'' +
                ", note='" + note + '\'' +
                ", dateRequested=" + dateRequested +
                ", dateResolved=" + dateResolved +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ReimbursementRequest p = (ReimbursementRequest) o;

        if (getDateResolved() != null) {
            if (p.getDateResolved() != null) {
                return getDateResolved().compareTo(p.getDateResolved());
            } else {
                return -1;
            }
        } else {
            return getDateRequested().compareTo(p.getDateRequested());
        }
    }

    public enum StateType {
        PENDING,
        APPROVED,
        DENIED
    }
}
