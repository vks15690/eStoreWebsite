package com.vikas.eStoreBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vikas.eStoreBackend.dao.CategoryDAO;
import com.vikas.eStoreBackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;	
	
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init( ) {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.vikas.eStoreBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//
//		category.setName("Brands");
//		category.setDescription("Top Brands");
//		category.setImageURL("5.jpg");
//
//		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
//	}

//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.getId(2);
//		assertEquals("Successfully get the category from the table", "Kids", category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.getId(2);
//		category.setName("Others");
//		assertEquals("Successfully updated a category in database", true, categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.getId(1);
//		assertEquals("Successfully delete a category in database", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		assertEquals("Successfully fetched active categories from table",3, categoryDAO.list().size());
//	}
	
	// all in a single test case...
	public void testCRUDCategory() {
		// add operation..
		category.setName("Men");
		category.setDescription("Men Collection");
		category.setImageURL("2.jpg");
		assertEquals("Successfully added a category", true, categoryDAO.add(category));
		
		category.setName("Kids");
		category.setDescription("Kids Collection");
		category.setImageURL("3.jpg");
		assertEquals("Successfully added a category", true, categoryDAO.add(category));
		
		// fetch and update operation...
		category = categoryDAO.getId(3);
		category.setName("Change");
		assertEquals("Successfully added a category", "Brands", categoryDAO.update(category));
		
		// delete the category...
		assertEquals("Successfully deleted a category", true, categoryDAO.delete(category));
		
		// fetching the list...
		assertEquals("Successfully fetching the list",1,categoryDAO.list().size());
	}
	
}
