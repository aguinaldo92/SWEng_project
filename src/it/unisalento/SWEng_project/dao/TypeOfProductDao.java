package it.unisalento.SWEng_project.dao;

import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.dto.TypeOfProductDTO;

import java.util.ArrayList;

public interface TypeOfProductDao extends BaseDao<TypeOfProduct> {
	public ArrayList<String> getBrandsByCategory(Category category); // da modificare per usare brand dto e cambiare il nome in getBrands
	public ArrayList<TypeOfProductDTO> getTypeOfProductsDTOByCategory(String category);
	public ArrayList<TypeOfProductDTO> getTypeOfProductsByCategoryAndBrand(String category,String brand);
	public ArrayList<TypeOfProductDTO> getBestDeals();
}
