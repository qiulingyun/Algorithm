package Proxy;

public class Proxy implements SourceInterface {

	private SourceInterface source;
	
	
	
	public Proxy() {
		super();
		source = new Source();
	}

	public void sourceMethod() {
		// TODO Auto-generated method stub
		System.out.println("In Proxy, before source.sourceMethod()");
		source.sourceMethod();
		System.out.println("In Proxy, after source.sourceMethod()");
	}

	public static void main(String[] args){
		SourceInterface proxy = new Proxy();
		proxy.sourceMethod();
	}
}
