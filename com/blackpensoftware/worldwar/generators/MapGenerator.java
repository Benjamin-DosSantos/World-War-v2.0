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
	
	boolean hasHadCleanPass = false;
	
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
		if(map[0][0] != null || hasHadCleanPass != false){
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

	public Hexagon[][] cleanPass(Hexagon[][] oldMap){
		Hexagon[][] newMap = new Hexagon[mapHeight][mapWidth];
		
		newMap = oldMap.clone();
		for(int col = 0; col < newMap.length; col++){
			for(int row = 0; row < newMap[col].length; row++){
				Hexagon[] currentCell = new Hexagon[8];
				populateCell(col, row, oldMap, currentCell);
				boolean containsWater = checkWater(currentCell);
				if(newMap[col][row].getType() == 0 && containsWater == true){
					newMap[col][row].setType(1);
				}// End of class
			}// End of for rows
		}// End of for cols
		
		return newMap;
	}// End of cleanPass method
	
	private boolean checkWater(Hexagon[] currentCell) {
		boolean hasWater = false;
		int waterFound = 0;
		for(int i = 0; i < currentCell.length; i++){
			if(currentCell[i].getType() == 1 && waterFound >= 2){
				return true;
			}else{
				waterFound++;
			}
		}
		return hasWater;
	}

	public void populateCell(int col, int row, Hexagon[][] map, Hexagon[] cellSelection){
		if((col - 1) >= 0){
			cellSelection[0] = map[col - 1][row - 1];
			cellSelection[1] = map[col - 1][row];
			cellSelection[2] = map[col - 1][row + 1];
		}
		
		if((row + 1) <= mapWidth){
			cellSelection[3] = map[col][row + 1];
		}
		
		if((col + 1) >= mapWidth){
			cellSelection[4] = map[col + 1][row + 1];
			cellSelection[5] = map[col + 1][row];
			cellSelection[6] = map[col + 1][row - 1];
			
		}
		
		if((row - 1) >= 0){
			cellSelection[7] = map[col][row - 1];
		}
	}// End of populateCell method
	
	public Hexagon[][] getMap() {
		return map;
	}// end of getMap

	public void setMap(Hexagon[][] map) {
		this.map = map;
	}// End of setMap
}// End of class
