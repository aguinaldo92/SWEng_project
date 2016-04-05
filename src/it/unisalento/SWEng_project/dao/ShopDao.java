package it.unisalento.SWEng_project.dao;

import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;

import java.util.List;

public interface ShopDao extends BaseDao<Shop>{
	
	public List<Shop> getShopsByUser(User user);
	public void updateShop(Shop shop);
	
}