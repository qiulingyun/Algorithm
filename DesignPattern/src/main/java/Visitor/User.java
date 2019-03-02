package Visitor;

public class User {
	public static void main(String[] args){
		Visitor visitor = new VisitorImpl();
		Subject subject = new SubjectImpl();
		subject.accept(visitor);
		
	}
}
