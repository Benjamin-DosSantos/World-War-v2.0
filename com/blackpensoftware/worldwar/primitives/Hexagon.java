package com.blackpensoftware.worldwar.primitives;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.blackpensoftware.worldwar.handlers.ColorHandler;

public class Hexagon {
	ColorHandler colors = new ColorHandler();
	
	boolean isActive = false;
	
	// 0 = grass
	// 1 = water
	// 2 = sand
	int type = 0;
	
	int zLevel = 0;	// the offset of color to show a difference in height
	int zOffset = 15;
	int zMin = 70;
	int zMax = 225;
	
	Color hexColor;
	
	int hex_width = 10;
	int hex_height = hex_width + (hex_width / 2);
	
	int hex_XPos[] = new int[6];
	int hex_YPos[] = new int[6];
	
	public void drawHexagon(Graphics g, int newXPos, int newYPos){
		genHexagon(newXPos, newYPos);
		
		if(hexColor == null){
			switch(type){
			case 0:
				hexColor = colors.genGreenColor(this, zLevel);
				break;
			case 1:
				hexColor = colors.genBlueColor(this, zLevel);
				break;
			case 2: 
				hexColor = colors.genYellowColor(this, zLevel);
				break;
			}// End of switch for type
		}// Check if a hex color has been assigned
		
		g.setColor(hexColor);
		g.fillPolygon(hex_XPos, hex_YPos, hex_XPos.length);
		
		if(isActive){
			g.setColor(Color.MAGENTA);
		}else{
			g.setColor(Color.BLACK);
		}// End of if hex is active
		
		g.drawPolygon(hex_XPos, hex_YPos, hex_XPos.length);
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
		this.type = newType;

	}// End of setType
	
	public void setHexSize(int newSize){
		this.hex_width = newSize;
		this.hex_height = hex_width + (hex_width / 2);
	}// End of setHexSize
	
	public void setHexWidth(int newWidth){
		this.hex_width = newWidth;
	}// End of setHexWidth
	
	public int getHexWidth(){
		return hex_width;
	}// End of getHexWidth
	
	public void setHexHeight(int newHeight){
		this.hex_height = newHeight;
	}// End of setHexWidth
	
	public int getHexHeight(){
		return hex_height;
	}// End of getHexWidth

	public Color getHexColor() {
		return hexColor;
	}// End of getHexColor

	public void setHexColor(Color hexColor) {
		this.hexColor = hexColor;
	}// End of setHexColor

	public int getzLevel() {
		return zLevel;
	}// End of getzLevel

	public void setzLevel(int zLevel) {
		this.zLevel = zLevel;
	}// End of setzLevel

	public int getzOffset() {
		return zOffset;
	}// End of getzOffset

	public void setzOffset(int zOffset) {
		this.zOffset = zOffset;
	}// End of setzOffset

	public int getzMin() {
		return zMin;
	}

	public void setzMin(int zMin) {
		this.zMin = zMin;
	}

	public int getzMax() {
		return zMax;
	}

	public void setzMax(int zMax) {
		this.zMax = zMax;
	}
}// End of class
