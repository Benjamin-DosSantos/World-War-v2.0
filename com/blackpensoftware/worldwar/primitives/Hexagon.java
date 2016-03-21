package com.blackpensoftware.worldwar.primitives;

import java.awt.Color;
import java.awt.Graphics;

import com.blackpensoftware.worldwar.handlers.ColorHandler;

public class Hexagon {
	ColorHandler colors = new ColorHandler();
	
	boolean isActive = false;
	// 0 = grass
	// 1 = water
	// 2 = sand
	int type = 1;
	
	int hex_width = 10;
	int hex_height = hex_width + (hex_width / 2);
	
	int hex_XPos[] = new int[6];
	int hex_YPos[] = new int[6];
	
	public void drawHexagon(Graphics g, int newXPos, int newYPos){
		genHexagon(newXPos, newYPos);
		
		Color hexColor = Color.BLACK;
		
		switch(type){
			case 0:
				hexColor = colors.genGreenColor();
				break;
			case 1:
				hexColor = colors.genBlueColor();
				break;
			case 2: 
				hexColor = colors.genYellowColor();
				break;
		}// End of switch for type

		g.setColor(hexColor);
		g.fillPolygon(hex_XPos, hex_YPos, hex_XPos.length);
	}// End of drawHexagon
	
	public void genHexagon(int xPos, int yPos){
		hex_XPos[0] = (hex_width / 2) + xPos;
		hex_YPos[0] = 0 + yPos;
		
		hex_XPos[1] = (hex_width / 2) + hex_width  + xPos;
		hex_YPos[1] = 0 + yPos;
		
		hex_XPos[2] = (hex_width * 2) + xPos;
		hex_YPos[2] = (hex_height / 2) + yPos;
		
		hex_XPos[3] = (hex_width / 2) + hex_width + xPos;
		hex_YPos[3] = hex_height + yPos;
		
		hex_XPos[4] = (hex_width / 2) + xPos;
		hex_YPos[4] = hex_height + yPos;
		
		hex_XPos[5] = 0 + xPos;
		hex_YPos[5] = (hex_height / 2) + yPos;
	}// End of genHexagon
	
	public boolean isActive(){
		return isActive;
	}// End of class
	
	public void activate(){
		isActive = true;
	}// End of activate
	
	public void deactivate(){
		isActive = false;
	}// End of deactivate
	
	public int getType(){
		return type;
	}// End of getType
	
	public void setType(int newType){
		type = newType;
	}// End of setType
	
	public void setHexSize(int newSize){
		hex_width = newSize;
		hex_height = hex_width + (hex_width / 2);
	}// End of setHexSize
	
	public void setHexWidth(int newWidth){
		hex_width = newWidth;
	}// End of setHexWidth
	
	public int getHexWidth(){
		return hex_width;
	}// End of getHexWidth
	
	public void setHexHeight(int newHeight){
		hex_height = newHeight;
	}// End of setHexWidth
	
	public int getHexHeight(){
		return hex_height;
	}// End of getHexWidth
}// End of class
