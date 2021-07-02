package Game;
import java.util.ArrayList;

import Grafika.RobotView;
import Grafika.SettlerView;
import Grafika.UfoView;

/**
 * Karakter osztály, ami a robotok és telepesek közös
 * õse, így az õ közös tulajdonságaikat és metódusaikat
 * határozza meg. Egy aszteroidán lévõ bármely karakter
 * implementációja.
 */

public class Character implements Stepper {
	private boolean hidden = false;
	protected Asteroid location;
	private boolean alive = true;
	
	private RobotView rv = new RobotView();
	private UfoView uv = new UfoView();
	private SettlerView sv = new SettlerView(this);

	
	public void setPortal(Portal portal) {
		
	}

	
	
	/**
	   * Ez a metódus a location attribútum normál gettere.
	   * @return location  A beállított hely attribútum, ahol
	   * a karakter tartózkodik, egy aszteroida.
	   */

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Asteroid getLocation() {
		return location;
	}
	
	/**
	   * Ez a metódus a location attribútum normál settere.
	   * @param location  A beállítani való hely, ahova a 
	   * karaktert szeretnénk állítani, egy aszteroida.
	   */

	public void setLocation(Asteroid location) {
		this.location = location;
		System.out.println(name + " is currently on " + this.location.getName());
	}
	
	/**
	   * Ez a metódus a resources attribútum settere.
	   * A leszármazotban implementáljuk, itt csak fel-
	   * tüntetjük.
	   * @param resources  A beállítani való anyag.
	   */

	public void setResources(Material resources) {

	}
	
	/**
	   * Ez a metódus a resources lista gettere.
	   * A leszármazottban implementáljuk, itt csak fel-
	   * tüntetjük.
	   * @return null nullal tér vissza, hisz ez a metódus
	   * csak a leszármazottban érvényes.
	   */

	public ArrayList<Material> getResources() {
		return null;
	}

	/**
	   * Ez a metódus a portals listába felvesz egy új elemet.
	   * @param portals  A karakternél lévõ portálok listájához
	   * hozzáadni kívánt portál. Csak a leszármazottra vonatkozik,
	   * ott implementáljuk
	   */
	
	public void addPortal(ArrayList<Portal> portal) {

	}
	
	/**
	   * Ez a metódus a portals lista gettere. A leszármazottban 
	   * implementáljuk, itt csak feltüntetjük.
	   * @return null  nullal tér vissza, hisz ez a metódus csak
	   * a leszármazottban érvényes.
	   */

	public ArrayList<Portal> getPortal() {
		return null;
	}
	
	/**
	   * Ez a metódus az osztály konstruktora.
	   * @param n  A beállítani való név.
	   */

	public Character(String n) {
		name = n;
	}
	
	/**
	 * Ez a metódus csak a leszármazottra jellemzõ, a telepesekre,
	 * ezért ott implementáljuk, itt csak feltüntetjük.
	 */

	public void mine() {
		// csak a telepes
	}
	
	/**
	   * Ez a metódus az anyag visszatételének metódusa.
	   * Csak leszármazottban implementáljuk, a telepesben,
	   * itt csak feltüntetjük.
	   * @param m  A behelyezni kívánt anyag.
	   */

	public void dumpMaterial(Material m) {
	}

	/**
	 * Ez a metódus egy karakter halálát kezeli le.
	 * Törli az adott aszteroidáról és elbúcsúzik tõle.
	 */
	
	public void die() {
		//location.remove(this);
		//System.out.println(this);
		for (int i = 0; i<location.getCharacters().size(); i++)
		{
			if (location.getCharacters().get(i).getName().equals(this.getName()))
			{
				location.getCharacters().remove(i);
				
			}
		}
		name = name + " - DEAD!";
		//System.out.println(location.getCharacters());
		setAlive(false);
		System.out.println("Astala Vista " + name);
		
	}

	/**
	 * Ez a metódus egy karakter egy egységnyi fúrását
	 * mutatja be. Ellenõrzi, hogy nincs e teljesen át-
	 * fúrva a köpeny, majd fúr és jelzi az új köpeny-
	 * vastagságot.
	 */
	
	public void drill() {

		
	}
	
	/**
	 * Ez a metódus egy karakter biztoonságát adja meg.
	 * Jelen esetben ez azt jelenti, hogy a karakter 
	 * elbújt állapotban van, tehát egy aszteroida belse-
	 * jében tartózkodik.
	 * @return boolean  A hidden attribútum állapota.
	 */

	public boolean isSafe() {
		return hidden;
	}
	
