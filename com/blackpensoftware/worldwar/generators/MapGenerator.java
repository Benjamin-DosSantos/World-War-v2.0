package com.blackpensoftware.worldwar.generators;

import java.awt.Graphics;
import java.util.Random;

import com.blackpensoftware.worldwar.core.WorldWar;
import com.blackpensoftware.worldwar.primitives.Hexagon;

public class MapGenerator {
	Hexagon hex = new Hexagon();
	
	int mapWidth = WorldWar.getScreenWidth() / hex.getHexWidth();
	int mapHeight = WorldWar.getScreenHeight() / hex.getHexHeight();
	
	Hexagon map[][] = new Hexagon[mapWidth][mapHeight];
	
	public void genMap(){
		for(int c = 0; c < map.length; c++){
			for(int r = 0; r < map[c].length; r++){
				int type = selectType();
				map[c][r] = new Hexagon();
				map[c][r].setType(type);
			}// End of for the number of items
		}// End of for the number of arrays
	}// End of genMap method

	
	public void drawMap(Graphics g, int xPos, int yPos){
		boolean shift = false;
		for(int rows = 0; rows < mapHeight; rows++){
			drawHexRow(g, xPos, yPos);
			yPos += hex.getHexHeight();
		}// End of for arrays
	}// End of drawMap method
	
	public void drawHexRow(Graphics g, int xPos, int yPos){
		boolean drop = false;
		for(int i = 0; i < mapWidth; i++){
			hex.drawHexagon(g, xPos, yPos);
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
	
	public int selectType(){
		Random ran = new Random();
		return ran.nextInt(3);
	}// End of selectType
}// End of class
