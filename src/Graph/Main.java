package Graph;

public class Main {

    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");


        System.out.println("Graph before removeVertex():");
        myGraph.printGraph();

        myGraph.removeVertex("D");

        System.out.println("\nGraph after removeVertex():");
        myGraph.printGraph();
    }
}
