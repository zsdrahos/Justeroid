package Game;
import java.util.Random;

public class Ufo extends Character implements Stepper{

	
	Timing t;
	public Ufo(String n, Timing tick) {
		super(n + " UFO");
		t = tick;
		t.addSubscriber(this);
	}
	
	/**
	   * Ez a metódus az osztály konstruktora.
	   * @param n  A beállítani való név.
	   */

	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}

	
	
	
	/**
	   * Pozíció beállítása
	   * @param n  A beállítani való helyszín.
	   */
	@Override
	public void setLocation(Asteroid location) {
		this.location = location;
		System.out.println(name + " is currently on " + this.location.getName());
	}
	
	/**
	 * Ez a metódus a bányászás mûveletét mutatja be, vizsgálva
	 * az adott aszteroida tulajdonságait. Ha nincs nyersanyag az
	 * aszteroidában, vagy a köpeny nincs teljesen átfúrva, a bányászás
	 * sikertelen.
	 */
	@Override
	public void mine() {

		if (location.getCrustThickness() == 0 && location.getResources() != null) {
			location.mined();
			System.out.println("UFO mined");
		} else
			System.out.println("Mining failed!");

	}
	/**
	 * Ufo léptetését megvalósító metódus
	 */
	@Override
	public void step() {
		
		if (this.isAlive())
			{Random r = new Random();
		int hanyadik = 0;
		if (this.location.getCrustThickness() == 0 && location.getResources() != null)
		{
			mine();
		}
		else if (location.isSolarstormOn())
		{
			hide();
		}
		else {
			hanyadik = r.nextInt(location.getNeighbours().size());
			move(this.getLocation().getNeighbours().get(hanyadik));
		}
		//System.out.println("Step-UFO");
		}
	}

	/**
	 * Ez a metódus kezeli le, mi történik egy robottal, 
	 * ha az aszeroida amin tartózkodik felrobban
	 */
	
	@Override
	public void upponExplosion() {
		System.out.println(name + " moves to random asteroid");
	}

}
