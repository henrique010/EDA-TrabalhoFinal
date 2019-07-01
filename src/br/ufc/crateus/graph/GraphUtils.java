package br.ufc.crateus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GraphUtils {

	public static <T> boolean shortestPath(Graph<T> graph, T v1, T v2) {
		return true;
	}
	
	public static AdjacencyListGraph<String> readFromFile(InputStream is, String sep) throws IOException{
		AdjacencyListGraph<String> listGraph = new AdjacencyListGraph<String>(500000);
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		while(buffer.ready()) {
			String [] tmp = buffer.readLine().split(sep);
			String firstVertex = tmp[0];
			
			for(int i=1; i<tmp.length; i++) listGraph.addEdge(firstVertex, tmp[i]);
			
		}
		
		buffer.close();
		
		return listGraph;
	}
	
}
