package Game;
import java.util.ArrayList;


import Grafika.AsteroidView;

/**
 * Aszteroida oszt�ly, az egyes aszteroid�k tulajdons�gait �s viselked�seit
 * foglalja mag�ban. A tesztel�s �rdek�ben felvett�nk egy name attrib�tumot, ami
 * a tesztek szeml�l- tet�s�t k�nny�ti meg.
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
	 * Ez a met�dus a name attrib�tum norm�l gettere.
	 * 
	 * @return name A be�ll�tott n�v attrib�tum.
	 */

	public String getName() {
		return ID;
	}

	/**
	 * Ez a met�dus a name attrib�tum norm�l settere.
	 * 
	 * @param name A be�ll�tani val� n�v.
	 */

	public void setName(String name) {
		this.ID = name;
	}

	/**
	 * Ez a met�dus az oszt�ly konstruktora.
	 * 
	 * @param n     A be�ll�tani val� n�v.
	 * @param m     A be�ll�tani val� nyersanyag.
	 * @param crust A be�ll�tani val� k�regvastags�g.
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
	 * Ez a met�dus a portals lista gettere.
	 * 
	 * @return portals A lista a port�lokr�l az aszteroid�n.
	 */

	public ArrayList<Portal> getPortals() {
		return portals;
	}

	/**
	 * Ez a met�dus a portals lista settere.
	 * 
	 * @param portals Az aszteroid�n l�v� port�lok list�j�hoz hozz�adni k�v�nt
	 *                port�l.
	 */

	public void setPortals(Portal portals) {
		this.portals.add(portals);
		System.out.println(portals.getID() + " added to " + this.getName());
	}

	/**
	 * Ez a met�dus a characters lista settere.
	 * 
	 * @param characters A megadni k�v�nt lista.
	 */

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}

	/**
	 * Ez a met�dus a CrustThickness attrib�tum norm�l gettere.
	 * 
	 * @return CrustThickness Az aszteroida k�peny�nek vastags�ga.
	 */

	public int getCrustThickness() {
		return CrustThickness;
	}

	/**
	 * Ez a met�dus a CrustThickness attrib�tum norm�l settere.
	 * 
	 * @param CrustThickness Az aszteroida k�v�nt k�peny vastags�ga.
	 */

	public void setCrustThickness(int crustThickness) {
		CrustThickness = crustThickness;
	}

	/**
	 * Ez a met�dus a NearSun attrib�tum norm�l gettere.
	 * 
	 * @return NearSun Azt adja meg, hogy az adott aszteroida napk�zelben van e.
	 */

	public boolean isNearSun() {
		return NearSun;
	}

	/**
	 * Ez a met�dus a NearSun attrib�tum norm�l settere.
	 * 
	 * @param nearSun Igaz vagy hamis �rt�ke m�dos�tja az aszteroida
	 *                nepk�zelbens�g�nek tulajdons�g�t..
	 */

	public void setNearSun(boolean nearSun) {
		NearSun = nearSun;
		if (NearSun == true)
			System.out.println(this.getName() + " got near to the Sun.");
	}

	/**
	 * Ez a met�dus a neighbours lista gettere.
	 * 
	 * @return neighbours A lista az aszteroida szomsz�djair�l.
	 */

	public ArrayList<Asteroid> getNeighbours() {
		return neighbours;
	}

	/**
	 * Ez a met�dus a neighbours lista settere. A met�dus be�ll�tja a szomsz�ds�gi
	 * viszonyt oda-vissza.
	 * 
	 * @param neighbours Az aszteroida szomsz�dj�nak felvenni k�v�nt aszteroida.
	 */

	@Override
	public void setNeighbours(Asteroid neighbours) {
		this.neighbours.add(neighbours);
		//neighbours.neighbours.add(this);
	}

	/**
	 * Ez a met�dus a neighbours lista egy elem�t t�vol�tja el. A met�dus
	 * megsz�nteti a szomsz�ds�gi viszonyt oda-vissza.
	 * 
	 * @param neighbours Az aszteroida szomsz�djai k�z�l t�r�lni k�v�nt aszteroida.
	 */

	public void removeNeighbours(Asteroid neighbours) {
		this.neighbours.remove(neighbours);
		neighbours.neighbours.remove(this);
	}

	/**
	 * Ez a met�dus a characters lista gettere.
	 * 
	 * @return characters A lista az aszteroid�n l�v� karakterekr�l.
	 */

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	/**
	 * Ez a met�dus a characters lista settere.
	 * 
	 * @param characters Az aszteroid�n l�v� karakterek list�j�hoz hozz�adni k�v�nt
	 *                   karakter.
	 */

	public void setCharacters(Character c) {
		characters.add(c);
	}

	public void removeEverthing() {
		characters.clear();
	}

	/**
	 * Ez a met�dus a resources attrib�tum norm�l gettere.
	 * 
	 * @return resources A be�ll�tott anyag attrib�tum.
	 */

	public Material getResources() {
		return resources;
	}

	/**
	 * Ez a met�dus a resources attrib�tum norm�l settere.
	 * 
	 * @param resources A be�ll�tani val� anyag.
	 */

	public void setResources(Material resources) {
		this.resources = resources;
	}

	/**
	 * Ez a met�dus, ami a port�lt �ll�t az aszteroid�ra.
	 * 
	 * @param p A be�ll�tani k�v�nt port�l.
	 */

	public void acceptPortal(Portal p) {
		p.setAsteroid(this);
		portals.add(p);

	}

	/**
	 * Ez a met�dus, ami a karaktert fogad az aszteroid�n.
	 * 
	 * @param c A fogadott karakter.
	 */

	@Override
	public void acceptCharacter(Character c) {
		c.setLocation(this);
		characters.add(c);
	}

	/**
	 * Ez a met�dus, ami a karaktert t�r�l az aszteroid�r�l.
	 * 
	 * @param t A t�r�lni k�v�nt karakter.
	 */

	public void remove(Character t) {
		characters.remove(t);
		
	}

	/**
	 * Ez a met�dus, ami a port�lt t�r�l az aszteroid�r�l.
	 * 
	 * @param p A t�r�lni k�v�nt port�l.
	 */

	public void removePortal(Portal p) {
		this.portals.remove(p);
		System.out.println(p.getID() + " removed from " + this.getName() + ".");
		
	}

	/**
	 * Ez a met�dus m�ly�ti az aszteroida k�peny�be f�rt lyukat, a vastags�g�t egy
	 * egys�ggel elv�kny�tja. Amennyiben nap k�zelben vagyunk �s �tf�rtuk a k�penyt
	 * megh�vunk egy olyan met�dust, ami ezt lekezeli. A tesztel�s �tl�that�s�g�nak
	 * �rdek�ben ki�rjuk, ha el�tr�k a magot.
	 */

	public void drilled() {
		if (CrustThickness > 0)
			CrustThickness -= 1;
		if (getCrustThickness() == 0)
			//System.out.println("El�rte a " + ID + " magot!");

		if (getCrustThickness() == 0 && NearSun && resources != null) {
			resources.interactWith(this);

		}

	}

	/**
	 * Ez a met�dus, akkor h�v�dik meg, mikor az aszteroid�t kib�ny�sztuk, ez�rt
	 * ekkor a benne l�v� anyagnak null �rt�ket ad, teh�t �res lesz a mag.
	 */

	public void mined() {
		resources = null;
		
	}

	/**
	 * Ez a met�dus, akkor h�v�dik meg, mikor az aszteroid�ba visszatesz�nk
	 * valamilyen anyagot.
	 */

	public void dumped() {
		
	}

	public void endGameResources() {
	}

	/**
	 * Ez a met�dus, akkor h�v�dik meg, mikor az aszteroida felrobban. Megh�vunk
	 * benne minden karakterre egy met�dust, ami ezt karakterenk�nt lekezeli.
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
		
		
		// felrobban ki kell szedni azt az aszteroid�t
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