	/**
	   * Ez a metódus egy karakter mozgását mutatja be.
	   * Paraméterként megadott aszteroidára mozog, de
	   * kezeli ha esetleg a két aszteroida nem szomszédos.
	   * @param d  A cél aszteroida.
	   */
	
	public void move(Asteroid d) {
		if (location.getNeighbours().contains(d) && hidden == false && alive) {
			System.out.println(name + " travelled/teleported from " + location.getName() + " to " + d.getName());
			//System.out.println("this: " + this);
			//System.out.println("remove elott: " + location.getCharacters());
			
			for (int i = 0;i<location.getCharacters().size(); i++)
			{
				if (location.getCharacters().get(i) == this)
					location.getCharacters().remove(i);
			}
			
			//System.out.println("remove utan: " + location.getCharacters());
			d.acceptCharacter(this);
			//System.out.println("masik: " + d.getCharacters());
			

		} else if (!location.getNeighbours().contains(d))
			System.out.println("The two asteroids are not neighbours!");
		else if (hidden)
			System.out.println("Character is hidden!");
		else if (!alive)
			System.out.println("Character is dead!");
	}
	
	/**
	   * Ez a metódus a robotépítés folyamatát mutatja be.
	   * Mivel robotot csak telepes építhet, ezért ezt a
	   * telepes osztályban implementáljuk, itt csak feltüntetjük.
	   * @param name  A robot leendõ neve.
	   * @return null  nullal tér vissza, hiszen a leszármazotban
	   * implementáljuk.
	   */

	public Character buildRobot() {
		return null;
	}

	/**
	   * Ez a metódus egy karakter teleportálását mutatja be.
	   * Paraméterként megadott teleportkapuval teleportál, de
	   * kezeli ha esetleg a kapunak nincs párja.
	   * @param p  A használni kívánt kapu.
	   */
	
	public void teleport(Portal p) {
		if (p != null)
		{
		if (location.getPortals().size() > 0 && p.getPair() != null) {
			this.move(p.getAsteroid());
		}}
		else {
			
		}

	}
	
	/**
	 * Ez a metódus a teleportkapu lerakásának mûveletét mutatja be.
	 * Mivel ezt csak a telepes teheti meg, ezért a telepes leszár-
	 * mazottban implementáljuk, itt csak feltüntetjük.
	 */

	public void placePortal(Timing t) {
	}
	
	/**
	 * Ez a metódus egy karakter elbújásának mûveletét mutatja be.
	 * Ellenõrzi, hogy az aszteroida üres e és a köpeny át van e
	 * fúrva. Ezután megtörténik az elbújás és kiiratás.
	 */

	public void hide() {
		if (location.getCrustThickness() == 0 && location.getResources() == null) {
			hidden = true;
			System.out.println(name + " is hidden");
		}

	}
	public void unhide() {
		
			hidden = false;
			System.out.println(name + " is unhidden");
		}

	
	
	/**
	   * Ez a metódus a teleportépítés folyamatát mutatja be.
	   * Mivel teleportot csak telepes építhet, ezért ezt a
	   * telepes osztályban implementáljuk, itt csak feltüntetjük.
	   * @return null  nullal tér vissza, hiszen a leszármazotban
	   * implementáljuk.
	   */

	public ArrayList<Portal> buildPortal() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Ez a metódus egy aszteroidán történt robbanást hivatott
	 * lekezelni a karaktereken, de ezt a leszármazottakban imple-
	 * mentáljuk, itt csak feltüntetjük.
	 */
	
	public void upponExplosion() {

	}

	/**
	   * Ez a metódus egy anyag eldobását mutatja be, de csak a
	   * leszármazottban implementáljuk, itt csak feltüntejük.
	   * @param resources  A eldobni kívánt anyag.
	   */
	
	public void removeResources(Material resources) {
		// TODO Auto-generated method stub

	}
	
	/**
	   * Ez a metódus egy teleportkapu felvételét mutatja be,
	   * de csak a leszármazottban implementáljuk, itt csak
	   * feltüntetjük.
	   * @param p  A felvenni kívánt kapu.
	   */

	public void pickUpPortal(Portal p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void step() {
		
			
		
	}
	@Override
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public UfoView getUv() {
		return uv;
	}

	public void setUv(UfoView uv) {
		this.uv = uv;
	}

	public RobotView getRv() {
		return rv;
	}

	public void setRv(RobotView rv) {
		this.rv = rv;
	}

	public SettlerView getSv() {
		return sv;
	}

	public void setSv(SettlerView sv) {
		this.sv = sv;
	}

}
