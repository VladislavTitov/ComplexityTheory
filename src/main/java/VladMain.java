import java.util.ArrayList;
import java.util.List;

public class VladMain {

    static ArrayList<DimacsGraph> graphs = new ArrayList<>();

    static {
        graphs.add(new DimacsGraph("zeroin.i.2.col.txt", 30));
        graphs.add(new DimacsGraph("r250.5.col.txt", 65));
        graphs.add(new DimacsGraph("r1000.5.col.txt", 234));
        graphs.add(new DimacsGraph("le450_5d.col.txt", 5));
        graphs.add(new DimacsGraph("myciel3.col.txt", 4));
        graphs.add(new DimacsGraph("myciel4.col.txt", 5));
        graphs.add(new DimacsGraph("myciel5.col.txt", 6));
        graphs.add(new DimacsGraph("myciel6.col.txt", 7));
        graphs.add(new DimacsGraph("myciel7.col.txt", 8));
        graphs.add(new DimacsGraph("anna.col.txt", 11));
        graphs.add(new DimacsGraph("david.col.txt", 11));
        graphs.add(new DimacsGraph("homer.col.txt", 13));
        graphs.add(new DimacsGraph("flat300_28_0.col.txt", 28));
        graphs.add(new DimacsGraph("flat1000_50_0.col.txt", 50));
        graphs.add(new DimacsGraph("flat1000_60_0.col.txt", 60));
        graphs.add(new DimacsGraph("flat1000_76_0.col.txt", 76));
    }

    public static void main(String[] args) {
        for (int l = 0; l < graphs.size(); l++) {
            MyLogger.log("=========================================================");
            MyLogger.newLine();

            GraphReader graphReader = new GraphReader(System.getProperty("user.dir") + "/src/main/resources/dimacs/" + graphs.get(l).getName());
            MyLogger.log("Graph name: " + graphs.get(l).getName() + " ");
            MyLogger.log("Chrome number: " + graphs.get(l).getChromeNumber() + " ");
            MyLogger.log("Count of vertices: " + graphReader.getVerticesCount());
            MyLogger.newLine();

            MyLogger.log("Bit Algorithm\n");
            List<Integer> colors = new ArrayList<>(20);
            List<Long> times = new ArrayList<>(20);
            for (int i = 0; i < 20; i++) {
                BitAlgorithm bitAlgorithm = new BitAlgorithm();
                bitAlgorithm.execute(graphReader.getGraphAdjacency());
                colors.add(bitAlgorithm.getK());
                times.add(bitAlgorithm.getExecutingTime());
            }
            MyLogger.log("Average time: ");
            MyLogger.log(times.stream().mapToLong(value -> value).average().getAsDouble() + "");
            MyLogger.append(" ");
            MyLogger.log("Average color: ");
            MyLogger.log(colors.stream().mapToLong(value -> value).average().getAsDouble() + "");
            MyLogger.newLine();
            MyLogger.newLine();
            colors.clear();
            times.clear();

            MyLogger.log("Greedy Algorithm\n");
            for (int i = 0; i < 20; i++) {
                long startTime = System.nanoTime();
                int color = NikitaMain.colorGraph(graphReader.getGraph());
                long finishTime = System.nanoTime();
                MyLogger.log("Time: " + (finishTime - startTime) + " ");
                MyLogger.log("Chrome number: " + color + " ");
                MyLogger.newLine();
                colors.add(color);
                times.add(finishTime - startTime);
            }
            MyLogger.log("Average time: ");
            MyLogger.log(times.stream().mapToLong(value -> value).average().getAsDouble() + "");
            MyLogger.append(" ");
            MyLogger.log("Average color: ");
            MyLogger.log(colors.stream().mapToLong(value -> value).average().getAsDouble() + "");
            MyLogger.newLine();

            MyLogger.log("=========================================================");
            MyLogger.newLine();
            MyLogger.newLine();
        }
    }

}
