package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Section;
import com.example.demo.Repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepository;
	

	public Integer count() {
		return (int) sectionRepository.count();
	}
	
	public List<Section> findAll(){
		return sectionRepository.findAll();
	}
	
	public Section findById(Integer id) {
		return sectionRepository.findById(id).get();
	}
	
	public void deleteById(Integer id) {
		sectionRepository.deleteById(id);
	}
	
	public Section insert(Section section) {
		return sectionRepository.save(section);
	}	
}
