package Affichage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class winMed extends JFrame {
	
	winMed ()
	{
		this.setSize(600, 600);
		this.setResizable(true);
		this.setTitle("winMedecin");
		Pan p = new Pan();
		this.setContentPane(p);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		winMed wm = new winMed ();
	}
}
