package Game;
import java.util.Random;



/**
 * A robotok oszt�lya, ami a Character oszt�ly
 * lesz�rmazottja, a robotokat jellemz� met�dusokat
 * �s tulajdons�got tartalmazza. A tesztesetek bemu-
 * tat�s�nak k�nny�t�sek�ppen kap egy nevet minden robot.
 */

public class Robot extends Character implements Stepper{


	

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
	 * Ez a met�dus kezeli le, mi t�rt�nik egy robottal
	 * egy aszteroida felrobban�sa sor�n. Ezt nem imple-
	 * ment�ltuk teljesen, a skeletonba m�g korainak
	 * tal�ltuk.
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
	 * Ez a met�dus egy karakter egy egys�gnyi f�r�s�t
	 * mutatja be. Ellen�rzi, hogy nincs e teljesen �t-
	 * f�rva a k�peny, majd f�r �s jelzi az �j k�peny-
	 * vastags�got.
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
