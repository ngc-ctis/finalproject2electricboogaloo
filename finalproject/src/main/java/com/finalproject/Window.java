package com.finalproject;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import com.finalproject.Main.InputHandler;
import com.finalproject.Main.TitleHandler;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Window {
    // Class Attributes
    JFrame window;

    JPanel titleNamePanel;
    JPanel startButtonPanel;
    JPanel mainViewPanel;
    JPanel mainTextPanel;
    JPanel mainInfoPanel;
    JPanel directionButtonsPanel;
    
    JLabel titlenameLabel;
    JLabel startButtonLabel;
    JLabel hpLabel;
    JLabel hpNumLabel;
    JLabel abilityLabel;
    JLabel abilityNameLabel;
    JLabel dungeonLeftLabel;
    JLabel dungeonMidLabel;
    JLabel dungeonRightLabel;
    
    JButton upButton;
    JButton downButton;
    JButton leftButton;
    JButton righButton;
    JButton actionButton;
    
    JTextArea mainTextArea;

    ImageIcon dungeonLeft = new ImageIcon("/dungeonLeft.png");
    ImageIcon dungeonMid = new ImageIcon("/dungeonMid.png");
    ImageIcon dungeonRight = new ImageIcon("/dungeonRight.png");

    Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 60);
    Font normalFont = new Font("Comic Sans MS", Font.PLAIN, 30);

    // Creating Window
    public void createWindow(TitleHandler tHandler){
        window = new JFrame();
        window.setSize(1200,950);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
      
        window.addKeyListener(tHandler);
        window.getContentPane();

        // Creating Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(250, 250, 650, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titlenameLabel = new JLabel("CTIS Final Project");
        titlenameLabel.setFont(titleFont);
        titlenameLabel.setForeground(Color.WHITE);
        titleNamePanel.add(titlenameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(475,550,200,100);
        startButtonPanel.setBackground(Color.BLACK);
        startButtonLabel = new JLabel("Press Enter");
        startButtonLabel.setForeground(Color.WHITE);
        startButtonLabel.setFont(normalFont);
    
        startButtonPanel.add(startButtonLabel);
    
        window.add(titleNamePanel);
        window.add(startButtonPanel);
    }

    // Creating Game Screen
    public void createGameScreen(InputHandler iHandler){

        
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // Visual View
        mainViewPanel = new JPanel();
        
        dungeonLeftLabel = new JLabel(dungeonLeft);
        dungeonMidLabel = new JLabel(dungeonMid);
        dungeonRightLabel = new JLabel(dungeonRight);

        mainViewPanel.setBounds(50,50, 700, 500);
        mainViewPanel.setBackground(Color.BLACK);
        mainViewPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        window.add(mainViewPanel);

        // Information View
        mainInfoPanel = new JPanel();
        mainInfoPanel.setBounds(800, 250, 350, 300);
        mainInfoPanel.setBackground(Color.BLACK);
        mainInfoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        mainInfoPanel.setLayout(new GridLayout(2,1));

        hpLabel = new JLabel("  HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        
        hpNumLabel = new JLabel();
        hpNumLabel.setFont(normalFont);
        hpNumLabel.setForeground(Color.WHITE);

        abilityLabel = new JLabel("  Ability:");
        abilityLabel.setFont(normalFont);
        abilityLabel.setForeground(Color.WHITE);

        abilityNameLabel = new JLabel();
        abilityNameLabel.setFont(normalFont);
        abilityNameLabel.setForeground(Color.WHITE);

        mainInfoPanel.add(hpLabel);
        mainInfoPanel.add(hpNumLabel);
        mainInfoPanel.add(abilityLabel);
        mainInfoPanel.add(abilityNameLabel);
        
        window.add(mainInfoPanel);

        // D-Pad
        directionButtonsPanel = new JPanel();
        directionButtonsPanel.setBounds(800, 575, 350, 300);
        directionButtonsPanel.setBackground(Color.BLACK);
        directionButtonsPanel.setLayout(new BorderLayout());
        
        upButton = new JButton("^");
        upButton.setBackground(Color.BLACK);
        upButton.setForeground(Color.white);
        upButton.setFont(normalFont);
        upButton.addActionListener(iHandler);
        upButton.setActionCommand("up");
        directionButtonsPanel.add(upButton, BorderLayout.NORTH);
        
        downButton = new JButton("v");
        downButton.setBackground(Color.BLACK);
        downButton.setForeground(Color.white);
        downButton.setFont(normalFont);
        downButton.addActionListener(iHandler);
        downButton.setActionCommand("down");
        directionButtonsPanel.add(downButton, BorderLayout.SOUTH);

        leftButton = new JButton("<");
        leftButton.setBackground(Color.BLACK);
        leftButton.setForeground(Color.white);
        leftButton.setFont(normalFont);
        leftButton.addActionListener(iHandler);
        leftButton.setActionCommand("left");
        directionButtonsPanel.add(leftButton, BorderLayout.WEST);

        righButton = new JButton(">");
        righButton.setBackground(Color.black);
        righButton.setForeground(Color.white);
        righButton.setFont(normalFont);
        righButton.addActionListener(iHandler);
        righButton.setActionCommand("right");
        directionButtonsPanel.add(righButton, BorderLayout.EAST);

        actionButton = new JButton("O");
        actionButton.setBackground(Color.BLACK);
        actionButton.setForeground(Color.white);
        actionButton.setFont(normalFont);
        actionButton.addActionListener(iHandler);
        directionButtonsPanel.add(actionButton, BorderLayout.CENTER);
        actionButton.setActionCommand("action");
        actionButton.setVisible(false);

        window.add(directionButtonsPanel);

        // Informational Text Area
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50, 575, 700, 300);
        mainTextPanel.setBackground(Color.BLACK);
        
        mainTextArea = new JTextArea("Test");
        mainTextArea.setBounds(50, 300, 700, 300);
        mainTextArea.setEnabled(false);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
    
        mainTextPanel.add(mainTextArea);
        
        
        window.add(mainTextPanel);
        
        // Fixing JPanel Drawing Glitch
        directionButtonsPanel.revalidate();
        directionButtonsPanel.repaint();
        mainTextPanel.revalidate();
        mainTextPanel.repaint();
        mainViewPanel.revalidate();
        mainViewPanel.repaint();
        mainInfoPanel.revalidate();
        mainInfoPanel.repaint();
    }
}
