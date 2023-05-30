package com.sample.services;

import java.util.List;

import com.sample.model.Item;

public interface ItemService {

	List<Item> getAllItems();
	public void save(Item anbar);
	Item getItemById(long id);
	public void deleteItemById(long id);




}
