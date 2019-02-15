import java.util.Scanner;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
//-----------------------------------------------------
//Title: Task Graph Class
//Author: Egemen OZDAG
//ID: 47755722122
//Section: 1
//Assignment: 2
//Description: This class receiving a file and runs a methods which wanted by you.
//-----------------------------------------------------
public class Planner {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
	In inputFile = new In("input3.txt");
	TaskGraph graph = new TaskGraph(inputFile);
	System.out.println("Enter choice (0: Exit, 1: List schedule, 2: Check order): ");
	int sec = key.nextInt();
	
	if(sec == 0) {System.out.println("Bye");}
	else if(sec == 1) {
		System.out.println("Enter how many schedules per day?");
		int a = key.nextInt();
		//TaskGraph.DepthFirstOrder(graph);
		System.out.println(graph.listSchedule(a));
		
		}
	//.DepthFirstOrder(graph);
	else if(sec == 2) {
		System.out.print("Enter first task: ");
		String task1 = key.next();
		System.out.println();
		System.out.print("Enter second task: ");
		String task2 = key.next();
		System.out.println();
		TaskGraph.ComesAfter(task1,task2);
	}
	else {System.out.println("Wrong Input");}
	}
}
