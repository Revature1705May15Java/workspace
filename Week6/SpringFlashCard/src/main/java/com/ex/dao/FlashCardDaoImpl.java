package com.ex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.domain.FlashCard;

@Service
@Transactional
public class FlashCardDaoImpl implements FlashCardDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@Override
	public List<FlashCard> findAllFlashCards() {
		System.out.println("findAllFlashCards");
		List<FlashCard> fcList = sessionFactory.getCurrentSession().createCriteria(FlashCard.class).list(); 
		return fcList;
	}

	@Override
	public FlashCard findFlashCardByQuestion(String question) {
		return null;
	}


	@Override
	@Transactional(readOnly=false)
	public void saveFlashCard(FlashCard fc) {
		Session session = sessionFactory.getCurrentSession();
		session.save(fc);
	}
	
	public FlashCard getFlashCardById(Integer id) {
		FlashCard fc = (FlashCard) sessionFactory.getCurrentSession().get(FlashCard.class, id);
		return fc;
	}

}
