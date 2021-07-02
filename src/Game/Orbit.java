package Game;

/**
 * Az aszteroid�k �s port�lok k�z�s interf�sze, ami
 * h�rom met�dusb�l �ll, ezeket implement�lj�k 
 * a megval�s�t� oszt�lyok.
 */

public interface Orbit {
	
	/**
	   * Ez a met�dus a neighbours lista settere.
	   * A met�dus be�ll�tja a szomsz�ds�gi viszonyt oda-vissza.
	   * Megval�s�t� oszt�lyban implement�ljuk.
	   * @param neighbours  Az aszteroida szomsz�dj�nak felvenni
	   * k�v�nt aszteroida.
	   */

	void setNeighbours(Asteroid neighbours);

	/**
	   * Ez a met�dus, ami a karaktert fogad az aszteroid�n.
	   * Megval�s�t� oszt�lyban implement�ljuk.
	   * @param c  A fogadott karakter.
	   */
	
	public void acceptCharacter(Character c);

	/**
	 * A napvihar bemutat�s��rt felel�s met�dus, a megval�s�t�
	 * oszt�lyban kell implement�lni.
	 */
	
	public void SolarStorm();

}
