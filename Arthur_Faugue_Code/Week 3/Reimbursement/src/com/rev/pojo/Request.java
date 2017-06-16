package com.rev.pojo;

import java.sql.Date;

public class Request {
	int id, stateId, reqId, resId;
	double  amount;
	String purpose, note, reqFn, reqLn, resFn, resLn;
	Date reqDate, resDate;
	
	
	public Request(int id, int stateId, int reqId, int resId, double amount, String purpose, String note, String reqFn,
			String reqLn, String resFn, String resLn, Date reqDate, Date resDate) {
		super();
		this.id = id;
		this.stateId = stateId;
		this.reqId = reqId;
		this.resId = resId;
		this.amount = amount;
		this.purpose = purpose;
		this.note = note;
		this.reqFn = reqFn;
		this.reqLn = reqLn;
		this.resFn = resFn;
		this.resLn = resLn;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
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
	public String getReqFn() {
		return reqFn;
	}
	public void setReqFn(String reqFn) {
		this.reqFn = reqFn;
	}
	public String getReqLn() {
		return reqLn;
	}
	public void setReqLn(String reqLn) {
		this.reqLn = reqLn;
	}
	public String getResFn() {
		return resFn;
	}
	public void setResFn(String resFn) {
		this.resFn = resFn;
	}
	public String getResLn() {
		return resLn;
	}
	public void setResLn(String resLn) {
		this.resLn = resLn;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", stateId=" + stateId + ", reqId=" + reqId + ", resId=" + resId + ", amount="
				+ amount + ", purpose=" + purpose + ", note=" + note + ", reqFn=" + reqFn + ", reqLn=" + reqLn
				+ ", resFn=" + resFn + ", resLn=" + resLn + ", reqDate=" + reqDate + ", resDate=" + resDate + "]";
	}
	
}
