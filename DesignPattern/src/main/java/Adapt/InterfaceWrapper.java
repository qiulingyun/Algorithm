package Adapt;

public class InterfaceWrapper extends SourceInterfaceWrapper implements Target {

	public void targetMethod() {
		// TODO Auto-generated method stub
		System.out.println("In Wrapper, target method");
	}
	
	public void method2(){
		System.out.println("In Wrapper, method2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target target = new InterfaceWrapper();
		target.targetMethod();
	}
}
