package br.ufc.crateus.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//--------------------------LISTA DE ADJACÊNCIA---------------------------------
		
	/*	AdjacencyListGraph<String> test = new AdjacencyListGraph<String>(6);
		
		test.addEdge("Alfredo", "Maria");
		test.addEdge("Alfredo", "Joana");
		test.addEdge("Maria", "Joana");
		test.addEdge("Marcelo", "Maria");
		test.addEdge("Marcelo", "Alfredo");
		test.addEdge("Antonio", "Joana");
		
		System.out.println(test.contains("Marcelo"));
		System.out.println("N° de vértices: "+test.countVertices());
		System.out.println("N° de arestas: "+test.countEdges());
		System.out.println(test.index("Joana"));
		System.out.println(test.label(1));
		System.out.println(test.adjacents("Alfredo"));
		System.out.println(test.degree("Maria")); 
		
	*/
		
//--------------------------MATRIZ DE ADJACÊNCIA---------------------------------
		
	/*	AdjacencyMatrixGraph<String> testM = new AdjacencyMatrixGraph<String>(4);
		
		testM.addEdge("Ana", "Marcos");
		testM.addEdge("Ana", "Luana");
		testM.addEdge("Marcos", "Luana");
		testM.addEdge("Marcelo", "Marcos");
		testM.addEdge("Marcelo", "Ana");
		
		System.out.println(testM.contains("Joana"));
		System.out.println("N° de vértices: "+testM.countVertices());
		System.out.println("N° de arestas: "+testM.countEdges());
		System.out.println(testM.index("Marcos"));
	    System.out.println(testM.label(3));
		System.out.println(testM.adjacents("Marcos"));
		System.out.println(testM.degree("Ana"));
	*/
		
		
//--------------------------LENDO GRAFO DO ARQUIVO---------------------------------
		
//		AdjacencyListGraph<String> fileGraph = new AdjacencyListGraph<String>(6);
//		fileGraph = GraphUtils.readFromFile(new FileInputStream("testMovies.txt"), ",");
		
		AdjacencyListGraph<String> fileGraph = GraphUtils.readFromFile(new FileInputStream("movies.txt"), ",");
		
		System.out.println(fileGraph.countVertices());
		
		
	}

}
