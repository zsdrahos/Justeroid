package Game;

/**
 * A vas anyag osztálya, ami egy nagyon egyszerû
 * osztály, alap metódusokkal rendelkezik és egy
 * name attribútummal.
 */

public class Iron extends Material {
	
	/**
	   * Ez a metódus a name attribútum normál gettere.
	   * @return name  A beállított név attribútum.
	   */
	
	@Override
	public String getName() {
		return name;
	}

	/**
	   * Ez a metódus a name attribútum normál settere.
	   * @param name  A beállítani való név.
	   */
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	private String name = "Iron";

	/**
	   * Ezt a metódust az osztály az õsétõl, a Matterial
	   * osztálytól örökölte, ezért kötelezõen implementáljuk.
	   * @param a  Az anyagot tartalmazó aszteroida
	   */
	
	@Override
	void interactWith(Asteroid a) {

	}
}
