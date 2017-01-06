
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Driver {
	public static void main(String[] args) {
		
		testTinyDG(); //Directed
		testMediumG();
		//testLargeG();

	}
	public static void testTinyDG() {
		FileReader r;
		try {
			r = new FileReader(new File("tinyDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			DirectedGraph g = new DirectedGraph(bf);
			System.out.println("\ntinyDG:\n");
			System.out.println(g.tostringM());
			System.out.println(g.tostring());
			double time = System.nanoTime()/100; //microseconds
			g.BFS(8);
			time = System.nanoTime()/100 - time;
			System.out.println("BFS from vertex " + "8: " + Double.toString(time) + " microseconds");

			r = new FileReader(new File("tinyDG.txt"));
			bf = new BufferedReader(r);
			g = new DirectedGraph(bf);
			time = System.nanoTime()/100;
			g.BFSM(8);
			time = System.nanoTime()/100 - time;
			System.out.println("BFSM from vertex " + "8: " + Double.toString(time) +" micrseconds");

			System.out.println("printPath(8,5): ");
			g.printPath(8, 5);

			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void testMediumG() {
		FileReader r;
		try {
			r = new FileReader(new File("mediumG.txt"));
			BufferedReader bf = new BufferedReader(r);
			UndirectedGraph g = new UndirectedGraph(bf);
			System.out.println("\nmediumG:\n");
			//System.out.println(g.tostringM());
			//System.out.println(g.tostring());
			double time = System.nanoTime()/100; //microseconds
			g.BFS(8);
			time = System.nanoTime()/100 - time;
			System.out.println("BFS from vertex " + "8: " + Double.toString(time) +" microseconds");

			r = new FileReader(new File("mediumG.txt"));
			bf = new BufferedReader(r);
			g = new UndirectedGraph(bf);
			time = System.nanoTime()/100;
			g.BFSM(8);
			time = System.nanoTime()/100 - time;
			System.out.println("BFSM from vertex " + "8: " + Double.toString(time) +" microseconds");

			System.out.println("printPath(8,5): ");
			g.printPath(8, 5);

			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testLargeG() {
		FileReader r;
		try {
			r = new FileReader(new File("largeG.txt"));
			BufferedReader bf = new BufferedReader(r);
			UndirectedGraph g = new UndirectedGraph(bf);
			System.out.println("\nlargeG:\n");
//			System.out.println(g.tostringM());
//			System.out.println(g.tostring());
			double time = System.nanoTime()/100; //microseconds
			g.BFS(4);
			time = System.nanoTime()/100 - time;
			System.out.println("BFS from vertex " + "4: " + Double.toString(time) + " microseconds");

			r = new FileReader(new File("largeG.txt"));
			bf = new BufferedReader(r);
			g = new UndirectedGraph(bf);
			time = System.nanoTime()/100;
			g.BFSM(4);
			time = System.nanoTime()/100 - time;
			System.out.println("BFSM from vertex " + "4: " + Double.toString(time) + " microseconds");

			System.out.println("printPath(4,0): ");
			g.printPath(4, 0);

			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}