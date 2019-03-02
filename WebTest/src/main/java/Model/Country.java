package Model;

import java.lang.reflect.Field;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Country {
	private int id;
	private City city;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", city=" + city + "]";
	}
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class cls = Class.forName("Model.Country");
		BeanWrapper beanWrapper = new BeanWrapperImpl(cls.newInstance());
		City city = new City();
		city.setId(999);
		city.setName("TestCity");
//		beanWrapper.setPropertyValue("city", new City(999,"TestCity", "-1", "-1", 233));
		beanWrapper.setPropertyValue("city", city);
		System.out.println(beanWrapper.getPropertyValue("city"));
		
		Country country = new Country();
		Field field = cls.getDeclaredField("id");
		field.set(country, 888);
		System.out.println(country.getId());
		
	}
	
	
	
	
}
