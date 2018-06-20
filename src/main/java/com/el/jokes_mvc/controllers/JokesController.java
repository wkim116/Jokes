package com.el.jokes_mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView index() {
		return new ModelAndView("redirect:/read");
	}
	
	@GetMapping("/read")
	public ModelAndView listJokes() {
		ModelAndView mv = new ModelAndView();
		List<Joke> jokes = jokeRepository.findAll();
		mv.addObject("jokes", jokes);
		mv.setViewName("read");
		return mv;
	}
	
	@GetMapping("/newJoke")
	public ModelAndView newJoke() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newJoke");
		return mv;
	}
	
	@PostMapping("/newJoke")	
	public ModelAndView newJoke(@RequestParam("joke") String joke, 
								@RequestParam("punchline") String punchline,
								@RequestParam("rating") int rating) {
		jokeRepository.save(new Joke(joke, punchline, rating));
		return new ModelAndView("redirect:/read");
	}
	
	@GetMapping("/deleteJoke")
	public ModelAndView deleteJoke(@RequestParam("id") int id) {
		jokeRepository.delete(id);
		return new ModelAndView("redirect:/read");
	}
	
	@GetMapping("/updateJoke")
	public ModelAndView updateJoke(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Joke joke = jokeRepository.findOne(id);
		
		mv.setViewName("updateJoke");
		
		mv.addObject("id", id);
		mv.addObject("joke", joke);
		return mv;
	}
	
	@PostMapping("/updateJoke")
	public ModelAndView updateJoke(@RequestParam("id") int id,
								   @RequestParam("newJoke") String newJoke,
								   @RequestParam("newPunchline") String newPunchline,
								   @RequestParam("newRating") int newRating)
	{
		Joke joke = jokeRepository.findOne(id);
		if(joke != null) {
			joke.setJoke(newJoke);
			joke.setPunchline(newPunchline);
			joke.setRating(newRating);
			jokeRepository.save(joke);
		}
		
		return new ModelAndView("redirect:/read");
	}
	
}
