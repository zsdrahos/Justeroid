package Game;

/**
 * Az anyagokat összefogó õsosztály. Minden anyag
 * ebbõl az osztályból származik. Ebben az osztályban
 * alapmetódusok vannak és egy név attribútum.
 */

public abstract class Material {

	/**
	   * Ez a metódus a name attribútum normál gettere.
	   * @return name  A beállított név attribútum.
	   */
	
	public String getName() {
		if (name == null)
			return "0";
		return name;

	}
	
	
	/**
	   * Ez a metódus a name attribútum normál settere.
	   * @param name  A beállítani való név.
	   */
	
	public void setName(String name) {
		this.name = name;
	}

	private String name;

	/**
	   * Ezt a metódus a leszármazottakban fontos, itt
	   * csak mint absztrakt függvény van jelen, késõbb
	   * a leszármazottakban kerül implementálásra.
	   * @param a  Az anyagot tartalmazó aszteroida
	   */
	
	abstract void interactWith(Asteroid a);
}
