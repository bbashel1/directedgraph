import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;


public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testTinyDG(); //Directed
		testMediumG();
	}
	private static void testMediumG() {
		
		FileReader r;
		try {
			System.out.println("\ntestMediumDG\n");
			r = new FileReader(new File("tinyDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			UndirectedGraph g = new UndirectedGraph(bf);
			//Initial dfs section
			System.out.println("Before Topological Sort; dfs from node 0: ");
			int h = 5;
			DepthFirstPaths dfp = new DepthFirstPaths(g,h);
			//Base string for printing paths From 'x' to 'y'
			String xl = "From " + Integer.toString(h) + " to ";
			for (int i = 0; i < g.V; i++){
				String s = "";
				String lz = Integer.toString(i);
				if (i < 10) lz += " ";
				//returned stack of ints
				Iterable<Integer> h2 = dfp.pathTo(i);
				if (h2 == null) {
					System.out.println(xl + lz + ": NONE");
					
				} else {
					for (int k : h2){
						s =  Integer.toString(k)+", " + s;
					}
					
					s = xl + lz + ": " + s.substring(0, s.length() - 2);
					System.out.println(s);
				}
			}
			
			
			
			//Topological sort section
			LinkedList<Integer> list = dfp.topologicalSort();
			
			System.out.println("\nAfter Topological Sort; all nodes traversed:");
			xl = "From " + Integer.toString(h) + " to ";
			for (int i = 0; i < g.V; i++){
				String s = "";
				String lz = Integer.toString(i);
				if (i < 10) lz += " ";
				//returned stack of ints
				Iterable<Integer> kk = dfp.pathTo(i);
				if (kk == null) {
					System.out.println(xl + lz + ": NONE");
					
				} else {
					for (int k : kk){
						s =  Integer.toString(k)+", " + s;
					}
					
					s = xl + lz + ": " + s.substring(0, s.length() - 2);
					System.out.println(s);
				}
			}
			
			
			//Topological sort print
			System.out.println("\nTopological Sort in Order:");
			String s = "";
			int k = list.size();
			for (int i = 0; i < k; i++){
				s += (list.pop() + ", ");
			}
			System.out.println(s.subSequence(0, s.length()-2));
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	public static void testTinyDG() {
		FileReader r;
		try {
			System.out.println("\ntestTinyDG\n");
			r = new FileReader(new File("tinyDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			DirectedGraph g = new DirectedGraph(bf);
			//Initial dfs section
			System.out.println("Before Topological Sort; dfs from node 0: ");
			int h = 5;
			DepthFirstPaths dfp = new DepthFirstPaths(g,h);
			//Base string for printing paths From 'x' to 'y'
			String xl = "From " + Integer.toString(h) + " to ";
			for (int i = 0; i < g.V; i++){
				String s = "";
				String lz = Integer.toString(i);
				if (i < 10) lz += " ";
				//returned stack of ints
				Iterable<Integer> h2 = dfp.pathTo(i);
				if (h2 == null) {
					System.out.println(xl + lz + ": NONE");
					
				} else {
					for (int k : h2){
						s =  Integer.toString(k)+", " + s;
					}
					
					s = xl + lz + ": " + s.substring(0, s.length() - 2);
					System.out.println(s);
				}
			}
			
			
			
			//Topological sort section
			LinkedList<Integer> list = dfp.topologicalSort();
			
			System.out.println("\nAfter Topological Sort; all nodes traversed:");
			xl = "From " + Integer.toString(h) + " to ";
			for (int i = 0; i < g.V; i++){
				String s = "";
				String lz = Integer.toString(i);
				if (i < 10) lz += " ";
				//returned stack of ints
				Iterable<Integer> kk = dfp.pathTo(i);
				if (kk == null) {
					System.out.println(xl + lz + ": NONE");
					
				} else {
					for (int k : kk){
						s =  Integer.toString(k)+", " + s;
					}
					
					s = xl + lz + ": " + s.substring(0, s.length() - 2);
					System.out.println(s);
				}
			}
			
			
			//Topological sort print
			System.out.println("\nTopological Sort in Order:");
			String s = "";
			int k = list.size();
			for (int i = 0; i < k; i++){
				s += (list.pop() + ", ");
			}
			System.out.println(s.subSequence(0, s.length()-2));

			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}