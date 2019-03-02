package Memento;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Origin origin = new Origin();
		origin.setData("sun");
		Storage storage = new Storage();
		storage.setMemento(origin.createMemento());
		
		origin.showData();
		origin.setData("Moon");
		origin.showData();
		origin.restoreByMemento(storage.getMemento());
		origin.showData();
	}

}
