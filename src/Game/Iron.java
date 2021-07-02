package Game;

/**
 * A vas anyag oszt�lya, ami egy nagyon egyszer�
 * oszt�ly, alap met�dusokkal rendelkezik �s egy
 * name attrib�tummal.
 */

public class Iron extends Material {
	
	/**
	   * Ez a met�dus a name attrib�tum norm�l gettere.
	   * @return name  A be�ll�tott n�v attrib�tum.
	   */
	
	@Override
	public String getName() {
		return name;
	}

	/**
	   * Ez a met�dus a name attrib�tum norm�l settere.
	   * @param name  A be�ll�tani val� n�v.
	   */
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	private String name = "Iron";

	/**
	   * Ezt a met�dust az oszt�ly az �s�t�l, a Matterial
	   * oszt�lyt�l �r�k�lte, ez�rt k�telez�en implement�ljuk.
	   * @param a  Az anyagot tartalmaz� aszteroida
	   */
	
	@Override
	void interactWith(Asteroid a) {

	}
}
