package com.sample.controllers;

import com.sample.model.Users;
import com.sample.repositories.ItemRepository;
import com.sample.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sample.model.Item;
import com.sample.services.ItemService;

import java.util.Date;

@Controller
public class ItemController {

	@Autowired
	private ItemService anbarService;
	@Autowired
	private ItemRepository anbarRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("listItems", anbarService.getAllItems());
		return "profile";
	}

	@RequestMapping("/newItemForm")
	public String newAnbarForm(Model model) {
		Item anbar = new Item();
		model.addAttribute("anbar", anbar);
		return "newAnbar";
	}

	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("anbar") Item anbar) {
		Date date = new Date();
		anbar.setDate(date);
		anbarService.save(anbar);
		return "redirect:/backtolist";
	}
	@RequestMapping("/findByCode")
	public String findByCode(){
		return "findByCode";
	}
	@GetMapping("/findByItemCode")
	public String findByItemCode(@RequestParam("item_code") String item_code, Model model)
	{
		System.out.println(item_code);
		Item anbar = anbarRepository.findByItemCode(item_code);
		model.addAttribute("anbar",anbar);
		return "findByCode";
	}

	@GetMapping("/updateItem/{id}")
	public String updateItem(@PathVariable(value="id") long id, Model model){

		Item anbar = anbarService.getItemById(id);
		model.addAttribute("anbar",anbar);
		return "updateAnbar";
	}
	
	@GetMapping("/deleteAnbar/{id}")
	public String deleteItem(@PathVariable(value="id") long id) {
		//delete method
		this.anbarService.deleteItemById(id);
		return "redirect:/backtolist";
	}
}
