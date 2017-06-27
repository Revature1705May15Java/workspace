package com.ex.dao;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;

public interface Dao {

	/* (non-Javadoc)
	 * @see com.ex.dao.Dao#addUser(com.ex.pojos.User)
	 */
	void addUser(User u);

	/* (non-Javadoc)
	 * @see com.ex.dao.Dao#addReimbursement(com.ex.pojos.Reimbursement)
	 */
	void addReimbursement(Reimbursement r);

}