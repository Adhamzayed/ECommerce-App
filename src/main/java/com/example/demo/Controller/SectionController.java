package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Section;
import com.example.demo.Service.SectionService;

@Controller
public class SectionController {

	@Autowired
	private SectionService sectionService;
	
	@GetMapping("/ListOfSection.html")
	public String listOfSection(Model model) {
		List<Section> section=sectionService.findAll();
		model.addAttribute("section",section);
		return"/ListOfSection.html";
	}
	
	@GetMapping("/addSection.html")
	public String addtoSection() {
		return "/addSection";
	}
	@PostMapping("/addSection")
	public String addSection(@RequestParam("sectionName") String sectionName,@RequestParam("description") String description,@RequestParam("test") String test) {
		Section section =new Section();
		section.setSectionName(sectionName);
		section.setDescription(description);
		sectionService.insert(section);
		return"redirect:/ListOfSection.html";
	}
	
	//delete by id
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Integer id) {
		sectionService.deleteById(id);
		return "redirect:/ListOfSection.html";
	}
	
	//Add Sub Category
//	@GetMapping("/addCategory/add/{id}")
//	public String addCategories(@PathVariable Integer id, Model model) {
//		model.addAttribute("SectionId", sectionService.findById(id));
//		return "addCategory.html";
//	}
}
