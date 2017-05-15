
public class VladMain {

    public static void main(String[] args) {

        GraphReader graphReader = new GraphReader(System.getProperty("user.dir") + "/src/main/resources/dimacs/r250.5.col.txt");

        BitAlgorithm bitAlgorithm = new BitAlgorithm();
        bitAlgorithm.execute(graphReader.getGraphAdjacency());

        System.out.println("\n\n");
        System.out.println(NikitaMain.colorGraph(graphReader.getGraph()));

    }

}
