package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService service;
	
	public SongController(SongService songService) {
		this.service=songService;
		
	}
	
	//RequestMappings
	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}
	
	@RequestMapping("/songs")
	public String dashboard(Model model) {
		List <Song> songs = service.all();
		model.addAttribute("songs", songs);
		return "/views/dashboard.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/views/new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/new.jsp";
		}else {
			service.create(song);
			return "redirect:/songs";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = service.find(id);
		if(song != null) {
			model.addAttribute("song", song);
			return "/views/show.jsp";
		}else {
			return "redirect:/songs";
		}
		
	}
	
	@RequestMapping("/songs/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("song") Song song, Model model) {
		Song tune = service.find(id);
		if(song != null) {
			model.addAttribute("tune", tune);
			return "/views/edit.jsp";
		}else {
			return "redirect:/songs";
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("song") Song song,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Song tune = service.find(id);
			model.addAttribute("tune", tune);
			return "/views/edit.jsp";
		} else {
			service.update(song);
			return "redirect:/songs/" + id;
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/songs";
	}
	
	@RequestMapping("/songs/artist")
	public String search(@RequestParam(value="query") String query, Model model) {
		List<Song> songs = service.findByArtist(query);
		model.addAttribute("songs", songs);
		return "/views/dashboard.jsp";
	}
	
	@RequestMapping("/songs/top")
	public String top(Model model) {
		List<Song> songs = service.findTopFive();
		model.addAttribute("songs", songs);
		return "/views/top.jsp";
	}
			
	
}
