import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TDA {
    //private static boolean arrayPrinted = true;
    private static boolean pointDrawn = true;

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(0, Canvas.Scale());
        SwingUtilities.invokeLater(() -> Canvas.promptUser());
        while (true) {
            //Hold shift and click to create points
            if (StdDraw.isKeyPressed(16) && StdDraw.isMousePressed() && pointDrawn) {
                pointDrawn = false;
                DataPt.drawPoint();
            }else if (!StdDraw.isKeyPressed(16) && !StdDraw.isMousePressed()) {
                pointDrawn = true;
            }
            //Hold q and click to create boundary points
            if (StdDraw.isKeyPressed(81) && StdDraw.isMousePressed() && pointDrawn) {
                pointDrawn = false;
                BoundPt.drawPoint();
            }else if (!StdDraw.isKeyPressed(81) && !StdDraw.isMousePressed()) {
                pointDrawn = true;
            }

            //if (StdDraw.isKeyPressed(80) && arrayPrinted) {

                //System.out.println(Storage.centroidX()+", "+Storage.centroidY());
                //arrayPrinted = false;
            //}else if (!StdDraw.isKeyPressed(80)) {
                //arrayPrinted = true;
            //}

        }
    }
}








