package com.ers.pojos;

public class RequestState {
	/**
	 * Designates a pending request.
	 */
	public static final int PENDING = 1;
	/**
	 * Designates an approved request.
	 */
	public static final int APPROVED = 2;
	/**
	 * Designates a denied request.
	 */
	public static final int DENIED = 3;
	
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
	 * Returns this request state's name.
	 * 
	 * @return	The name of this state.
	 */
	public String getName() {
		return name;
	}
}
