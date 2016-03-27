package com.blackpensoftware.worldwar.core;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.blackpensoftware.worldwar.generators.MapGenerator;
import com.blackpensoftware.worldwar.primitives.Hexagon;

public class WorldPanel extends JPanel{
	Hexagon hex = new Hexagon();
	public static MapGenerator mapGen = new MapGenerator(); 
	
	@Override
	public void paint(Graphics g){
		mapGen.drawMap(g, -(hex.getHexWidth() / 2), -(hex.getHexHeight() / 2));
		try {
			Thread.sleep(1);
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// End of paint method 
}// End of class
