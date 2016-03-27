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
			//sandPass(map);
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
		for(int c = 0; c < map.length; c++){
			for(int r = 0; r < map[c].length; r++){
				int cell[] = new int[6];	// The six surrounding hexagons around the current hexagon
				
				if((c - 1) != -1){
					cell[0] = hexMap[c - 1][r].getType();	// Above
					
					if((r - 1) != -1){
						cell[2] = hexMap[c - 1][r - 1].getType();	// Left top
					}// end of if row - 1 is not smaller then the map
					
					if((r + 1) < mapWidth){
						cell[5] = hexMap[c - 1][r + 1].getType();	// Left bottom 
					}// end of if row + 1 is not bigger then the map
				}// End of if col - 1 is not smaller then 0
				
				if((c + 1) < mapHeight){
					cell[1] = hexMap[c + 1][r].getType();	// Below
					
					if((r - 1) != -1){
						cell[3] = hexMap[c + 1][r - 1].getType();	// Right top
					}// end of if row - 1 is not smaller then the map
					
					if((r + 1) < mapWidth){
						cell[4] = hexMap[c + 1][r + 1].getType();	// right bottom
					}// end of if row + 1 is not bigger then the map
				}// end of if col + 1 is not null
				int typeSelection = ran.nextInt(cell.length);
				
				if(cell[typeSelection] >= 0){
					map[c][r].setType(cell[typeSelection]);
				}else{
					map[c][r].setType(0);
				}
			}// End of For rows in a column
		}// End of for columns in the map
	}// End of cleanPass
	
	public Hexagon[][] getMap() {
		return map;
	}// end of getMap

	public void setMap(Hexagon[][] map) {
		this.map = map;
	}// End of setMap
}// End of class
