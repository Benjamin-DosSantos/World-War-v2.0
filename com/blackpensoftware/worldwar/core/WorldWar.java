package com.blackpensoftware.worldwar.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WorldWar {
	static String mainFrame_title = "World War v2.0";
	static JFrame mainFrame= new JFrame(mainFrame_title);
	
	static WorldPanel worldPanel = new WorldPanel();
	
	public static void main(String args[]){
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
}// End of class
