package Visitor;

public class SubjectImpl implements Subject {

	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		if(visitor != null){
			visitor.visit(this);
		}
	}

	public Subject getSubject() {
		return this;
	}

	@Override
	public String toString() {
		return "This is SubjectImpl";
	}
	
	

}
