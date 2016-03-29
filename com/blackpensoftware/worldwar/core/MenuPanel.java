package com.blackpensoftware.worldwar.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel implements ActionListener{
	String mainLabel_text = "World War II - Alpha";
	JLabel mainLabel = new JLabel(mainLabel_text, SwingConstants.CENTER);
	
	JButton startButton = new JButton("Start");
	JButton optionsButton = new JButton("Options");
	JButton exitButton = new JButton("Exit");
	
	Color bgColor = new Color(70, 70, 70);
	Color labelColor = new Color(20, 255, 20);
	
	Color startButtonFontColor = Color.GREEN;
	Color optionsButtonFontColor = Color.BLUE;
	Color exitButtonFontColor = Color.RED;
	
	int buttonWidth = WorldWar.getScreenSmaller().width / 2;
	int buttonHeight = WorldWar.getScreenSmaller().height / 8;
	int buttonXPos = WorldWar.getScreenSmaller().width / 4;
	int buttonYPos = WorldWar.getScreenSmaller().height / 3;
	int bufferSpace = 100;
	
	int labelWidth = WorldWar.getScreenSmaller().width / 2;
	int labelHeight = WorldWar.getScreenSmaller().height / 8;
	int labelXPos = WorldWar.getScreenSmaller().width / 4;
	int labelYPos = 50;
	
	Font buttonFont = new Font("Verdana",1,20);
	
	public MenuPanel(){
		formatComponents();
		addAllComponents();
	}// End of constructor
	 
	public void addAllComponents(){
		this.setLayout(null);
		this.add(mainLabel);
		this.add(startButton);
		this.add(optionsButton);
		this.add(exitButton);
	}// end of addAllComponents method
	
	public void formatComponents(){
		this.setBackground(bgColor);
		
		mainLabel.setSize(labelWidth, labelHeight);
		mainLabel.setLocation(labelXPos, labelYPos);
		mainLabel.setVisible(true);
		mainLabel.setForeground(labelColor);
		mainLabel.setFont(new Font("Verdana",1,20));
		
		startButton.setSize(buttonWidth, buttonHeight);
		startButton.setLocation(buttonXPos, buttonYPos);
		startButton.setVisible(true);
		startButton.addActionListener(this);
		startButton.setForeground(startButtonFontColor);
		startButton.setFont(buttonFont);
		
		buttonYPos += bufferSpace;
		
		optionsButton.setSize(buttonWidth, buttonHeight);
		optionsButton.setLocation(buttonXPos, buttonYPos);
		optionsButton.setVisible(true);
		optionsButton.addActionListener(this);
		optionsButton.setForeground(optionsButtonFontColor);
		optionsButton.setFont(buttonFont);
		
		buttonYPos += bufferSpace;
		
		exitButton.setSize(buttonWidth, buttonHeight);
		exitButton.setLocation(buttonXPos, buttonYPos);
		exitButton.setVisible(true);
		exitButton.addActionListener(this);
		exitButton.setForeground(exitButtonFontColor);
		exitButton.setFont(buttonFont);
	}
	
	 public void actionPerformed(ActionEvent evt) {
		 Object src = evt.getSource();
		 
		 if (src == startButton) {
			 this.setVisible(false);
			 WorldWar.setupGameFrame();
		 }else if(src == optionsButton){
			 this.setVisible(false);
			 //WorldWar.setupOptionPanel();
		 }else{
			 System.exit(0);
		 }
	 }
}// End of class
