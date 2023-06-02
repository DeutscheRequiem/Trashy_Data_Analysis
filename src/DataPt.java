/**
 * The DataPt class represents a data point in a graph.
 */
public class DataPt {
    private double x; // x-coordinate of the data point
    private double y; // y-coordinate of the data point
    private int deg; // degree of the data point
    private static int ptcount = 0; // count of total data points

    /**
     * Constructs a DataPt object with the specified coordinates.
     *
     * @param x the x-coordinate of the data point
     * @param y the y-coordinate of the data point
     */
    public DataPt(double x, double y){
        this.x = x;
        this.y = y;
        deg = 0;
        ptcount++;
    }

    /**
     * Returns the x-coordinate of the data point.
     *
     * @return the x-coordinate of the data point
     */
    public double X() {
        return x;
    }

    /**
     * Returns the y-coordinate of the data point.
     *
     * @return the y-coordinate of the data point
     */
    public double Y() {
        return y;
    }

    /**
     * Sets the total count of data points.
     *
     * @param n the total count of data points
     */
    public static void setPtcount(int n){
        if(n >= 0) {
            ptcount = n;
        }
    }

    /**
     * Draws a point on the graph using the current mouse coordinates.
     * Also adds the data point to the storage.
     */
    public static void drawPoint(){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(StdDraw.mouseX(), StdDraw.mouseY(), 0.008 * Canvas.Scale());
        Storage.addPt(new DataPt(StdDraw.mouseX(), StdDraw.mouseY()));
        StdDraw.show();
        StdDraw.pause(10);
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
        if (Storage.getSize() > 2) {
            for (int i = 0; i < Storage.getSize(); i++) {
                for (int j = 1; j < Storage.getSize(); j++) {
                    if(neighborhood(r, Storage.getDataPt(i), Storage.getDataPt(j))){
                        StdDraw.line(Storage.getDataPt(i).X(), Storage.getDataPt(i).Y(), Storage.getDataPt(j).X(), Storage.getDataPt(j).Y());
                    }
                }
            }
        }
    }
}
