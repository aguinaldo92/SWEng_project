package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ShopModel;
import it.unisalento.SWEng_project.services.LongLatService;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * Ã¨ necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class UpdateShop extends ActionSupport implements ModelDriven<ShopModel>, SessionAware{
	
	private ShopModel updated_shop = new ShopModel();
	private SessionMap<String, Object> userSession;
 
	
	public String execute () throws Exception {
		System.out.println("Sono entrato nella action");
		
		Shop newshop=new Shop();
		
		newshop.setAddress(updated_shop.getAddress());
		newshop.setCap(updated_shop.getCap());
		newshop.setCity(updated_shop.getCity());
		newshop.setName(updated_shop.getName());
		newshop.setProvince(updated_shop.getProvince());
		newshop.setState(updated_shop.getState());
		newshop.setTypology(updated_shop.getTypology());
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
		
		User user=(User) userSession.get("user");
		newshop.setUser(user);
		
		System.out.println("ID seller (sessione): "+user.getId());
		System.out.println("Nome seller (sessione): "+user.getName());
		System.out.println("ID shop: "+updated_shop.getId());
		System.out.println("Data registrazione shop: "+updated_shop.getRegistrationDate());
		
		//aggiorno lo shop nel DB
		FactoryDao.getIstance().getShopDao().updateShop(newshop);
		
		System.out.println("Shop aggiornato");
		
		//aggiorno gli shop nella sessione
		userSession.replace("shops", FactoryDao.getIstance().getShopDao().getShopsByUser(user));
		
		System.out.println("Shop di "+user.getName()+" aggiornato nella sessione");
		
		return SUCCESS;
	}
	
//	 Se sono presenti errori viene ritornato result = "input";
//	public void validate() {
//		
//		boolean errors = false;
//		
//		if (!(userForm.getPassword().equals(this.getConfirm_password()))){
//			addFieldError("confirm_password", "La password confermata è scorretta");
//			errors = true;
//		}
//		if (errors) {
//			addActionError("Sono presenti errori all'interno del form");
//		}
//	}

	@Override
	public ShopModel getModel() {
		// TODO Auto-generated method stub
		return updated_shop;
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap) map;
		
	}

//	public String getConfirm_password() {
//		return confirm_password;
//	}
//
//	@RequiredStringValidator(message = "Conferma password richiesta")
//	public void setConfirm_password(String confirm_password) {
//		this.confirm_password = confirm_password;
//	}	
}
