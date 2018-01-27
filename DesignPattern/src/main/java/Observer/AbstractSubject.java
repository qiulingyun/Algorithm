package Observer;

import java.util.Iterator;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {

private Vector<Observer> obVector = new Vector<Observer>();
	
	public void addObserver(Observer ob) {
		obVector.addElement(ob);
	}

	public void removeObserver(Observer ob) {
		obVector.remove(ob);
	}

	public void notifyAllObserver() {
		for(Iterator<Observer> it = obVector.iterator();it.hasNext();){
			Observer ob = it.next();
			ob.update();
		}
		

	}

	public final void operation() {
		operation2();
		notifyAllObserver();
	}
	
	protected abstract void operation2();

}
