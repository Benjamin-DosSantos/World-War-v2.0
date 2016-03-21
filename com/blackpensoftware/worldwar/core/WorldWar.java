package com.blackpensoftware.worldwar.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.blackpensoftware.worldwar.generators.MapGenerator;

public class WorldWar {
	static String mainFrame_title = "World War v2.0";
	static JFrame mainFrame= new JFrame(mainFrame_title);
	
	static WorldPanel worldPanel = new WorldPanel();
	static MapGenerator mapGen = new MapGenerator();
	
	public static void main(String args[]){
		mapGen.genMap();
		setupFrame();
	}// End of main Method
	
	public static void setupFrame(){
		mainFrame.add(worldPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBackground(Color.GRAY);
		mainFrame.setVisible(true);
		mainFrame.setSize(getScreenDimension());
	}// End of setupPanel
	
	public static Dimension getScreenDimension(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize;
	}// End of getScreenDimension
	
	public static int getScreenWidth(){
		return getScreenDimension().width;
	}// End of get Screen Width
	
	public static int getScreenHeight(){
		return getScreenDimension().height;
	}// End of get Screen Width
}// End of class
