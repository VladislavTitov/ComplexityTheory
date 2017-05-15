import java.util.ArrayList;
import java.util.Random;

public class NikitaMain {

    /*public static void main(String[] args) {
        int[][] graph =
                {   {0, 0, 0, 0, 1},
                    {0, 0, 1, 1, 0},
                    {0, 1, 0, 0, 1},
                    {0, 1, 0, 0, 1},
                    {1, 0, 1, 1, 0}
                };
        for (int i = 0; i < 1; i++) {
            System.out.println("_______Algoritm started_______");
            ArrayList<ArrayList<Integer>> coloredGraph = colorGraph(graph);
            System.out.println("Result: " + coloredGraph);
            System.out.println("_______Algoritm finished_______");
        }

	// write your code here
    }*/

    public static int colorGraph(int[][] graph) {

        ArrayList<ArrayList<Integer>> colored = new ArrayList<>();
        int color = 0;
        colored.add(new ArrayList<>());
        ArrayList<Integer> uncoloredVertex = new ArrayList<>();

        for (int i = 0; i < graph.length; i ++) {
            uncoloredVertex.add(i);
        }
        while (uncoloredVertex.size() != 0) {
            color = colorVertex(uncoloredVertex, graph, colored, color);
        }
        return color;

    }

    private static int colorVertex(ArrayList<Integer> uncoloredVertex, int[][] graph, ArrayList<ArrayList<Integer>> colored, int color) {
        int randomIndex = new Random().nextInt(uncoloredVertex.size());
        int randomVertex = uncoloredVertex.get(randomIndex);
        //System.out.println("Select random vertex: " + randomVertex+" at: " + randomIndex + " in" + uncoloredVertex);
        //System.out.println("Colored before:" + colored + "number of colors " + color);
        if (!canColorVertex(graph, randomVertex, colored, color)) {
            colored.add(new ArrayList<Integer>());

            color += 1;
            colored.get(color).add(randomVertex);

            uncoloredVertex.remove(randomIndex);

        }else {
            colored.get(color).add(randomVertex);
            uncoloredVertex.remove(randomIndex);
        }
        //System.out.println("Colored after:" + colored + "number of colors " + color);
        return color;

    }

    private static boolean canColorVertex(int[][] graph, int checkedVertex, ArrayList<ArrayList<Integer>> colored, int color) {
        for (int coloredVertex : colored.get(color)) {
            if (graph[coloredVertex][checkedVertex] == 1) {
                return false;
            }
        }
        return true;
    }
}
