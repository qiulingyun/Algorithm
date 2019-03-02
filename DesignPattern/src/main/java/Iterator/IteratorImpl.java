package Iterator;

public class IteratorImpl implements Iterator {

	private Collection collection;
	private int pos;
	
	public IteratorImpl(Collection collection) {
		super();
		this.collection = collection;
		pos = 0;
	}

	public Object next() {
		Object obj = null;
		if(pos < collection.size() - 1){
			obj = collection.get(pos++);
		}
		return obj;
	}

	public boolean hasNext() {
		boolean flag = false;
		if(pos < collection.size() - 1){
			flag = true;
		}
		return flag;
	}

	public Object previous() {
		Object obj = null;
		if(pos > 0){
			obj = collection.get(pos--);
		}
		return obj;
	}

}
