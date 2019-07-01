package br.ufc.crateus.leftheap;

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
	private int size;
	
	
	@Override
	public void insert(int i, K key) {
		root = merge(root, new Node(key));
		size++;
	}
	
	
	private Node merge(Node h1, Node h2) {
		if(h1 == null) return h2;
		if(h2 == null) return h1;
		
		if(h1.key.compareTo(h2.key) > 0) {
			Node tmp = h1;
			h1 = h2;
			h2 = tmp;
		}
		if(h1.left == null)
			h1.left = h2;
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
	public int extractMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void decreaseKey(int i, K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public K min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
