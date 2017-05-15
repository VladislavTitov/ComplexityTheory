import java.util.Random;

public class GraphGenerator {

    /**
     * The method generates graph with given amount of vertices
     * @param vertexCount number of vertices
     * @param adjacency boolean variable that says either vertex adjacent yourself or not
     * @return table of adjacency
     */
    public static int[][] generateGraph(int vertexCount, boolean adjacency){
        int[][] graph = new int[vertexCount][vertexCount];
        Random random = new Random();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                graph[i][j] = graph[j][i] = random.nextBoolean() ? 1 : 0;
            }
        }

        if (adjacency){
            for (int i = 0; i < vertexCount; i++) {
                graph[i][i] = 1;
            }
        }

        return graph;
    }

    public static int[][] printGraph(int[][] graph){
        int vertexCount = graph.length;
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        return graph;
    }

}
