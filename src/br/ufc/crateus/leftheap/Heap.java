package br.ufc.crateus.leftheap;

public interface Heap<K> {
	void insert(K key);
	K extractMin();
	boolean contains(K key);
	boolean isEmpty();
	K min();
	void delete(K key);
}
