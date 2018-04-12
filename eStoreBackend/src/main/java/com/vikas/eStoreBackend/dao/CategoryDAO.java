package com.vikas.eStoreBackend.dao;

import java.util.List;

import com.vikas.eStoreBackend.dto.Category;

public interface CategoryDAO {
	
	public abstract List<Category> list();
	public abstract Category getId(int id);

	// CRUD operations...
	public abstract boolean add(Category category);
	public abstract boolean delete(Category category);
	public abstract boolean update(Category category);
	
}
