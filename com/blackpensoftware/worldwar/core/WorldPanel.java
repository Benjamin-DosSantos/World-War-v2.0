package com.blackpensoftware.worldwar.core;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.blackpensoftware.worldwar.generators.MapGenerator;
import com.blackpensoftware.worldwar.primitives.Hexagon;

public class WorldPanel extends JPanel{
	Hexagon hex = new Hexagon();
	MapGenerator mapGen = new MapGenerator(); 
	
	@Override
	public void paint(Graphics g){
		mapGen.drawMap(g, 0, 0);
	}// End of paint method 
}// End of class
