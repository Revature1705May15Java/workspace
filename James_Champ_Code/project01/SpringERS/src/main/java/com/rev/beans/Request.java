package com.rev.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.rev.beans.status.RequestStatus;

@Component
@Entity
@Table(name="REQUEST_TABLE")
public class Request implements Serializable{
	private static final long serialVersionUID = -7641500695486401542L;

	@Id
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="STATUS")
	private RequestStatus status;
	
	@Column(name="NOTE")
	private String note;

	public Request() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
