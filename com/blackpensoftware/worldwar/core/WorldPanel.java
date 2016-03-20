package com.blackpensoftware.worldwar.core;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WorldPanel extends JPanel{
	@Override
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 100, 100);
	}// End of paint method 
}// End of class
