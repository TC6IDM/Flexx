package Andrew;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Ava.Home;

//THIS IS AN IMPORTED PACKAGE NOT MADE BY ME, IT IS UED TO PLOT GRAPHS USING JAVA SWING


/**
 *
 * @author "Hovercraft Full of Eels", "Rodrigo Azevedo"
 *
 * This is an improved version of Hovercraft Full of Eels (https://stackoverflow.com/users/522444/hovercraft-full-of-eels)
 * answer on StackOverflow: https://stackoverflow.com/a/8693635/753012
 *
 * GitHub user @maritaria has made some performance improvements which can be found in the comment section of this Gist.
 */
public class GraphPanel extends JPanel {
    private int width = 800;
    private int height = 400;
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private Color textColor = new Color(0, 0, 0, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 10;
    private List<Double> scores;
	private List<Integer> xAxis;
	private List<String> bestSets;

    public GraphPanel(List<Double> scores,List<Integer> xAxis,List<String> bestSets) {
        this.scores = scores;
        this.xAxis = xAxis;
        this.bestSets = bestSets;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (xAxis.get(xAxis.size()-1)-xAxis.get(0));
        double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
        	int x1 = (int) ((xAxis.get(i)-xAxis.get(0)) * xScale + padding + labelPadding); // change this to change the x on the bottom, "i" can change to the workout number
            int y1 = (int) ((getMaxScore() - scores.get(i)) * yScale + padding);
            graphPoints.add(new Point(x1, y1));
        }

        // draw white background
        g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding, getHeight() - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);

        // create hatch marks and grid lines for y axis.
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
            if (scores.size() > 0) {
                g2.setColor(gridColor);
                g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
                g2.setColor(Color.BLACK);
                String yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y1);
        }

        // and for x axis
        for (int i = xAxis.get(0); i < xAxis.get(xAxis.size()-1)+1; i++) {
            if (scores.size() > 1) {
                int x0 = (i-xAxis.get(0)) * (getWidth() - padding * 2 - labelPadding) / (xAxis.get(xAxis.size()-1)-xAxis.get(0)) + padding + labelPadding;
                int x1 = x0;
                int y0 = getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
                if ((i % ((int) (((xAxis.get(xAxis.size()-1)+1) / 20.0)) + 1)) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
                    g2.setColor(Color.BLACK);
                    String xLabel = i + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                g2.drawLine(x0, y0, x1, y1);
            }
        }

        // create x and y axes 
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding, getHeight() - padding - labelPadding);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.setStroke(GRAPH_STROKE); //maybe change this???
            g2.setColor(textColor);
            g2.drawString(bestSets.get(i), x-15, y-5);
            g2.drawString(scores.get(i)+"",x-10,y+15);
            g2.setStroke(oldStroke);
            g2.setColor(pointColor);
            g2.fillOval(x, y, ovalW, ovalH);
        }
        g2.setStroke(GRAPH_STROKE); //maybe change this???
        g2.setColor(textColor);
        g2.drawString("Click Anywhere to Exit", getWidth()/2 - 30 , 15);
        g2.drawString("One Rep Max", 10, 15);
        g2.drawString("Workout Number", getWidth()/2 - 30 , getHeight()-15);
    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(width, height);
//    }

    private double getMinScore() {
        double minScore = Double.MAX_VALUE;
        for (Double score : scores) {
            minScore = Math.min(minScore, score);
        }
        return minScore;
    }

    private double getMaxScore() {
        double maxScore = Double.MIN_VALUE;
        for (Double score : scores) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
        invalidate();
        this.repaint();
    }

    public List<Double> getScores() {
        return scores;
    }
    
    public static void createAndShowGui(List<Double> scores,List<Integer> xAxis, List<String> bestSets) {
    	
        GraphPanel mainPanel = new GraphPanel(scores,xAxis, bestSets);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("DrawGraph");
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      //creates the back button
		int buttonWidth = 100;
		int buttonDistanceFromSides = 0;
		int buttonHeight = 50;
		JButton backButton = new JButton("");
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setIcon(new ImageIcon(Page3.class.getResource("/Andrew/x-mark-32.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Home home = new Home();
//				home.frame.setVisible(true);
				frame.setVisible(false);
		        
			}
		});
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(buttonDistanceFromSides, buttonDistanceFromSides, buttonWidth, buttonHeight);
		frame.getContentPane().add(backButton);
    }
    
    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        	 List<Double> scores = new ArrayList<>();
        	 List<Integer> xAxis = new ArrayList<>();
        	 List<String> bestSets = new ArrayList<>();
//             Random random = new Random();
//             int maxDataPoints = 40;
//             int maxScore = 10;
             scores.add(1.0); xAxis.add(10); bestSets.add("1");
             scores.add(5.0); xAxis.add(13); bestSets.add("1");
             scores.add(20.0); xAxis.add(17); bestSets.add("1");
             scores.add(10.0); xAxis.add(20); bestSets.add("1");
             scores.add(2.0); xAxis.add(25); bestSets.add("1");
//             for (int i = 0; i < maxDataPoints; i++) {
//                 scores.add((double) random.nextDouble() * maxScore);
//                 xAxis.add(i+5);
////                 scores.add((double) i);
//             }
             createAndShowGui(scores,xAxis,bestSets);
         }
      });
   }
}