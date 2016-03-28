package com.blackpensoftware.worldwar.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener{
	String mainLabel_text = "This is a main Label";
	JLabel mainLabel = new JLabel(mainLabel_text);
	JButton startButton = new JButton("Start");
	
	Color bgColor = new Color(70, 70, 70);
	Color labelColor = new Color(20, 255, 20);
	
	public MenuPanel(){
		formatComponents();
		addAllComponents();
	}// End of constructor
	 
	public void addAllComponents(){
		this.setLayout(null);
		this.add(mainLabel);
		this.add(startButton);
	}// end of addAllComponents method
	
	public void formatComponents(){
		this.setBackground(bgColor);
		
		mainLabel.setSize(400, 400);
		mainLabel.setVisible(true);
		mainLabel.setForeground(labelColor);
		mainLabel.setFont(new Font("Verdana",1,20));
		
		startButton.setSize(400, 400);
		startButton.setLocation(200, 200);
		startButton.setVisible(true);
		startButton.addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent evt) {
		 Object src = evt.getSource();
		 if (src == startButton) {
			 this.setVisible(false);
			 WorldWar.setupGameFrame();
		 }
	 }
}// End of class
