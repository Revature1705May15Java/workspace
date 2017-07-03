package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.dao.FlashCardRepository;
import com.ex.domain.FlashCard;

@Service
@Transactional
public class FlashCardServiceImpl implements FlashCardService {
	
	@Autowired
	private FlashCardRepository flashCardRepository;
	
	@Override
	public void addFlashCard(FlashCard fc) {
		flashCardRepository.save(fc);
	}

	@Override
	public List<FlashCard> findAllFlashCards() {
		return flashCardRepository.findAll();
	}

	@Override
	public FlashCard findFlashCardByQuestion(String question) {
		return flashCardRepository.findByQuestion(question);
	}
	
}
