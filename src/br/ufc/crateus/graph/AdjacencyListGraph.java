package br.ufc.crateus.graph;

import java.util.LinkedList;

import br.ufc.crateus.st.SeparateChainingHashingST;

public class AdjacencyListGraph<T> implements Graph<T>{

	private int V;
	private int E;
	private int currentVertices;
	private LinkedList<T> [] adj;
	private SeparateChainingHashingST<T, Integer> tags;

	public AdjacencyListGraph(int V) {
		this.V = V;
		this.currentVertices = 0;
		this.E = 0;
		this.adj = new LinkedList[V];
		
		for(int i=0; i < V; i++) adj[i] = new LinkedList<T>();
		
		this.tags = new SeparateChainingHashingST<T, Integer>(V);
	}
	
	@Override
	public int countVertices() {
		return currentVertices;
	}

	@Override
	public int countEdges() {
		return E;
	}

	@Override
	public int index(T v) {
		return tags.get(v);
	}

	@Override
	public T label(int index) {
		LinkedList<T> labels = (LinkedList<T>) tags.keys();
		
		for(T label : labels) {
			if(index(label) == index) return label;
		}
		return null;
	}

	@Override
	public boolean contains(T v) {
		return tags.contains(v) ? true : false;
	}

	@Override
	public void addEdge(T v1, T v2) {
	
		if(!tags.contains(v1)) {
			int index = currentVertices++;
			tags.put(v1, index);
		} 
		
		if(!tags.contains(v2)) {
			int index = currentVertices++;
			tags.put(v2, index);
		}
		
		adj[(int) index(v1)].add(v2);
		adj[(int) index(v2)].add(v1);
		
		E++;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		LinkedList<T> adjacents = new LinkedList<T>();
		int index = tags.get(v);
		
		for(int i=0; i<adj[index].size(); i++) {
			adjacents.add(adj[index].get(i));
		}
		return adjacents;
	}

	@Override
	public int degree(T v) {
		int index = tags.get(v);
		
		return adj[index].size();
	}
	
}
