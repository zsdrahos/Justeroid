package Game;

/**
 * Az urán anyag osztálya, ami egy nagyon egyszerû osztály, alap metódusokkal
 * rendelkezik és egy name attribútummal.
 */

public class Uranium extends Material {

	/**
	 * Ez a metódus a name attribútum normál gettere.
	 * 
	 * @return name A beállított név attribútum.
	 */
	private int counter;

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Ez a metódus a name attribútum normál settere.
	 * 
	 * @param name A beállítani való név.
	 */

	@Override
	public void setName(String name) {
		this.name = name;
	}

	private String name = "Uranium";

	/**
	 * Ezt a metódust az osztály az õsétõl, a Matterial osztálytól örökölte,
	 * bemutatja, hogyan viselkedik az urán napközelben, megfúrt állapotban. Ha
	 * mindez teljesül, akkor felrobban az aszteroida.
	 * 
	 * @param a Az uránt tartalmazó aszteroida.
	 */

	@Override
	public void interactWith(Asteroid a) {
		if (a.isNearSun() && a.getCrustThickness() == 0) {

			counter++;
			//System.out.println(counter);
			if (counter == 3) {
				a.setResources(null);
				a.explode();
			}

		}

	}
}
