package Game;
import java.util.Random;

/**
 * A portálkapuk osztálya, az Orbit interfész
 * megvalósító osztálya. A portálokon való mûveletek
 * bemutatására való metódusok és a kapuk tulajdon-
 * ságait tartalmazó osztály.
 */

public class Portal implements Orbit, Stepper {
	private Portal pair;
	private Asteroid asteroid;
	private boolean crazy;
	private String ID;
	private boolean alive = true;
	/**
	   * Ez a metódus a pair attribútum normál gettere.
	   * @return pair  A beállított kapu, ami a párja.
	   */
	
	public Portal(String n)
	{
		ID = n;
	}
	public Portal getPair() {
		return pair;
	}
	
	/**
	   * Ez a metódus a pair attribútum normál settere.
	   * @param pair  A beállítani való kapu, ami a párja
	   * lesz.
	   */

	public void setPair(Portal pair) {
		this.pair = pair;
	}

	/**
	   * Ez a metódus a asteroid attribútum normál gettere.
	   * @return asteroid  Az aszteroida, amin a kapu van.
	   */
	
	public Asteroid getAsteroid() {
		return asteroid;
	}
	
	/**
	   * Ez a metódus a asteroid attribútum normál settere.
	   * @param asteroid  Az aszteroida, amin lesz a kapu.
	   */

	public void setAsteroid(Asteroid asteroid) {
		this.asteroid = asteroid;
	}

	public void hasPair(Portal p) {
		
	}
	
	/**
	   * Ez a metódus a neighbours lista settere.
	   * A metódus beállítja a szomszédsági viszonyt oda-vissza.
	   * Az interfész része, ezért implementáljuk.
	   * @param neighbours  Az aszteroida szomszédjának felvenni
	   * kívánt aszteroida.
	   */
	
	@Override
	public void setNeighbours(Asteroid neighbours) {
		// TODO Auto-generated method stub

	}
	
	/**
	   * Ez a metódus, ami a karaktert fogad az aszteroidán.
	   * Az interfész része, ezért implementáljuk.
	   * @param c  A fogadott karakter.
	   */

	@Override
	public void acceptCharacter(Character c) {
		// TODO Auto-generated method stub

	}

	/**
	 * A napvihar bemutatásáért felelõs metódus.
	 * Az interfész része, ezért implementáljuk.
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
