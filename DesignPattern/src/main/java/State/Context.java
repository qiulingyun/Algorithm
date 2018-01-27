package State;

public class Context {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void action(){
		if(state == null){
			return;
		}else{
			if(state.getState() == "1"){
				state.action1();
			}else if(state.getState() == "2"){
				state.action2();
			}
		}
	}
	
	public static void main(String[] args){
		Context context = new Context();
		State state = new State();
		state.setState("1");
		context.setState(state);
		context.action();
	}
}
