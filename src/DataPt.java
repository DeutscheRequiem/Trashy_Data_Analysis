import java.util.ArrayList;

/**
 * The DataPt class represents a data point in a graph.
 */
public class DataPt extends Point{
    private int deg; // degree of the data point
    private static int ptCount = 0; // count of total data points
    private static ArrayList<DataPt> dtPoints = new ArrayList<>();
    private ArrayList<Integer> edges = new ArrayList<>();

    /**
     * Constructs a DataPt object with the specified coordinates.
     *
     * @param x the x-coordinate of the data point
     * @param y the y-coordinate of the data point
     */
    public DataPt(double x, double y){
        super(x,y, "DT: " + (ptCount + 1));
        deg = 0;
        ptCount++;
        dtPoints.add(this);
    }
    /**
     * Sets the total count of data points.
     *
     * the total count of data points
     */
    public static void clear(){
        ptCount = 0;
        dtPoints = new ArrayList<>();
    }

    /**
     * Checks if two data points are within a specified distance of each other.
     *
     * @param r the distance threshold
     * @param a the first data point
     * @param b the second data point
     * @return true if the distance between the data points is less than or equal to the threshold, false otherwise
     */
    public static boolean neighborhood(double r, DataPt a, DataPt b){
        if(r >= Math.hypot(a.X() - b.X(), a.Y() - b.Y())){
            return true;
        }
        return false;
    }

    /**
     * Draws lines between data points that are within a specified distance of each other.
     *
     * @param r the distance threshold
     */
    public static void graph(double r) {
        StdDraw.setPenColor(StdDraw.MAGENTA);
        for (DataPt pt: dtPoints) {
            pt.edges.clear();
        }
        if (dtPoints.size() > 1) {
            for (int i = 0; i < dtPoints.size(); i++) {
                for (int j = 0; j < dtPoints.size(); j++) {
                    if (i == j) {
                        dtPoints.get(i).edges.add(0);
                        continue;
                    }
                    if(neighborhood(r, dtPoints.get(i), dtPoints.get(j))){
                        dtPoints.get(i).edges.add(1);
                        StdDraw.line(dtPoints.get(i).X(), dtPoints.get(i).Y(), dtPoints.get(j).X(), dtPoints.get(j).Y());
                    } else {
                        dtPoints.get(i).edges.add(0);
                    }
                }
            }
        }
        System.out.println();
        for (DataPt pt: dtPoints) {
            System.out.print("[ ");
            for (Integer n: pt.edges) {
                System.out.print(n + " ");
            }
            System.out.println("]");
        }
    }
    public void draw(){
        draw(StdDraw.BLACK);
    }
}
