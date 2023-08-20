package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;

@Service
public class CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Integer count() {
		return (int) categoryRepository.count();
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Integer id) {
		return categoryRepository.findById(id).get();
	}
	
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	public Category insert(Category category) {
		return categoryRepository.save(category);
	}	
	
	public List<Category> findBySection(Integer id){
		
		return categoryRepository.findCategoryBySection(id);
	}

}
