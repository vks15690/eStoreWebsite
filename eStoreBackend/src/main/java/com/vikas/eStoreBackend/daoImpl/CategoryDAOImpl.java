package com.vikas.eStoreBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vikas.eStoreBackend.dao.CategoryDAO;
import com.vikas.eStoreBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category..
		category.setId(1);
		category.setName("Women");
		category.setDescription("Women Collection");
		category.setImageURL("1.jpg");
		categories.add(category);

		// adding second category..
		category.setId(2);
		category.setName("Men");
		category.setDescription("Men Collection");
		category.setImageURL("2.jpg");
		categories.add(category);

		// adding third category..
		category.setId(3);
		category.setName("Kids");
		category.setDescription("Kids Collection");
		category.setImageURL("3.jpg");
		categories.add(category);

		// adding fourth category..
		category.setId(4);
		category.setName("Home and Living");
		category.setDescription("Home and Living");
		category.setImageURL("4.jpg");
		categories.add(category);

		// adding fifth category..
		category.setId(5);
		category.setName("Brands");
		category.setDescription("Top Brands");
		category.setImageURL("5.jpg");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// getting the list of all active categories...
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	// getting single category based on id...
	@Override
	public Category getId(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	// adding a category to database...
	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// deleting a single category...
//	@Override
//	public boolean delete(Category category) {
//		try {
//			sessionFactory.getCurrentSession().delete(category);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
		// making a category inactive...
		@Override
		public boolean delete(Category category) {
			category.setActive(false);
			try {
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

	// updating a single category...
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
