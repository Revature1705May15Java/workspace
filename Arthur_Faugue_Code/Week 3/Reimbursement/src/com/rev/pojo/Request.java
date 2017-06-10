package com.rev.pojo;

import java.sql.Date;

public class Request {
	int id, stateId, amount, reqId, resId;
	String purpose, note;
	Date reqDate, resDate;
	public Request(int id, int stateId, int amount, int reqId, int resId, String purpose, String note, Date reqDate,
			Date resDate) {
		super();
		this.id = id;
		this.stateId = stateId;
		this.amount = amount;
		this.reqId = reqId;
		this.resId = resId;
		this.purpose = purpose;
		this.note = note;
		this.reqDate = reqDate;
		this.resDate = resDate;
	}
	public Request() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
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
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", stateId=" + stateId + ", amount=" + amount + ", reqId=" + reqId + ", resId="
				+ resId + ", purpose=" + purpose + ", note=" + note + ", reqDate=" + reqDate + ", resDate=" + resDate
				+ "]";
	}
	
	
}