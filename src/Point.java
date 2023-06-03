import java.awt.*;
import java.util.ArrayList;

public class Point {
    protected double x;
    protected double y;
    protected String ID;
    protected static ArrayList<Point> points = new ArrayList<>();
    public Point (double x, double y, String ID){
        this.x = x;
        this.y = y;
        this.ID = ID;
        points.add(this);
        StdDraw.clear();
        for (Point p: points) {
            p.draw();
        }
    }
    public double X(){
        return x;
    }
    public double Y(){
        return y;
    }
    public void draw(Color c){
        StdDraw.setPenColor(c);
        StdDraw.filledCircle(x, y, 0.008 * Canvas.Scale());
        StdDraw.text(x + 0.01 * Canvas.Scale(), y + 0.01 * Canvas.Scale(), ID);
        StdDraw.show();
    }
    public void draw(){}
}
