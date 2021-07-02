package Grafika;



import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class UfoView implements IViewable 
{
	

	@Override
	public void paint(JLabel j) {
		j.setIcon(new ImageIcon("src/images/ufo.png"));
		
	}
}
