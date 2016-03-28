package com.blackpensoftware.worldwar.handlers;

import java.awt.Color;
import java.util.Random;

import com.blackpensoftware.worldwar.primitives.Hexagon;

public class ColorHandler {
	Random ran = new Random();
	
	public Color genBlueColor(Hexagon hex, int zLevel){
		int red = 0;
		int green = 0;
		int blue = ran.nextInt(56) + 200;
		
		int colors[] = {red, green, blue};
		//colors = addZLevel(hex, colors, zLevel);
		
		return new Color(colors[0], colors[1], colors[2]);
	}// End of genBlueColor
		
	public Color genGreenColor(Hexagon hex,int zLevel){
		int red = 0;
		int green = ran.nextInt(56) + 200;
		int blue = 0;
		
		int colors[] = {red, green, blue};
		//colors = addZLevel(hex, colors, zLevel);
		
		return new Color(colors[0], colors[1], colors[2]);
	}// End of genBlueColor

	public Color genYellowColor(Hexagon hex,int zLevel){
		int red = ran.nextInt(56) + 200;
		int green = ran.nextInt(56) + 200;
		int blue = 0;
		
		int colors[] = {red, green, blue};
		//colors = addZLevel(hex, colors, zLevel);
		return new Color(colors[0], colors[1], colors[2]);
	}// End of genBlueColor
	
	public int[] addZLevel(Hexagon hex, int[] colors, int zLevel){
		for(int i = 0; i < colors.length; i++){
			if((colors[i] + zLevel) <= hex.getzMax()){
				if((colors[i] + zLevel) <= hex.getzMin()){
					colors[i] = hex.getzMin();
				}else{
					colors[i] += zLevel;
				}
			}else{
				colors[i] = hex.getzMax();
			}
		}// End of for the length of colors
		return colors;
	}// End of class
}// End of class
