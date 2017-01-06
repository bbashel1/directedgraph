import java.io.BufferedReader;
import java.io.IOException;


public class UndirectedGraph extends Graph {

	public UndirectedGraph(BufferedReader reader) throws IOException
	{
		super(reader);
	}

	//integer v toward to w all the time 
	public void addEdge(int v, int w){
		/**
		 * 2d adjacent 
		 */
		adj[v].add(w);
		adj[w].add(v);
	/**
	 * matrix section 
	 */
		adjm[v][w] = 1;
		adjm[w][v] = 1;
	}
}
