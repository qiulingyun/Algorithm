package Model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class City {
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private long population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public City(int id, String name, String countryCode, String district, long population) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.countryCode = countryCode;
//		this.district = district;
//		this.population = population;
//	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class<City> cityClass = (Class<City>) Class.forName("Model.City");
		BeanWrapper beanWrapper = new BeanWrapperImpl(cityClass.newInstance());
		beanWrapper.setPropertyValue("name", "Shanghai");
		System.out.println(beanWrapper.getPropertyValue("name"));
		City city = cityClass.newInstance();
//		Field nameField = cityClass.getField("name");
		Method methodSetName = cityClass.getMethod("setName", new Class[]{String.class});
		methodSetName.invoke(city, new String[]{"Beijing"});
		Method methodGetName = cityClass.getMethod("getName");
		System.out.println(methodGetName.invoke(city, null));
	}
	
	
}
