package Game;

/**
 * Az aszteroidák és portálok közös interfésze, ami
 * három metódusból áll, ezeket implementálják 
 * a megvalósító osztályok.
 */

public interface Orbit {
	
	/**
	   * Ez a metódus a neighbours lista settere.
	   * A metódus beállítja a szomszédsági viszonyt oda-vissza.
	   * Megvalósító osztályban implementáljuk.
	   * @param neighbours  Az aszteroida szomszédjának felvenni
	   * kívánt aszteroida.
	   */

	void setNeighbours(Asteroid neighbours);

	/**
	   * Ez a metódus, ami a karaktert fogad az aszteroidán.
	   * Megvalósító osztályban implementáljuk.
	   * @param c  A fogadott karakter.
	   */
	
	public void acceptCharacter(Character c);

	/**
	 * A napvihar bemutatásáért felelõs metódus, a megvalósító
	 * osztályban kell implementálni.
	 */
	
	public void SolarStorm();

}
