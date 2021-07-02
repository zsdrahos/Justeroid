package Game;
import java.util.ArrayList;



/**
 * A játék osztálya, jelen esteben még csak egy metódussal
 * rendelkezik, a teszteléshez ennyi is elegendõ most
 * számunkra.
 */

public class Game {
	public Game() {
		settlers.add(s1);
		settlers.add(s2);
		settlers.add(s3);
		currentSettler = s1;
		
		
		
	}
	/**
	 * Karakterek hozzáadása (3)
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
	 * Ufo és settler arraylist
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
	 * A játékot befejezõ metódus, meghívásával véget ér
	 * a játék, jelen esetben a tesztelés.
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
	 * A játékot elindító metódus, meghívásával elindul
	 * a játék. Ezt a tesztelésbe nem foglaljuk bele, késõbb
	 * kerül implementálásra. Ajáték inicializálásáért lesz
	 * felelõs
	 */
	
	public void StartGame(SolarSystem s) {
		currentSystem = s;
		s.createAsteroid(50);
		s.setNeighbour();
		
		//s.list();
	}
}
