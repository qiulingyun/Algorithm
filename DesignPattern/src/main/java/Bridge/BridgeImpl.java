package Bridge;

public class BridgeImpl extends Bridge {
	public void action(){
		Source s = getSource();
		if(s != null){
			s.action();
		}
	}
}
