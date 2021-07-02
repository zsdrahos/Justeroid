package Game;

/**
 * Az anyagokat �sszefog� �soszt�ly. Minden anyag
 * ebb�l az oszt�lyb�l sz�rmazik. Ebben az oszt�lyban
 * alapmet�dusok vannak �s egy n�v attrib�tum.
 */

public abstract class Material {

	/**
	   * Ez a met�dus a name attrib�tum norm�l gettere.
	   * @return name  A be�ll�tott n�v attrib�tum.
	   */
	
	public String getName() {
		if (name == null)
			return "0";
		return name;

	}
	
	
	/**
	   * Ez a met�dus a name attrib�tum norm�l settere.
	   * @param name  A be�ll�tani val� n�v.
	   */
	
	public void setName(String name) {
		this.name = name;
	}

	private String name;

	/**
	   * Ezt a met�dus a lesz�rmazottakban fontos, itt
	   * csak mint absztrakt f�ggv�ny van jelen, k�s�bb
	   * a lesz�rmazottakban ker�l implement�l�sra.
	   * @param a  Az anyagot tartalmaz� aszteroida
	   */
	
	abstract void interactWith(Asteroid a);
}
