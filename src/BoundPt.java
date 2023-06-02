/**
 * The BoundPt class represents a bounded data point in a graph, extending the DataPt class.
 * It adds a weight property to the data point and provides methods to compare points in a counterclockwise manner.
 */
public class BoundPt extends DataPt {
    private double weight; // weight of the bounded data point
    private static double totWeight = 0; // total weight of all bounded data points

    /**
     * Gets the total weight of all bounded data points.
     *
     * @return the total weight of all bounded data points
     */
    public static double getTotWeight() {
        return totWeight;
    }

    /**
     * Sets the total weight of all bounded data points.
     *
     * @param i the total weight of all bounded data points
     */
    public static void setTotWeight(int i) {
        totWeight = i;
    }

    /**
     * Constructs a BoundPt object with the specified coordinates and weight.
     * If the weight is less than or equal to zero, it is set to 1.
     *
     * @param x      the x-coordinate of the bounded data point
     * @param y      the y-coordinate of the bounded data point
     * @param weight the weight of the bounded data point
     */
    public BoundPt(double x, double y, double weight) {
        super(x, y);
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 1;
        }
        totWeight += this.weight;
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
    public static void drawPoint() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(StdDraw.mouseX(), StdDraw.mouseY(), 0.008 * Canvas.Scale());
        Storage.addBdPt(new BoundPt(StdDraw.mouseX(), StdDraw.mouseY(), 1.0));
        StdDraw.show();
    }
}
