package br.ufc.crateus.st;

public interface ST<T, V> {

	V get(T key);
	
	void put(T key, V value);
	
	boolean contains(T key);
	
	void delete(T key);
	
	boolean isEmpty();
	
	int size();
	
	Iterable<T> keys();
	
}
