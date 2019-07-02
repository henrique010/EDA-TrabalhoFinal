package br.ufc.crateus.leftheap;

public class App {

	public static void main(String[] args) {
		LeftHeap<Integer> leftHeap = new LeftHeap<Integer>();
		
		leftHeap.insert(4);
		leftHeap.insert(19);
		leftHeap.insert(8);
		leftHeap.insert(27);
		leftHeap.insert(20);
		leftHeap.insert(43);
		leftHeap.insert(12);
		leftHeap.insert(15);
		leftHeap.insert(25);
		
		
		System.out.println(leftHeap.isEmpty());
		
		System.out.println(leftHeap.extractMin());
		System.out.println(leftHeap.extractMin());
		System.out.println(leftHeap.extractMin());
		
		System.out.println(leftHeap.min());
		
		System.out.println(leftHeap.keys());
		
		System.out.println(leftHeap.contains(20));
		
	}

}
