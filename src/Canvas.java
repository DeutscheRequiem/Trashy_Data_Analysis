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
    public void setScale(double sc){
        scale = sc;
    }

    /**
     * Clears the canvas by removing all drawn elements and resetting the storage.
     */
    public static void clearCanvas(){
        StdDraw.clear();
        Storage.resetStorage();
        DataPt.setPtcount(0);
    }

    /**
     * Prompts the user and displays the tools on the canvas.
     */
    public static void promptUser(){
        JFrame frame = new JFrame();
        JFrame loc = new JFrame();
        JFrame radius = new JFrame();
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
            Storage.drawBoundaries();
            StdDraw.show();
        });

        button4.addActionListener(e -> {
            Canvas.clearCanvas();
            StdDraw.show();
        });

        JButton r1 = new JButton("0.05");
        JButton r2 = new JButton("0.1");
        JButton r3 = new JButton("0.2");
        JButton r4 = new JButton("0.3");
        JButton r5 = new JButton("0.4");
        JButton r6 = new JButton("0.5");
        JButton r7 = new JButton("0.75");
        JButton r8 = new JButton("0.9");

        button5.addActionListener( e -> {
            radius.setTitle("Radius of Neighborhood");
            radius.setSize(125, 400);
            JPanel rPanel = new JPanel();
            radius.getContentPane().add(rPanel);
            rPanel.add(r1);
            rPanel.add(r2);
            rPanel.add(r3);
            rPanel.add(r4);
            rPanel.add(r5);
            rPanel.add(r6);
            rPanel.add(r7);
            rPanel.add(r8);
            radius.setVisible(true);
        });

        r1.addActionListener(e -> {
            rNeighborhood = 0.05;
        });

        r2.addActionListener(e -> {
            rNeighborhood = 0.1;
        });

        r3.addActionListener(e -> {
            rNeighborhood = 0.2;
        });

        r4.addActionListener(e -> {
            rNeighborhood = 0.3;
        });

        r5.addActionListener(e -> {
            rNeighborhood = 0.4;
        });

        r6.addActionListener(e -> {
            rNeighborhood = 0.5;
        });

        r7.addActionListener(e -> {
            rNeighborhood = 0.75;
        });

        r8.addActionListener(e -> {
            rNeighborhood = 0.9;
        });

        button6.addActionListener(e -> {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(Storage.centroidX(), Storage.centroidY(), 0.01);
            StdDraw.show();
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loc.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        radius.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
