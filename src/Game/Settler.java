package Game;
import java.util.ArrayList;

import java.util.Random;

/**
 * A telepesek osztálya, ami a Character osztály
 * leszármazottja, a telepeseket jellemzõ metódusokat
 * és tulajdonságokat tartalmazza. A tesztesetek bemu-
 * tatásának könnyítéseképpen kap egy nevet minden telepes.
 */

public class Settler extends Character {

	protected ArrayList<Material> resources = new ArrayList<Material>(10);
	protected ArrayList<Portal> portal = new ArrayList<Portal>(3);
	/**
	   * Ez a metódus a portal lista settere.
	   * @param portal  A telepesnél lévõ portálok listájához
	   * hozzáadni kívánt portál.
	   */
	
	public void setPortal(Portal portal) {
		if (portal != null )
			{this.portal.add(portal);
		System.out.println(portal.getID() + " added to " + this.getName());}
		
	}

	

	/**
	   * Ez a metódus a portal lista gettere.
	   * @return portal  A lista a portálokról a telepesnél.
	   */
	
	public ArrayList<Portal> getPortal() {
		return portal;
	}

	/**
	   * Ez a metódus az osztály konstruktora.
	   * @param name  A beállítani való név.
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
	   * Ez a metódus a resources lista gettere.
	   * @return resources  A lista a telepesnél lévõ anyagokról.
	   */
	
	@Override
	public ArrayList<Material> getResources() {
		return resources;
	}
	
	/**
	   * Ez a metódus a resources lista settere.
	   * @param resources  A telepesnél lévõ anyagok listájához
	   * hozzáadni kívánt anyag.
	   */

	@Override
	public void setResources(Material resources) {
		this.resources.add(resources);
		System.out.println(resources.getName() +" was added to " + this.getName());
	}

	/**
	   * Ez a metódus a resources lista egy elemét távolítja el.
	   * A metódus töröl egy anyagot az aszteroidánál lévõk közül.
	   * @param resources  A telepesnél lévõ anyagok közül törölni
	   * kívánt anyag.
	   */
	
	@Override

	public void removeResources(Material resources) {
		this.resources.remove(resources);
	}

	/**
	 * Ez a metódus a bányászás mûveletét mutatja be, vizsgálva
	 * az adott aszteroida tulajdonságait. Ha nincs nyersanyag az
	 * aszteroidában, vagy a köpeny nincs teljesen átfúrva, a bányászás
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
	 * Ez a metódus egy karakter egy egységnyi fúrását
	 * mutatja be. Ellenõrzi, hogy nincs e teljesen át-
	 * fúrva a köpeny, majd fúr és jelzi az új köpeny-
	 * vastagságot.
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
	   * Ez a metódus összehasonlít két anyagot nevük alapján.
	   * @param obj  Az összehasonlítandó anyag objektum
	   * @return boolean  Az összehasonlítás eredménye.
	   */

	public boolean equals(Object obj) {
		if (obj instanceof Material) {
			Material o = (Material) obj;
			return o.getName() == this.name;
		}
		return false;
	}

	/**
	   * Ez a metódus egy robot építésének folyamatát mutatja be.
	   * A robot elkészítéséhez szükséges nyersanyagokat ellenõrzi,
	   * ha megvan, azt el is veszi a telepestõl és megépíti a robotot.
	   * Ammenyiebn viszont nincsn elég nyersanyag, nem épül meg a robot.
	   * @param resources  A leendõ robot neve.
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
	   * Ez a metódus a teleport építésének folyamatát mutatja be.
	   * A teleport elkészítéséhez szükséges nyersanyagokat ellenõrzi,
	   * ha megvan, azt el is veszi a telepestõl és megépíti a teleportot.
	   * Ammenyiebn viszont nincsn elég nyersanyag, nem épül meg a teleport.
	   * @return portals  Az elkészült teleport, ha nem készül el, nullal 
	   * tér vissza.
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
	 * Ez a metódus egy teleportkapu lehelyezését mutatja be,
	 * amikoris egy aszteroidára helyezünk egy kaput, amennyiben
	 * a telepesnél van kapu.
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
	   * Ez a metódus egy portál listát vesz fel az aszteroidára.
	   * @param portal  Az aszteroidára felvenni kívánt portálok
	   * listája.
	   */
	
	@Override
	public void addPortal(ArrayList<Portal> portal) {
		this.portal = portal;
	}
	
	

	/**
	   * Ez a metódus a portal lista egy elemét távolítja el.
	   * A metódus töröl egy kaput az aszteroidáról.
	   * @param p  A törölni kívánt kapu.
	   */
	
	public void removePortal(Portal p) {
		portal.remove(p);
	}

	/**
	   * Ez a metódus egy teleportkapu felvételét mutatja be,
	   * amennyiben a megadott portál a jelen aszteroidán van
	   * és elfér nálunk a portál.
	   * @param p  A felvenni kívánt kapu.
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
	   * Ez a metódus az anyag visszatételének metódusa.
	   * Amennyiben át van fúrva az adott aszteroida 
	   * köpenye és üres a magja, a telepes a magba
	   * helyez egy adott anyagot.
	   * @param m  A behelyezni kívánt anyag.
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
	 * Ez a metódus egy aszteroida felrobbanása során
	 * hívódik meg, mikoris az aszteroidán lévõ telepes
	 * meghal.
	 */
	
	@Override
	public void upponExplosion() {
		this.die();
	}

}
