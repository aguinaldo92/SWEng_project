package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.factories.FactoryDao;

import com.opensymphony.xwork2.ActionSupport;

public class ShopDetails extends ActionSupport{
	
	private Shop shop = new Shop();
	private int idshop;
    
	public String execute () throws Exception {
		
		System.out.println("idshop="+idshop);
		this.shop=FactoryDao.getIstance().getShopDao().get(idshop, Shop.class);
		
		System.out.println("Nome dello shop estratto: "+shop.getName());
		
		return SUCCESS;
	}

	public Shop getShop() {
		return shop;
	}


	public void setShops(Shop shop) {
		this.shop = shop;
	}

	public int getIdshop() {
		return idshop;
	}

	public void setIdshop(int idshop) {
		this.idshop = idshop;
	}	
}