package Grafika;


import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


import Game.Asteroid;
/**
 * Az osztály felel az aszteroida megjelnítésért
 * */
public class AsteroidView implements IViewable 
{
	Asteroid a;
	Image asteroid;
	public AsteroidView(Asteroid aa) {
		asteroid =  new ImageIcon("src/images/asteroid.png").getImage();
		a = aa;
	}
	
	/**
	 * Megadott feltételeknek megfelelõen azt a képet rajzolja ki amit mit szeretnénk
	 * */
	public void paint(JLabel j) {
		if (a.getCrustThickness() == 0 && a.getResources() == null)
			j.setIcon(new ImageIcon("src/images/ast_set/empty_s.png"));
		else if (a.getCrustThickness() != 0)
			j.setIcon(new ImageIcon("src/images/ast_set/Drill1_s.png"));
		else if (a.getCrustThickness() == 0 && a.getResources().getName() == "IceWater")
			j.setIcon(new ImageIcon("src/images/ast_set/icewater_s.png"));
		else if (a.getCrustThickness() == 0 && a.getResources().getName() == "Coal")
			j.setIcon(new ImageIcon("src/images/ast_set/coal_s.png"));
		else if (a.getCrustThickness() == 0 && a.getResources().getName() == "Uranium")
			j.setIcon(new ImageIcon("src/images/ast_set/uran_s.png"));
		else if (a.getCrustThickness() == 0 && a.getResources().getName() == "Iron")
			j.setIcon(new ImageIcon("src/images/ast_set/iron_s.png"));
		
		for (int i = 0; i<a.getCharacters().size(); i++)
		{ if (a.getCharacters().get(i).isSafe())
			j.setIcon(new ImageIcon("src/images/ast_set/hide.png"));
		else if (a.getCharacters().get(i).isAlive() == false)
			j.setIcon(new ImageIcon("src/images/ast_set/settler_d.png"));
		}
		for (int i = 0; i<a.getCharacters().size(); i++)
		{ 
		if (a.getCharacters().get(i).isAlive() == false && a.getCharacters().get(i).getName().contains("Settler"))
			j.setIcon(new ImageIcon("src/images/ast_set/settler_d.png"));
		}
			
		
	}
}
