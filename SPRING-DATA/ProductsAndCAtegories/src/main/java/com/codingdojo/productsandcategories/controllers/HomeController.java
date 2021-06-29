package com.codingdojo.productsandcategories.controllers;

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

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.APIService;

@Controller
public class HomeController {
	private APIService api;
	
	public HomeController(APIService api) {
		this.api = api;
	}
	
	//Mapping
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/products")
	public String productIndex(Model model) {
		List<Product> products = api.findAllProducts();
		model.addAttribute("products", products);
		return "/products/index.jsp";
	}
	
	@RequestMapping("/categories")
	public String categoryIndex(Model model) {
		List<Category> categories = api.findAllCategories();
		model.addAttribute("categories", categories);
		return "/categories/index.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String createProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			api.createProduct(product);
			return "redirect:/products";
		}
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCategory(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			api.createCategory(category);
			return "redirect:/categories";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = api.findOneProduct(id);
		List<Category> categories = api.findAllCategoriesNotAssoc(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "/products/show.jsp";
	}	
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = api.findOneCategory(id);
		List<Product> products = api.findAllProductsNotAssoc(id);
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "/categories/show.jsp";
	}
	
	@RequestMapping(value="/addProductToCategory/{productId}", method=RequestMethod.POST)
	public String addProductToCategory(
			@PathVariable("productId") Long productId,
			@RequestParam(name="categoryId") Long categoryId) {
		api.addProductToCategory(productId, categoryId);
		return "redirect:/products/" + productId;
	}
	
	@RequestMapping(value="/addCategoryToProduct/{categoryId}", method=RequestMethod.POST)
	public String addCategoryToProduct(
			@PathVariable("categoryId") Long categoryId,
			@RequestParam(name="productId") Long productId) {
		api.addProductToCategory(productId, categoryId);
		return "redirect:/categories/" + categoryId;
	}
	
	@RequestMapping("/removeCategoryFromProduct/{productId}/{categoryId}")
	public String removeCategoryFromProduct(
			@PathVariable("productId") Long productId,
			@PathVariable("categoryId") Long categoryId) {
		api.removeProductFromCategory(productId, categoryId);
		return "redirect:/products/" + productId;
	}
	
	@RequestMapping("/removeProductFromCategory/{categoryId}/{productId}")
	public String removeProductFromCategory(
			@PathVariable("productId") Long productId,
			@PathVariable("categoryId") Long categoryId) {
		api.removeProductFromCategory(productId, categoryId);
		return "redirect:/categories/" + categoryId;
	}
}
