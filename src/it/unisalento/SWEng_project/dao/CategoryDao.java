package it.unisalento.SWEng_project.dao;

import it.unisalento.SWEng_project.domain.Category;

import java.util.ArrayList;

public interface CategoryDao extends BaseDao<Category> {
	public int set(Category category);
	public Category getByName(String categoryName);
	public ArrayList<Category> getAllSorted(Class categoryClass);
}
