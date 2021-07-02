package Game;
import java.util.Random;

/**
 * A port�lkapuk oszt�lya, az Orbit interf�sz
 * megval�s�t� oszt�lya. A port�lokon val� m�veletek
 * bemutat�s�ra val� met�dusok �s a kapuk tulajdon-
 * s�gait tartalmaz� oszt�ly.
 */

public class Portal implements Orbit, Stepper {
	private Portal pair;
	private Asteroid asteroid;
	private boolean crazy;
	private String ID;
	private boolean alive = true;
	/**
	   * Ez a met�dus a pair attrib�tum norm�l gettere.
	   * @return pair  A be�ll�tott kapu, ami a p�rja.
	   */
	
	public Portal(String n)
	{
		ID = n;
	}
	public Portal getPair() {
		return pair;
	}
	
	/**
	   * Ez a met�dus a pair attrib�tum norm�l settere.
	   * @param pair  A be�ll�tani val� kapu, ami a p�rja
	   * lesz.
	   */

	public void setPair(Portal pair) {
		this.pair = pair;
	}

	/**
	   * Ez a met�dus a asteroid attrib�tum norm�l gettere.
	   * @return asteroid  Az aszteroida, amin a kapu van.
	   */
	
	public Asteroid getAsteroid() {
		return asteroid;
	}
	
	/**
	   * Ez a met�dus a asteroid attrib�tum norm�l settere.
	   * @param asteroid  Az aszteroida, amin lesz a kapu.
	   */

	public void setAsteroid(Asteroid asteroid) {
		this.asteroid = asteroid;
	}

	public void hasPair(Portal p) {
		
	}
	
	/**
	   * Ez a met�dus a neighbours lista settere.
	   * A met�dus be�ll�tja a szomsz�ds�gi viszonyt oda-vissza.
	   * Az interf�sz r�sze, ez�rt implement�ljuk.
	   * @param neighbours  Az aszteroida szomsz�dj�nak felvenni
	   * k�v�nt aszteroida.
	   */
	
	@Override
	public void setNeighbours(Asteroid neighbours) {
		// TODO Auto-generated method stub

	}
	
	/**
	   * Ez a met�dus, ami a karaktert fogad az aszteroid�n.
	   * Az interf�sz r�sze, ez�rt implement�ljuk.
	   * @param c  A fogadott karakter.
	   */

	@Override
	public void acceptCharacter(Character c) {
		// TODO Auto-generated method stub

	}

	/**
	 * A napvihar bemutat�s��rt felel�s met�dus.
	 * Az interf�sz r�sze, ez�rt implement�ljuk.
	 */
	
	@Override
	public void SolarStorm() {
		// TODO Auto-generated method stub

	}
	public void goCrazy() {
		
		Random r = new Random();
		int hanyadik = 0;
		if (crazy)
		{
			hanyadik = r.nextInt(asteroid.getNeighbours().size());
			System.out.println("Portal moved to " + asteroid.getNeighbours().get(hanyadik).getName());
			this.setAsteroid(asteroid.getNeighbours().get(hanyadik));
			
		}
		
	}
	@Override
	public void step() {
		goCrazy();
		//System.out.println("Step - Portal");
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public boolean isCrazy() {
		return crazy;
	}
	public void setCrazy(boolean crazy) {
		this.crazy = crazy;
	}
	@Override
	public boolean isAlive() {
		
			return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
