package Game;
import java.util.ArrayList;

/**
 * A Nap bemutat�s��rt felel�s oszt�ly, ami egy attrib�tumot
 * �s egy met�dust tartalmaz. Az attrib�tum m�g nem rendelkezik
 * jelent�s�ggel, ezt a k�s�bbiek sor�n, fogjuk haszn�lni.
 */

public class Sun implements Stepper{
	private int solarTimer;
	private boolean alive = true;
	
	
	/**
	 * Ez a met�dus a naprendszer �sszes aszteroid�j�n napvihart 
	 * gener�l, jelen esetben ezt egy kiirat�ssal jelezz�k a fel-
	 * haszn�l� fel�.
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
