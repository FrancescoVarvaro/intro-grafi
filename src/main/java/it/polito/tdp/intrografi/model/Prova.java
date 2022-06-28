package it.polito.tdp.intrografi.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class Prova {

	public void creaGrafo() {
		Graph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		//la prima coppia di [] rappresenta i vertici la seconda gli archi
//		aggiungiamo vertici e archi(se gliarchi sono presentati con {} --> NON ORIENTATO)
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);

		g.addEdge(1, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 5);
		g.addEdge(1, 5);
		g.addEdge(3, 6);

		System.out.println(g);

		System.out.println("Connessioni del vertice 2");
		Set<DefaultEdge> archi = g.edgesOf(2);
		for (DefaultEdge e : archi) {
			if (g.getEdgeTarget(e) == 2)
				System.out.println(g.getEdgeSource(e));
			else
				System.out.println(g.getEdgeTarget(e));
		}
//		ESISTE UNA CLASSE 'Graphs' che contiene metodi STATICI quindi che chiamo scrivendo Graphs.metodo
//		e passando come parametro il grafo. Questa classe ha metodi MOLTO utili!
		List<Integer> vicini = Graphs.neighborListOf(g, 2);//TROVO I VERTICI VICINI (ADIACENTI) AL VERTICE 2.
		System.out.println(vicini);						   //IN UN GRAFO ORIENTANTO VICINI PRECEDENTI E SUCCESSIVI
	}

	public static void main(String args[]) {
		Prova p = new Prova();
		p.creaGrafo();
	}

}
