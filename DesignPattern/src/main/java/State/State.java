package State;

public class State {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void action1(){
		System.out.println("In Action 1");
	}
	
	public void action2(){
		System.out.println("In Action 2");
	}
}
