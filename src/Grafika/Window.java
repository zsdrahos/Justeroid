package Grafika;

import java.awt.Color;
import java.awt.Container;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import Game.Game;
import Game.Robot;
import Game.Timing;
import Game.Ufo;

/**
 * Ez az osztály felel a játékfelületért
 * */

public class Window extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container con;
	private JFrame frame;
	private JButton bmove, bdrill, bmine, bhide, bteleport, binventory, togglesettler, bbuildrobot, bbuildteleport, bpickupportal,bdump, bplaceteleport;
	JTextArea t1;
	Font d = new Font("Courier New", Font.PLAIN, 20);
	Font g = new Font("Courier New", Font.PLAIN, 18);
	Font c = new Font("Courier New", Font.PLAIN, 60);
	JList<String> list;
	JList<String> listP;
	static boolean tick = false;
	static Timing t = new Timing();
	Timer time = new Timer(0, this);
	static Game game;
	JLabel robot;
	JPanel gamerobot;
	JLabel ufo;
	JPanel gameufo;
	DefaultListModel<String> portallist;
	JLabel crrsett;
	JLabel jl2;
	JLabel solarstormlabel;
	JPanel solarstorm;
	int numsettlres;
	JPanel end;
	JLabel lname;
	
	/**
	 * Konstruktor amiben a játék kezelõfelülete van megírva
	 * */
	public Window(Game gg) throws InterruptedException {
		frame = new JFrame();
		frame.setSize(1280, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		con = frame.getContentPane();
		time.setDelay(1000);
		time.start();
		
		game = gg;
		

		/// ================================================================================
		// GamePanel
		// ================================================================================
		JPanel gamespace = new JPanel();
		gamespace.setBounds(500, 200, 400, 500);
		jl2 = new JLabel();
		jl2.setBackground(Color.white);
		gamespace.setBackground(Color.black);
		
		jl2.setIcon(new ImageIcon("src/images/ast_set/Drill1_s.png"));
		//MyCanvas canvas = new MyCanvas(game);
		gamespace.add(jl2);
		
		gamerobot = new JPanel();
		gamerobot.setBounds(900, 150, 200, 200);
		robot = new JLabel();
		gamerobot.setBackground(Color.black);
		gamerobot.add(robot);
		//robot.setIcon(new ImageIcon("src/images/settler_k.png"));
		//MyCanvas canvas = new MyCanvas(game);
		//gamesettler.add(jlsettler);
		gameufo = new JPanel();
		gameufo.setBounds(850, 400, 300,300);
		ufo = new JLabel();
		gameufo.setBackground(new Color(0,0,0,0));
		gameufo.add(ufo);
		
		
		// ================================================================================
		// SolarStorm visszajelzo
		// ================================================================================
		solarstormlabel = new JLabel("");
		solarstorm = new JPanel();
		solarstormlabel.setFont(d);
		solarstorm.setBounds(700, 10,700,50);
		solarstorm.setBackground(Color.black);
		solarstormlabel.setBackground(Color.black);
		solarstormlabel.setForeground(Color.red);
		solarstorm.add(solarstormlabel);
		
		// ================================================================================
		// Create UFO
		// ================================================================================
		Random rr = new Random();
		Random r = new Random();
		for (int i = 0; i < 5; i++)
			new Ufo("U" + r.nextInt(700), t).setLocation(game.getCurrentSystem().getAsteroids().get(rr.nextInt(game.getCurrentSystem().getAsteroids().size())));
		new Ufo("U001", t).setLocation(game.getCurrentSystem().getAsteroids().get(0));
		// ================================================================================
		// Automata dolgok
		// ================================================================================
		tick = true;
		t.tick();
		t.addSubscriber(game.getCurrentSystem().getSun());
		t.addSubscriber(game.getCurrentSystem());
		// ================================================================================
		// SetIcon
		// ================================================================================
		ImageIcon img = new ImageIcon("src/images/logo2.png");
		frame.setIconImage(img.getImage());
		// ================================================================================
		// Console output
		// ================================================================================
		JPanel p2 = new JPanel();
		p2.setBounds(10, 410, 205, 300);
		p2.setBackground(Color.black);
		t1 = new JTextArea(18, 18);
		t1.setText("******OUTPUT******\n\n>");
		t1.setBackground(Color.black);
		t1.setForeground(Color.green);
		t1.setFont(g);
		t1.setBorder(BorderFactory.createLineBorder(Color.white));
		p2.add(t1);

		/// ================================================================================
		// Current settler
		// ================================================================================
		JPanel currentsettlerL = new JPanel();
		currentsettlerL.setBounds(20, 10, 300, 100);
		currentsettlerL.setBackground(Color.black);

		crrsett = new JLabel("");
		crrsett.setText(game.getCurrentSettler().getName() + " - " + game.getCurrentSettler().getLocation().getName());
		crrsett.setForeground(Color.WHITE);
		crrsett.setBackground(Color.black);
		crrsett.setFont(d);

		// ================================================================================
		// Gomobok
		// ================================================================================
		bmove = new JButton("MOVE");
		bdrill = new JButton("DRILL");
		bmine = new JButton("MINE");
		bhide = new JButton("HIDE/UNHIDE");
		bteleport = new JButton("TELEPORT");
		bdump = new JButton("DUMP");
		binventory = new JButton("INVENTORY");
		togglesettler = new JButton("CHANGE SETTLER");
		bbuildrobot = new JButton("BUILD  ROBOT");
		bbuildteleport = new JButton("BUILD PORTAL");
		bplaceteleport = new JButton("PLACE PORTAL");
		bpickupportal = new JButton("PICKUP PORTAL");

		// ================================================================================
		// Szomszédsági lista view
		// ================================================================================
		DefaultListModel<String> tmp = new DefaultListModel<String>();
		list = new JList<>(tmp);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(3);
		JScrollPane astListScrollPane = new JScrollPane(list);
		astListScrollPane.setBounds(230, 100, 100, 100);

		list.setBackground(Color.black);
		list.setForeground(Color.white);

		// ================================================================================
		// Portal lista view
		// ================================================================================
		portallist = new DefaultListModel<String>();
		listP = new JList<>(portallist);
		listP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listP.setSelectedIndex(0);
		listP.setVisibleRowCount(3);
		JScrollPane PortalListScrollPane = new JScrollPane(listP);
		PortalListScrollPane.setBounds(230, 300, 100, 100);

		listP.setBackground(Color.black);
		listP.setForeground(Color.white);

		// ================================================================================
		// Gomobok beállítása
		// ================================================================================
		bmove.setBackground(Color.black);
		bmove.setForeground(Color.white);
		bmove.setFont(d);
		bmove.addActionListener(new MoveListener(game, list, tmp, portallist, jl2, gamespace));
		// bmove.setPreferredSize(new Dimension(140, 140));

		bdrill.setBackground(Color.black);
		bdrill.setForeground(Color.white);
		bdrill.setFont(d);
		bdrill.addActionListener(new DillListener(gg, jl2, gamespace));

		bmine.setBackground(Color.black);
		bmine.setForeground(Color.white);
		bmine.setFont(d);
		bmine.addActionListener(new MineListener(game, jl2, gamespace));

		bhide.setBackground(Color.black);
		bhide.setForeground(Color.white);
		bhide.setFont(d);
		bhide.addActionListener(new HideListener(game, jl2));

		bteleport.setBackground(Color.black);
		bteleport.setForeground(Color.white);
		bteleport.setFont(d);
		bteleport.addActionListener(new TeleportListener(game, listP, portallist));
		
		bdump.setBackground(Color.black);
		bdump.setForeground(Color.white);
		bdump.setFont(d);
		bdump.addActionListener(new DumpListener(game, jl2));

		binventory.setBackground(Color.black);
		binventory.setForeground(Color.white);
		binventory.setFont(d);
		binventory.addActionListener(new InventoryListener(game, t1));

		togglesettler.setBackground(Color.black);
		togglesettler.setForeground(Color.white);
		togglesettler.setFont(d);
		togglesettler.addActionListener(new ToggleSettlerListener(game, tmp, crrsett, portallist, jl2));

		bbuildrobot.setBackground(Color.black);
		bbuildrobot.setForeground(Color.white);
		bbuildrobot.setFont(d);
		bbuildrobot.addActionListener(new BuildRobotListener(game, tick, t));

		bbuildteleport.setBackground(Color.black);
		bbuildteleport.setForeground(Color.white);
		bbuildteleport.setFont(d);
		bbuildteleport.addActionListener(new BuildPortalListener(game, t1));

		bplaceteleport.setBackground(Color.black);
		bplaceteleport.setForeground(Color.white);
		bplaceteleport.setFont(d);
		bplaceteleport.addActionListener(new PlacePortalListener(game, portallist, t));
		
		bpickupportal.setBackground(Color.black);
		bpickupportal.setForeground(Color.white);
		bpickupportal.setFont(d);
		bpickupportal.addActionListener(new PickUpPortalListener(game, portallist));
		
		// ================================================================================
		// Szomszedsagi Lista feltoltese
		// ================================================================================
		for (int i = 0; i < game.getCurrentSettler().getLocation().getNeighbours().size(); i++) {
			tmp.addElement(game.getCurrentSettler().getLocation().getNeighbours().get(i).getName());
		}
		System.out.println(tmp);

		// ================================================================================
		// Portal Lista feltoltese
		// ================================================================================
		for (int i = 0; i < game.getCurrentSettler().getLocation().getPortals().size(); i++) {
			portallist.addElement(game.getCurrentSettler().getLocation().getPortals().get(i).getPair().getID());
		}
		System.out.println(portallist);

		// ================================================================================
		// Toggler Settler gomb panel
		// ================================================================================
		JPanel toggle = new JPanel();
		toggle.setBounds(250, 655, 200, 100);
		toggle.setBackground(Color.black);

		// ================================================================================
		// Gomob panel
		// ================================================================================
		JPanel p = new JPanel();
		p.setBounds(10, 100, 200, 280);
		p.setBackground(Color.black);

		// ================================================================================
		// Build jobb also panel
		// ================================================================================
		JPanel p3 = new JPanel();
		p3.setBounds(1062, 560, 200, 280);
		p3.setBackground(Color.black);

		p3.add(bplaceteleport);
		p3.add(bbuildteleport);
		p3.add(bbuildrobot);
		p3.add(bpickupportal);
		currentsettlerL.add(crrsett);
		// set Box Layout
		p.setLayout(new GridLayout(7, 1));

		// add buttons and textfield to panel
		p.add(bmove);
		p.add(bdrill);
		p.add(bmine);
		p.add(bhide);
		p.add(bteleport);
		p.add(bdump);
		p.add(binventory);

		toggle.add(togglesettler);
		numsettlres = game.getSettlers().size();
		for (int i = 0; i<game.getSettlers().size(); i++)
		{
			
			if (game.getSettlers().get(i).isAlive() == false)
				{
				numsettlres--;
				}
		}
		
		
		end = new JPanel();
		end.setBounds(100, 100, 1280, 720);
		end.setBackground(Color.black);

		JLabel endtitle = new JLabel("Game Over");
		endtitle.setName("Game Over");
		endtitle.setForeground(Color.white);
		endtitle.setBackground(Color.red);
		endtitle.setFont(c);
		end.add(endtitle);
		
		
		

		// ================================================================================
		// Cím Panel
		// ================================================================================
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(450, 10, 400, 150);
		titlePanel.setBackground(Color.black);

		lname = new JLabel("JUSTEROID");
		lname.setName("JUSTEROID");
		lname.setForeground(Color.WHITE);
		lname.setBackground(Color.black);
		lname.setFont(c);
		titlePanel.add(lname);

		// ================================================================================
		// Megjelenítése
		// ================================================================================

		if (numsettlres <= 1)
		{
			con.add(end);
			con.remove(p);
			con.remove(p2);
			con.remove(astListScrollPane);
			con.remove(currentsettlerL);
			con.remove(toggle);
			con.remove(p3);
			con.remove(PortalListScrollPane);
			con.remove(gamespace);
			
			//Thread.sleep(4000);
			//System.exit(0);
			
		}
		else {
		
		con.add(p);
		con.add(p2);
		con.add(astListScrollPane);
		con.add(currentsettlerL);
		
		con.add(titlePanel);
		con.add(toggle);
		con.add(p3);
		con.add(gamespace);
		con.add(PortalListScrollPane);
		//con.add(gamesettler);
		con.add(gamerobot);
		con.add(gameufo);
		con.add(solarstorm);
		//con.add(canvas);
		}
		
		con.repaint();
		con.revalidate();
		
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i<game.getCurrentSettler().getLocation().getCharacters().size(); i++)
			{if (game.getCurrentSettler().getLocation().getCharacters().get(i).getName().contains("Robot"))	
			{
				game.getCurrentSettler().getLocation().getCharacters().get(i).getRv().paint(robot);
				con.add(gamerobot);
				con.repaint();
				con.revalidate();
				
			}
			
			else {
				con.remove(gamerobot);
				//con.remove(gameufo);
				con.repaint();
				con.revalidate();
				
			}
			}
		
		for (int i = 0; i<game.getCurrentSettler().getLocation().getCharacters().size(); i++)
		{
			if (game.getCurrentSettler().getLocation().getCharacters().get(i).getName().contains(" UFO"))
		{
			game.getCurrentSettler().getLocation().getCharacters().get(i).getUv().paint(ufo);
			con.add(gameufo);
			con.repaint();
			con.revalidate();
			break;
		}
		
		else {
			con.remove(gameufo);
			con.repaint();
			con.revalidate();
			break;
		}
		}
		
		
		for (int j = 0; j < game.getCurrentSettler().getLocation().getPortals().size(); j++) {
			
			if (game.getCurrentSettler().getLocation().getPortals().get(j).isCrazy())
				{portallist.clear();
				portallist.addElement(game.getCurrentSettler().getLocation().getPortals().get(j).getPair().getID());}
			else {
				
			}
		}
		
		game.getCurrentSettler().getLocation().getAv().paint(jl2);
		crrsett.setText(game.getCurrentSettler().getName() + " - " + game.getCurrentSettler().getLocation().getName());
		game.getCurrentSettler().getSv().paint(jl2);
		if ((game.getCurrentSystem().getSun().getSolarTimer()+1) % 20 == 0)
			{solarstormlabel.setText("Solarstorm is coming - 10 sec");
			
			con.add(solarstorm);
			}
		else 
		{solarstormlabel.setText("");
		
		
		}
		for (int i = 0; i<game.getSettlers().size(); i++)
		{
			
			if (game.getSettlers().get(i).isAlive() == false)
				{
				numsettlres--;
				}
		}

		if (numsettlres <= 1)
		{
			//con.add(end);
			lname.setText("GAMEOVER");
			lname.setForeground(Color.red);
			con.repaint();
			con.revalidate();
			
			
			
			
			//Thread.sleep(4000);
			
			
		}
		
		for (int k = 0; k < game.getCurrentSystem().getAsteroids().size(); k++) {
			int ir = 0;
			int u = 0;
			int c = 0;
			int iw = 0;
			if (game.getCurrentSystem().getAsteroids().get(k).getCharacters().size() >= 2) {
				for (int i = 0; i < game.getCurrentSystem().getAsteroids().get(k).getCharacters().size(); i++) {
					if (game.getCurrentSystem().getAsteroids().get(k).getCharacters().get(i).getName().contains("Settler")) {
					

						for (int j = 0; j < game.getCurrentSystem().getAsteroids().get(k).getCharacters().get(i).getResources().size(); j++) {

							if (game.getCurrentSystem().getAsteroids().get(k).getCharacters().get(i).getResources().get(j).getName() == "Coal") {
								c++;
							} else if (game.getCurrentSystem().getAsteroids().get(k).getCharacters().get(i).getResources().get(j).getName() == "Uranium") {
								u++;
							} else if (game.getCurrentSystem().getAsteroids().get(k).getCharacters().get(i).getResources().get(j).getName() == "Iron") {
								ir++;
							} else if (game.getCurrentSystem().getAsteroids().get(k).getCharacters().get(i).getResources().get(j).getName() == "IceWater") {
								iw++;
							}

						}
						if (c >= 3 && u >= 3 && ir >= 3 && iw >= 3)
						{
							System.out.print("Winner Winner Chicken Dinner");
							lname.setText("WINNER");
							lname.setForeground(Color.orange);
						}
					}

				}
			}
		}
		
		
		
	}
	
	

}

