package com.ex.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.domain.FlashCard;
import com.ex.service.FlashCardService;

public class MainClass {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		FlashCardService flashCardService = (FlashCardService) applicationContext.getBean("flashCardServiceImpl");
		
		List<FlashCard> fcList = flashCardService.findAllFlashCards();
		
		for(FlashCard temp : fcList){
			System.out.println(temp);
		}
		
		System.out.println(flashCardService.findFlashCardByQuestion("What time is it?"));
		
		
//		flashCardService.addFlashCard(new FlashCard("What is Spring Data?1", "Really awesome."));
		
		
		
	}
}
