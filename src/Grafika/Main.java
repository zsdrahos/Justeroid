package Grafika;

import java.io.IOException;


import Game.Game;
import Game.IceWater;
import Game.Iron;

import Game.Uranium;


import Game.Coal;

public class Main {
public static View view = new View();
public static Game g = new Game();

/**
 * A main függvény, itt indul a játék, itt deklarálom a menu osztályt
 * */
public static void main(String[] args) throws IOException {
	
	new Menu(g);
	g.StartGame(view.getSolarsystem());
	for (int i = 0;i<50;i++)
	{
		if(g.getCurrentSystem().getAsteroids().get(i).getName().equals("AS001"))
			{
			for (int j = 0; j<g.getSettlers().size(); j++)
			{
				g.getSettlers().get(j).setLocation(g.getCurrentSystem().getAsteroids().get(i));
				g.getCurrentSystem().getAsteroids().get(i).setCharacters(g.getSettlers().get(j));
			}
				//a = g.getCurrentSystem().getAsteroids().get(i);
			}
	}
	
	/**
	 * Kezdetben hozzáadunk a settlerhez pár nyersanyagot h lehessen buildet tesztelni
	 * */
	g.getCurrentSettler().setResources(new Iron());
	g.getCurrentSettler().setResources(new IceWater());
	g.getCurrentSettler().setResources(new Uranium());
	g.getCurrentSettler().setResources(new Coal());
	/*g.getCurrentSettler().setResources(new Uranium());
	g.getCurrentSettler().setResources(new Uranium());
	
	g.getCurrentSettler().setResources(new Coal());
	g.getCurrentSettler().setResources(new Coal());
	*/
}
}
