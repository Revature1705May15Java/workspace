package com.ers.util;

import com.ers.pojos.RequestState;

//TODO: Find out if this is really a pool...
public final class RequestStatePool {
	/**
	 * Sole instance of a pending {@code RequestState} object.
	 */
	private static final RequestState PENDING_STATE = new RequestState(RequestState.PENDING);
	/**
	 * Sole instance of an approved {@code RequestState} object.
	 */
	private static final RequestState APPROVED_STATE = new RequestState(RequestState.APPROVED);
	/**
	 * Sole instance of a denied {@code RequestState} object.
	 */
	private static final RequestState DENIED_STATE = new RequestState(RequestState.DENIED);
	
	private RequestStatePool() {}
	
	/**
	 * Returns an instance of a {@code RequestState} with the given
	 * state ID number.
	 * 
	 * @param stateId	The ID number of the required {@code RequestState}
	 * @return	A {@code RequestState} that has the given state ID number, or
	 * 			{@code null} if no such state exists.
	 */
	public static RequestState getState(int stateId) {
		switch(stateId) {
			case RequestState.PENDING:
				return PENDING_STATE;
			case RequestState.APPROVED:
				return APPROVED_STATE;
			case RequestState.DENIED:
				return DENIED_STATE;
		}
		
		return null;
	}
}
