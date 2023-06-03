import java.util.ArrayList;

/**
 * The BoundPt class represents a bounded data point in a graph, extending the DataPt class.
 * It adds a weight property to the data point and provides methods to compare points in a counterclockwise manner.
 */
public class BoundPt extends Point {
    private double weight; // weight of the bounded data point
    private static double ptCount = 0; // total weight of all bounded data points
    private static ArrayList<BoundPt> bdPoints = new ArrayList<>();

    /**
     * Gets the total weight of all bounded data points.
     *
     * @return the total weight of all bounded data points
     */
    public static double getPtCount() {
        return ptCount;
    }

    /**
     * Sets the total weight of all bounded data points.
     *
     * @param i the total weight of all bounded data points
     */
    public static void setPtCount(int i) {
        ptCount = i;
    }

    /**
     * Constructs a BoundPt object with the specified coordinates and weight.
     * If the weight is less than or equal to zero, it is set to 1.
     *
     * @param x      the x-coordinate of the bounded data point
     * @param y      the y-coordinate of the bounded data point
     */
    public BoundPt(double x, double y) {
        super(x,y, "BD: " + (ptCount + 1));
        ptCount++;
        bdPoints.add(this);
    }

    /**
     * Compares two bounded data points in a counterclockwise manner.
     * It calculates the cross product of the vectors formed by the points and compares the result.
     *
     * @param p1 the first bounded data point
     * @param p2 the second bounded data point
     * @return -1 if p2 is counterclockwise to p1, 1 if p2 is clockwise to p1, 0 if they are collinear
     */
    public static int compareCCW(BoundPt p1, BoundPt p2) {
        double crossProduct = (p2.X() - p1.X()) * -p1.Y() - (p2.Y() - p1.Y()) * -p1.Y();
        if (crossProduct < 0) {
            return -1;
        } else if (crossProduct > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Draws a bounded data point on the graph using the current mouse coordinates.
     * Also adds the bounded data point to the storage.
     */
    public static double centroidX(){
        double centroidX = 0.0;
        for (BoundPt p : bdPoints){
            centroidX = centroidX + p.X();
        }
        centroidX = centroidX / ptCount;
        return centroidX;
    }
    public static double centroidY(){
        double centroidY = 0.0;
        for (BoundPt p : bdPoints) {
            centroidY = centroidY + p.Y();
        }
        centroidY = centroidY / ptCount;
        return centroidY;
    }
    public static void clear(){
        bdPoints = new ArrayList<>();
        ptCount = 0;
    }
    public static void drawBoundaries(){
        StdDraw.setPenColor(StdDraw.RED);
        for(int i = 0; i < bdPoints.size() - 1; i++){
            StdDraw.line(bdPoints.get(i).X(), bdPoints.get(i).Y(), bdPoints.get(i + 1).X(), bdPoints.get(i + 1).Y());
        }
        StdDraw.line(bdPoints.get(0).X(), bdPoints.get(0).Y(), bdPoints.get(bdPoints.size() - 1).X(), bdPoints.get(bdPoints.size() - 1).Y());
    }
    public void draw(){
        draw(StdDraw.RED);
    }
}
