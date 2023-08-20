package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Integer count() {
		return (int) itemRepository.count();
	}
	
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	public Item findById(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	public void deleteById(Integer id) {
		itemRepository.deleteById(id);
	}
	
	public Item insert(Item item) {
		return itemRepository.save(item);
	}	
	
	public List<Item> findByCategory(Integer id){
		
		return itemRepository.findItemByCategory(id);
	}
}
