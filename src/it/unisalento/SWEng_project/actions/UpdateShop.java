package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ShopModel;
import it.unisalento.SWEng_project.services.LongLatService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * Ã¨ necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class UpdateShop extends ActionSupport implements ModelDriven<ShopModel>{
	
	private ShopModel updated_shop = new ShopModel();
	private List<Shop> shops = new ArrayList<Shop>();
 
	
	public String execute () throws Exception {
		System.out.println("Sono entrato nella action");
		
		Shop newshop=new Shop();
		
		newshop.setAddress(updated_shop.getAddress());
		newshop.setCap(updated_shop.getCap());
		newshop.setCity(updated_shop.getCity());
		newshop.setName(updated_shop.getName());
		newshop.setProvince(updated_shop.getProvince());
		newshop.setState(updated_shop.getState());
		newshop.setRegistrationDate(updated_shop.getRegistrationDate());
		newshop.setId(updated_shop.getId());
		
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
			
			//se la conversione non è andata a buon fine imposto le coordinate del Polo Nord
			//chi cazzo vuoi che abbia un negozio al POLO NORD?!?!?!
			newshop.setLat(new BigDecimal("90.00000"));
			newshop.setLon(new BigDecimal("0.00000"));
		}
		
		System.out.println("ID shop: "+updated_shop.getId());
		System.out.println("Data registrazione shop: "+updated_shop.getRegistrationDate());
		
		//aggiorno lo shop nel DB
		FactoryDao.getIstance().getShopDao().update(newshop);
		
		System.out.println("Shop aggiornato");

		this.shops=FactoryDao.getIstance().getShopDao().getAll(Shop.class);
				
		return SUCCESS;
	}

	@Override
	public ShopModel getModel() {
		// TODO Auto-generated method stub
		return updated_shop;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
