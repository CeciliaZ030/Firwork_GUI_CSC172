import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.sql.StatementEventListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUIPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//Types of fireworks
	protected JCheckBox Aerial;
	protected JCheckBox BlackPowder;
	protected JCheckBox Comet;
	protected JCheckBox FirefLy;
	protected JCheckBox Glitter;
	protected static int FireworkNumber;
	//Parameters
	protected JSlider Speed;
	protected JSlider Angle;
	protected JSlider ExplosionTime;
	protected JLabel Speed1;
	protected JLabel Angle1;
	protected JLabel ExplosionTime1;
	
	//Colors
	protected JCheckBox red;
	protected JCheckBox blue;
	protected JCheckBox yellow;
	protected JCheckBox green;
	protected JCheckBox purple;
	protected JCheckBox orange;
	protected JCheckBox pink;
	protected static int ColorNumber;
	//Launch Button
	protected JButton Launch;
	static Timer timer;

	

	public static int getColorNumber() {
		return ColorNumber;
	}
	public static void setColorNumber(int colorNumber) {
		ColorNumber = colorNumber;
	}

	
	public GUIPanel() {
		setLayout(new BorderLayout());
		add(new FireworksSelection(), BorderLayout.NORTH);
		add(new SlidersPanel(), BorderLayout.CENTER);
		add(new Launch(), BorderLayout.SOUTH);
		
	}
	
	protected class Launch extends JPanel implements ActionListener{
		public Launch() {
			setLayout(new FlowLayout());
			
			Launch = new JButton("Launch");
			add(Launch);
			Launch.addActionListener(this);
			
		}
		
		public void actionPerformed (ActionEvent e) {
				timer.restart();
				System.out.println("Timer Restart");
		}
	}
	
	protected class FireworksSelection extends JPanel implements ItemListener {

		private static final long serialVersionUID = 1L;

		public FireworksSelection() {
			setLayout(new FlowLayout());
			
			Aerial = new JCheckBox("Aerial");
			add(Aerial);
			Aerial.addItemListener(this);
			
			BlackPowder = new JCheckBox("BlackPowder");
			add(BlackPowder);
			BlackPowder.addItemListener(this);
			
			Comet = new JCheckBox("Comet");
			add(Comet);
			Comet.addItemListener(this);
			
			FirefLy = new JCheckBox("FirefLy");
			add(FirefLy);
			FirefLy.addItemListener(this);
			
			Glitter = new JCheckBox("Glitter");
			add(Glitter);
			Glitter.addItemListener(this);
			
			// Color check box
			
			red = new JCheckBox("red");
			add(red);
			red.addItemListener(this);
			
			blue = new JCheckBox("blue");
			add(blue);
			blue.addItemListener(this);
			
			yellow = new JCheckBox("yellow");
			add(yellow);
			yellow.addItemListener(this);
			
			green = new JCheckBox("green");
			add(green);
			green.addItemListener(this);
			
			purple = new JCheckBox("purple");
			add(purple);
			purple.addItemListener(this);
			
			orange = new JCheckBox("orange");
			add(orange);
			orange.addItemListener(this);
			
			pink = new JCheckBox("pink");
			add(pink);
			pink.addItemListener(this);
		}
		
		public void itemStateChanged (ItemEvent e) {
			Object source = e.getItem();	

			if (source == Aerial) {
				if (Aerial.isSelected() == true)
				FireworkNumber = 1;
			}
			if (source == BlackPowder) {
				if (BlackPowder.isSelected() == true)
				FireworkNumber = 2;
			}
			if (source == Comet) {
				if (Comet.isSelected() == true)
				FireworkNumber = 3;
			}
			if (source == FirefLy) {
				if (FirefLy.isSelected() == true)
				FireworkNumber = 4;
			}
			if (source == Glitter) {
				if (Glitter.isSelected() == true)
				FireworkNumber = 5;
			}
			
			//Color
			if (source == red) {
				if (red.isSelected() == true)
				ColorNumber = 1;
			}
			if (source == blue) {
				if (blue.isSelected() == true)
				ColorNumber = 2;
			}
			if (source == yellow) {
				if (yellow.isSelected() == true)
				ColorNumber = 3;
			}
			if (source == green) {
				if (green.isSelected() == true)
				ColorNumber = 4;
			}
			if (source == purple) {
				if (purple.isSelected() == true)
				ColorNumber = 5;
			}
			if (source == orange) {
				if (orange.isSelected() == true)
				ColorNumber = 6;
			}
			if (source == pink) {
				if (pink.isSelected() == true)
				ColorNumber = 7;
			}	
		}	
	}
	
	
	protected class SlidersPanel extends JPanel implements ChangeListener {
	
		private static final long serialVersionUID = 1L;

		public SlidersPanel() {
			setLayout(new FlowLayout());
				
			Speed = new JSlider (0, 30);
			Speed.addChangeListener(this);
			Speed1 = new JLabel ("Speed: " + Speed.getValue());
			add (Speed1);
			add (Speed);
	
			
			Angle = new JSlider (0, 90);
			Angle.addChangeListener(this);
			Angle1 = new JLabel ("Angle: " + Angle.getValue());
			add(Angle1);
			add (Angle);
			

			ExplosionTime = new JSlider (0,10);
			ExplosionTime.addChangeListener(this);
			ExplosionTime1 = new JLabel ("Explosion Time: " + ExplosionTime.getValue());
			add (ExplosionTime1);
			add (ExplosionTime);
			
		}
		
		public void stateChanged (ChangeEvent e) {
			//set global variables and change color

			Object source = e.getSource();

			if (source == Speed) {
				Fireworks.setV(Speed.getValue());
				Speed1.setText("Speed: " + Speed.getValue());
			}
			if (source == Angle) {
				Fireworks.setTheta(Math.toRadians(Angle.getValue()));
				Angle1.setText("Angle: " + Angle.getValue());
			}
			if (source == ExplosionTime) {
				Fireworks.setExplosionTime(ExplosionTime.getValue());
				ExplosionTime1.setText("Explosion Time: " + ExplosionTime.getValue());
			}
		}		
	}

}
	

