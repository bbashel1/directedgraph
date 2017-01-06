import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo; 		// edgeTo[v] = last edge on s-v path
    private int [] distTo;
    private final int s;   
    private final Graph G;// source vertex
    
    public LinkedList<Integer> list = new LinkedList<>();

    /**
     * Computes a path between <tt>s</tt> and every other vertex in graph <tt>G</tt>.
     * @param G the graph you built in the previous assignment, make sure it has the adjacency list adj for each vertex
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph G, int s) {
    	this.G = G;
    	this.s=s;
    	this.edgeTo = new int [G.V];
    	this.marked = new boolean [G.V];
        //initialize marked, edgeTo and s
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
    	marked[v] = true;
    	for(int w : G.adj[v]){
    		if(!marked[w]){
    			edgeTo[w] = v;
    			//distTo[w] =v;
    			dfs(G, w);
    		}
    	}
    	list.addFirst(v);
        //write your dfs code here. Edit edgeTo and marked whenever necessary. It would be easy to use recursion in this function
		}

    /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
		return marked[v];
   
    }

    /**
     * Returns a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>, or
     * <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *   <tt>s</tt> and vertex <tt>v</tt>, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
    	if(!hasPathTo(v)) 
		return null;
    	Stack<Integer> path = new Stack <Integer>();
    	int x; 
    	for (x=v; x != 0; x = edgeTo[x])
    		path.push(x);
    	path.push(x);
    	return path;
    }

    /**
     * Unit tests the <tt>DepthFirstPaths</tt> data type.
     */
    
    public LinkedList<Integer> topologicalSort(){
		for (int i = 0; i < this.G.adj.length; i++){
			if (!marked[i]){
				dfs(this.G, i);
			}
		}
		return this.list;
	}
}