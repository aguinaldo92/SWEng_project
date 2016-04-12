package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ResidenceModel;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * è necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class UpdateResidence extends ActionSupport implements ModelDriven<ResidenceModel>, SessionAware{
	
	private ResidenceModel residenceForm = new ResidenceModel();
    private SessionMap<String, Object> userSession;
    
    public String execute(){
    	
    	User newuser = (User) userSession.get("user");
    	
    	//modifica della residenza
    	newuser.setResidenceAddress(residenceForm.getAddress());
    	newuser.setResidenceCap(residenceForm.getCap());
    	newuser.setResidenceCity(residenceForm.getCity());
    	newuser.setResidenceNumber(residenceForm.getNumber());
    	newuser.setResidenceProvince(residenceForm.getProvince());
    	newuser.setResidenceState(residenceForm.getState());
    	
    	FactoryDao.getIstance().getUserDao().update(newuser);
    	
    	System.out.println("Residenza dello user "+newuser.getName()+" aggiornata");
    	
    	userSession.replace("user", newuser);
    	
    	System.out.println("Aggiornato utente della sessione");
    	
    	return SUCCESS;
    }

	@Override
	public ResidenceModel getModel() {
		// TODO Auto-generated method stub
		return residenceForm;
	}


	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap) map;
	}
}
