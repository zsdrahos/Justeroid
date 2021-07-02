package Grafika;



import javax.swing.ImageIcon;
import javax.swing.JLabel;


import Game.Robot;

public class RobotView implements IViewable 
{
	Robot robot;

	@Override
	public void paint(JLabel j) {
		j.setIcon(new ImageIcon("src/images/robot_k.png"));
		
	}
	
}
