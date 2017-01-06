
import java.io.BufferedReader;
import java.io.IOException;

public class DirectedGraph extends Graph {
	
	public DirectedGraph(BufferedReader reader) throws IOException
	{
		super(reader);
	}

	@Override
	public void addEdge(int v, int w){
		adj[v].add(w); 			///this can be the list 
		adjm[v][w] = 1; 		///this can be matrix
	}

}