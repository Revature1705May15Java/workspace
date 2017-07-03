package com.ex.dao;

import java.util.List;

import com.ex.domain.FlashCard;

public interface FlashCardDAO {
	
	public List<FlashCard> findAllFlashCards();
	
	public FlashCard findFlashCardByQuestion(String question);
	
	public void saveFlashCard(FlashCard flashCard);

	public FlashCard getFlashCardById(Integer id);
}
