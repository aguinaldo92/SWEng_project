package it.unisalento.SWEng_project.factories;

import it.unisalento.SWEng_project.dao.CategoryDao;
import it.unisalento.SWEng_project.dao.LocationDao;
import it.unisalento.SWEng_project.dao.ProductPhotoDao;
import it.unisalento.SWEng_project.dao.TypeOfProductDao;
import it.unisalento.SWEng_project.dao.ShopDao;
import it.unisalento.SWEng_project.dao.UserDao;
import it.unisalento.SWEng_project.dao.impl.CategoryDaoImpl;
import it.unisalento.SWEng_project.dao.impl.LocationDaoImpl;
import it.unisalento.SWEng_project.dao.impl.ProductPhotoDaoImpl;
import it.unisalento.SWEng_project.dao.impl.TypeOfProductDaoImpl;
import it.unisalento.SWEng_project.dao.impl.UserDaoImpl;
import it.unisalento.SWEng_project.dao.impl.ShopDaoImpl;

public class FactoryDao {
	/*IMPLEMENTAZIONE PATTERN SINGLETON --> PERFORMANCE SCARSE
	 * serve per incastrare le implementazioni con le relative interfacce del pattern
	 * Bridge. Da ora nell'applicazione verrà utilizzato il Factory e non le classi
	 * implementazioni e interfacce.
	 * Tale classe FastoryDao deve essere unico per tutto
	 * il programma --> si utilizza il Pattern Singleton --> dichiaro una variabile
	 * privata FactoryDao, rendo il costruttore privato e dichiaro un metodo statico per
	 * ottenere un oggetto della classe FactoryDao
	 
	private static FactoryDao istance;
	private FactoryDao(){
		
	}
	static synchronized FactoryDao getIstance(){
		/*
		 * syncronized per evitare che più thread utilizzino questo metodo in concorrenza.
		 * Tale metodo però sfrutta troppe risorse dell'applicazione.
		 
		if(istance==null){
			istance=new FactoryDao();
		}
		return istance;
	}
	
	public StudentDao getStudentDao(){
		return new StudentDaoImpl();
	}
	
	public CorsoDao getCorsoDao(){
		return new CorsoDaoImpl();
	}
	*/
	
	///////////////////////////////////////////////////////////
	/*
	 * si procede invece come segue poichè java permette cosi di creare delle variabili
	 * statiche COMUNQUE in modalità threadsave per gestire le concorrenze senza
	 * la necessità di un metodo syncronized, che spreca risorse.
	 * 
	 
	private final static FactoryDao ISTANCE=new FactoryDao();
	
	static FactoryDao getIstance(){
		return ISTANCE;
	}
	
	public StudentDao getStudentDao(){
		return new StudentDaoImpl();
	}
	
	public CorsoDao getCorsoDao(){
		return new CorsoDaoImpl();
	}
	*/
	
	/*
	 * Il pattern Singleton però non permette di garantire che una proprietà statica
	 * venga dichiarata solo quando serve immediatamente.
	 * 
	 * Per essere sicuri che Singleton venga implementato solo quando serve immediatamente
	 * si usa un altro Pattern (Holder).
	 * La classe annidata deve essere statica altrimenti non riuscirebbe
	 * ad accedere alle proprietà della classe che la contiene.
	 */
	
	static private class Holder{
		static final private FactoryDao ISTANCE=new FactoryDao();
	}
	
	public static FactoryDao getIstance(){
		System.out.println("FactoryDao: getIstance()");
		return Holder.ISTANCE;
	}
	
	public UserDao getUserDao(){
		System.out.println("FactoryDao: getUserDao");
		return new UserDaoImpl();
	}
	
	public LocationDao getLocationDao(){
		return new LocationDaoImpl();
	}
	
	public CategoryDao getCategoryDao(){
		return new CategoryDaoImpl();
	}
	
	public TypeOfProductDao getTypeOfProductDao(){
		return new TypeOfProductDaoImpl();
	}
	
	public ProductPhotoDao getProductPhotoDao(){
		return new ProductPhotoDaoImpl();
	}
		
	public ShopDao getShopDao(){
		return new ShopDaoImpl();
	}
}
