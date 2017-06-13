package com.ers.util;

import com.ers.pojos.RequestState;

//TODO: Find out if this is really a pool...
public class RequestStatePool {
	private static final RequestState PENDING_STATE = new RequestState(RequestState.PENDING);
	private static final RequestState APPROVED_STATE = new RequestState(RequestState.APPROVED);
	private static final RequestState DENIED_STATE = new RequestState(RequestState.DENIED);
	
	private RequestStatePool() {}
	
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
