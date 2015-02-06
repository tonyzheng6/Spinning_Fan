/*******************************************************************************************************
 * Title:		Fan.java
 * Author:		Tony Zheng
 * Created On:	January 17, 2015
 * Description:	Simulates a fan with three speeds
 * Build with:	Eclipse or using the following commands
 * 				To compile: javac *.java
 * 				To run: 	java Fan
 *******************************************************************************************************/
import javax.swing.*;

public class Fan 
{
	public static void main(String[] args)
	{
		Spin EnergyStarFan = new Spin();
		
		EnergyStarFan.setTitle("ENERGY STAR Certified");
		EnergyStarFan.setSize(400,400);
		EnergyStarFan.setLocationRelativeTo(null);
		EnergyStarFan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EnergyStarFan.setVisible(true);
	}
}