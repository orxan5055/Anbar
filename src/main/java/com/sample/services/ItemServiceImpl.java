package com.sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Item;
import com.sample.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository anbarRepository;
	@Autowired
	private ItemService anbarService;

	@Override
	public List<Item> getAllItems() {
		return anbarRepository.findAll();
	}

	@Override
	public void save(Item student) {
		this.anbarRepository.save(student);
		
	}

	@Override
	public Item getItemById(long id) {
		Optional<Item> optional = anbarRepository.findById(id);
		Item student = null;
		if(optional.isPresent()) {
			student=optional.get();
		}else
		{
			throw new RuntimeException("Item has not been founded");
		}
		return student;
	}

	@Override
	public void deleteItemById(long id) {
		this.anbarRepository.deleteById(id);
		
	}


	public Item findByItemCode(String item_code) {
		return anbarRepository.findByItemCode(item_code);
	}


}
