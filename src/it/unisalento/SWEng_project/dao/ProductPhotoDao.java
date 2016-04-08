package it.unisalento.SWEng_project.dao;

import java.util.ArrayList;

import it.unisalento.SWEng_project.domain.ProductPhoto;
import it.unisalento.SWEng_project.dto.ProductPhotoDTO;

public interface ProductPhotoDao extends BaseDao<ProductPhoto>{
	public abstract ArrayList<ProductPhoto> getAllPhotosByIdTypeOfProduct(Integer id);		
	public abstract ProductPhoto getPhotoByIdTypeOfProduct(Integer id);		
	

}
