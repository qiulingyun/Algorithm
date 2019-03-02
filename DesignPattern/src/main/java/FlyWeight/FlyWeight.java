package FlyWeight;

import java.util.ArrayList;

public class FlyWeight {
	private int id;
	private String value;
	private ArrayList<String> resourceList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ArrayList<String> getResourceList() {
		return resourceList;
	}
	public void setResourceList(ArrayList<String> resourceList) {
		this.resourceList = resourceList;
	}
	public FlyWeight() {
		super();
		value = new String();
		resourceList = new ArrayList<String>();
	}
	public FlyWeight(int id, String value, ArrayList<String> resourceList) {
		super();
		this.id = id;
		this.value = value;
		this.resourceList = resourceList;
	}
	@Override
	public String toString() {
		return "FlyWeight [id=" + id + ", value=" + value + ", resourceList=" + resourceList + "]";
	}
	
	
}
