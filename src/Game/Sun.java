package Game;
import java.util.ArrayList;

/**
 * A Nap bemutatásáért felelõs osztály, ami egy attribútumot
 * és egy metódust tartalmaz. Az attribútum még nem rendelkezik
 * jelentõséggel, ezt a késõbbiek során, fogjuk használni.
 */

public class Sun implements Stepper{
	private int solarTimer;
	private boolean alive = true;
	
	
	/**
	 * Ez a metódus a naprendszer összes aszteroidáján napvihart 
	 * generál, jelen esetben ezt egy kiiratással jelezzük a fel-
	 * használó felé.
	 */
	
	public void startSolarStorm(ArrayList<Asteroid> asteroids) {
		for (int i = 0; i<asteroids.size(); i++)
		{
			System.out.println(asteroids.get(i).getName() + " has been hit by solar storm.");
			
			for(int k = 0; k< asteroids.get(i).getPortals().size(); k++)
			{
				asteroids.get(i).getPortals().get(k).setCrazy(true);
			}
		
			for (int j = 0; j<asteroids.get(i).getCharacters().size(); j++)
			{
				asteroids.get(i).setSolarstormOn(true);
				if (asteroids.get(i).getCharacters().get(j).isSafe())
				{asteroids.get(i).setSolarstormOn(false);
					
				}
				else {asteroids.get(i).getCharacters().get(j).die();
				asteroids.get(i).setSolarstormOn(false);
				}
			}
		}
		
		
	}

	@Override
	public void step() {
		this.solarTimer++;
		//System.out.println("SUUUUUUUUUUUUUUUUn");
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return alive;
	}

	public int getSolarTimer() {
		return solarTimer;
	}

	public void setSolarTimer(int solarTimer) {
		this.solarTimer = solarTimer;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
}
