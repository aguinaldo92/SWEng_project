package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Characteristic;
import it.unisalento.SWEng_project.domain.Characterizes;
import it.unisalento.SWEng_project.domain.Product;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.CharacteristicModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddCharacteristic extends ActionSupport implements ModelDriven<CharacteristicModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005699344713824173L;
	private Characteristic characteristic = new Characteristic();
	private Product product;
	private CharacteristicModel characteristicModel = new CharacteristicModel();
	private Characterizes characterizes;
	private Integer productId;


	public String execute() {
		try {
			characteristic.setName(characteristicModel.getName());
			characteristic.setPrice(characteristicModel.getPrice());
			characteristic.setDiscount(characteristicModel.getDiscount());

			characteristic.setId(FactoryDao.getIstance().getCharacteristicDao().set(characteristic));

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

		try {
			product = (Product) FactoryDao.getIstance().getProductDao().get(productId,Product.class);
			characterizes.setProduct(product);
			characterizes.setCharacteristic(characteristic);
			
			characterizes.setId(FactoryDao.getIstance().getCharacterizesDao().set(characterizes));

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return SUCCESS;
	}
	@Override
	public CharacteristicModel getModel() {
		return characteristicModel;
	}

}
