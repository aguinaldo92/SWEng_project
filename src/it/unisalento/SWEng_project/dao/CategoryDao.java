package it.unisalento.SWEng_project.dao;

import it.unisalento.SWEng_project.domain.Category;

import java.util.List;

public interface CategoryDao extends BaseDao<Category> {
	public int set(Category category);
	public List<Category> getAll(Class categoryClass);
	public List<Category> getAllSorted(Class categoryClass);
}
