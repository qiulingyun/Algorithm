package Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Prototype implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private ArrayList<String> list = null;

	public Prototype() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prototype(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Prototype [id=" + id + ", list=" + list + "], hashcode=" + this.hashCode();
	}

	public Object deepClone() throws Exception{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		return ois.readObject();
	}
	
	
	public static void main(String[] args) throws Exception{
		Prototype prototype = new Prototype(1L);
		ArrayList<String> tmpList = new ArrayList<String>();
		tmpList.add("a");
		tmpList.add("b");
		prototype.setList(tmpList);
		Prototype another = (Prototype) prototype.deepClone();
//		Prototype another = (Prototype) prototype.clone();
		System.out.println(prototype);
		System.out.println(another);
		
		prototype.getList().add("addition!");
		prototype = null;
//		Runtime.getRuntime().gc();
		System.gc();
		System.out.println(prototype);
		System.out.println(another);
		
	}
	
}
