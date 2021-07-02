package Game;
import java.util.ArrayList;



/**
 * A j�t�k oszt�lya, jelen esteben m�g csak egy met�dussal
 * rendelkezik, a tesztel�shez ennyi is elegend� most
 * sz�munkra.
 */

public class Game {
	public Game() {
		settlers.add(s1);
		settlers.add(s2);
		settlers.add(s3);
		currentSettler = s1;
		
		
		
	}
	/**
	 * Karakterek hozz�ad�sa (3)
	 * 
	 * */
	Character currentSettler =null;
	public static Character s1 = new Settler("S1");
	public static Character s2 = new Settler("S2");
	public static Character s3 = new Settler("S3");

	
	public ArrayList<Character> getSettlers() {
		return settlers;
	}


	public void setSettlers(Character settlers) {
		this.settlers.add(settlers);
	}

	/**
	 * Ufo �s settler arraylist
	 * */
	ArrayList<Character> settlers = new ArrayList<Character>();
	ArrayList<Character> ufos = new ArrayList<Character>();
	
	
	
	int currentindex = 0;
	
	public int getCurrentindex() {
		return currentindex;
	}


	public void setCurrentindex(int currentindex) {
		this.currentindex = currentindex;
	}


	public void SetIndex() {
		currentindex++;
		currentindex = currentindex % settlers.size();
		currentSettler = settlers.get(currentindex);
	}
	
	public Character getCurrentSettler() {
		return currentSettler;
	}	
	

	public void setCurrentSettler(Character currentSettler) {
		this.currentSettler = currentSettler;
	}

	/**
	 * A j�t�kot befejez� met�dus, megh�v�s�val v�get �r
	 * a j�t�k, jelen esetben a tesztel�s.
	 */
	private SolarSystem currentSystem;
	
	
	public SolarSystem getCurrentSystem() {
		return currentSystem;
	}

	public void setCurrentSystem(SolarSystem currentSystem) {
		this.currentSystem = currentSystem;
	}

	private int numOfAsteroids;
	
	
	public int getNumOfAsteroids() {
		return numOfAsteroids;
	}

	public void setNumOfAsteroids(int numOfAsteroids) {
		this.numOfAsteroids = numOfAsteroids;
	}

	
	/**
	 * A j�t�kot elind�t� met�dus, megh�v�s�val elindul
	 * a j�t�k. Ezt a tesztel�sbe nem foglaljuk bele, k�s�bb
	 * ker�l implement�l�sra. Aj�t�k inicializ�l�s��rt lesz
	 * felel�s
	 */
	
	public void StartGame(SolarSystem s) {
		currentSystem = s;
		s.createAsteroid(50);
		s.setNeighbour();
		
		//s.list();
	}
}
