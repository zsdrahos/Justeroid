package Grafika;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


import Game.Character;

public class SettlerView implements IViewable 
{
	Character b;
	public SettlerView(Character a)
	{
		b = a;
	}

	@Override
	public void paint(JLabel j) {
		// TODO Auto-generated method stub
		if (b.isAlive() == false)
			j.setIcon(new ImageIcon("src/images/ast_set/settler_d.png"));
	}
	
}