/**
 * Gomb listenerek, ezek mondják meg mit csinál a gomb
 * */
//================================================================================
// Listenerek
//================================================================================
class DillListener implements ActionListener {
	Game g;
	JLabel j;
	JPanel p;
	
	public DillListener(Game game, JLabel jj, JPanel pp) {
		g = game;
		j = jj;
		p = pp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.getCurrentSettler().drill();
		if (g.getCurrentSettler().getLocation().getCrustThickness() == 0)
			g.getCurrentSettler().getLocation().getAv().paint(j);
		
			
	}
}
/**
 * Karakter váltó gomb listenre
 * */

class ToggleSettlerListener implements ActionListener {
	Game g;
	DefaultListModel<String> dlm;
	DefaultListModel<String> dlm2;
	JLabel l;
	JLabel l2;
	

	public ToggleSettlerListener(Game game, DefaultListModel<String> d, JLabel ll, DefaultListModel<String> d2, JLabel l22) {
		g = game;
		dlm = d;
		l = ll;
		dlm2 = d2;
		l2 = l22;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.SetIndex();
		g.setCurrentSettler(g.getSettlers().get(g.getCurrentindex()));
		
		/*
		 * System.out.println("kattint"); System.out.println(g.getCurrentindex());
		 * System.out.println(g.getCurrentSettler().getName());
		 */
		dlm.clear();
		for (int j = 0; j < g.getCurrentSettler().getLocation().getNeighbours().size(); j++) {
			dlm.addElement(g.getCurrentSettler().getLocation().getNeighbours().get(j).getName());
		}
		l.setText(g.getCurrentSettler().getName());
		dlm2.clear();
		for (int j = 0; j < g.getCurrentSettler().getLocation().getPortals().size(); j++) {
			dlm2.addElement(g.getCurrentSettler().getLocation().getPortals().get(j).getPair().getID());
		}
		g.getCurrentSettler().getLocation().getAv().paint(l2);
		
	}
}

