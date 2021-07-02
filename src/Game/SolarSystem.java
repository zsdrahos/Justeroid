package Game;
import java.util.ArrayList;
import java.util.Random;

/**
 * A naprendszert szimboliz�l� oszt�ly, melyben alap-
 * met�dusok tal�lhat�ak meg az aszteroid�nkon �s a 
 * Napon k�v�l
 */

public class SolarSystem implements Stepper{
		private Sun sun = new Sun();
		private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		private boolean alive = true;
		
		//----------------met�dusok--------------------
		public Sun getSun() {
			return sun;
		}

		public void setSun(Sun sun) {
			this.sun = sun;
			System.out.println("Sun is born");
		}

		
		
		public ArrayList<Asteroid> getAsteroids() {
			return asteroids;
		}

		public void setAsteroids(Asteroid asteroids) {
			this.asteroids.add(asteroids);
		}

		/**
		 * Ez a met�dus l�trehoz egy aszteroid�t a naprendszerben
		 * �s elnevezi azt.
		 */
		
		public void createAsteroid(int num){
			Random r = new Random();
			Random r1 = new Random();
			Random r2 = new Random();
			
			for (int j = 0; j<num;j++)
		    {
				
			int rand = 0;
			boolean uj = false;
			
			if (asteroids.size() == 0)
			{
				Asteroid a000 = new Asteroid("AS001",new Iron(), 10);
				asteroids.add(a000);
			}
			
			rand = r.nextInt(700);
			while(!uj)
			{
				rand = r.nextInt(700);
				for (int i = 0; i<asteroids.size(); i++)
				{
					if ("AS" + rand == asteroids.get(i).getName())
					{
						uj = false;
					}
					else uj = true;
					
				}
				
			}
			
			
			int rand1 = r1.nextInt(5);
			int rand2 = r2.nextInt(5);
			
			//int x = rrr.nextInt(700);
			boolean near = false;
			if (rand % 11 == 0)
			{
				near = true;
			}
			else {
				near = false;
			}
			
			Material m;
			Asteroid a;
			switch(rand2)
			{
				case 0: m = new Iron(); a = new Asteroid("AS"+rand ,m, rand1); asteroids.add(a);a.setNearSun(near);break;
				
				case 1: m = new Coal(); a = new Asteroid("AS"+rand,m, rand1); asteroids.add(a);a.setNearSun(near);break;
				
				case 2: m = new IceWater(); a = new Asteroid("AS"+rand, m, rand1); asteroids.add(a);a.setNearSun(near);break;
				
				case 3: m = new Uranium(); a = new Asteroid("AS"+rand,m, rand1); asteroids.add(a); a.setNearSun(near);break;
				
				case 4: m = null; a = new Asteroid("AS"+rand,m, rand1); asteroids.add(a);a.setNearSun(near);break;
				
				default:
			}
			
			
			
		    }
			
			
			
			
		}
		
		/**
		 * Ez a met�dus az inicializ�l�s r�sze lesz a k�sz j�t�kban.
		 * Az alap fel�ll�st �s naprendszert fogja be�ll�tani, de 
		 * most m�g a skeletonba ezt nem implement�ltuk.
		 */
		
		public void list()
		{
			for (Asteroid var : asteroids) 
			{ 
				ArrayList<String> a = new ArrayList<String>();
				 for(int i = 0; i<var.getNeighbours().size(); i++) 
					a.add(var.getNeighbours().get(i).getName());
				if (var.getResources() == null)
					System.out.println(var.getName() + " " + var.getCrustThickness() + " " + "EMPTY" + "\n" + "Neighbour: " + a);
				else 
					System.out.println(var.getName() + " " + var.getCrustThickness() + " " + var.getResources().getName() + "\n" + "Neighbour: " + a);
				
			}
			
		}
		
		public void setNeighbour() {
			
			
			for (int i = 0; i<asteroids.size()-1; i++)
			{
				asteroids.get(i).setNeighbours(asteroids.get(i+1));
				asteroids.get(i+1).setNeighbours(asteroids.get(i));
			}
			
			Random r = new Random();
			
			
			for (int i = 0; i<asteroids.size(); i++)
				{
				//asteroids.get(i);
				
				int rand = r.nextInt(asteroids.size());
				//asteroids.get(rand);
				
				
				asteroids.get(i).setNeighbours(asteroids.get(rand));
				asteroids.get(rand).setNeighbours(asteroids.get(i));
				}
			
		}
		
		/**
		   * Ez a met�dus, ami a t�r�l egy aszteroid�t a naprendszerb�l.
		   * @param a  A t�r�lni k�v�nt aszteroida.
		   */
		
		
		
		public void removeAsteroid(String a)
		{
			
			Asteroid ast = null;
			for (int k = 0; k<asteroids.size(); k++)
			{
				if (asteroids.get(k).getName().equals(a))
					{ast = asteroids.get(k);
					for (int i = 0; i<ast.getCharacters().size(); i++)
						ast.getCharacters().get(i).upponExplosion();
						break;
						
					}
					
			}
			//System.out.println(ast);
			
			
			for (int i = 0; i<ast.getNeighbours().size(); i++)
			{
				for (int j = 0; j<ast.getNeighbours().get(i).getNeighbours().size(); j++)
				{
					ast.getNeighbours().get(i).getNeighbours().remove(ast);
					
				}
				
			}
			System.out.println(ast.getName() + " exploded");
			asteroids.remove(ast);
				
				
				
			
		}
		
		/**
		 * Ez a met�dus a napvihar folyamat�nak bemutat�s��rt felel�s.
		 * Ez jelen esetben nagyon egyszer� �s manu�lisan t�rt�nik, 
		 * �leseben a j�t�kban ett�l �sszetettebb lesz. Most itt a
		 * Nap met�dus�t h�vjuk meg az �ssze aszteroid�nkra.
		 */
		@Override
		public void step() {
			
			ArrayList<Asteroid> a_solar = new ArrayList<Asteroid>();
			Random r = new Random();
			int rand = 0;
			rand = r.nextInt(asteroids.size());
			a_solar.add(asteroids.get(rand));
			a_solar.addAll(asteroids.get(rand).getNeighbours());
			if (sun.getSolarTimer() % 20 == 0)
				sun.startSolarStorm(a_solar);
			//System.out.println("STEEEEEEEEEEEEEEp-solar");
			
		}

		@Override
		public boolean isAlive() {
			// TODO Auto-generated method stub
			return alive;
		}

		public void setAlive(boolean alive) {
			this.alive = alive;
		}

	
		
		
}
