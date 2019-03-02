package Test.Algorithm;

import java.util.HashMap;
import java.util.LinkedList;

public class NewestUnflagElement {
	
	public static final int CAPAICITY = 2;
	
	public class Node{
		public Node prev;
		public Node next;
		public String val;
//		public boolean notDel;
		public Node(String in){
			this.val = in;
		}
	}
	
	public HashMap<String, Integer> valueMap = new HashMap<String, Integer>();
	public HashMap<String, Node> positionMap = new HashMap<String, NewestUnflagElement.Node>();
//	public HashMap<String, Boolean> flagMap = new HashMap<String, Boolean>();
	public Node unflag;
//	public Node flaged;
	
	public void add(String key, Integer val){
		if (unflag == null) {
			unflag = new Node(key);
		}else{
			Node old = unflag;
			unflag = new Node(key);
			unflag.next = old;
			old.prev = unflag;
			
			if(valueMap.size() == CAPAICITY){
				String keyToDel = old.val;
				valueMap.remove(keyToDel);
				positionMap.remove(keyToDel);
				deleteNode(old);
			}
		}
		positionMap.put(key, unflag);
		valueMap.put(key, val);
	}
	
	public Integer acquire(String key){
		Integer answer = valueMap.get(key);
		if (answer == null) {
			return null;
		}
		Node node = positionMap.get(key);
		deleteNode(node);
//		node.notDel = true;
		return answer;
	}
	
	private void deleteNode(Node node){
		Node prev = node.prev;
		Node next = node.next;
		if (prev == null && next == null) {
			
		}else if (prev == null) {
			unflag = next;
			node.next = null;
			next.prev = null;
		}else if (next == null) {
			node.prev = null;
			prev.next = null;
		}else{
			node.prev = null;
			node.next = null;
			prev.next = next;
			next.prev = prev;
		}
	}
	
	public void show(){
		System.out.print("Unflaged List:");
		Node node = unflag;
		while(node != null){
			System.out.print("[ref:" + node + ", val:" + node.val +"] ");
			node = node.next;
		}
		System.out.println();
//		System.out.println("Value:" + valueMap);
//		System.out.println("Position:" + positionMap);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewestUnflagElement util = new NewestUnflagElement();
		util.add("120", 120);
		util.add("33", 33);
		util.show();
		util.acquire("33");
		util.show();
		util.add("aa", 65);
		util.show();
		System.out.println(util.valueMap);
		
		LinkedList<Node> list = new LinkedList<NewestUnflagElement.Node>();
		
	}

}
