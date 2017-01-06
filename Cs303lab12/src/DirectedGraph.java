import java.io.BufferedReader;
import java.io.IOException;


public class DirectedGraph extends Graph {
	 
	public DirectedGraph(BufferedReader reader) throws IOException
	{
		super(reader);
	}

	@Override
	/**
	 * Integer v always points at w
	 * v -- > w
	 */
	public void addEdge(int v, int w){
		//List
		adj[v].add(w);
		//Matrix
		adjm[v][w] = 1;
	}

}