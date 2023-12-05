package com.finalproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;

public class Main {
    int playerHP;
    int monsterHP;
    int roomCheck;
    int battleCheck1 = 0;
    int battleCheck2 = 0;
    int battleCheck3 = 0;
    int battleCheck4 = 0;
    int battleCheck5 = 0;
    int boss = 0;
    int masterSword = 1;

    String ability;
    String position;

    ImageIcon dungeonLeft = new ImageIcon("dungeonLeft.png");
    ImageIcon dungeonMid = new ImageIcon("dungeonMid.png");
    ImageIcon dungeonRight = new ImageIcon("dungeonRight.png");

    Window window = new Window();

    TitleHandler tHandler = new TitleHandler();
    InputHandler iHandler = new InputHandler();

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        window.createWindow(tHandler);
    }

    public class TitleHandler implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                window.createGameScreen(iHandler);
                playerSetup();
            } else;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
     

    }

    public class InputHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
           
            String yourInput = e.getActionCommand();

            switch (position) {
                case "startingArea":
                    switch (yourInput) {
                        case "up": c2(); break;
                    }
                    break;
                case "c2":
                    switch (yourInput) {
                        case "up": b2(); break;
                        case "down": startingArea(); break;
                        case "left": c1(); break;
                        case "right": c3(); break;
                    }
                    break;
                case "c1":
                    switch (yourInput) {
                        case "up": b1(); break;
                        case "right": c2(); break; 
                    }
                    break;
                case "c3":
                    switch (yourInput) {
                        case "up": b3(); break;
                        case "left": c2(); break;
                    }
                    break;
                case "b1":
                    switch (yourInput) {
                        case "up": a1(); break;
                        case "down": c1(); break;
                        case "right": b2(); break;
                    }
                    break;
                case "b2":
                    switch (yourInput) {
                        case "up": a2(); break;
                        case "down": c2(); break;
                        case "left": b1(); break;
                        case "right": b3(); break;
                    }
                    break;
                case "b3":
                    switch (yourInput) {
                        case "up": a3(); break;
                        case "down": c3(); break;
                        case "left": b2(); break;
                    }
                    break;
                case "a1":
                    switch (yourInput) {
                        case "down": b3(); break;
                        case "right": a2(); break;
                    }
                    break;
                case "a2":
                    switch (yourInput) {
                        case "up": preBoss(); break;
                        case "down": b2(); break;
                        case "left": a1(); break;
                        case "right": a3(); break;
                    }
                    break;
                case "a3":
                    switch (yourInput) {
                        case "down" : b3(); break;
                        case "left": a2(); break;
                    }
                    break;
                case "preBoss":
                    switch (yourInput) {
                        case "up": bossRoom(); break;
                        case "down": a2(); break;
                    }
                    break;
                case "combat":
                    switch (yourInput) {
                        case "action": playerAttack(); break;
                    }
                    break;
                case "playerAttack":
                    switch (yourInput) {
                        case "action": monsterAttack(); break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourInput) {
                        case "action": playerAttack(); break;
                    }
                    break;
                case "win":
                    switch (yourInput) {
                        case "action": if (boss == 0) {
                            window.actionButton.setVisible(false); 
                            roomCheck();
                        } else {
                            window.actionButton.setVisible(false);
                            endScreen();
                        } break;
                    }
                    break;
            }
        }
        
    }

    // Initalizing Game
    public void playerSetup(){
        playerHP = 15;
        monsterHP = 10;
        ability = "Normal";
        window.abilityNameLabel.setText(ability);
        window.hpNumLabel.setText(Integer.toString(playerHP));

        startingArea();
    }

    public void startingArea(){
        position = "startingArea";
        window.mainTextArea.setText("You are in Green Greens.");
    }

    // Creating Rooms
    public void c1(){
        position = "c1";
        roomCheck = 1;
        window.mainTextArea.setText("C1");
        window.dungeonLeftLabel.setVisible(true);

    if (battleCheck1 == 0) {
            battleCheck1 = 1;
            battle();
            
        } else if (battleCheck1 == 1); {}
    
    }

    public void c2(){
        position = "c2";
        window.mainTextArea.setText("C2");
    }

    public void c3(){
        position = "c3";
        roomCheck = 2;
        window.mainTextArea.setText("C3");
          
        if (battleCheck2 == 0) {
            battleCheck2 = 1;
            battle();
            
        } else if (battleCheck2 == 1); {}
    }

    public void b1(){
        position = "b1";
        window.mainTextArea.setText("B1");
    }

    public void b2(){
        position = "b2";
        roomCheck = 3;
        window.mainTextArea.setText("B2");
        
        if (battleCheck3 == 0) {
            battleCheck3 = 1;
            battle();
            
        } else if (battleCheck3 == 1); {}
    }

    public void b3(){
        position = "b3";
        window.mainTextArea.setText("B3");
    }

    public void a1(){
        position = "a1";
        roomCheck = 4;
        window.mainTextArea.setText("A1");
        
        if (battleCheck4 == 0) {
            battleCheck4 = 1;
            battle();
            
        } else if (battleCheck4 == 1); {}
    }

    public void a2(){
        position = "a2";
        window.mainTextArea.setText("A2");
    }

    public void a3(){
        position = "a3";
        roomCheck = 5;
        window.mainTextArea.setText("A3");
        
        if (battleCheck5 == 0) {
            battleCheck5 = 1;
            battle();
        } else if (battleCheck5 == 1); {}
    }

    public void preBoss(){
        playerHP = 15;
        window.hpNumLabel.setText(Integer.toString(playerHP));

        position = "preBoss";
        window.mainTextArea.setText("You found the Master Sword!\nYou found a Maxim Tomato! Your health is now " + playerHP + ".");

        masterSword = 1;
        ability = "Sword";
        window.abilityNameLabel.setText(ability);
    }

    public void bossRoom() {
        boss = 1;
        position = "bossRoom";
        window.mainTextArea.setText("Boss Room");
        battle();
    }

    // Room Check for returning after battle
    public void roomCheck(){

        if (roomCheck == 1) {
            position = "c1";
            roomCheck = 0;
            c1();
        } else if (roomCheck == 3) {
            position = "b2";
            roomCheck = 0;
            b2();
        } else if (roomCheck == 4 ) {
            position = "a1";
            roomCheck = 0;
            a1();
        } else if (roomCheck == 5) {
            position = "a3";
            roomCheck = 0;
            a3();
        } else if (roomCheck == 2) {
            position = "c3";
            roomCheck = 0;
            c3();
        }
    }

    // Battle System
    public void battle(){
        position = "combat";
        window.actionButton.setVisible(true);
        
        if (boss == 0) {
            window.mainTextArea.setText("You encountered a Waddle Dee!\n\nCurrent Health: " + monsterHP);
        } else {
            monsterHP = 35;
            window.mainTextArea.setText("You encountered Meta Knight!\n\nCurrent Health: " + monsterHP);
        }
    }

    public void playerAttack(){
        position = "playerAttack";
        int playerDamage = 0;
      
        if (ability == "Normal") {
        playerDamage = new Random().nextInt(6);
        } else if (ability == "Sword") {
        playerDamage = new Random().nextInt(11);
        }

        monsterHP = monsterHP - playerDamage;

        if (boss == 0) {
            window.mainTextArea.setText("You attacked the Waddle Dee\n and dealt " + playerDamage + " damage!\n\nCurrent Health: " + monsterHP);
        } else {
            window.mainTextArea.setText("You attacked Meta Knight\n and dealt " + playerDamage + " damage!\n\nCurrent Health: " + monsterHP); 
        }

        if (monsterHP <= 0) {
            monsterHP = 0;
            win();
            
        } else if (playerHP <= 0) {
            playerHP = 0;
            lose();

        }
    }

    public void monsterAttack(){
        position = "monsterAttack";
        
        int monsterDamage = 0;

        if (boss == 0) {

            monsterDamage = new Random().nextInt(3);

            playerHP = playerHP - monsterDamage;
        
            window.mainTextArea.setText("The Waddle Dee attacked you and\nyou received " + monsterDamage + " damage!\n\nCurrent Health: " + monsterHP);

            window.hpNumLabel.setText(Integer.toString(playerHP));
        } else if (boss == 1) {

            monsterDamage = new Random().nextInt(5);

            playerHP = playerHP - monsterDamage;
        
            window.mainTextArea.setText("Meta Knight attacked you and\nyou received " + monsterDamage + " damage!\n\nCurrent Health: " + monsterHP);

            window.hpNumLabel.setText(Integer.toString(playerHP));

        }
        
        if (monsterHP <= 0) {
                monsterHP = 0;    
                win();
            } else if (playerHP <= 0) {
                playerHP = 0;
                lose();
            }
    }

    public void win(){
        position = "win";
        
        if (boss == 0) {
        window.mainTextArea.setText("You defeated the Waddle Dee!");
        monsterHP = 10;
        } else {
            window.mainTextArea.setText("You defeated Meta Knight!");
        } 
       
    }

    public void lose(){
        window.actionButton.setVisible(false);
        window.mainTextArea.setText("Kirby is too tired to continue.\n\nGame over.\n\nTry again?");

    }

    // Ending Screen
    public void endScreen(){
        window.mainTextArea.setText("Congratulations! You completed the game!");
    }
}