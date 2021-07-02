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
	   * Ez a met�dus az oszt�ly konstruktora.
	   * @param n  A be�ll�tani val� n�v.
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
	   * Poz�ci� be�ll�t�sa
	   * @param n  A be�ll�tani val� helysz�n.
	   */
	@Override
	public void setLocation(Asteroid location) {
		this.location = location;
		System.out.println(name + " is currently on " + this.location.getName());
	}
	
	/**
	 * Ez a met�dus a b�ny�sz�s m�velet�t mutatja be, vizsg�lva
	 * az adott aszteroida tulajdons�gait. Ha nincs nyersanyag az
	 * aszteroid�ban, vagy a k�peny nincs teljesen �tf�rva, a b�ny�sz�s
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
	 * Ufo l�ptet�s�t megval�s�t� met�dus
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
	 * Ez a met�dus kezeli le, mi t�rt�nik egy robottal, 
	 * ha az aszeroida amin tart�zkodik felrobban
	 */
	
	@Override
	public void upponExplosion() {
		System.out.println(name + " moves to random asteroid");
	}

}