/**
 * Bányászás gomb listenre
 * */
class MineListener implements ActionListener {
	Game g;
	JLabel j;
	JPanel p;
	
	public MineListener(Game game, JLabel jj, JPanel pp) {
		g = game;
		j = jj;
		p = pp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.getCurrentSettler().mine();
		
		g.getCurrentSettler().getLocation().getAv().paint(j);
	}
}
/**
 * Hide gomb listenre
 * */
class HideListener implements ActionListener {

	Game g;
	JLabel j;
	public HideListener(Game game, JLabel jj) {
		g = game;
		j = jj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (g.getCurrentSettler().isSafe())
			g.getCurrentSettler().unhide();

		else
			g.getCurrentSettler().hide();

		g.getCurrentSettler().getLocation().getAv().paint(j);
	}
}
/**
 * Inventory kiírás gomb listenre
 * */
class InventoryListener implements ActionListener {
	Game g;
	JTextArea j;

	public InventoryListener(Game game, JTextArea jt) {
		g = game;
		j = jt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		j.setText("******OUTPUT******\n" + g.getCurrentSettler().getName() + "\n>");
		for (int i = 0; i < g.getCurrentSettler().getResources().size(); i++) {

			j.append(g.getCurrentSettler().getResources().get(i).getName() + "\n>");
			System.out.println(g.getCurrentSettler().getResources().get(i).getName() + ", ");
			// System.out.println(g.getCurrentSettler().getLocation().getNeighbours().get(0).getName());

		}

	}
}
/**
 * Mozgás gomb listenre
 * */
