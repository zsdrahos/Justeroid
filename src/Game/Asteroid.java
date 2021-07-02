package Game;
import java.util.ArrayList;


import Grafika.AsteroidView;

/**
 * Aszteroida osztály, az egyes aszteroidák tulajdonságait és viselkedéseit
 * foglalja magában. A tesztelés érdekében felvettünk egy name attribútumot, ami
 * a tesztek szemlél- tetését könnyíti meg.
 */

public class Asteroid implements Orbit {
	private int CrustThickness;
	private boolean NearSun;
	private String ID;
	private ArrayList<Asteroid> neighbours = new ArrayList<Asteroid>();
	private ArrayList<Character> characters = new ArrayList<Character>();
	private ArrayList<Portal> portals = new ArrayList<Portal>();
	private Material resources;
	private boolean exploded = false;
	private boolean solarstormOn = false;
	private AsteroidView av = new AsteroidView(this);
	
	
	
	public boolean isExploded() {
		return exploded;
	}

	public void setExploded(boolean exploded) {
		this.exploded = exploded;
	}

	/**
	 * Ez a metódus a name attribútum normál gettere.
	 * 
	 * @return name A beállított név attribútum.
	 */

	public String getName() {
		return ID;
	}

	/**
	 * Ez a metódus a name attribútum normál settere.
	 * 
	 * @param name A beállítani való név.
	 */

	public void setName(String name) {
		this.ID = name;
	}

	/**
	 * Ez a metódus az osztály konstruktora.
	 * 
	 * @param n     A beállítani való név.
	 * @param m     A beállítani való nyersanyag.
	 * @param crust A beállítani való kéregvastagság.
	 */

	public Asteroid(String n, Material m, int crust) {
		/*Random r = new Random();
		int rand = r.nextInt(1000);
		ID = "AS" + rand;*/
		ID = n;
		resources = m;
		CrustThickness = crust;
		if (resources == null)
			System.out.println(ID + " was born, with " + "null" + " in it!");
		else System.out.println(ID + " was born, with " + resources.getName() + " in it!");
	}

	/**
	 * Ez a metódus a portals lista gettere.
	 * 
	 * @return portals A lista a portálokról az aszteroidán.
	 */

	public ArrayList<Portal> getPortals() {
		return portals;
	}

	/**
	 * Ez a metódus a portals lista settere.
	 * 
	 * @param portals Az aszteroidán lévõ portálok listájához hozzáadni kívánt
	 *                portál.
	 */

	public void setPortals(Portal portals) {
		this.portals.add(portals);
		System.out.println(portals.getID() + " added to " + this.getName());
	}

