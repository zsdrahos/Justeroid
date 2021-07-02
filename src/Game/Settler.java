package Game;
import java.util.ArrayList;

import java.util.Random;

/**
 * A telepesek oszt�lya, ami a Character oszt�ly
 * lesz�rmazottja, a telepeseket jellemz� met�dusokat
 * �s tulajdons�gokat tartalmazza. A tesztesetek bemu-
 * tat�s�nak k�nny�t�sek�ppen kap egy nevet minden telepes.
 */

public class Settler extends Character {

	protected ArrayList<Material> resources = new ArrayList<Material>(10);
	protected ArrayList<Portal> portal = new ArrayList<Portal>(3);
	/**
	   * Ez a met�dus a portal lista settere.
	   * @param portal  A telepesn�l l�v� port�lok list�j�hoz
	   * hozz�adni k�v�nt port�l.
	   */
	
	public void setPortal(Portal portal) {
		if (portal != null )
			{this.portal.add(portal);
		System.out.println(portal.getID() + " added to " + this.getName());}
		
	}

	

	/**
	   * Ez a met�dus a portal lista gettere.
	   * @return portal  A lista a port�lokr�l a telepesn�l.
	   */
	
	public ArrayList<Portal> getPortal() {
		return portal;
	}

	/**
	   * Ez a met�dus az oszt�ly konstruktora.
	   * @param name  A be�ll�tani val� n�v.
	   */ 
	
