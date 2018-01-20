package QLY.TestMaven;

import java.util.Date;

public class SayHi {
	private String str = null;
	private Date date = null;
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void init(){
		str = "Hi";
		
	}
	
	public void ToSayHi(){
		System.out.println(str);
	}
}