class MoveListener implements ActionListener {
	Game g;
	JList<String> jl;
	DefaultListModel<String> dlm;
	DefaultListModel<String> dlm2;
	JLabel j2;
	JPanel p2;
	public MoveListener(Game game, JList<String> j, DefaultListModel<String> d, DefaultListModel<String> d2, JLabel jj, JPanel pp) {
		g = game;
		jl = j;
		dlm = d;
		dlm2 = d2;
		j2 = jj;
		p2 = pp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < g.getCurrentSettler().getLocation().getNeighbours().size(); i++) {
			if (g.getCurrentSettler().getLocation().getNeighbours().get(i).getName().equals(jl.getSelectedValue())) {
				g.getCurrentSettler().move(g.getCurrentSettler().getLocation().getNeighbours().get(i));
				dlm.clear();
				for (int j = 0; j < g.getCurrentSettler().getLocation().getNeighbours().size(); j++) {
					dlm.addElement(g.getCurrentSettler().getLocation().getNeighbours().get(j).getName());
				}
			}

		}
		dlm2.clear();
		for (int j = 0; j < g.getCurrentSettler().getLocation().getPortals().size(); j++) {
			dlm2.addElement(g.getCurrentSettler().getLocation().getPortals().get(j).getPair().getID());
		}
		g.getCurrentSettler().getLocation().getAv().paint(j2);

	}
}
/**
 * Teleport gomb listenre
 * */

