package com.ers.pojos;

public class RequestState {
	/**
	 * Designates a pending request.
	 */
	private static final int PENDING = 1;
	/**
	 * Designates an approved request.
	 */
	private static final int APPROVED = 2;
	/**
	 * Designates a denied request.
	 */
	private static final int DENIED = 3;
	
	/**
	 * An integer that identifies the state of this request.
	 */
	private int requestId;
	/**
	 * The name of this request's current state.
	 */
	private String name;
	
	public RequestState(int requestId) {
		this.requestId = requestId;
		
		switch(requestId) {
			case PENDING:
				name = "Pending";
				break;
			case APPROVED:
				name = "Approved";
				break;
			case DENIED:
				name = "Denied";
				break;
		}
	}
	/**
	 * Creates a new {@code RequestState} with the given information.
	 * 
	 * @param requestId	An integer representation of the request's state.
	 * @param name		String representation of the request's state.
	 */
	public RequestState(int requestId, String name) {
		super();
		this.requestId = requestId;
		this.name = name;
	}

	/**
	 * Returns an integer representation of state of this request.
	 * Representations are as follows:
	 * <table>
	 * 	<tr>
	 * 		<th>State</th>
	 * 		<th>ID</th>
	 * 	</tr>
	 * 	<tr>
	 * 		<td>Pending</td>
	 * 		<td>1</td>
	 * 	</tr>
	 * 	<tr>
	 * 		<td>Approved</td>
	 * 		<td>2</td>
	 * 	</tr>
	 * 	<tr>
	 * 		<td>Denied</td>
	 * 		<td>3</td>
	 * 	</tr>
	 * </table>
	 * 
	 * @return	An integer representation of the request's state.
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * Sets this request state's ID number to the given integer.
	 * 
	 * @param requestId	The request's new ID number.
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	/**
	 * Returns this request state's name.
	 * 
	 * @return	The name of this state.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of this request's state to the given name.
	 * 
	 * @param name	This state request's new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
