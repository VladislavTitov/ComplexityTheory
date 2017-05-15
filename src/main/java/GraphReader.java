import java.io.*;

public class GraphReader {

    /**
     * Обычный неориентированный граф
     */
    private int[][] graph;

    /**
     * Это поле нужно для битового алгоритма, он предполагает то, что вершины смежны сами с собой
     * То есть в этом графе на каждой вершине - петля
     */
    private int[][] graphAdjacency;

    public GraphReader(String path) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){

            int vertexCount = 0;
            String currentString = reader.readLine();
            while (currentString != null && currentString.charAt(0) == 'c'){
                currentString = reader.readLine();
            }
            while (currentString != null && currentString.charAt(0) == 'p'){
                currentString = currentString.substring(2);
                currentString = currentString.substring(currentString.indexOf(' ') + 1);
                vertexCount = Integer.valueOf(currentString.substring(0, currentString.indexOf(' ')));
                graph = new int[vertexCount][vertexCount];
                graphAdjacency = new int[vertexCount][vertexCount];
                System.out.println(vertexCount);
                currentString = reader.readLine();
            }
            while (currentString != null){
                currentString = currentString.substring(2);
                int a = Integer.valueOf(currentString.substring(0, currentString.indexOf(' '))) - 1;
                int b = Integer.valueOf(currentString.substring(currentString.indexOf(' ') + 1)) - 1;
                graph[a][b] = 1;
                graph[b][a] = 1;
                graphAdjacency[a][b] = 1;
                graphAdjacency[b][a] = 1;
                //System.out.println(a + " " + b);
                currentString = reader.readLine();
            }

            for (int i = 0; i < vertexCount; i++) {
                graphAdjacency[i][i] = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] getGraph() {
        return graph;
    }

    public int[][] getGraphAdjacency() {
        return graphAdjacency;
    }
}
