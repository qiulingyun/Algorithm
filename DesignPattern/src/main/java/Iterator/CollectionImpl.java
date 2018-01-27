package Iterator;

import java.util.ArrayList;

public class CollectionImpl implements Collection {

	private ArrayList<String> value = new ArrayList<String>();
	
	public Object get(int i) {
		// TODO Auto-generated method stub
		return value.get(i);
	}
	
	public void add(String obj){
		value.add(obj);
	}

	public int size() {
		// TODO Auto-generated method stub
		return value.size();
	}

	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new IteratorImpl(this);
	}

}
