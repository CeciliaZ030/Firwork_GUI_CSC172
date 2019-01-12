import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Fireworks extends JPanel {
	
	static int v;
	static double theta;
	static int explosionTime;	
	MainFrame m;
	static Timer timer;


	public static int getV() {
		return v;
	}
	public static void setV(int v) {
		Fireworks.v = v;
		System.out.println("v set to" + v);
	}
	public static double getTheta() {
		return theta;
	}
	public static void setTheta(double theta) {
		Fireworks.theta = theta;
		System.out.println("theta set to" + theta);
	}
	public static int getExplosionTime() {
		return explosionTime;
	}
	public static void setExplosionTime(int explosionTime) {
		Fireworks.explosionTime = explosionTime;
		System.out.println("Explosion time set to" + explosionTime);
	}
	
	public Fireworks(MainFrame m) {
		setPreferredSize(new Dimension(800, 570));
		setBackground(Color.LIGHT_GRAY);
		this.m = m;
	}
	
	public void paintComponent(Graphics g){
		
		double x = 5*v*Math.cos(theta)*(m.getT());
		double y = 570-(5*v*Math.sin(theta)*(m.getT()) - 0.5*9.8*(m.getT())*(m.getT()));
		Graphics g2 = (Graphics2D) g;

		System.out.println("PaintComponent called");
		System.out.println("t " + m.getT());
		System.out.println("x " + x);
		System.out.println("y " + y);
		System.out.println("v " + v);
		System.out.println("theta " + theta);
		System.out.println();

		for (double i = 0; i < m.getT(); i=i+0.1) {
			double x1 = 5*v*Math.cos(theta)*i;
			double y1 = 570-(5*v*Math.sin(theta)*i - 0.5*9.8*i*i);
			Ellipse2D dot = new Ellipse2D.Double(x1, y1, 1, 1);
			 ((Graphics2D) g2).draw(dot);
			 System.out.println("Paint dots for trajectory");
		}
		 
		if (m.getT() < explosionTime) {
			// paint the trajectory
			Ellipse2D dot = new Ellipse2D.Double(x, y, 10, 10);
			 ((Graphics2D) g2).draw(dot);
			 System.out.println("If loop: draw trajectory");
		}
		else if (m.getT() >= explosionTime) {
			 System.out.println("Else loop: draw firwork");
			 
			 timer.stop();
			 m.setT(0);
			 
			if (GUIPanel.FireworkNumber == 1) {
				Aerial(g, GUIPanel.ColorNumber, x, y);
			}
			if (GUIPanel.FireworkNumber == 2) {
				BlackPowder(g, GUIPanel.ColorNumber, x, y);
			}
			if (GUIPanel.FireworkNumber == 3) {
				Comet(g, GUIPanel.ColorNumber, x, y);
			}
			if (GUIPanel.FireworkNumber == 4) {
				Firefly(g, GUIPanel.ColorNumber, x, y);
			}
			if (GUIPanel.FireworkNumber == 5) {
				Glitter(g, GUIPanel.ColorNumber, x, y);
			}
		}
	}
	
	public void Aerial(Graphics g, int ColorNumber, double x, double y) {
		Graphics g2 = (Graphics2D) g;
		
		if (ColorNumber == 1) {
			g.setColor(Color.RED);
		}
		if (ColorNumber == 2) {
			g.setColor(Color.BLUE);
		}
		if (ColorNumber == 3) {
			g.setColor(Color.YELLOW);
		}
		if (ColorNumber == 4) {
			g.setColor(Color.GREEN);
		}
		if (ColorNumber == 5) {
			g.setColor(Color.MAGENTA);
		}
		if (ColorNumber == 6) {
			g.setColor(Color.ORANGE);
		}
		if (ColorNumber == 7) {
			g.setColor(Color.PINK);
		}
	
		for (int j=0; j < 70; j++) {
			Line2D line = new Line2D.Double(x, y, x+100*Math.cos(j), y+100*Math.sin(j));
		    ((Graphics2D) g2).draw(line);
		}
	}
	
	public void BlackPowder(Graphics g, int ColorNumber, double x, double y) {
		Graphics g2 = (Graphics2D) g;

		if (ColorNumber == 1) {
			g.setColor(Color.RED);
		}
		if (ColorNumber == 2) {
			g.setColor(Color.BLUE);
		}
		if (ColorNumber == 3) {
			g.setColor(Color.YELLOW);
		}
		if (ColorNumber == 4) {
			g.setColor(Color.GREEN);
		}
		if (ColorNumber == 5) {
			g.setColor(Color.MAGENTA);
		}
		if (ColorNumber == 6) {
			g.setColor(Color.ORANGE);
		}
		if (ColorNumber == 7) {
			g.setColor(Color.PINK);
		}
		
		for(int i=0;i<50;i++) {
		    Ellipse2D ellipse = new Ellipse2D.Double(x+100*Math.sin(i), y+100*Math.cos(i), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);			
		}	
		for (int i = 0; i < 12; i++) {
			 Ellipse2D ellipse = new Ellipse2D.Double(x-50+30*Math.sin(i), y-50+30*Math.cos(i), 100, 100);
			    ((Graphics2D) g2).draw(ellipse);	
			}
	}
	
	public void Comet(Graphics g, int ColorNumber, double x, double y) {
		Graphics g2 = (Graphics2D) g;

		if (ColorNumber == 1) {
			g.setColor(Color.RED);
		}
		if (ColorNumber == 2) {
			g.setColor(Color.BLUE);
		}
		if (ColorNumber == 3) {
			g.setColor(Color.YELLOW);
		}
		if (ColorNumber == 4) {
			g.setColor(Color.GREEN);
		}
		if (ColorNumber == 5) {
			g.setColor(Color.MAGENTA);
		}
		if (ColorNumber == 6) {
			g.setColor(Color.ORANGE);
		}
		if (ColorNumber == 7) {
			g.setColor(Color.PINK);
		}
		
		for (int i = 0; i < 6; i++) {
			 Ellipse2D ellipse = new Ellipse2D.Double(x-50+30*Math.sin(i), y-50+30*Math.cos(i), 100, 100);
			    ((Graphics2D) g2).draw(ellipse);	
			}
		
		for (int j=0; j <12; j++) {
			Line2D line = new Line2D.Double(x, y, x/2+5+100*Math.cos(j), y/2+5+100*Math.sin(j));
		    ((Graphics2D) g2).draw(line);
		}
	}
	
	public void Firefly(Graphics g, int ColorNumber, double x, double y) {
		Graphics g2 = (Graphics2D) g;

		if (ColorNumber == 1) {
			g.setColor(Color.RED);
		}
		if (ColorNumber == 2) {
			g.setColor(Color.BLUE);
		}
		if (ColorNumber == 3) {
			g.setColor(Color.YELLOW);
		}
		if (ColorNumber == 4) {
			g.setColor(Color.GREEN);
		}
		if (ColorNumber == 5) {
			g.setColor(Color.MAGENTA);
		}
		if (ColorNumber == 6) {
			g.setColor(Color.ORANGE);
		}
		if (ColorNumber == 7) {
			g.setColor(Color.PINK);
		}
		
		for(int i=0;i<20;i++) {
		    Ellipse2D ellipse = new Ellipse2D.Double(x+10*Math.sin(i), y+10*Math.cos(i), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);			
		}		
		for (int j=0; j < 30; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+20*Math.sin(j), y+20*Math.cos(j), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);
		}
		for (int j=0; j < 40; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+35*Math.sin(j), y+35*Math.cos(j), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);
		}
		for (int j=0; j < 50; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+50*Math.sin(j), y+50*Math.cos(j), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);
		}
		for (int j=0; j < 60; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+70*Math.sin(j), y+70*Math.cos(j), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);
		}
		for (int j=0; j < 50; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+90*Math.sin(j), y+90*Math.cos(j), 1, 1);
		    ((Graphics2D) g2).draw(ellipse);
		}
	}
	
	public void Glitter(Graphics g, int ColorNumber, double x, double y) {
		Graphics g2 = (Graphics2D) g;

		if (ColorNumber == 1) {
			g.setColor(Color.RED);
		}
		if (ColorNumber == 2) {
			g.setColor(Color.BLUE);
		}
		if (ColorNumber == 3) {
			g.setColor(Color.YELLOW);
		}
		if (ColorNumber == 4) {
			g.setColor(Color.GREEN);
		}
		if (ColorNumber == 5) {
			g.setColor(Color.MAGENTA);
		}
		if (ColorNumber == 6) {
			g.setColor(Color.ORANGE);
		}
		if (ColorNumber == 7) {
			g.setColor(Color.PINK);
		}
		
		for(int i=0;i<6;i++) {		
		    Ellipse2D ellipse = new Ellipse2D.Double(x+10*Math.sin(i), y+10*Math.cos(i), 5, 5);
		    ((Graphics2D) g2).draw(ellipse);		
		}		
		for (int j=0; j < 12; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+20*Math.sin(j), y+20*Math.cos(j), 5, 5);
		    ((Graphics2D) g2).draw(ellipse);
		}		
		for (int j=0; j < 36; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+35*Math.sin(j), y+35*Math.cos(j), 5, 5);
		    ((Graphics2D) g2).draw(ellipse);
		}		
		for (int j=0; j < 42; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+60*Math.sin(j), y+60*Math.cos(j), 5, 5);
		    ((Graphics2D) g2).draw(ellipse);
		}
		for (int j=0; j < 44; j++) {
			Ellipse2D ellipse = new Ellipse2D.Double(x+90*Math.sin(j), y+90*Math.cos(j), 5, 5);
		    ((Graphics2D) g2).draw(ellipse);
		}
	}	
}
