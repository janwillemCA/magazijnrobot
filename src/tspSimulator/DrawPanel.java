package tspSimulator;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SingleSelectionModel;

/**
 * Authors: Jan Willem en Henri 
 * Class: ICTM2A
 */

public class DrawPanel extends JPanel {

	DrawPanel d1;
	DrawPanel d2;
	DrawPanel d3;
	
	public DrawPanel() {
		this.setPreferredSize(new Dimension(700, 150));
//		d1 = new DrawPanel();
//		d2 = new DrawPanel();
//		d3 = new DrawPanel();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

}
	