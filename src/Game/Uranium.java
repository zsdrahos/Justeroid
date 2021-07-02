package Game;

/**
 * Az ur�n anyag oszt�lya, ami egy nagyon egyszer� oszt�ly, alap met�dusokkal
 * rendelkezik �s egy name attrib�tummal.
 */

public class Uranium extends Material {

	/**
	 * Ez a met�dus a name attrib�tum norm�l gettere.
	 * 
	 * @return name A be�ll�tott n�v attrib�tum.
	 */
	private int counter;

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Ez a met�dus a name attrib�tum norm�l settere.
	 * 
	 * @param name A be�ll�tani val� n�v.
	 */

	@Override
	public void setName(String name) {
		this.name = name;
	}

	private String name = "Uranium";

	/**
	 * Ezt a met�dust az oszt�ly az �s�t�l, a Matterial oszt�lyt�l �r�k�lte,
	 * bemutatja, hogyan viselkedik az ur�n napk�zelben, megf�rt �llapotban. Ha
	 * mindez teljes�l, akkor felrobban az aszteroida.
	 * 
	 * @param a Az ur�nt tartalmaz� aszteroida.
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
