package Decorator;

public class Decorator implements SourceInterface {

	Source source;
	
	
	public Decorator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Decorator(Source source) {
		super();
		this.source = source;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public void sourceMethod() {
		// TODO Auto-generated method stub
		System.out.println("In Decorator, before source.sourceMethod");
		if(source != null){
			source.sourceMethod();
		}
		System.out.println("In Decorator, after source.sourceMethod");

	}
	
	public static void main(String[] args){
		SourceInterface decorator = new Decorator(new Source());
		decorator.sourceMethod();
	}

}
