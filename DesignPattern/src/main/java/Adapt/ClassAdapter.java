package Adapt;

public class ClassAdapter extends Source implements Target {

	public void targetMethod() {
		// TODO Auto-generated method stub
		System.out.println("In Adapter, target method");
	}
	
	public static void main(String[] args){
		Target classAdapter = new ClassAdapter();
		classAdapter.targetMethod();
		classAdapter.sourceMethod();
	}
	
}
