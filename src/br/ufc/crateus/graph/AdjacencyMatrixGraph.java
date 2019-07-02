package br.ufc.crateus.graph;

import java.util.LinkedList;

import br.ufc.crateus.st.SeparateChainingHashingST;

public class AdjacencyMatrixGraph<T> implements Graph<T>{

	private int V;
	private int E;
	private int currentVertex;
	private int[][] adj;
	private SeparateChainingHashingST<T, Integer> tags;
	
	public AdjacencyMatrixGraph(int V) {
		this.V = V;
		this.currentVertex = 0;
		this.E = 0;
		this.adj = new int[V][V];
		
		for(Integer i=0; i<V; i++) {
			for(Integer j=0; j<V; j++) adj[i][j] = 0;
		}
		
		this.tags = new SeparateChainingHashingST<T, Integer>(V);
	}
	
	@Override
	public int countVertices() {
		return currentVertex;
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
			int index = currentVertex++;
			tags.put(v1, index);
		}
		
		if(!tags.contains(v2)) {
			int index = currentVertex++;
			tags.put(v2, index);
		}
		
		adj[index(v1)][index(v2)] = 1;
		adj[index(v2)][index(v1)] = 1;
		
		E++;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		LinkedList<T> adjacents = new LinkedList<T>();
		int index = tags.get(v);
		
		for(int i=0; i<currentVertex; i++) {
			if(adj[index][i] != 0) adjacents.add(label(i));
		}
		return adjacents;
	}

	@Override
	public int degree(T v) {
		int index = tags.get(v);
		int count = 0;
		for(int i=0; i<V; i++) {
			if(adj[index][i] == 1) count++;
		}
		return count;
	}

}
