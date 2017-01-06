
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Graph {
	public int V;
	public int E;
	protected LinkedList<Integer>[] adj;
	protected int[][] adjm;
	private final int WHITE = 0;
	private final int GREY = 1;
	private final int BLACK = 2; 
	private final int NIL = -1;
	private final int INF = -2;
	
	private int[] color;
	private int[] distance; 
	private int[] parent;
	
	public Graph()
	{
		V = 0;
		E = 0;
	}
	
	public Graph(BufferedReader reader) throws IOException
	{
		String line;
		line = reader.readLine();
		V = Integer.parseInt(line);
		line = reader.readLine();
		E = Integer.parseInt(line);
		//adjacency list
		adj =  new LinkedList[V];
		//adjacency matrix
		adjm = new int[V][V];
		
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<>();
		}
		while ((line = reader.readLine()) != null) {
			int tempV1, tempV2;
			  StringTokenizer st = new StringTokenizer(line, " ");
			  tempV1 = Integer.parseInt(st.nextToken());
			  tempV2 = Integer.parseInt(st.nextToken());
			  addEdge(tempV1, tempV2);
		}
	}
	
	
	public void addEdge(int v, int w) {
		
	}
	
	
	public void BFS(int s){
		LinkedList<Integer> q = new LinkedList<>();
		
		color = new int[adj.length];
		distance = new int[adj.length];
		parent = new int[adj.length];
		
		for(int i = 0; i < color.length; i++) {
			if (i == s) {
				color[i] = GREY;
				distance[i] = 0;
				parent[i] = NIL;
			}
			else{
				color[i] = WHITE;
				distance[i] = INF;
				parent[i] = NIL;
			}
		}
		
		q.add(s);
		while(!q.isEmpty()){
			int u = q.remove();
			for(int v : adj[u]){
				if (color[v] == WHITE){
					color[v] = GREY;
					distance[v] = distance[u] + 1;
					parent[v] = u;
					q.add(v);
				}
				color[u] = BLACK;
			}
		}
	}
	
	
	public void BFSM(int s){
		LinkedList<Integer> q = new LinkedList<>();
		
		color = new int[adjm.length];
		distance = new int[adjm.length];
		parent = new int[adjm.length];
		
		for(int i = 0; i < color.length; i++) {
			if (i == s) {
				color[i] = GREY;
				distance[i] = 0;
				parent[i] = NIL;
			}
			else{
				color[i] = WHITE;
				distance[i] = INF;
				parent[i] = NIL;
			}
		}
		
		q.add(s);
		while(!q.isEmpty()){
			int u = q.remove();
			int inner = 0;
			for(int v : adjm[u]){
				if (color[inner] == WHITE && v == 1){
					color[inner] = GREY;
					distance[inner] = distance[u] + 1;
					parent[inner] = u;
					q.add(inner);
				}
				color[u] = BLACK;
				inner += 1;
			}
		}
	}
	
	public void printPath(int s, int v){
		if (v == s) {
			System.out.print(" " + s + " ");
		} else if(parent[v] == NIL){
			System.out.println("no pathm from " + s + " to " + v);
		} else {
			printPath(s, parent[v]);
			System.out.print(" " + v + " ");
		}
		
	}
	
	public String tostringM(){
		String s = "There are "+V+" vertices and "+E+" edges\n";
		String lm = "";
		int dist = 5;
		int tmp;
		
		for (int i = 0; i < adjm.length; i++){
			tmp = dist;
			lm += Integer.toString(i) + ":|"; 
			for (int k = Integer.toString(i).length(); k >= 0; k--){
				tmp -= 1;
			}
			for (int k = tmp; k >= 0; k--)
			{
				lm+=" ";
			}
			lm += Arrays.toString(adjm[i]);
			lm += "\n";
		}
		return s+lm;
	}
	
	public String tostring()
	{
		String s = new String();
		s = "There are "+V+" vertices and "+E+" edges\n";
		for(int i=0;i<V;i++)
		{
			s = s+i+": ";
			for(int j = 0; j<adj[i].size();j++)
			{
				s = s+adj[i].get(j)+" ";
			}
			s = s+"\n";
			
		}
		return s;
	}
	
}