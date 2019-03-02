package Iterator;

public class User {

	public static void main(String[] args) {
		CollectionImpl c = new CollectionImpl();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		for(Iterator iter = c.getIterator();iter.hasNext();){
			System.out.println(iter.next());
		}
	}

}
