package Model;

import java.util.ArrayList;
import java.util.Date;

import Utility.AddPrefixZero;

public class Post {
	private String business;
	private Header header;
	private ArrayList<LineItem> lineItems;
	
	public Post() {
		super();
		header = new Header();
		lineItems = new ArrayList<LineItem>();
		business = new String();
	}

	public Post(Header header, ArrayList<LineItem> lineItems) {
		super();
		this.header = header;
		this.lineItems = lineItems;
	}
	
	public Post(Post other){
		super();
		this.business = other.getBusiness();
		this.header = other.getHeader();
		this.lineItems = other.getLineItems();
	}
	

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(ArrayList<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public String toString() {
		return "Post [business=" + business + ", header=" + header + ", lineItems=" + lineItems + "]";
	}

	
	
	
}
