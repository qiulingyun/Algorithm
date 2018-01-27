package Memento;

public class Origin {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public Memento createMemento(){
		return new Memento(data);
	}
	
	public void restoreByMemento(Memento memento){
		if(memento != null){
			this.data = memento.getData();
		}
	}
	
	public void showData(){
		System.out.println("Data is: " + data);
	}
}
