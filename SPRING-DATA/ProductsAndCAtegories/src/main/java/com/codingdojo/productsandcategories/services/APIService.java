package com.codingdojo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class APIService {
	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;
	
	public APIService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	//Products
	public List<Product> findAllProducts() {
		return productRepo.findByOrderByName();
	}
	
	public List<Product> findAllProductsNotAssoc(Long categoryId) {
		return productRepo.findAllNotAssoc(categoryId);
	}
	
	public Product findOneProduct(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	
	//Categories
	public List<Category> findAllCategories() {
		return categoryRepo.findByOrderByName();
	}
	
	public List<Category> findAllCategoriesNotAssoc(Long productId) {
		return categoryRepo.findAllNotAssoc(productId);
	}
	
	public Category findOneCategory(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	// Join Methods
	public void addProductToCategory(Long productId, Long categoryId) {
		Optional<Product> product = productRepo.findById(productId);
		Optional<Category> category = categoryRepo.findById(categoryId);
		if (product.isPresent() && category.isPresent()) {
			List<Product> productList = category.get().getProducts();
			productList.add(product.get());
			category.get().setProducts(productList);
			categoryRepo.save(category.get());
		}
	}
	
	public void removeProductFromCategory(Long productId, Long categoryId) {
		Optional<Product> product = productRepo.findById(productId);
		Optional<Category> category = categoryRepo.findById(categoryId);
		if (product.isPresent() && category.isPresent()) {
			List<Product> productList = category.get().getProducts();
			productList.remove(product.get());
			category.get().setProducts(productList);
			categoryRepo.save(category.get());
//			List<Category> categoryList = product.get().getCategories();
//			categoryList.remove(category.get());
//			product.get().setCategories(categoryList);
//			productRepo.save(product.get());
		}
	}
}