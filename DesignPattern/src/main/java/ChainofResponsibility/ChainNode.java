package ChainofResponsibility;

public class ChainNode extends BridgeHandler implements Handler {

	private String name;
	
	public ChainNode(String name) {
		super();
		this.name = name;
	}

	public void operate() {
		// TODO Auto-generated method stub
		System.out.println("This is node: " + name);
		Handler handler = getHandler();
		if(handler != null){
			getHandler().operate();
		}
		
	}

}
