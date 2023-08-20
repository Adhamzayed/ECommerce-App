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
import com.example.demo.Entity.Item;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ItemService;
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/ListOfItem.html")
	public String showAllItem(Model model) {
		List<Item> item =itemService.findAll();
		model.addAttribute("item", item);
		return "/ListOfItem.html";
	}
	//delete by id
	@GetMapping("/deleteItemById/{id}")
	public String deleteItem(@PathVariable Integer id) {
		itemService.deleteById(id);
		return "redirect:/ListOfItem.html";
	}
	
	
	//Add Item to Category table
	@GetMapping("/addItem/add/{id}")
	public String addItems(@PathVariable Integer id, Model model) {
		Category categoryId= categoryService.findById(id);
		model.addAttribute("categoryId",categoryId);
		return "addItem";
	}
	
	@PostMapping("/addItem/{id}")
	public String addItem(@PathVariable Integer id ,@RequestParam("itemName") String itemName,@RequestParam("description") String description,@RequestParam("price") Long price) {
		Category c=categoryService.findById(id);
		Item item=new Item();
		item.setItemName(itemName);
		item.setDescription(description);
		item.setPrice(price);
		item.setCategory(c);
		itemService.insert(item);
		return "redirect:/ListOfItem.html";
	}
	//find by Category id
	@GetMapping("/ListOfSubItem/{id}")
	public String findByCategoryId(@PathVariable Integer id, Model model) {
		List<Item> item= itemService.findByCategory(id);
		model.addAttribute("item", item);
		return "/ListOfSubItem.html";
	}
	
}
