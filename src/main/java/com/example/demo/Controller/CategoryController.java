package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Section;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.SectionService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SectionService sectionService;
	
	@GetMapping("/ListOfCategory.html")
	public String showAllCategory(Model model) {
		List<Category> categoryList =categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		return "/ListOfCategory.html";
	}
	//delete by id
	@GetMapping("/deleteCategoryById/{id}")
	public String deleteCategory(@PathVariable Integer id) {
		categoryService.deleteById(id);
		return "redirect:/ListOfCategory.html";
	}
	
	
	//Add Category to section table
	@GetMapping("/addCategory/add/{id}")
	public String addCategories(@PathVariable Integer id, Model model) {
		Section sectionId= sectionService.findById(id);
		model.addAttribute("sectionId",sectionId);
		return "addCategory";
	}
	
	@PostMapping("/addCategory/{id}")
	public String addCategory(@PathVariable Integer id ,@RequestParam("name") String name,@RequestParam("description") String description) {
		Section c=sectionService.findById(id);
		Category category=new Category();
		category.setName(name);
		category.setDescription(description);
		category.setSection(c);
		categoryService.insert(category);
		return "redirect:/ListOfCategory.html";
	}
	

	//find by Section id
	@GetMapping("/ListOfSubCategory/{id}")
	public String findBySectionId(@PathVariable Integer id, Model model) {
		List<Category> category= categoryService.findBySection(id);
		model.addAttribute("category", category);
		return "/ListOfSubCategory.html";
	}
}
