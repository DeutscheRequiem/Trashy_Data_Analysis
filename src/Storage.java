import java.util.ArrayList;
import java.util.ArrayList;

/**
 * The Storage class provides storage and utility methods for managing data points and bounded data points.
 */
public class Storage {
    private static ArrayList<DataPt> PtList = new ArrayList<DataPt>(); // list of data points
    private static ArrayList<BoundPt> BdList = new ArrayList<BoundPt>(); // list of bounded data points
    private static DataPt[][] adjMatrix = new DataPt[1][1]; // adjacency matrix (not currently used)

    /**
     * Adds a data point to the storage.
     *
     * @param p the data point to be added
     */
    public static void addPt(DataPt p){
        PtList.add(p);
    }

    /**
     * Adds a bounded data point to the storage.
     *
     * @param p the bounded data point to be added
     */
    public static void addBdPt(BoundPt p){
        BdList.add(p);
    }

    /**
     * Resets the storage by clearing the lists and resetting the total weight of bounded data points.
     */
    public static void resetStorage(){
        PtList.clear();
        BdList.clear();
        BoundPt.setTotWeight(0);
    }

    /**
     * Retrieves a bounded data point from the storage at the specified index.
     *
     * @param i the index of the bounded data point to retrieve
     * @return the bounded data point at the specified index, or null if the index is out of bounds
     */
    public static BoundPt getBdPt(int i){
        if (i >= 0 && i < getBdSize()){
            return BdList.get(i);
        }
        return null;
    }

    /**
     * Prints the coordinates of the data points in the storage.
     *
     * @return a string representation of the coordinates of the data points
     */
    public static String print(){
        String a = "";
        for(DataPt poi : PtList){
            a = a + "("+ poi.X() + ", " + poi.Y() + ")\n";
        }
        return a;
    }

    /**
     * Prints the coordinates of the bounded data points in the storage.
     *
     * @return a string representation of the coordinates of the bounded data points
     */
    public static String Bdprint(){
        String a = "";
        for(BoundPt poi : BdList){
            a = a + "("+ poi.X() + ", " + poi.Y() + ")\n";
        }
        return a;
    }

    /**
     * Returns the number of data points in the storage.
     *
     * @return the number of data points in the storage
     */
    public static int getSize(){
        return PtList.size();
    }

    /**
     * Returns the number of bounded data points in the storage.
     *
     * @return the number of bounded data points in the storage
     */
    public static int getBdSize(){
        return BdList.size();
    }

    /**
     * Retrieves a data point from the storage at the specified index.
     *
     * @param i the index of the data point to retrieve
     * @return the data point at the specified index, or null if the index is out of bounds
     */
    public static DataPt getDataPt(int i ){
        if (i >= 0 && i < getSize()){
            return PtList.get(i);
        }
        return null;
    }

    /**
     * Sorts the bounded data points in counterclockwise order.
     */
    public static void BdSort(){
        int n = BdList.size();

        for (int i = 2; i < n; i++) {
            BoundPt temp = BdList.get(i);
            int j = i - 1;

            while (j >= 0 && (BoundPt.compareCCW(temp, BdList.get(j)) == -1)) {
                BdList.set(j + 1, BdList.get(j));
                j--;
            }

            BdList.set(j + 1, temp);
        }
    }

    /**
     * Draws the boundaries connecting the bounded data points on the graph.
     */
    public static void drawBoundaries(){
        StdDraw.setPenColor(StdDraw.RED);
        for(int i = 0; i < getBdSize()-1; i++){
            StdDraw.line(BdList.get(i).X(), BdList.get(i).Y(), BdList.get(i + 1).X(), BdList.get(i + 1).Y());
        }
        StdDraw.line(BdList.get(0).X(), BdList.get(0).Y(), BdList.get(getBdSize()-1).X(), BdList.get(getBdSize()-1).Y());
    }

    /**
     * Calculates the centroid's x-coordinate of the bounded data points.
     *
     * @return the x-coordinate of the centroid of the bounded data points
     */
    public static double centroidX(){
        double centroidX = 0.0;
        for (BoundPt p : BdList){
            centroidX = centroidX + p.X();
        }
        centroidX = centroidX / BoundPt.getTotWeight();
        return centroidX;
    }

    /**
     * Calculates the centroid's y-coordinate of the bounded data points.
     *
     * @return the y-coordinate of the centroid of the bounded data points
     */
    public static double centroidY(){
        double centroidY = 0.0;
        for (BoundPt p : BdList) {
            centroidY = centroidY + p.Y();
        }
        centroidY = centroidY / BoundPt.getTotWeight();
        return centroidY;
    }
}
