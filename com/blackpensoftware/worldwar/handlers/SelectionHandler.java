package com.blackpensoftware.worldwar.handlers;

import java.awt.Color;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.blackpensoftware.worldwar.core.WorldPanel;
import com.blackpensoftware.worldwar.core.WorldWar;
import com.blackpensoftware.worldwar.generators.MapGenerator;
import com.blackpensoftware.worldwar.primitives.Hexagon;

public class SelectionHandler implements MouseListener, MouseWheelListener{

	Hexagon hex = new Hexagon();
	MapGenerator mapGen = WorldPanel.mapGen;
	Hexagon[][] map = mapGen.getMap();
	
	@Override
	public void mouseClicked(MouseEvent event) {
		Hexagon[][] liveMap = map;
		int hexXValue = (int) Math.floor(event.getX() / hex.getHexWidth());    
		int hexYValue = (int) Math.floor(event.getY() / hex.getHexHeight());

		liveMap[hexYValue][hexXValue].setHexColor(Color.magenta);
		
	}// End of mouse Clicked
 
	@Override
	public void mouseEntered(MouseEvent event) {}// End Of mouseEntered

	@Override
	public void mouseExited(MouseEvent event) {}// End Of mouseExited

	@Override
	public void mousePressed(MouseEvent event) {}// End Of mousePressed

	@Override
	public void mouseReleased(MouseEvent event) {}// End Of mouseReleased

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {}// End of mouseWheelMoved Method
}// End of class