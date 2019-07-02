//código feito com base nas informações desse site: https://www.geeksforgeeks.org/leftist-tree-leftist-heap/

package br.ufc.crateus.leftheap;

import java.util.LinkedList;

public class LeftHeap <K extends Comparable<K>> implements Heap<K>{

	private class Node{
		private K key;
		private Node left;
		private Node right;
		private int i;
		
		public Node(K key) {
			this(key,null,null);
			
		}
		
		public Node(K key, Node right, Node left) {
			this.key = key;
			this.right = right;
			this.left = left;
			i = 0;
		}
		
	}
	
	private Node root;	
	
	@Override
	public void insert(K key) {
		root = merge(root, new Node(key));
	}
	
	private Node merge(Node h1, Node h2) {
	    if (h1 == null) return h2;
	    
	    else if (h2 == null) return h1; 
	    
	    else if (h1.key.compareTo(h2.key) < 0) return merge2(h1, h2); 
	    
	    else return merge2(h2, h1);
	}
	
	private Node merge2(Node h1, Node h2) {
		if(h1.left == null) h1.left = h2;
		
		else {
			h1.right = merge(h1.right,h2);
			
			if(h1.left.i < h1.right.i) {
				Node tmp = h1.left;
				h1.left = h1.right;
				h1.right = tmp;
			}
			h1.i = h1.right.i + 1;
		}
		return h1;
	}

	@Override
	public K extractMin() {
		K min = min();
		root = merge(root.left, root.right);
		
		return min;
	}


	@Override
	public boolean contains(K key) {
		for(K k : keys()) {
			if(k == key) return true;
		}
		return false;
	}
	@Override
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	@Override
	public K min() {
		return root.key;
	}
	
	public Iterable<K> keys(){
		LinkedList<K> keys = new LinkedList<K>();
		keys(root, keys);
		
		return keys;
	}
	
	private void keys(Node h1, LinkedList<K> keysList) {
		if(h1 == null) return;
		
		keys(h1.left, keysList);
		
		keysList.add(h1.key);
		
		keys(h1.right, keysList);
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}
	
}