class TeleportListener implements ActionListener {
	Game g;
	JList<String> jl;
	DefaultListModel<String> dlm;

	public TeleportListener(Game game, JList<String> j, DefaultListModel<String> d) {
		g = game;
		jl = j;
		dlm = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < g.getCurrentSettler().getLocation().getPortals().size(); i++) {
			if (g.getCurrentSettler().getLocation().getPortals().get(i).getPair().getID()
					.equals(jl.getSelectedValue())) {
				g.getCurrentSettler().teleport(g.getCurrentSettler().getLocation().getPortals().get(i).getPair());
				dlm.clear();
				for (int j = 0; j < g.getCurrentSettler().getLocation().getPortals().size(); j++) {
					dlm.addElement(g.getCurrentSettler().getLocation().getPortals().get(j).getPair().getID());
				}
			}
		}

	}
}
/**
 * Portál építés gomb listenre
 * */
class BuildPortalListener implements ActionListener {
	Game g;
	JTextArea j;

	public BuildPortalListener(Game game, JTextArea jt) {
		g = game;
		j = jt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.getCurrentSettler().addPortal(g.getCurrentSettler().buildPortal());
		if (g.getCurrentSettler().getPortal() == null) {
			return;
		} else {
			for (int i = 0; i < g.getCurrentSettler().getPortal().size(); i++) {
				j.append("\n" + g.getCurrentSettler().getPortal().get(i).getID());
				System.out.println(g.getCurrentSettler().getPortal().get(i).getID());
			}
		}
	}
}
/**
 * Portál lehelyezés gomb listenre
 * */
