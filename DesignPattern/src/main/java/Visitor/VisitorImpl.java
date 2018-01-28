package Visitor;

public class VisitorImpl implements Visitor {

	public void visit(Subject sub) {
		System.out.println("In VisitorImpl, visit:" + sub.getSubject());
	}

}
