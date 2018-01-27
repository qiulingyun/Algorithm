package Observer;

public interface Subject {
	public void addObserver(Observer ob);
	public void removeObserver(Observer ob);
	public void notifyAllObserver();
	public void operation();
}
