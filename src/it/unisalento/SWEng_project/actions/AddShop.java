package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;
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

public class AddShop extends ActionSupport implements ModelDriven<ShopModel>{
	
	private ShopModel shopForm = new ShopModel();
	private List<Shop> shops = new ArrayList<Shop>();
    
	public String execute () throws Exception {
		
		System.out.println("Sono entrato nella action");
		System.out.println("Shop inserito: "+shopForm.getName());
		
		Shop newshop=new Shop();
		
		Date now=new Date();
		
		newshop.setAddress(shopForm.getAddress());
		newshop.setCap(shopForm.getCap());
		newshop.setCity(shopForm.getCity());
		newshop.setLat(shopForm.getLat());
		newshop.setLon(shopForm.getLon());
		newshop.setName(shopForm.getName());
		newshop.setProvince(shopForm.getProvince());
		newshop.setRegistrationDate(now);
		newshop.setState(shopForm.getState());

		//ottengo le coordinate geografiche in base all'indirizzo
		try{
			String address=newshop.getAddress()+", "+newshop.getCap()+", "+
				newshop.getCity()+" ("+newshop.getProvince()+") "+newshop.getState();
			LongLatService geo_converter=new LongLatService();
			String[] geo_coord=geo_converter.getLatLongPositions(address);
			
			newshop.setLat(new BigDecimal(geo_coord[0]));
			newshop.setLon(new BigDecimal(geo_coord[1]));
		}catch(Exception egeneric){
			System.out.println("Errore durante la collocazione dell'indirizzo nelle coordinate geografiche: "+egeneric.getMessage());
			
			//se la conversione non � andata a buon fine imposto le coordinate del Polo Nord
			//chi cazzo vuoi che abbia un negozio al POLO NORD?!?!?!
			newshop.setLat(new BigDecimal("90.00000"));
			newshop.setLon(new BigDecimal("0.00000"));
		}
		
		//inserimento shop nel DB
		newshop.setId(FactoryDao.getIstance().getShopDao().set(newshop));
		
		System.out.println("Inserimento shop effettuato: ID shop="+newshop.getId());
		
		this.shops=FactoryDao.getIstance().getShopDao().getAll(Shop.class);
		
		return SUCCESS;
	}

	@Override
	public ShopModel getModel() {
		// TODO Auto-generated method stub
		return shopForm;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}	
}