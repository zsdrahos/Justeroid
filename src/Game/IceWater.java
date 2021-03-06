package Game;


/**
 * A v?zj?g anyag oszt?lya, ami egy nagyon egyszer?
 * oszt?ly, alap met?dusokkal rendelkezik ?s egy
 * name attrib?tummal.
 */

public class IceWater extends Material {
	
	/**
	   * Ez a met?dus a name attrib?tum norm?l gettere.
	   * @return name  A be?ll?tott n?v attrib?tum.
	   */
	
	@Override
	public String getName() {
		return name;
	}
	
	/**
	   * Ez a met?dus a name attrib?tum norm?l settere.
	   * @param name  A be?ll?tani val? n?v.
	   */

	@Override
	public void setName(String name) {
		this.name = name;
	}

	private String name = "IceWater";

	/**
	   * Ezt a met?dust az oszt?ly az ?s?t?l, a Matterial
	   * oszt?lyt?l ?r?k?lte, bemutatja, hogyan viselkedik
	   * a v?zj?g napk?zelben, megf?rt ?llapotban. Ha mindez
	   * teljes?l, akkor szublim?l, ?res lesz aszteroid?j?nak
	   * a magja.
	   * @param a  A v?zjeget tartalmaz? aszteroida.
	   */
	
	@Override
	public void interactWith(Asteroid a) {
		if (a.isNearSun() && a.getCrustThickness() == 0) {
			a.setResources(null);

			System.out.println("IceWater is sublimated!");

		}

	}
}