/*******************************************************************************************************
 * Title:		Spin.java
 * Author:		Tony Zheng
 * Created On:	January 17, 2015
 * Description:	Simulates a fan with three speeds
 * Build with:	Eclipse or using the following commands
 * 				To compile: javac *.java
 * 				To run: 	java Fan
 *******************************************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Spin extends JFrame  
{
	private static final long serialVersionUID = 1L;
	private JPanel controlPanel;
	private JButton offButton, lowButton, medButton, highButton;
	private Timer timer;
	
	public Spin()
	{
		super();
		setLayout(new BorderLayout());
		ArcsPanel ArcFrame = new ArcsPanel();
		choicePanel();
		getContentPane().add(ArcFrame, BorderLayout.CENTER);
		getContentPane().add(controlPanel, BorderLayout.SOUTH);	
	}
	
	class ArcsPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private int radius = 0, xCenter = 0, yCenter = 0, x = 0, y = 0, theta = 0;
		
		protected void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			
			radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
			
			x = xCenter - radius;
			y = yCenter - radius;
			
			g2d.translate(getWidth() / 2, getHeight() / 2);
			g2d.rotate(theta);
			
			theta -= 1;
			
			g.setColor(Color.LIGHT_GRAY);
			
			g.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
			g.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
			g.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
			g.fillArc(x, y, 2 * radius, 2 * radius, 270, 30); 

			g.drawOval(-1,-1, 2, 2); 
			g.drawOval(-2,-2, 4, 4); 
			g.drawOval(-3,-3, 6, 6);  
			g.drawOval(-10,-10, 20, 20); 
			g.drawOval(-150,-150, 300, 300);
			g.drawOval(-160,-160, 320, 320);  
	 	}	
	}
	
	public void choicePanel()
	{
		controlPanel = new JPanel();

		offButton = new JButton("Off");		
		lowButton = new JButton("Low");
		medButton = new JButton("Med");
		highButton = new JButton("High");
		
		controlPanel.add(offButton);
		controlPanel.add(lowButton);
		controlPanel.add(medButton);
		controlPanel.add(highButton);
		
		ActionHandler Handler = new ActionHandler();
		
		offButton.addActionListener(Handler);
	   	lowButton.addActionListener(Handler);
   		medButton.addActionListener(Handler);
	   	highButton.addActionListener(Handler);
	}
	
	private class ActionHandler implements ActionListener
	{
		private int count = 0;
		
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource() == (offButton))
			{
				count++;
				
				if(count == 1)
				{	
					timer = new Timer(0, new TimerListener());
		   			timer.stop();
				}
				else
				{
					timer.stop();
				}
			}
			else if(event.getSource() == (lowButton))
			{
				count++;
				
				if(count == 1)
				{
					timer = new Timer(90, new TimerListener());
		   			timer.start();
				}	
				else
				{		
					timer.stop();
					timer = new Timer(90, new TimerListener());
					timer.start();
				}	
			}
			else if (event.getSource() == (medButton))
			{
				count++;
				
				if(count == 1)
				{
					timer = new Timer(60, new TimerListener());
		   			timer.start();
				}	
				else
				{
					timer.stop();
					timer = new Timer(60, new TimerListener());
					timer.start();
				}
			}
			else if (event.getSource() == (highButton))
			{
				count++;
				
				if(count == 1)
				{
					timer = new Timer(30, new TimerListener());
		   			timer.start();
				}	
				else
				{
					timer.stop();
					timer = new Timer(30, new TimerListener());
					timer.start();
				}
			}			  
		}
	}	
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			repaint();
		}
	}
}