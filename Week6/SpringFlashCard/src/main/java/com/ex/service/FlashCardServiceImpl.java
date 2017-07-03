package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.dao.FlashCardDAO;
import com.ex.domain.FlashCard;

@Service
@Transactional
public class FlashCardServiceImpl implements FlashCardService {

	@Autowired
	private FlashCardDAO fcDao;
	
	@Override
	public void addFlashCard(FlashCard fc) {
		fcDao.saveFlashCard(fc);
	}

	@Override
	public List<FlashCard> findAllFlashCards() {
		return fcDao.findAllFlashCards();
	}

	@Override
	public FlashCard findFlashCardByQuestion(String question) {
		return fcDao.findFlashCardByQuestion(question);
	}
}