	/**
	 * Ez a metódus a characters lista settere.
	 * 
	 * @param characters A megadni kívánt lista.
	 */

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}

	/**
	 * Ez a metódus a CrustThickness attribútum normál gettere.
	 * 
	 * @return CrustThickness Az aszteroida köpenyének vastagsága.
	 */

	public int getCrustThickness() {
		return CrustThickness;
	}

	/**
	 * Ez a metódus a CrustThickness attribútum normál settere.
	 * 
	 * @param CrustThickness Az aszteroida kívánt köpeny vastagsága.
	 */

	public void setCrustThickness(int crustThickness) {
		CrustThickness = crustThickness;
	}

	/**
	 * Ez a metódus a NearSun attribútum normál gettere.
	 * 
	 * @return NearSun Azt adja meg, hogy az adott aszteroida napközelben van e.
	 */

	public boolean isNearSun() {
		return NearSun;
	}

	/**
	 * Ez a metódus a NearSun attribútum normál settere.
	 * 
	 * @param nearSun Igaz vagy hamis értéke módosítja az aszteroida
	 *                nepközelbenségének tulajdonságát..
	 */

	public void setNearSun(boolean nearSun) {
		NearSun = nearSun;
		if (NearSun == true)
			System.out.println(this.getName() + " got near to the Sun.");
	}

	/**
	 * Ez a metódus a neighbours lista gettere.
	 * 
	 * @return neighbours A lista az aszteroida szomszédjairól.
	 */

	public ArrayList<Asteroid> getNeighbours() {
		return neighbours;
	}

	/**
	 * Ez a metódus a neighbours lista settere. A metódus beállítja a szomszédsági
	 * viszonyt oda-vissza.
	 * 
	 * @param neighbours Az aszteroida szomszédjának felvenni kívánt aszteroida.
	 */

	@Override
	public void setNeighbours(Asteroid neighbours) {
		this.neighbours.add(neighbours);
		//neighbours.neighbours.add(this);
	}

	/**
	 * Ez a metódus a neighbours lista egy elemét távolítja el. A metódus
	 * megszünteti a szomszédsági viszonyt oda-vissza.
	 * 
	 * @param neighbours Az aszteroida szomszédjai közül törölni kívánt aszteroida.
	 */

	public void removeNeighbours(Asteroid neighbours) {
		this.neighbours.remove(neighbours);
		neighbours.neighbours.remove(this);
	}

	/**
	 * Ez a metódus a characters lista gettere.
	 * 
	 * @return characters A lista az aszteroidán lévõ karakterekrõl.
	 */

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	/**
	 * Ez a metódus a characters lista settere.
	 * 
	 * @param characters Az aszteroidán lévõ karakterek listájához hozzáadni kívánt
	 *                   karakter.
	 */

	public void setCharacters(Character c) {
		characters.add(c);
	}

	public void removeEverthing() {
		characters.clear();
	}

	/**
	 * Ez a metódus a resources attribútum normál gettere.
	 * 
	 * @return resources A beállított anyag attribútum.
	 */

	public Material getResources() {
		return resources;
	}

	/**
	 * Ez a metódus a resources attribútum normál settere.
	 * 
	 * @param resources A beállítani való anyag.
	 */

	public void setResources(Material resources) {
		this.resources = resources;
	}

	/**
	 * Ez a metódus, ami a portált állít az aszteroidára.
	 * 
	 * @param p A beállítani kívánt portál.
	 */

	public void acceptPortal(Portal p) {
		p.setAsteroid(this);
		portals.add(p);

	}

	/**
	 * Ez a metódus, ami a karaktert fogad az aszteroidán.
	 * 
	 * @param c A fogadott karakter.
	 */

	@Override
	public void acceptCharacter(Character c) {
		c.setLocation(this);
		characters.add(c);
	}

	/**
	 * Ez a metódus, ami a karaktert töröl az aszteroidáról.
	 * 
	 * @param t A törölni kívánt karakter.
	 */

	public void remove(Character t) {
		characters.remove(t);
		
	}

	/**
	 * Ez a metódus, ami a portált töröl az aszteroidáról.
	 * 
	 * @param p A törölni kívánt portál.
	 */

	public void removePortal(Portal p) {
		this.portals.remove(p);
		System.out.println(p.getID() + " removed from " + this.getName() + ".");
		
	}

	/**
	 * Ez a metódus mélyíti az aszteroida köpenyébe fúrt lyukat, a vastagságát egy
	 * egységgel elvéknyítja. Amennyiben nap közelben vagyunk és átfúrtuk a köpenyt
	 * meghívunk egy olyan metódust, ami ezt lekezeli. A tesztelés átláthatóságának
	 * érdekében kiírjuk, ha elétrük a magot.
	 */

	public void drilled() {
		if (CrustThickness > 0)
			CrustThickness -= 1;
		if (getCrustThickness() == 0)
			//System.out.println("Elérte a " + ID + " magot!");

		if (getCrustThickness() == 0 && NearSun && resources != null) {
			resources.interactWith(this);

		}

	}

	/**
	 * Ez a metódus, akkor hívódik meg, mikor az aszteroidát kibányásztuk, ezért
	 * ekkor a benne lévõ anyagnak null értéket ad, tehát üres lesz a mag.
	 */

	public void mined() {
		resources = null;
		
	}

	/**
	 * Ez a metódus, akkor hívódik meg, mikor az aszteroidába visszateszünk
	 * valamilyen anyagot.
	 */

	public void dumped() {
		
	}

	public void endGameResources() {
	}

	/**
	 * Ez a metódus, akkor hívódik meg, mikor az aszteroida felrobban. Meghívunk
	 * benne minden karakterre egy metódust, ami ezt karakterenként lekezeli.
	 */

	public void explode() {
		for (int i = 0; i < characters.size(); i++) {
			characters.get(i).upponExplosion();
			
			exploded = true;
		}
		for (int i = 0; i < portals.size(); i++) {
			portals.get(i).setAlive(false);
			
			exploded = true;
		}
		
		//this.removeEverthing();
		
		
		// felrobban ki kell szedni azt az aszteroidát
	}

	

	@Override
	public void SolarStorm() {
		// TODO Auto-generated method stub

	}

	public boolean isSolarstormOn() {
		return solarstormOn;
	}

	public void setSolarstormOn(boolean solarstormOn) {
		this.solarstormOn = solarstormOn;
	}

	public AsteroidView getAv() {
		return av;
	}

	public void setAv(AsteroidView av) {
		this.av = av;
	}

}
