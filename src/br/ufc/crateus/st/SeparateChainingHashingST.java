package br.ufc.crateus.st;

import java.util.LinkedList;

public class SeparateChainingHashingST<T, V> implements ST<T, V>{

	private Node[] array;
	private int m;
	private int size;
	
	private static class Node {
		Object key;
		Object value;
		Node next;
		
		Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public SeparateChainingHashingST(int m) {
		this.array = new Node[m];
		this.m = m;
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(T key) {
		int i = hash(key);
		for (Node n = array[i]; n != null; n = n.next) 
			if (key.equals(n.key)) return (V) n.value;
		return null;
	}

	@Override
	public void put(T key, V value) {
		if ((size / m) >= 8) rehashing(2 * m);
		
		int i = hash(key);
		for (Node n = array[i]; n != null; n = n.next) 
			if (key.equals(n.key)) {
				n.value = value;
				return;
			}
		array[i] = new Node(key, value, array[i]);
		size++;
	}
	
	
	@SuppressWarnings("unchecked")
	private void rehashing(int newM) {
		SeparateChainingHashingST<T, V> hash = new SeparateChainingHashingST<>(newM);
		for (Node h : array) { 
			for (Node node = h; node != null; node = node.next)
				hash.put((T) node.key, (V) node.value);
		}
		array = hash.array;
		m = newM;
	}

	@Override
	public boolean contains(T key) {
		return get(key) != null;
	}

	@Override
	public void delete(T key) {
		
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<T> keys() {
		LinkedList<T> ll = new LinkedList<T>();
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null)
			ll.add((T) array[i].key);
		}
		return ll;
	}
	
	private int hash(T key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	
}
