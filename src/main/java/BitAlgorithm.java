import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BitAlgorithm {

    private int k;
    private Set<Integer> v;
    private List<Set<Integer>> sets;
    private int[][] graph;
    private long executingTime;

    public void execute(int[][] graph){
        this.graph = copyGraph(graph);
        prepare();
        long startTime = System.nanoTime();
        process();
        long finishTime = System.nanoTime();
        MyLogger.log("Time: ");
        executingTime = finishTime - startTime;
        MyLogger.logTime(executingTime);
        MyLogger.append(" ");
        MyLogger.log("Chrome number: " + k + " ");
        MyLogger.newLine();
    }

    private int[][] copyGraph(int[][] graph){
        int[][] newGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

    private void prepare(){
        v = new HashSet<>();
        sets = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            v.add(i);
        }
    }

    private void process(){
        k = 0;
        int n = graph.length;
        for (int i = 0; i < n + 1; i++) {
            if (!v.contains(i)){
                continue;
            }

            sets.add(new HashSet<>());
            sets.get(k).add(i);

            v.remove(i);

            while (rowContainsZero(i)){
                int j;
                for (j = i + 1; j < n; j++) {
                    if (graph[i][j] == 0 && v.contains(j)) break;
                }
                if (j == n) break;
                sets.get(k).add(j);
                v.remove(j);
                concatenate(i, j);
            }

            k++;
        }
    }

    private boolean rowContainsZero(int i){
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 0){
                return true;
            }
        }
        return false;
    }

    private void concatenate(int i, int j){
        for (int l = 0; l < graph.length; l++) {
            graph[i][l] = graph[i][l] | graph[j][l];
        }
    }

    /*private void showProcess(){
        System.out.println("==========================================================");
        System.out.println(v);
        sets.forEach(s -> System.out.print(s.toString() + " "));
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("k = " + k);
        System.out.println("==========================================================");
        System.out.println();
    }*/

    public int getK() {
        return k;
    }

    public long getExecutingTime() {
        return executingTime;
    }
}
