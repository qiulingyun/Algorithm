package Test.Algorithm;

import java.util.LinkedList;

public class MinStack {

	/** initialize your data structure here. */
	LinkedList<Integer> stack = new LinkedList<>();
	LinkedList<Integer> min = new LinkedList<>();
	
    public MinStack() {
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	if (min.isEmpty() || x < min.peek()) {
			min.push(x);
		}else{
			min.push(min.peek());
		}
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

}
