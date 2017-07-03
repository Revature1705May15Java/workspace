package com.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ex.domain.FlashCard;
import com.ex.service.FlashCardService;

@Controller
public class FlashCardController {
	
	@Autowired
	private FlashCardService flashCardService;
	

	@RequestMapping(value="viewAll")
	public ModelAndView viewAllFlashCards(){
		System.out.println("viewAll");
		return new ModelAndView("showFlashCards", "fcList", flashCardService.findAllFlashCards());
	}
	
	@RequestMapping(value="viewOne/{question}")
	public String viewOneFlashCard(@PathVariable String question, HttpServletRequest req){
		System.out.println(question + "-question in url");
		FlashCard fc = flashCardService.findFlashCardByQuestion(question);
		HttpSession session = req.getSession();
		session.setAttribute("fc", fc);

		return "showFlashCardByQuestion";
	}
	
	@RequestMapping(value="add")
	public ModelAndView redirectInsertFlashCard(FlashCard flashCard){
		flashCardService.addFlashCard(flashCard);
		return viewAllFlashCards();
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String insertFlashCard(@Valid FlashCard flashcard, BindingResult bindingResult, @ModelAttribute("question") ModelMap modelMap,  HttpServletRequest request ){
		System.out.println("add - post");
		if(bindingResult.hasErrors()){
			//ASSERT: validation failed
			System.out.println("Error hit and returning!");
			return "redirect:home";
		}
		//ASSERT: validation successful
		
		System.out.println(flashcard + "- flashcard add -post");
		
		flashCardService.addFlashCard(flashcard);
		modelMap.addAttribute("flashcard", flashcard);
		return "redirect:viewAll";
	}
	
	
	@RequestMapping(value="home")
	public String home(ModelMap modelMap ){
		FlashCard flashcard = new FlashCard();
		modelMap.addAttribute("flashcard", flashcard);
		return "home";
	}
	
	
}
