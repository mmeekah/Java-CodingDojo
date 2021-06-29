package com.mika.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mika.mvc.models.Book;
import com.mika.mvc.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable(value="id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable(value="id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable(value="id") Long id) {
		System.out.println("iS HERE!!!!!!!!!!!!!!!!!");
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}

