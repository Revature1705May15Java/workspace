package com.ex.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.dao.Dao;
import com.ex.domain.FlashCard;

public class MainClass {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Dao dao = (Dao) applicationContext.getBean("mydao");
		
		List<FlashCard> fcList = dao.getAllFC();
		for(FlashCard temp : fcList){
			System.out.println(temp);
		}
				
		FlashCard javaQuestion = dao.getFlashCardById(4);
		System.out.println("\n\n"+javaQuestion+"\n\n");
		
//		
//		FlashCard newFC = new FlashCard(540,"Why is Spring awesome?110", "Because it integrates well and makes your life easier.");
//		dao.saveFC(newFC);
		
		
	}
}
