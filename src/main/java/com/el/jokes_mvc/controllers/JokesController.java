package com.el.jokes_mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.el.jokes_mvc.models.Joke;
import com.el.jokes_mvc.repositories.JokeRepository;

@Controller
public class JokesController {
	
	@Autowired
	private JokeRepository jokeRepository;

	public JokesController() {
		
	}
	
	@GetMapping("/")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		List<Joke> jokes = jokeRepository.findAll();
		mv.addObject("jokes", jokes);
		mv.setViewName("read");
		return mv;
	}

}
