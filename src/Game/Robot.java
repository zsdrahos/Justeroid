package Game;
import java.util.Random;



/**
 * A robotok osztálya, ami a Character osztály
 * leszármazottja, a robotokat jellemzõ metódusokat
 * és tulajdonságot tartalmazza. A tesztesetek bemu-
 * tatásának könnyítéseképpen kap egy nevet minden robot.
 */

public class Robot extends Character implements Stepper{


	

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
	@Override
	public void setLocation(Asteroid location) {
		this.location = location;
		System.out.println(name + " is currently on " + this.location.getName());
	}

	
	public Robot(String name) {
		super(name + " Robot");
		
	}
	
	@Override
	public void step() {
		Random r = new Random();
		int hanyadik = 0;
		if (this.location.getCrustThickness() != 0)
		{
			drill();
		}
		else if (location.isSolarstormOn())
		{
			hide();
		}
		else {
			hanyadik = r.nextInt(location.getNeighbours().size());
			move(this.getLocation().getNeighbours().get(hanyadik));
		}
		
		//System.out.println("Step-Robot");
		
	}

	/**
	 * Ez a metódus kezeli le, mi történik egy robottal
	 * egy aszteroida felrobbanása során. Ezt nem imple-
	 * mentáltuk teljesen, a skeletonba még korainak
	 * találtuk.
	 */
	
	@Override
	public void upponExplosion() {
		if (this.getLocation().getNeighbours().size() == 0)
		{
			this.die();
		}
		else {
		System.out.println(name + " moves to random asteroid");
		Random r = new Random();
		int rand = 0;
		
		rand = r.nextInt(this.getLocation().getNeighbours().size());
		this.move(this.location.getNeighbours().get(rand));
		}
	}
	
	/**
	 * Ez a metódus egy karakter egy egységnyi fúrását
	 * mutatja be. Ellenõrzi, hogy nincs e teljesen át-
	 * fúrva a köpeny, majd fúr és jelzi az új köpeny-
	 * vastagságot.
	 */
	
	@Override
	public void drill() {

		if (location.getCrustThickness() > 0) {
			int i = location.getCrustThickness() - 1;
			System.out.println(name + " drilled " + location.getName() +"\n" + location.getName() +" crust thickness: " + i);
			location.drilled();

		}
	}

}
