package Grafika;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Game;

public class Menu extends JFrame  implements  ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel titlePanel;
private JPanel buttonPanel;
public JFrame frame;
private JButton bstart;
private JButton bexit;
private JLabel lname;
static Game game;

Container con;
Font c = new Font("Courier New", Font.PLAIN, 90);
Font d = new Font("Courier New", Font.PLAIN, 40);


public Menu(Game g) throws IOException{
	frame = new JFrame();
	frame.setSize(1280, 756);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.getContentPane().setBackground(Color.black);
	frame.setLayout(null);
	frame.setResizable(false);
	con = frame.getContentPane();
	ImageIcon img = new ImageIcon("src/images/logo2.png");
	frame.setIconImage(img.getImage());
	
	game = g;
	
	titlePanel = new JPanel();
	titlePanel.setBounds(300,100,600,150);
	titlePanel.setBackground(Color.black);
	
	lname = new JLabel("JUSTEROID");
	lname.setName("JUSTEROID");
	lname.setForeground(Color.WHITE);
	lname.setBackground(Color.black);
	lname.setFont(c);
	
	buttonPanel = new JPanel();
	buttonPanel.setBounds(500,400,200,100);
	buttonPanel.setBackground(Color.black);
	//buttonPanel.setBorder(BorderFactory.createEmptyBorder());
	
	bstart = new JButton("START");
	bstart.setBackground(Color.black);
	bstart.setForeground(Color.white);
	bstart.setFont(d);
	bstart.setBorder(BorderFactory.createEmptyBorder());
	bexit = new JButton("EXIT");
	bexit.setBackground(Color.black);
	bexit.setForeground(Color.white);
	bexit.setFont(d);
	bexit.setBorder(BorderFactory.createEmptyBorder());
	bstart.addActionListener(this);
	bexit.addActionListener(new CloseListener());
	titlePanel.add(lname);
	buttonPanel.add(bstart);
	buttonPanel.add(bexit);
	
	con.add(titlePanel);
	con.add(buttonPanel);
	con.add(buttonPanel);

	//kep hozzadasas 1
	JPanel jp1 = new JPanel();
	jp1.setBounds(750,200,400,400);
		
	JLabel jl1 = new JLabel();
	jl1.setBackground(Color.black);
	jp1.setBackground(Color.black);
	jl1.setIcon(new ImageIcon("src/images/settler.png"));
	jp1.add(jl1);
	con.add(jp1);
	
	
	
	
	//kep hozzadasas 2
	JPanel jp2 = new JPanel();
	jp2.setBounds(100,200,400,400);
			
	JLabel jl2 = new JLabel();
	jl2.setBackground(Color.black);
	jp2.setBackground(Color.black);
	jl2.setIcon(new ImageIcon("src/images/robot.png"));
		
	jp2.add(jl2);
	con.add(jp2);
	
	//kep hozzadasas 3
		JPanel jp3 = new JPanel();
		jp3.setBounds(1093,580,200,200);
			
		JLabel jl3 = new JLabel();
		jl3.setBackground(Color.black);
		jp3.setBackground(Color.black);
		jl3.setIcon(new ImageIcon("src/images/logo.png"));
		
		jp3.add(jl3);
		con.add(jp3);
	
	//revalidate
	con.revalidate();
	con.revalidate();
    
   


}

public void Start() {
	
}

@Override
public void actionPerformed(ActionEvent e) {
	try {
		new Window(game);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	frame.dispose();
	
}

}

class CloseListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //DO SOMETHING
        System.exit(0);
    }
}




