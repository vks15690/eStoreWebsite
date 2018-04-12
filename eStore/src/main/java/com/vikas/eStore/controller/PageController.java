package com.vikas.eStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vikas.eStoreBackend.dao.CategoryDAO;
import com.vikas.eStoreBackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	// it will run by default and when clicked on eStore logo...
	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("title", "Home");
		
		// passing the list of categories from database to homepage..
		modelAndView.addObject("categories", categoryDAO.list());
		
		// this will be called from index.html when home button will be clicked...
		modelAndView.addObject("userClickHome", true);
		return modelAndView;
	}
	
	@RequestMapping(value = "/demoList")
	public ModelAndView showAllCategories() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("title", "All Categories");
		
		// passing the list of categories from database to homepage..
		modelAndView.addObject("categories", categoryDAO.list());
		
		// this will be called from index.html when home button will be clicked...
		modelAndView.addObject("userClickCategory", true);
		return modelAndView;
	}
	
	@RequestMapping(value = "/show/category/{id}/collection")
	public ModelAndView showCategoryCollection(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("index");
		
		// to fetch a single category from categoryDAO...
		Category category = null;
		category = categoryDAO.getId(id);
		modelAndView.addObject("title", category.getName());
		
		// passing the list of categories...
		modelAndView.addObject("categories", categoryDAO.list());
		
		// passing the single category objects...
		modelAndView.addObject("category", category);
		
		modelAndView.addObject("userClickCategoryProducts", true);
		return modelAndView;
	}

	// @RequestParam...
	// @RequestMapping(value="/test")
	// public ModelAndView testing(@RequestParam("key") String value) {
	// ModelAndView modelAndView = new ModelAndView("test");
	// if (value == null) {
	// value = "Testing @RequestParam...";
	// }
	// modelAndView.addObject("title", "Test");
	// return modelAndView;
	// }
	
	// @PathVariable...
	// @RequestMapping(value="/test/{key}")
	// public ModelAndView testing(@PathVariable("key") String value) {
	// ModelAndView modelAndView = new ModelAndView("test");
	// if (value == null) {
	// value = "Testing @PathVariable...";
	// }
	// modelAndView.addObject("title", "Test");
	// return modelAndView;
	// }

	
	// it will run when we click on contact us in footer...
	@RequestMapping(value = "/contact-us")
	public ModelAndView contactUs() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("title", "Contact Us");
		// this will be called from index.html when contact us will be clicked...
		modelAndView.addObject("userClickContactUs", true);
		return modelAndView;
	}

	// it will run when we click on about us in footer...
	@RequestMapping(value = "/about-us")
	public ModelAndView aboutUs() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("title", "About us");
		// this will be called from index.html when about us will be clicked...
		modelAndView.addObject("userClickAboutUs", true);
		return modelAndView;
	}
}
