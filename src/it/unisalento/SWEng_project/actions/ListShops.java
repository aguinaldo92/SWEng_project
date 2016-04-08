package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ShopModel;
import it.unisalento.SWEng_project.services.LongLatService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListShops extends ActionSupport{
	
	private List<Shop> shops = new ArrayList<Shop>();
    
	public String execute () throws Exception {
		
		this.shops=FactoryDao.getIstance().getShopDao().getAll(Shop.class);
		
		System.out.println("Caricata la lista degli shops. N° shops: "+shops.size());
		
		return SUCCESS;
	}

	public List<Shop> getShops() {
		return shops;
	}


	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}	
}