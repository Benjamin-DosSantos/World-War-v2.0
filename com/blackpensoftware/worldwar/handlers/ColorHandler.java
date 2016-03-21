package com.blackpensoftware.worldwar.handlers;

import java.awt.Color;
import java.util.Random;
import java.util.Random;

public class ColorHandler {
	Random ran = new Random();
	
	public Color genBlueColor(){
		int red = 0;
		int green = 0;
		int blue = ran.nextInt(56) + 200;
		
		return new Color(red, green, blue);
	}// End of genBlueColor
		
	public Color genGreenColor(){
		int red = 0;
		int green = ran.nextInt(56) + 200;
		int blue = 0;
		
		return new Color(red, green, blue);
	}// End of genBlueColor

	public Color genYellowColor(){
		int red = ran.nextInt(56) + 200;
		int green = ran.nextInt(56) + 200;
		int blue = 0;
		
		return new Color(red, green, blue);
	}// End of genBlueColor
}// End of class