	public Settler(String name) {
			super(name + " Settler");
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	   * Ez a met�dus a resources lista gettere.
	   * @return resources  A lista a telepesn�l l�v� anyagokr�l.
	   */
	
	@Override
	public ArrayList<Material> getResources() {
		return resources;
	}
	
	/**
	   * Ez a met�dus a resources lista settere.
	   * @param resources  A telepesn�l l�v� anyagok list�j�hoz
	   * hozz�adni k�v�nt anyag.
	   */

	@Override
	public void setResources(Material resources) {
		this.resources.add(resources);
		System.out.println(resources.getName() +" was added to " + this.getName());
	}

	/**
	   * Ez a met�dus a resources lista egy elem�t t�vol�tja el.
	   * A met�dus t�r�l egy anyagot az aszteroid�n�l l�v�k k�z�l.
	   * @param resources  A telepesn�l l�v� anyagok k�z�l t�r�lni
	   * k�v�nt anyag.
	   */
	
	@Override

	public void removeResources(Material resources) {
		this.resources.remove(resources);
	}

	/**
	 * Ez a met�dus a b�ny�sz�s m�velet�t mutatja be, vizsg�lva
	 * az adott aszteroida tulajdons�gait. Ha nincs nyersanyag az
	 * aszteroid�ban, vagy a k�peny nincs teljesen �tf�rva, a b�ny�sz�s
	 * sikertelen.
	 */
	
	@Override
	public void mine() {

		if (location.getCrustThickness() == 0 && location.getResources() != null && this.isAlive()) {
			if (this.getResources().size() < 10)
			{
				resources.add(location.getResources());
				System.out.println(name + " Settler Mining - Mined material: " + location.getResources().getName());
				location.mined();
			}
			else {
				System.out.println(name + " mining FAILED");
			}
			
		} else
			System.out.println("Mining failed!");

	}
	/**
	 * Ez a met�dus egy karakter egy egys�gnyi f�r�s�t
	 * mutatja be. Ellen�rzi, hogy nincs e teljesen �t-
	 * f�rva a k�peny, majd f�r �s jelzi az �j k�peny-
	 * vastags�got.
	 */
	
	@Override
	public void drill() {

		if (location.getCrustThickness() > 0 && this.isAlive()) {
			int i = location.getCrustThickness() - 1;
			System.out.println(name + " drilled " + location.getName() +"\n" + location.getName() +" crust thickness: " + i);
			location.drilled();

		}
	}
	
	
	
	/**
	   * Ez a met�dus �sszehasonl�t k�t anyagot nev�k alapj�n.
	   * @param obj  Az �sszehasonl�tand� anyag objektum
	   * @return boolean  Az �sszehasonl�t�s eredm�nye.
	   */

	public boolean equals(Object obj) {
		if (obj instanceof Material) {
			Material o = (Material) obj;
			return o.getName() == this.name;
		}
		return false;
	}

	/**
	   * Ez a met�dus egy robot �p�t�s�nek folyamat�t mutatja be.
	   * A robot elk�sz�t�s�hez sz�ks�ges nyersanyagokat ellen�rzi,
	   * ha megvan, azt el is veszi a telepest�l �s meg�p�ti a robotot.
	   * Ammenyiebn viszont nincsn el�g nyersanyag, nem �p�l meg a robot.
	   * @param resources  A leend� robot neve.
	   */
	
	@Override
	public Character buildRobot() {
		String name;
		Random k = new Random();
		int rand = k.nextInt(700);
		name = "R"+rand;
		
		boolean ir = false;
		boolean u = false;
		boolean c = false;
		for (int i = 0; i < resources.size(); i++) {
			if (resources.get(i).getName() == "Coal") {
				c = true;
			} else if (resources.get(i).getName() == "Uranium") {
				u = true;
			} else if (resources.get(i).getName() == "Iron") {
				ir = true;
			}

		}

		if (c && ir && u && this.isAlive()) {

			Character r = new Robot(name);
			System.out.println("Build robot successful");
			resources.removeIf(t -> t.getName() == "Iron");
			resources.removeIf(t -> t.getName() == "Uranium");
			resources.removeIf(t -> t.getName() == "Coal");
			//System.out.println(resources);
			r.setLocation(location);
			location.setCharacters(r);
			return r;
		} else {
			System.out.println("Build robot not successful");
			return null;
		}
	}

	/**
	   * Ez a met�dus a teleport �p�t�s�nek folyamat�t mutatja be.
	   * A teleport elk�sz�t�s�hez sz�ks�ges nyersanyagokat ellen�rzi,
	   * ha megvan, azt el is veszi a telepest�l �s meg�p�ti a teleportot.
	   * Ammenyiebn viszont nincsn el�g nyersanyag, nem �p�l meg a teleport.
	   * @return portals  Az elk�sz�lt teleport, ha nem k�sz�l el, nullal 
	   * t�r vissza.
	   */
	
	@Override
	public ArrayList<Portal> buildPortal() {
		// 2vas,1vizjeg, 1uran
		String p1 = ""; 
		String pp2 = "";
		Random r  = new Random();
		int rand = r.nextInt(700);
		p1 = "P" + rand + ".1";
		pp2 = "P" + rand + ".2";
		
		int ir = 0;
		boolean u = false;

		boolean wi = false;
		for (int i = 0; i < resources.size(); i++) {
			if (resources.get(i).getName() == "Uranium") {
				u = true;
			} else if (resources.get(i).getName() == "Iron") {
				ir++;
			} else if (resources.get(i).getName() == "IceWater") {
				wi = true;
			}

		}

		ArrayList<Portal> portals = new ArrayList<Portal>();

		if (ir >= 2 && u && wi && this.isAlive()) {

			Portal p = new Portal(p1);
			Portal p2 = new Portal(pp2);
			
			portals.add(p2);
			portals.add(p);
			System.out.println("Build portal successful");
			resources.removeIf(t -> t.getName() == "Iron");
			resources.removeIf(t -> t.getName() == "Uranium");
			resources.removeIf(t -> t.getName() == "Iron");
			resources.removeIf(t -> t.getName() == "IceWater");
			p.setPair(p2);
			p2.setPair(p);
			return portals;

		} else {
			System.out.println("Build portal not successful");
			return null;
		}

	}
	
	/**
	 * Ez a met�dus egy teleportkapu lehelyez�s�t mutatja be,
	 * amikoris egy aszteroid�ra helyez�nk egy kaput, amennyiben
	 * a telepesn�l van kapu.
	 */

	@Override
	public void placePortal(Timing t) {
		if (portal.size() != 0 && this.isAlive()) {
			location.acceptPortal(portal.get(0));
			t.addSubscriber(portal.get(0));
			portal.remove(portal.get(0));
			System.out.println("Portal is placed to " + location.getName());
		} else
			System.out.println(name + " doesn't have portal");

	}

	/**
	   * Ez a met�dus egy port�l list�t vesz fel az aszteroid�ra.
	   * @param portal  Az aszteroid�ra felvenni k�v�nt port�lok
	   * list�ja.
	   */
	
	@Override
	public void addPortal(ArrayList<Portal> portal) {
		this.portal = portal;
	}
	
	

	/**
	   * Ez a met�dus a portal lista egy elem�t t�vol�tja el.
	   * A met�dus t�r�l egy kaput az aszteroid�r�l.
	   * @param p  A t�r�lni k�v�nt kapu.
	   */
	
	public void removePortal(Portal p) {
		portal.remove(p);
	}

	/**
	   * Ez a met�dus egy teleportkapu felv�tel�t mutatja be,
	   * amennyiben a megadott port�l a jelen aszteroid�n van
	   * �s elf�r n�lunk a port�l.
	   * @param p  A felvenni k�v�nt kapu.
	   */
	
	@Override
	public void pickUpPortal(Portal p) {
		if (p.getAsteroid() == location && portal.size() < 2 && this.isAlive()) {
			this.portal.add(p);
			location.removePortal(p);
			p.setAsteroid(null);
			System.out.println("Portal is pickedup from " + location.getName());
		}
	}

	/**
	   * Ez a met�dus az anyag visszat�tel�nek met�dusa.
	   * Amennyiben �t van f�rva az adott aszteroida 
	   * k�penye �s �res a magja, a telepes a magba
	   * helyez egy adott anyagot.
	   * @param m  A behelyezni k�v�nt anyag.
	   */
	
	public void dumpMaterial(Material m) {

		if (location.getResources() == null && location.getCrustThickness() == 0 && this.isAlive()) {
			System.out.println(name + " dumped a " + m.getName() + " material");
			m.interactWith(location);
			resources.remove(m);
			location.setResources(m);
			
		
		}
		else {
			System.out.println("Nothing was dumped in " + location.getName() + " by " + this.getName());
		}

	}

	/**
	 * Ez a met�dus egy aszteroida felrobban�sa sor�n
	 * h�v�dik meg, mikoris az aszteroid�n l�v� telepes
	 * meghal.
	 */
	
	@Override
	public void upponExplosion() {
		this.die();
	}

}
