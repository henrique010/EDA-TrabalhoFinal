package br.ufc.crateus.graph;

public class App {

	public static void main(String[] args) {
		AdjacencyListGraph<String> test = new AdjacencyListGraph<String>(5);
		
		test.addEdge("Alfredo", "Maria");
		test.addEdge("Alfredo", "Joana");
		test.addEdge("Maria", "Joana");
		test.addEdge("Marcelo", "Maria");
		test.addEdge("Marcelo", "Alfredo");
		
		//System.out.println(test.contains("Marcelo"));
		//System.out.println("N° de vértices: "+test.countVertices());
		//System.out.println("N° de arestas: "+test.countEdges());
		//System.out.println(test.index("Joana"));
		//System.out.println(test.label(1));
		//System.out.println(test.adjacents("Alfredo"));
		System.out.println(test.degree("Maria"));
	}

}
