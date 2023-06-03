import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Canvas class provides methods for managing the canvas and user interface for the application.
 */
public class Canvas {
    private static double scale = 1;
    private static double rNeighborhood = 0;

    /**
     * Returns the scale value of the canvas.
     *
     * @return the scale value of the canvas
     */
    public static double Scale(){
        return scale;
    }

    /**
     * Sets the scale value of the canvas.
     *
     * @param sc the new scale value to set
     */
    public static void setScale(double sc){
        if (sc > 0)
        StdDraw.setScale(0,sc);
        StdDraw.show();
    }

    /**
     * Clears the canvas by removing all drawn elements and resetting the storage.
     */
    public static void clearCanvas(){
        StdDraw.clear();
        DataPt.clear();
        BoundPt.clear();
    }

    /**
     * Prompts the user and displays the tools on the canvas.
     */
    public static void promptUser(){
        JFrame frame = new JFrame();
        JFrame loc = new JFrame();
        JFrame radius = new JFrame();
        JFrame scale = new JFrame();
        frame.setTitle("Tools");
        frame.setSize(450, 125);
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        JButton button1 = new JButton("Graph");
        JButton button2 = new JButton("Location");
        JButton button3 = new JButton("Boundaries");
        JButton button4 = new JButton("Clear");
        JButton button5 = new JButton("Radius");
        JButton button6 = new JButton("Centroid");
        JButton button7 = new JButton("Scale");

        button1.addActionListener(e -> {
            DataPt.graph(rNeighborhood * Scale());
            StdDraw.show();
        });

        JButton Dublin = new JButton("Dublin");
        JButton Busan = new JButton("Busan");
        JButton Casablanca = new JButton("Casablanca");
        JButton Zagreb = new JButton("Zagreb");

        button2.addActionListener(e -> {
            loc.setTitle("Locations");
            loc.setSize(125, 200);
            JPanel locPanel = new JPanel();
            loc.getContentPane().add(locPanel);
            locPanel.add(Dublin);
            locPanel.add(Busan);
            locPanel.add(Casablanca);
            locPanel.add(Zagreb);
            loc.setVisible(true);
        });

        Zagreb.addActionListener(e -> {
            StdDraw.picture(0.5 * Scale(), 0.5 * Scale(), "zag.png", Scale(), Scale());
            StdDraw.show();
        });

        Casablanca.addActionListener(e -> {
            StdDraw.picture(0.5 * Scale(), 0.5 * Scale(), "casa.png", Scale(), Scale());
            StdDraw.show();
        });

        Busan.addActionListener(e -> {
            StdDraw.picture(0.5 * Scale(), 0.5 * Scale(), "busa.png", Scale(), Scale());
            StdDraw.show();
        });

        Dublin.addActionListener(e -> {
            StdDraw.picture(0.5 * Scale(), 0.5 * Scale(), "dub.png", Scale(), Scale());
            StdDraw.show();
        });

        button3.addActionListener(e -> {
            BoundPt.drawBoundaries();
            StdDraw.show();
        });

        button4.addActionListener(e -> {
            Canvas.clearCanvas();
            StdDraw.show();
        });

        JButton rSubmit = new JButton("Submit");
        JTextField rField = new JTextField(2);

        button5.addActionListener( e -> {
            radius.setTitle("Radius of Neighborhood");
            radius.setSize(200, 200);
            JPanel rPanel = new JPanel();
            rPanel.add(rSubmit);
            rPanel.add(rField);
            radius.getContentPane().add(rPanel);
            radius.setVisible(true);
        });


        rSubmit.addActionListener(e -> {
            rNeighborhood = Double.parseDouble(rField.getText());
            radius.setVisible(false);
        });

        button6.addActionListener(e -> {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(BoundPt.centroidX(), BoundPt.centroidY(), 0.01);
            StdDraw.show();
        });

        JPanel sPanel = new JPanel();
        JTextField sField = new JTextField(2);
        JButton sSubmit = new JButton("Submit");
        button7.addActionListener(e -> {
            scale.setTitle("Scale");
            scale.setSize(200, 200);
            scale.getContentPane().add(sPanel);
            sPanel.add(sField);
            sPanel.add(sSubmit);
            scale.setVisible(true);
        });

        sSubmit.addActionListener(e -> {
            setScale(Double.parseDouble(sField.getText()));
            scale.setVisible(false);

        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loc.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        radius.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        scale.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
