package br.ufc.crateus.leftheap;

public interface Heap<K> {
	void insert(int i, K key);
	int extractMin();
	void decreaseKey(int i, K key);
	boolean contains(int i);
	public int size();
	boolean isEmpty();	
	K min();
	void delete(int i);
}
