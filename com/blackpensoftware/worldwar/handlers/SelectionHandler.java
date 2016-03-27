package com.blackpensoftware.worldwar.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.blackpensoftware.worldwar.generators.MapGenerator;
import com.blackpensoftware.worldwar.primitives.Hexagon;

public class SelectionHandler implements MouseListener, MouseWheelListener{

	Hexagon hex = new Hexagon();
	MapGenerator mapGen = new MapGenerator();
	
	@Override
	public void mouseClicked(MouseEvent event) {
		Hexagon[][] liveMap = mapGen.getMap();
		
		int hexXValue = (int) Math.floor(event.getX() / hex.getHexWidth());    
		int hexYValue = (int) Math.floor(event.getY() / hex.getHexHeight());
		
		System.out.println(hexXValue + ", " + hexYValue);
		
		liveMap[hexYValue][hexXValue].activate();
	}
 
	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		
	}
}// End of class