package Game;


/**
 * A vízjég anyag osztálya, ami egy nagyon egyszerû
 * osztály, alap metódusokkal rendelkezik és egy
 * name attribútummal.
 */

public class IceWater extends Material {
	
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

	private String name = "IceWater";

	/**
	   * Ezt a metódust az osztály az õsétõl, a Matterial
	   * osztálytól örökölte, bemutatja, hogyan viselkedik
	   * a vízjég napközelben, megfúrt állapotban. Ha mindez
	   * teljesül, akkor szublimál, üres lesz aszteroidájának
	   * a magja.
	   * @param a  A vízjeget tartalmazó aszteroida.
	   */
	
	@Override
	public void interactWith(Asteroid a) {
		if (a.isNearSun() && a.getCrustThickness() == 0) {
			a.setResources(null);

			System.out.println("IceWater is sublimated!");

		}

	}
}