import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



public class MainFrame extends JFrame {
	
	protected JLabel Title;

	protected Timer timer;
	protected Fireworks canvas;
	protected double t = 0.0;
	
	public double getT() {
		return t;
	}
	public void setT(double t) {
		this.t = t;
	}
	
	public MainFrame() {
		setSize(1100, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Fireworks");
		setLayout(new BorderLayout());
		
		canvas = new Fireworks(this);
		add(canvas, BorderLayout.NORTH);
		add(new WelcomeLabel(), BorderLayout.CENTER);
		add(new GUIPanel(), BorderLayout.SOUTH);
		
		timer = new Timer(100, new TimerListener());
		System.out.println("MainFrame is set.");
	}
	
	protected class TimerListener implements ActionListener {

		public void actionPerformed (ActionEvent e) {
			System.out.println("Timer action called");
			setT(t +.1 );
			canvas.repaint();
			System.out.println("Firework canvas repaint");
		}
	}
	
	protected class WelcomeLabel extends JPanel {
		public WelcomeLabel() {
		Title = new JLabel("Welcom to Fireworks! You must select firwork and reset sliders to start.");
		add(Title);
		}
	}
	
	public static void main (String[] args) {
		MainFrame m = new MainFrame();
		GUIPanel.timer = m.timer;
		Fireworks.timer = m.timer;
		m.setVisible(true);
	}
}

