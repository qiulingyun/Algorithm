package Adapt;

public class Wrapper implements Target{

	private Source source;
	
	public Wrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wrapper(Source source) {
		super();
		this.source = source;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}



	public void targetMethod() {
		// TODO Auto-generated method stub
		System.out.println("In Wrapper, target method");
	}

	public void sourceMethod() {
		// TODO Auto-generated method stub
		if(source != null){
			source.sourceMethod();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target target = new Wrapper(new Source());
		target.sourceMethod();
		target.targetMethod();
	}
}
