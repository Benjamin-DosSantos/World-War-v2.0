package com.blackpensoftware.worldwar.generators;

import java.awt.Graphics;
import java.util.Random;

import com.blackpensoftware.worldwar.core.WorldWar;
import com.blackpensoftware.worldwar.primitives.Hexagon;

public class MapGenerator {
	Hexagon hex = new Hexagon();
	
	int mapWidth = WorldWar.getScreenWidth() / hex.getHexWidth();
	int mapHeight = WorldWar.getScreenHeight() / hex.getHexHeight();
	
	Hexagon map[][] = new Hexagon[mapHeight][mapWidth];
	
	Random ran = new Random();
	
	public void genMap(){
		for(int c = 0; c < map.length; c++){
			for(int r = 0; r < map[c].length; r++){
				int type = ran.nextInt(3);
				map[c][r] = new Hexagon();
				map[c][r].setType(type);
			}// End of for the number of items
		}// End of for the number of arrays
	}// End of genMap method

	public void drawMap(Graphics g, int xPos, int yPos){
		if(map[0][0] != null){
			for(int col = 0; col < mapHeight; col++){
				drawHexRow(g, xPos, yPos, col);
				yPos += hex.getHexHeight();
			}// End of for arrays
		}else{
			genMap();
			drawMap(g, yPos, yPos);
		}//End of if null value
	}// End of drawMap method
	
	public void drawHexRow(Graphics g, int xPos, int yPos, int cols){
		boolean drop = false;
		for(int row = 0; row < mapWidth; row++){
			map[cols][row].drawHexagon(g, xPos, yPos);
			xPos += hex.getHexWidth() + (hex.getHexWidth() / 2);
			if(drop){
				yPos += hex.getHexHeight() / 2;
				drop = false;
			}else{
				yPos -= hex.getHexHeight() / 2;
				drop = true;
			}
		}// End of for number of hexagons
	}// End of drawHexRow

	public Hexagon[][] getMap() {
		return map;
	}// end of getMap

	public void setMap(Hexagon[][] map) {
		this.map = map;
	}// End of setMap
}// End of class
