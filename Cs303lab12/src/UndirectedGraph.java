import java.io.BufferedReader;
import java.io.IOException;


public class UndirectedGraph extends Graph {

	public UndirectedGraph(BufferedReader reader) throws IOException
	{
		super(reader);
	}

	@Override
	/**
	 * Integer v always points at w
	 * v -- > w
	 */
	public void addEdge(int v, int w){
		//Adj List
		adj[v].add(w);
		adj[w].add(v);
		//Adj Matrix
		adjm[v][w] = 1;
		adjm[w][v] = 1;
	}
	
	
}