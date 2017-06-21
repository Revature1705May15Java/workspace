package com.ers.pojos;

import java.time.LocalDate;

/**
 * This class will contain the information about a request
 * @author Gian-Carlo
 *
 */
public class Request {
	private int requestId;
	private int employeeId;
	private StateType type;
	private double amount;
	private LocalDate openDate;
	private LocalDate closeDate;
	private String purpose;
	private int managerId;
	private String managerNote;
	
	/**
	 * No-args constructor
	 */
	public Request() {
		super();
		this.requestId = 0;
		this.employeeId = 0;
		this.type = null;
		this.amount = 0;
		this.openDate = null;
		this.closeDate = null;
		this.purpose = "";
		this.managerId = 0;
		this.managerNote = "";
	}
	
	/**
	 * All fields constructor
	 * @param requestId
	 * @param employeeId
	 * @param type
	 * @param amount
	 * @param openDate
	 * @param closeDate
	 * @param purpose
	 * @param managerId
	 * @param managerNote
	 */
	public Request(int requestId, int employeeId, StateType type, double amount, LocalDate openDate,
			LocalDate closeDate, String purpose, int managerId, String managerNote) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.type = type;
		this.amount = amount;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.purpose = purpose;
		this.managerId = managerId;
		this.managerNote = managerNote;
	}
	
	/**
	 * Gets the requestId
	 * @return the request id
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * Sets the requestId to a specific value
	 * @param requestId, the new request id
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	/**
	 * Gets the employeeId
	 * @return the employee id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employeeId
	 * @param employeeId, the employee id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the state type of the request
	 * @return the state type
	 */
	public StateType getType() {
		return type;
	}

	/**
	 * Sets the state type of a request
	 * @param type, the state type
	 */
	public void setType(StateType type) {
		this.type = type;
	}

	/**
	 * Gets the amount of the request
	 * @return the amount of the request
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of the request
	 * @param amount, the amount of the request
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the date at which the request was submitted
	 * @return the date the request was submitted
	 */
	public LocalDate getOpenDate() {
		return openDate;
	}

	/**
	 * Sets the date at which the request was submitted
	 * @param openDate, the date the request was submitted
	 */
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	/**
	 * Gets the date at which the request was approved or denied
	 * @return the date the request was closed
	 */
	public LocalDate getCloseDate() {
		return closeDate;
	}

	/**
	 * Sets the date at whih the request was approved or denied
	 * @param closeDate, the date the request was closed
	 */
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * Gets the purpose for the request
	 * @return the request's purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * Sets the request's purpose
	 * @param purpose, the request's purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * Gets the id of the manager that approved or denied the request
	 * @return the manager's id
	 */
	public int getManagerId() {
		return managerId;
	}

	/**
	 * Sets the id of the manager that will take care of the request
	 * @param managerId, the manager's id
	 */
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	
	/**
	 * Get the manager's note
	 * @return the manager's note
	 */
	public String getManagerNote() {
		return managerNote;
	}

	/**
	 * Set the manager's note
	 * @param managerNote, the manager's note
	 */
	public void setManagerNote(String managerNote) {
		this.managerNote = managerNote;
	}

	/**
	 * Returns the attributes of the Request as a String.
	 * @return a string representation of the request
	 */
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", type=" + type + ", amount="
				+ amount + ", openDate=" + openDate + ", closeDate=" + closeDate + ", purpose=" + purpose
				+ ", managerId=" + managerId + ", managerNote=" + managerNote + "]";
	}
	
	
	
}
