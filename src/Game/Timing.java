package Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

public class Timing implements ActionListener {
	Timer t = new Timer(0, this);
	ArrayList<Stepper> s = new ArrayList<>();;
	public void tick() {
		t.setDelay(10000);
		t.start();
	}
	Iterator<Stepper> iter = s.iterator();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*while (iter.hasNext()) {
		    Stepper str = iter.next();

		    if (str.isAlive()==false)
		        this.remvoeSubscriber(str);
		    else str.step();
		}*/
		
		
		
		if (s.size() != 0)
		{for (Stepper st : s) {
           
           /*if (st.isAlive()==false)
        	   this.remvoeSubscriber(st);*/
           st.step();
        }}
		s.removeIf(k -> (k.isAlive() == false));
	}
	public void addSubscriber(Stepper sub) {
        s.add(sub);
    }
	public void remvoeSubscriber(Stepper sub) {
        s.remove(sub);
    }
	
}
