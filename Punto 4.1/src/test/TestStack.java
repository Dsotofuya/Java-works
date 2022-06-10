package test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import DataStructure.MyQueue;

public class TestStack {
	public static void main(String[] args) {
		/*Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		Iterator<Integer> iterator = stack.iterator();
		
		int num = 0;
		while (iterator.hasNext()) {
			num = iterator.next();
			System.out.println(num);
		}
		
		System.out.println("datos");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());*/
		
		
		
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		
		
		myQueue.print();
		
		System.out.println("cant: " + myQueue.getQueue().size());
		
		System.out.println("enquee");
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
	
		
	}
}
