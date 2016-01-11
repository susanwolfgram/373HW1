import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
/*
This program developed by Susan Wolfgram for CSE 373 Homework 1.
Program is a GUI Timed Response Game that calculates 
the difference between player clicking Start and Stop. 
 */

public class TimedResponseGame extends JFrame {
	private JLabel directions, result; 
	private JButton start, stop;
	private StartButtonHandler startButtonHandler;
	private StopButtonHandler stopButtonHandler;
	private long startTime; 
	
	//initializer for a Timed Response Game 
	public TimedResponseGame() {
		directions = new JLabel("Click Stop exactly 3 seconds after clicking Start");
		result = new JLabel("Result ");
		start = new JButton("Start");
		start.setBackground(Color.GREEN);
		start.setOpaque(true);
		start.setBorderPainted(false);
		startButtonHandler = new StartButtonHandler();
		start.addActionListener(startButtonHandler);
		stop = new JButton("Stop"); 
		stop.setBackground(Color.RED);
		stop.setOpaque(true);
		stop.setBorderPainted(false);
		stopButtonHandler = new StopButtonHandler();
		stop.addActionListener(stopButtonHandler);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 2));
		pane.add(directions);
		pane.add(start);
		pane.add(stop); 
		pane.add(result); 
		setTitle("Timed Response Game");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//creates new instance of the Timed Response Game
	public static void main(String[] args) {
		TimedResponseGame rectObj = new TimedResponseGame();
	}
	
	//sets the start time when player clicks the Start button
	public class StartButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			startTime = System.nanoTime(); 
			System.out.println(startTime);
		}
	}
	
	//calculates and displays results when player clicks Stop button
	public class StopButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			long difference = System.nanoTime() - startTime;
			difference = difference / 1000000; 
			boolean wasEarly = false; 
			if (difference < 3000) {
				wasEarly = true; 
			} 
			int millisecondsOff = (int) Math.abs(3000 - difference); 
			if (millisecondsOff == 0) {
				result.setText("You got it in exactly 3 seconds!");
			} else if (millisecondsOff <= 100) {
				if (wasEarly) {
					result.setText("Nice! You were only " + millisecondsOff + " milliseconds early.");
				} else {
					result.setText("Nice! You were only " + millisecondsOff + " milliseconds late.");
				}
			} else {
				if (wasEarly) {
					result.setText("You were " + millisecondsOff + " milliseconds early.");
				} else {
					result.setText("You were " + millisecondsOff + " milliseconds late.");
				}
			}
		}
	}
}
