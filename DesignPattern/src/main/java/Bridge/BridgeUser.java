package Bridge;

public class BridgeUser {
	public static void main(String[] args){
		Bridge bridge = new BridgeImpl();
		bridge.setSource(new SourceImpl1());
		bridge.action();
		bridge.setSource(new SourceImpl2());
		bridge.action();
	}
}
