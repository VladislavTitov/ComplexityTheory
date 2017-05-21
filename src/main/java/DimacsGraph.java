public class DimacsGraph {

    private String name;
    private int chromeNumber;

    public DimacsGraph(String name, int chromeNumber) {
        this.name = name;
        this.chromeNumber = chromeNumber;
    }

    public String getName() {
        return name;
    }

    public int getChromeNumber() {
        return chromeNumber;
    }
}
