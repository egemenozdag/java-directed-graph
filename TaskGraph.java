import java.util.*;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Stack;
//-----------------------------------------------------
// Title: Task Graph Class
// Author: Egemen OZDAG
// Section: 1
// Assignment: 2
// Description: This class makes a graph and includes methods which makes some ordering and etc.
//-----------------------------------------------------
public class TaskGraph {
	private static int V;
	private int E = 0;
	private static LinkedList<String>[] adj;
	private static ST<String, Integer> st;

	public TaskGraph(In in) {
		loadGraph(in);
	}

	private void loadGraph(In in) {
		/** This method reading lines calculating Vertexes and Edges and Loading Graph */
		ArrayList<String> lines;

		lines = new ArrayList<>();
		while (in.hasNextLine()) {
			lines.add(in.readLine());
		}
		st = new ST<>();
		for (int i = 0; i < Integer.parseInt(lines.get(0)); i++) {
			st.put(lines.get(i + 2), i);
		}
		V = Integer.parseInt(lines.get(0));

		adj = (LinkedList<String>[]) new LinkedList[V];
		for (int a = 0; a < V; a++) {
			adj[a] = new LinkedList<String>();
		}

		for (int i = 1 + V; !lines.get(i).equals("-1 -1"); i++) {
			String[] an = lines.get(i).split(" ");
			int a = Integer.parseInt(an[0]);
			int b = Integer.parseInt(an[1]);

			add(a, b);

		}
	}

	public void add(int ak, int b) {
		/** connecting tasks */
		String ba = null;
		for (String w : st.keys()) {
			if (st.get(w) == b) {
				ba = w;
			}
		}
		adj[ak].add(ba);
		E++;

	}

	public static void TaskGraph(In inputFile) {}

/** 	//This method is topological Sort method.
	   private boolean[] marked;
	   private Stack<Integer> reversePostorder;
	   public void DepthFirstOrder(TaskGraph graph){
	      reversePostorder = new Stack<Integer>();
	      marked = new boolean[graph.V()];
	      for (int v = 0; v < graph.V(); v++)
	         if (!marked[v]) dfs(graph, st.put(adj[v].toString()));
	   }
	   private void dfs(TaskGraph G, String v)
	   {	int i =0;
	      marked[i] = true;
	      for (String w : adj[i]) {
	    	  if (!marked[i]) dfs(G, w);i++;  
	      }reversePostorder.push(i);
	        
	      
	   }
	   public Iterable<Integer> reversePostorder()
	   {  return reversePostorder;  }

	*/

	public String listSchedule(int a) {
	/**	 List Schedule method
		 * Note For myself;
		 * to string metodunu slayta göre düzelt bunun dışında edge ve vertexlerin
		 * hepsini alabiliyorsun. Sırada yapman gereken; topological sort listcshedule*/
		 
		StringBuilder s = new StringBuilder();
		s.append("The program will schedule "+a+" tasks per day.\n");
		int i = 0;
		for (i = 0; i < 7; i++) {
			s.append("day " + (i + 1) + "\t\t: ");
			for (int is = 0; is < a; is++) {
				s.append(adj[i] + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
		
	public static void ComesAfter(String task1, String task2) {
		/** This is comes after method and I done this really simple  */
		int count1 = 0;
		int count2 = 0;
		for (String w : st.keys()) {if (w.equals(task1)) {break;}count1++;}
		for (String wn : st.keys()) {if (wn.equals(task2)) {break;}count2++;}
		if (count1 > count2) {System.out.println("You should do " + task1 + " before " + task2 + ".");} 
		else if (count1 > count2) {System.out.println("You should do " + task1 + " after " + task2 + ".");}
		else if (count1 == count2) {System.out.println("You should do " + task1 + " and " + task2 + " on the same day.");}
	}

	public int V() {return V;}

}