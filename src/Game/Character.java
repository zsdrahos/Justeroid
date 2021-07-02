package Game;
import java.util.ArrayList;

import Grafika.RobotView;
import Grafika.SettlerView;
import Grafika.UfoView;

/**
 * Karakter oszt�ly, ami a robotok �s telepesek k�z�s
 * �se, �gy az � k�z�s tulajdons�gaikat �s met�dusaikat
 * hat�rozza meg. Egy aszteroid�n l�v� b�rmely karakter
 * implement�ci�ja.
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
	   * Ez a met�dus a location attrib�tum norm�l gettere.
	   * @return location  A be�ll�tott hely attrib�tum, ahol
	   * a karakter tart�zkodik, egy aszteroida.
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
	   * Ez a met�dus a location attrib�tum norm�l settere.
	   * @param location  A be�ll�tani val� hely, ahova a 
	   * karaktert szeretn�nk �ll�tani, egy aszteroida.
	   */

	public void setLocation(Asteroid location) {
		this.location = location;
		System.out.println(name + " is currently on " + this.location.getName());
	}
	
	/**
	   * Ez a met�dus a resources attrib�tum settere.
	   * A lesz�rmazotban implement�ljuk, itt csak fel-
	   * t�ntetj�k.
	   * @param resources  A be�ll�tani val� anyag.
	   */

	public void setResources(Material resources) {

	}
	
	/**
	   * Ez a met�dus a resources lista gettere.
	   * A lesz�rmazottban implement�ljuk, itt csak fel-
	   * t�ntetj�k.
	   * @return null nullal t�r vissza, hisz ez a met�dus
	   * csak a lesz�rmazottban �rv�nyes.
	   */

	public ArrayList<Material> getResources() {
		return null;
	}

	/**
	   * Ez a met�dus a portals list�ba felvesz egy �j elemet.
	   * @param portals  A karaktern�l l�v� port�lok list�j�hoz
	   * hozz�adni k�v�nt port�l. Csak a lesz�rmazottra vonatkozik,
	   * ott implement�ljuk
	   */
	
	public void addPortal(ArrayList<Portal> portal) {

	}
	
	/**
	   * Ez a met�dus a portals lista gettere. A lesz�rmazottban 
	   * implement�ljuk, itt csak felt�ntetj�k.
	   * @return null  nullal t�r vissza, hisz ez a met�dus csak
	   * a lesz�rmazottban �rv�nyes.
	   */

	public ArrayList<Portal> getPortal() {
		return null;
	}
	
	/**
	   * Ez a met�dus az oszt�ly konstruktora.
	   * @param n  A be�ll�tani val� n�v.
	   */

	public Character(String n) {
		name = n;
	}
	
	/**
	 * Ez a met�dus csak a lesz�rmazottra jellemz�, a telepesekre,
	 * ez�rt ott implement�ljuk, itt csak felt�ntetj�k.
	 */

	public void mine() {
		// csak a telepes
	}
	
	/**
	   * Ez a met�dus az anyag visszat�tel�nek met�dusa.
	   * Csak lesz�rmazottban implement�ljuk, a telepesben,
	   * itt csak felt�ntetj�k.
	   * @param m  A behelyezni k�v�nt anyag.
	   */

	public void dumpMaterial(Material m) {
	}

	/**
	 * Ez a met�dus egy karakter hal�l�t kezeli le.
	 * T�rli az adott aszteroid�r�l �s elb�cs�zik t�le.
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
	 * Ez a met�dus egy karakter egy egys�gnyi f�r�s�t
	 * mutatja be. Ellen�rzi, hogy nincs e teljesen �t-
	 * f�rva a k�peny, majd f�r �s jelzi az �j k�peny-
	 * vastags�got.
	 */
	
	public void drill() {

		
	}
	
	/**
	 * Ez a met�dus egy karakter biztoons�g�t adja meg.
	 * Jelen esetben ez azt jelenti, hogy a karakter 
	 * elb�jt �llapotban van, teh�t egy aszteroida belse-
	 * j�ben tart�zkodik.
	 * @return boolean  A hidden attrib�tum �llapota.
	 */

	public boolean isSafe() {
		return hidden;
	}
	
	/**
	   * Ez a met�dus egy karakter mozg�s�t mutatja be.
	   * Param�terk�nt megadott aszteroid�ra mozog, de
	   * kezeli ha esetleg a k�t aszteroida nem szomsz�dos.
	   * @param d  A c�l aszteroida.
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
	   * Ez a met�dus a robot�p�t�s folyamat�t mutatja be.
	   * Mivel robotot csak telepes �p�thet, ez�rt ezt a
	   * telepes oszt�lyban implement�ljuk, itt csak felt�ntetj�k.
	   * @param name  A robot leend� neve.
	   * @return null  nullal t�r vissza, hiszen a lesz�rmazotban
	   * implement�ljuk.
	   */

	public Character buildRobot() {
		return null;
	}

	/**
	   * Ez a met�dus egy karakter teleport�l�s�t mutatja be.
	   * Param�terk�nt megadott teleportkapuval teleport�l, de
	   * kezeli ha esetleg a kapunak nincs p�rja.
	   * @param p  A haszn�lni k�v�nt kapu.
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
	 * Ez a met�dus a teleportkapu lerak�s�nak m�velet�t mutatja be.
	 * Mivel ezt csak a telepes teheti meg, ez�rt a telepes lesz�r-
	 * mazottban implement�ljuk, itt csak felt�ntetj�k.
	 */

	public void placePortal(Timing t) {
	}
	
	/**
	 * Ez a met�dus egy karakter elb�j�s�nak m�velet�t mutatja be.
	 * Ellen�rzi, hogy az aszteroida �res e �s a k�peny �t van e
	 * f�rva. Ezut�n megt�rt�nik az elb�j�s �s kiirat�s.
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
	   * Ez a met�dus a teleport�p�t�s folyamat�t mutatja be.
	   * Mivel teleportot csak telepes �p�thet, ez�rt ezt a
	   * telepes oszt�lyban implement�ljuk, itt csak felt�ntetj�k.
	   * @return null  nullal t�r vissza, hiszen a lesz�rmazotban
	   * implement�ljuk.
	   */

	public ArrayList<Portal> buildPortal() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Ez a met�dus egy aszteroid�n t�rt�nt robban�st hivatott
	 * lekezelni a karaktereken, de ezt a lesz�rmazottakban imple-
	 * ment�ljuk, itt csak felt�ntetj�k.
	 */
	
	public void upponExplosion() {

	}

	/**
	   * Ez a met�dus egy anyag eldob�s�t mutatja be, de csak a
	   * lesz�rmazottban implement�ljuk, itt csak felt�ntej�k.
	   * @param resources  A eldobni k�v�nt anyag.
	   */
	
	public void removeResources(Material resources) {
		// TODO Auto-generated method stub

	}
	
	/**
	   * Ez a met�dus egy teleportkapu felv�tel�t mutatja be,
	   * de csak a lesz�rmazottban implement�ljuk, itt csak
	   * felt�ntetj�k.
	   * @param p  A felvenni k�v�nt kapu.
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