class PlacePortalListener implements ActionListener {
	Game g;
	DefaultListModel<String> dlm;
	Timing t;
	public PlacePortalListener(Game game, DefaultListModel<String> d, Timing tt) {
		g = game;
		dlm = d;
		t = tt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (g.getCurrentSettler().getPortal().size() != 0 && g.getCurrentSettler().getPortal() != null)
			g.getCurrentSettler().placePortal(t);
		if (g.getCurrentSettler().getPortal() == null) {
			return;
		} else {
			for (int i = 0; i < g.getCurrentSettler().getLocation().getPortals().size(); i++) {
				// System.out.println(g.getCurrentSettler().getLocation().getPortals().get(i).getID());

			}
			dlm.clear();
			for (int j = 0; j < g.getCurrentSettler().getLocation().getPortals().size(); j++) {
				dlm.addElement(g.getCurrentSettler().getLocation().getPortals().get(j).getPair().getID());
			}
		}
	}
}
/**
 * Robot építés gomb listenre
 * */
class BuildRobotListener implements ActionListener {
	Game g;
	static boolean tick;
	static Timing t;
	static Robot r = null;

	public BuildRobotListener(Game game, boolean tt, Timing ttt) {
		g = game;
		t = ttt;
		tick = tt;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		r = (Robot) g.getCurrentSettler().buildRobot();
		if (r != null)
		{if (tick)
			t.addSubscriber(r);
		}
		else {
			
		}

	}
}
/**
 * Portál felvétel gomb listenre gomb listenre
 * */
class PickUpPortalListener implements ActionListener {
	Game g;
	DefaultListModel<String> dlm;
	public PickUpPortalListener(Game game, DefaultListModel<String> d) {
		g = game;
		dlm = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (g.getCurrentSettler().getLocation().getPortals().size() != 0)
			g.getCurrentSettler().pickUpPortal(g.getCurrentSettler().getLocation().getPortals().get(0));
		dlm.clear();
		for (int j = 0; j < g.getCurrentSettler().getLocation().getPortals().size(); j++) {
			dlm.addElement(g.getCurrentSettler().getLocation().getPortals().get(j).getPair().getID());
		}
	}
}
/**
 * Nyersanyag visszarakás gomb listenre
 * */
class DumpListener implements ActionListener {
	Game g;
	JLabel j2;
	public DumpListener(Game game, JLabel j) {
		g = game;
		j2 = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((g.getCurrentSettler().getResources().size() != 0))
				g.getCurrentSettler().dumpMaterial(g.getCurrentSettler().getResources().get(0));
		g.getCurrentSettler().getLocation().getAv().paint(j2);
	}
}

