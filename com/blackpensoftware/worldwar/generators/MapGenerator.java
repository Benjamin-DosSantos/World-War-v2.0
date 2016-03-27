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
				int type = ran.nextInt(2);  //Generate only green or blue then yellow sand is added after
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
			cleanPass(map);
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
	
	public void cleanPass(Hexagon[][] hexMap){
		// if touching green and touching blue set color to yellow
		// if touching yellow and blue set to blue
		// if touching green and yellow set blue
		// if touching only ColorA set to ColorA
		// else keep same color
		
		for(int col = 0; col < hexMap.length; col++){
			for(int row = 0; row < hexMap[col].length; row++){
				int[] types = new int[6]; // Hexagons above, below, to the left and right, of center hex
				
				if((col - 1) != -1){
					types[0] = hexMap[col - 1][row].getType();	// Above
					
					if((row - 1) != -1){
						types[2] = hexMap[col - 1][row - 1].getType();	// Left top
					}
					
					if((row + 1) < mapWidth){
						types[5] = hexMap[col - 1][row + 1].getType();
					}
				}
				
				if((col + 1) < mapHeight){
					types[1] = hexMap[col + 1][row].getType();	// Below
					
					if((row - 1) != -1){
						types[3] = hexMap[col + 1][row - 1].getType();	// Right top
					}
					
					if((row + 1) < mapWidth){
						types[4] = hexMap[col + 1][row + 1].getType();
					}
				}
				
				int touchingGreen = 0;
				int touchingYellow = 0;
				int touchingBlue = 0;
				
				for(int value: types){
					switch(value){
						case 0:
							touchingGreen++;
							break;
						case 1: 
							touchingBlue++;
							break;
						case 2:
							touchingYellow++;
							break;
					}// End of color based on the value of type
				}// End of for the types
				
				if(map[col][row].getType() == 0 && touchingBlue >= 3){
					map[col][row].setType(2);
				}// End of if blue
			}// End of for individual cells
		}// End of for arrays
	}// End of cleanPass
	
	public Hexagon[][] getMap() {
		return map;
	}// end of getMap

	public void setMap(Hexagon[][] map) {
		this.map = map;
	}// End of setMap
}// End of class
