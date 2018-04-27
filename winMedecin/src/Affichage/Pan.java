package Affichage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Diagnostic.*;
public class Pan extends JPanel implements MouseMotionListener, MouseListener{
	BufferedImage  img;
	Graphics2D g2d;
	ArrayList <Diagnostic> dl;
	Diagnostic d ;
	Color cBC = Color.GREEN;
	Color cTA = Color.GREEN;
	int x,y;
	Color cbg = Color.white;
	public Pan()
	{
		short a = 120, b= 3;
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		Mesure m = new Mesure (a,b);
		d = new Diagnostic (m);
		dl = new ArrayList<Diagnostic>();
		dl.add(new Diagnostic (new Mesure (95,8)));
		dl.add(new Diagnostic (new Mesure (80,5)));
		dl.add(new Diagnostic (new Mesure (35,20)));
		dl.add(new Diagnostic (new Mesure (90,15)));
		img =new BufferedImage (600, 600, BufferedImage.TYPE_3BYTE_BGR);
		g2d = img.createGraphics();
	}
	protected void paintComponent(Graphics g)
	{

		g2d= (Graphics2D) g;
		g2d.setColor(cbg);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		int hh = this.getHeight()/2;
		g2d.setColor(Color.BLACK);
		g2d.drawString("Rapport Medicale", 250, 30);
		g2d.drawLine(50, hh, 350, hh);
		g2d.drawLine(50, hh, 50, (hh)-250);
		for (int i=0;i< dl.size();i++)
		{
			updateColor(dl.get(i));
			g2d.setColor(cBC);
			g2d.fillRect(60+(22*i), hh-dl.get(i).mesure.bc, 20, dl.get(i).mesure.bc);
			g2d.setColor(cTA);
			g2d.fillRect(60+(dl.size()*22)+(22*i)+5, hh-(dl.get(i).mesure.ta*5), 20, (dl.get(i).mesure.ta*5));
		}
		g2d.setColor(Color.BLACK);
		g2d.drawString("Batement".toString(), 60, hh+20);
		g2d.drawString("de Coeur".toString(), 60, hh+35);
		g2d.drawString("Tension".toString(), 60+(dl.size()*22), hh+20);
		g2d.drawString("Arterielle".toString(),60+(dl.size()*22), hh+35);
		g2d.drawOval(x-20, y-20, 40, 40);
		g2d.drawString(x+", "+y, 20, 20);

	}
	private void creatImg(Graphics2D g2d)
	{
		g2d = img.createGraphics();
	}
	private void save (BufferedImage  img) throws IOException
	{
		File outputfile = new File("monImage.png");
		ImageIO.write(img, "PNG", outputfile);
	}
	private void updateColor(Diagnostic d)
	{
		switch (d.etatBC)
		{
		case Bas : cBC = Color.BLUE;break;
		case Eleve : cBC = Color.RED;break;
		}
		switch (d.etatTA)
		{
		case Bas : cTA = Color.BLUE;break;
		case Eleve : cTA = Color.RED;break;
		}
	}
	@Override
	public void mouseDragged(MouseEvent ev) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void mouseMoved(MouseEvent ev) {
		// TODO Auto-generated method stub
		x = ev.getX();
		y = ev.getY();
		this.repaint();
	}
	@Override
	public void mouseClicked(MouseEvent ev) {
		// TODO Auto-generated method stub
	
		try {
			save (img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
