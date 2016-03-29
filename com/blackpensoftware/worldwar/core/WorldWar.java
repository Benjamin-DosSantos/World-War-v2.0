package com.blackpensoftware.worldwar.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.blackpensoftware.worldwar.generators.MapGenerator;
import com.blackpensoftware.worldwar.handlers.SelectionHandler;

public class WorldWar {
	static String mainFrame_title = "World War v2.0";
	static JFrame mainFrame= new JFrame(mainFrame_title);
	
	static WorldPanel worldPanel = new WorldPanel();
	static MenuPanel menuPanel = new MenuPanel();
	public static MapGenerator mapGen = new MapGenerator();
	static SelectionHandler selection = new SelectionHandler();
	
	public static void main(String args[]){
		mapGen.genMap();
		setupStartMenu();
	}// End of main Method
	
	public static void setupGameFrame(){
		mainFrame.add(worldPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBackground(Color.GRAY);
		mainFrame.setVisible(true);
		mainFrame.setSize(getScreenDimension());
		mainFrame.setLocation(0, 0);
		worldPanel.addMouseListener(selection);
	}// End of setupPanel
	
	public static void setupStartMenu(){
		mainFrame.add(menuPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBackground(Color.GRAY);
		mainFrame.setVisible(true);
		mainFrame.setSize(getScreenSmaller());
		mainFrame.setLocation(getScreenWidth() / 4, getScreenHeight() / 4);
	}// End of setupStartMenu Method
	
	public static Dimension getScreenDimension(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize;
	}// End of getScreenDimension
	
	public static Dimension getScreenSmaller(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		
		Dimension smallScreen = new Dimension(screenWidth / 2, screenHeight / 2);
		
		return smallScreen;
	}// End of getScreenDimension
	
	public static int getScreenWidth(){
		return getScreenDimension().width;
	}// End of get Screen Width
	
	public static int getScreenHeight(){
		return getScreenDimension().height;
	}// End of get Screen Width
}// End of class
