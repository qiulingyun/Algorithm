package ChainofResponsibility;

public class User {
	public static void main(String[] args){
		ChainNode node1 = new ChainNode("1");
		ChainNode node2 = new ChainNode("2");
		ChainNode node3 = new ChainNode("3");
		node1.setHandler(node2);
		node2.setHandler(node3);
		node1.operate();
	}
}
