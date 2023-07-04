/**************************************************************************************************************
	File: SnakesAndLadder.java 
	Purpose: To use GUIs and display a version of Snakes and Ladders that is fully functional and well presented.    	
	Author: Areej Ansari 
	Date: January 24th, 2018
	Based on: ICS4U Java Assignment Final Project
**************************************************************************************************************

- I have used A to differentiate the normal set of variables from the second set. 
*/
//Import Statements 
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.io.*; 
import java.util.Scanner; 
//Main Class SnakesAndLadder Class Using JFrame and Action Listener 
public class SnakesAndLadder extends JFrame implements ActionListener
{
   //Creating JPanel
   JPanel controlPanel = new JPanel();
   JButton roll = new JButton("Roll Dice:");
   JButton movePeg = new JButton("Move"); 
   JTextField output;
   //Well named variables representing their function
   static String playerOneName;
   static String playerTwoName; 
   BoardMaker board = new BoardMaker();
   //Different set of dice for different players 
   DiceShower one; 
   DiceShower two; 
   DiceShower oneA; 
   DiceShower twoA; 
   //Everything with A is a second version for player two 
   int rollCounter = 0;
   int firstRoll = 0; 
   int secondRoll = 0;  
   int totalRoll = 1; 
   int pegMoveCount = 100; 
   int total =0; 
   int rollCounterA = 0;
   int firstRollA = 0; 
   int secondRollA = 0;  
   int totalRollA = 1; 
   int totalA =0; 
   int turnChecker = 2; 
   //Base Coordinates
   int yCoordinate = 605;
   int xCoordinate = 20;   
   //Constructor Method 
   public SnakesAndLadder()
   {
      //Naming 
      super("Snakes and Ladders");
      //Setting Default Close Operation and Bounds 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(10,10,10,10);
      //Limiting Text Field 
      output = new JTextField(30);
      output.setEditable(false); 
      roll.addActionListener(this);
      //Adding an action listener
      movePeg.addActionListener(this);  
      //Layout
      setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
      //Adding objects to screen
      controlPanel.add(roll);  
      controlPanel.add(output);    
      controlPanel.add(movePeg);  
      //Playing around with the dimensions
      controlPanel.setPreferredSize(new Dimension(500,50));
      board.setPreferredSize(new Dimension(650,650));
      //Setting resizable off
      setResizable(false);
      controlPanel.setBackground(Color.BLACK);
      add(controlPanel); 
      add(board);
      //add(output);
      pack();
      setVisible(true);
      
      
   }
   //BoardMaker class using JPanel
   private class BoardMaker extends JPanel 
   {
      //Paint compenent method 
      public void paintComponent(Graphics g) 
      {
         Graphics2D g2d = (Graphics2D) g;
         super.paintComponent(g);
         //Creating the board
         g2d.drawLine(65,0,65,650);
         g2d.drawLine(130,0,130,650);
         g2d.drawLine(195,0,195,650);
         g2d.drawLine(260,0,260,650);
         g2d.drawLine(325,0,325,650);
         g2d.drawLine(390,0,390,650);
         g2d.drawLine(455,0,455,650);
         g2d.drawLine(520,0,520,650);
         g2d.drawLine(585,0,585,650);
         g2d.drawLine(650,0,650,650);
         g2d.drawLine(0,65,650,65);
         g2d.drawLine(0,130,650,130);
         g2d.drawLine(0,195,650,195);
         g2d.drawLine(0,260,650,260);
         g2d.drawLine(0,260,650,260);
         g2d.drawLine(0,325,650,325);
         g2d.drawLine(0,390,650,390);
         g2d.drawLine(0,455,650,455);
         g2d.drawLine(0,520,650,520);
         g2d.drawLine(0,585,650,585);
         g2d.drawLine(0,650,650,650);
         //Ladders
         g2d.setPaint(new Color (66, 20, 15));
         g2d.drawLine(158+5,621, 28+5,556); 
         g2d.drawLine(613+5,556, 483+5,491);
         g2d.drawLine(353+5,556, 418+5,426); 
         g2d.drawLine(223+5,556, 418+5,166); 
         g2d.drawLine(92+5,491, 223+5,426); 
         g2d.drawLine(158+5,426, 92+5,296); 
         g2d.drawLine(548+5,361, 418+5,231); 
         g2d.drawLine(223+5,296, 288+5,166); 
         g2d.drawLine(28+5,231,158+5,166); 
         g2d.drawLine(483+5,166, 353+5,101); 
         g2d.drawLine(28+5,101,158+5,36);
         
         g2d.drawLine(158,621, 28,556); 
         g2d.drawLine(613,556, 483,491);
         g2d.drawLine(353,556, 418,426); 
         g2d.drawLine(223,556, 418,166); 
         g2d.drawLine(92,491, 223,426); 
         g2d.drawLine(158,426, 92,296); 
         g2d.drawLine(548,361, 418,231); 
         g2d.drawLine(223,296, 288,166); 
         g2d.drawLine(28,231,158,166); 
         g2d.drawLine(483,166, 353,101); 
         g2d.drawLine(28,101,158,36);  
         g2d.setPaint(new Color (0,0,0));
         //Board Numbers
         //g2d.drawString("Start", 18, 640); 
         g2d.drawString("1",28,621);
         g2d.drawString("2",92,621);
         g2d.drawString("3",158,621);
         g2d.drawString("4",223,621);
         g2d.drawString("5",288,621);
         g2d.drawString("6",353,621);
         g2d.drawString("7",418,621);
         g2d.drawString("8",483,621);
         g2d.drawString("9",548,621);
         g2d.drawString("10",613,621);
         g2d.drawString("11",613,556);
         g2d.drawString("12",548,556);
         g2d.drawString("13",483,556);
         g2d.drawString("14",418,556);
         g2d.drawString("15",353,556);
         g2d.drawString("16",288,556);
         g2d.drawString("17",223,556);
         g2d.drawString("18",158,556);
         g2d.drawString("19",92,556);
         g2d.drawString("20",28,556);
         g2d.drawString("21",28,491);
         g2d.drawString("22",92,491);
         g2d.drawString("23",158,491);
         g2d.drawString("24",223,491);
         g2d.drawString("25",288,491);
         g2d.drawString("26",353,491);
         g2d.drawString("27",418,491);
         g2d.drawString("28",483,491);
         g2d.drawString("29",548,491);
         g2d.drawString("30",613,491);
         g2d.drawString("40",28,426);
         g2d.drawString("39",92,426);
         g2d.drawString("38",158,426);
         g2d.drawString("37",223,426);
         g2d.drawString("36",288,426);
         g2d.drawString("35",353,426);
         g2d.drawString("34",418,426);
         g2d.drawString("33",483,426);
         g2d.drawString("32",548,426);
         g2d.drawString("31",613,426);
         g2d.drawString("41",28,361);
         g2d.drawString("42",92,361);
         g2d.drawString("43",158,361);
         g2d.drawString("44",223,361);
         g2d.drawString("45",288,361);
         g2d.drawString("46",353,361);
         g2d.drawString("47",418,361);
         g2d.drawString("48",483,361);
         g2d.drawString("49",548,361);
         g2d.drawString("50",613,361);
         g2d.drawString("60",28,296);
         g2d.drawString("59",92,296);
         g2d.drawString("58",158,296);
         g2d.drawString("57",223,296);
         g2d.drawString("56",288,296);
         g2d.drawString("55",353,296);
         g2d.drawString("54",418,296);
         g2d.drawString("53",483,296);
         g2d.drawString("52",548,296);
         g2d.drawString("51",613,296);
         g2d.drawString("61",28,231);
         g2d.drawString("62",92,231);
         g2d.drawString("63",158,231);
         g2d.drawString("64",223,231);
         g2d.drawString("65",288,231);
         g2d.drawString("66",353,231);
         g2d.drawString("67",418,231);
         g2d.drawString("68",483,231);
         g2d.drawString("69",548,231);
         g2d.drawString("70",613,231);
         g2d.drawString("80",28,166);
         g2d.drawString("79",92,166);
         g2d.drawString("78",158,166);
         g2d.drawString("77",223,166);
         g2d.drawString("76",288,166);
         g2d.drawString("75",353,166);
         g2d.drawString("74",418,166);
         g2d.drawString("73",483,166);
         g2d.drawString("72",548,166);
         g2d.drawString("71",613,166);
         g2d.drawString("81",28,101);
         g2d.drawString("82",92,101);
         g2d.drawString("83",158,101);
         g2d.drawString("84",223,101);
         g2d.drawString("85",288,101);
         g2d.drawString("86",353,101);
         g2d.drawString("87",418,101);
         g2d.drawString("88",483,101);
         g2d.drawString("89",548,101);
         g2d.drawString("90",613,101); 
         g2d.drawString("100",25,36);
         //g2d.drawString("Finish", 18, 60);
         g2d.drawString("99",92,36);
         g2d.drawString("98",158,36);
         g2d.drawString("97",223,36);
         g2d.drawString("96",288,36);
         g2d.drawString("95",353,36);
         g2d.drawString("94",418,36);
         g2d.drawString("93",483,36);
         g2d.drawString("92",548,36);
         g2d.drawString("91",613,36);
         //Snakes Visual
         g2d.setPaint(new Color (62, 173, 66));
         g2d.drawLine(613,621,353,491); 
         g2d.drawLine(613,296,353,621); 
         g2d.drawLine(92,426,288,621);
         g2d.drawLine(288,296,20,605);  
         g2d.drawLine(353,166,483,491); 
         g2d.drawLine(288,101, 92,296); 
         g2d.drawLine(158,101, 288,166); 
         g2d.drawLine(548,36,288,491); 
         g2d.drawLine(613,101, 483,361); 
         g2d.drawLine(92,36,158,231); 
         //FIrst Player 1-10
         if (total < 11 && total > -1)
         { 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-0*65; 
            if (total == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 2)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 3)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 4)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 6)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 7)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 8)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 9)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (total == 10)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Second Player 1-10
         if (totalA < 11 && total > -1)
         { 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-0*65; 
            if (totalA == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 2)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 3)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 4)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 6)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 7)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 8)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 9)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (totalA == 10)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         
         //Player One 11 To 20
         if (total < 21 && total > 10 )
         { 
            int tempVarForCal = 20-total; 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-1*65; 
            if (tempVarForCal == 0)//Red Peg "20"
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)//Red Peg "19"
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)//Red Peg "18"
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)//Red Peg "17"
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)//Red Peg "16"
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)//Red Peg "15"
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)//Red Peg "14"
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7) //Red Peg "13"
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8) //Red Peg "12"
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 9) //Red Peg "11"
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         
         //Player Two 11 TO 20 
         if (totalA < 21 && totalA > 10 )
         { 
            int tempVarForCalA = 20-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-1*65; 
            if (tempVarForCalA == 0) //
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
            //PlayerOne Moving from Numbers from 21 - 30
         if (total < 31 && total > 20     )
         { 
            int tempVarForCal = 30-total;
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-2*65; 
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         } 
            //Moving Player 2 from 21-30 
         if (totalA < 31 && totalA > 20 )
         { 
            int tempVarForCalA = 30-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-2*65; 
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //1: 31-40
         if (total < 41 && total > 30     )
         { 
            int tempVarForCal = 40-total; 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-3*65; 
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //2: 31-40
         if (totalA < 41 && totalA > 30     )
         { 
            int tempVarForCalA = 40-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-3*65; 
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         
         }
            //PlayerOne Moving from Numbers from 41 - 50
         if (total < 51 && total > 39     )
         { 
            int tempVarForCal = 50 - total;  
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-4*65; 
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }  
            //Moving Player 2 from 41-50 
         if (totalA < 51 && totalA > 40     )
         { 
            int tempVarForCalA = 50-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-4*65; 
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Player One: 51-60
         if (total < 61 && total > 50     )
         { 
            int tempVarForCal = 60-total; 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-5*65; 
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Player Two 51 - 60
         if (totalA < 61 && totalA > 50     )
         { 
            int tempVarForCalA = 60-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-5*65; 
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
            //PlayerOne Moving from Numbers from 61 - 70
         if (total < 71 && total > 60     )
         { 
            int tempVarForCal = 70 -total;  
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-6*65; 
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
            //Moving Player 2 from 61-70 
         if (totalA < 71 && totalA > 60     )
         { 
            int tempVarForCalA = 70-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-6*65; 
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Player One 71-80
         if (total < 81 && total > 70     )
         { 
            int tempVarForCal = 80-total; 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-7*65; 
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Player Two: 71-80
         if (totalA < 81 && totalA > 70     )
         { 
            int tempVarForCalA = 80-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-7*65; 
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
            //PlayerOne Moving from Numbers from 81 - 90
         if (total < 91 && total > 80     )
         { 
            int tempVarForCal = 90-total; 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-8*65; 
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
            //Person 2: Line 81-90
         if (totalA < 91 && totalA > 80)
         { 
            int tempVarForCalA = 90-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-8*65; 
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Player One: Line 91-100
         if (total < 101 && total > 90)
         { 
            int tempVarForCal = 100-total; 
            g2d.setPaint(new Color(214, 22, 8));
            yCoordinate = 605-9*65; 
            if (tempVarForCal == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCal == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }
         //Player 2: Line 91 to 100 
         if (totalA < 101 && totalA > 90 )
         { 
            int tempVarForCalA = 100-totalA; 
            g2d.setPaint(new Color(0, 62, 209));
            yCoordinate = 603-9*65; 
            if (tempVarForCalA == 0)
            {
               xCoordinate = 20+0*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 1)
            {
               xCoordinate = 20+1*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 2)
            {
               xCoordinate = 20+2*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 3)
            {
               xCoordinate = 20+3*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 4)
            {
               xCoordinate = 20+4*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 5)
            {
               xCoordinate = 20+5*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 6)
            {
               xCoordinate = 20+6*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 7)
            {
               xCoordinate = 20+7*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 8)
            {
               xCoordinate = 20+8*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
            if (tempVarForCalA == 9)
            {
               xCoordinate = 20+9*65;
               g2d.fillOval(xCoordinate,yCoordinate, 25,25);
            }
         }  
      } 
   }
   //Listens to if an action is being performed
   public void actionPerformed (ActionEvent evt)
   {
      //Checks to see if it is person one's turn 
      if (roll.equals(evt.getSource()) && turnChecker == 2)
      {
         //Instantiating Dice
         Dice diceOne = new Dice();
         Dice diceTwo = new Dice(); 
         //Storing the 2 dices output
         int firstRoll = diceOne.diceOutcome();
         //Visually showing dice  
         one = new DiceShower(firstRoll); 
         one.setLocation(900,50);
         int secondRoll = diceTwo.diceOutcome();
         two = new DiceShower(secondRoll); 
         two.setLocation(900,400);
         output.setText(playerOneName + ":" + "    Die One: " + firstRoll +  "     Die Two: " + secondRoll + "     Total: " + (firstRoll+secondRoll)); 
         total += (firstRoll + secondRoll); 
         //Checking if Player One has reached a total over 100 or not. 
         if (total > 100) 
         {
            total = (total - (firstRoll + secondRoll));
         }
         //Player One --> Ladders and programming logic 
         if (total == 3)
         {
            total = 20; 
         }
         if (total == 11)
         {
            total = 28; 
         }
         if (total == 15)
         {
            total = 34;
         }
         if (total == 17)
         {
            total = 74; 
         }
         if (total == 22) 
         {
            total = 37;
         }
         if (total == 38) 
         {
            total = 59; 
         }
         if (total == 49)
         {
            total = 67;
         }
         if (total == 57)
         {
            total = 76;
         }
         if (total == 61)
         {
            total = 78;
         }
         if (total == 73)
         {
            total = 86;
         }
         if (total == 81)
         {
            total = 98;
         }
         //Snakes for player one; programming logic 
         if (total == 99)
         {
            total = 63; 
         }
         if (total == 92)
         {
            total = 25; 
         }
         if (total == 83)
         {
            total = 76;
         }
         if (total == 85)
         {
            total = 59; 
         }
         if (total == 90) 
         {
            total = 48;
         }
         if (total == 75) 
         {
            total = 28; 
         }
         if (total == 56)
         {
            total = 1;
         }
         if (total == 51)
         {
            total = 6;
         }
         if (total == 39)
         {
            total = 5;
         }
         if (total == 26)
         {
            total = 10;
         }
      
         turnChecker = 3;  
      }   
      //Player One Moving and Ending Turn 
      if (movePeg.equals(evt.getSource()) && turnChecker == 3)
      {
         //Method Hide it created 
         one.hideIt(); 
         two.hideIt(); 
         repaint();
         turnChecker = 4;  
         //If player one gets 100 they win the game
         if (total == 100) 
         {
            System.out.println(playerOneName+ " You've Won!");
            System.exit(0);   
         }
      }
      //Player Two Rollin Dice 
      if (roll.equals(evt.getSource()) && turnChecker == 4)
      {     
         //Instantiating Die One and Die Two for Player Two 
         Dice diceOneA = new Dice();
         Dice diceTwoA = new Dice(); 
         //Storing the numbers
         int firstRollA = diceOneA.diceOutcome(); 
         oneA = new DiceShower(firstRollA); 
         oneA.setLocation(900,50);
         int secondRollA = diceTwoA.diceOutcome();
         twoA = new DiceShower(secondRollA);
         twoA.setLocation(900,400); 
         //Outputting the second users information onto the screen
         output.setText(playerTwoName +":" + "    Die One: " + firstRollA +  "     Die Two: " + secondRollA + "     Total: " + (firstRollA+secondRollA)); 
         totalA += (firstRollA + secondRollA); 
         //Ensuring that the second player cannot have a sum greater than 100. Removes last roll from total count. 
         if (totalA > 100) 
         {
            totalA = (totalA - (firstRollA + secondRollA));
         }
         //Ladders --> math and code logic behind the ladders, for player two.
         if (totalA == 3)
         {
            totalA = 20; 
         }
         if (totalA == 11)
         {
            totalA = 28; 
         }
         if (totalA == 15)
         {
            totalA = 34;
         }
         if (totalA == 17)
         {
            totalA = 74; 
         }
         if (totalA == 22) 
         {
            totalA = 37;
         }
         if (totalA == 38) 
         {
            totalA = 59; 
         }
         if (totalA == 49)
         {
            totalA = 67;
         }
         if (totalA == 57)
         {
            totalA = 76;
         }
         if (totalA == 61)
         {
            totalA = 78;
         }
         if (totalA == 73)
         {
            totalA = 86;
         }
         if (totalA == 81)
         {
            totalA = 98;
         }
         //Mathematics and Programming Logic Behind the Use of Snakes --> For the Second Player 
         if (totalA == 99)
         {
            totalA = 63; 
         }
         if (totalA == 92)
         {
            totalA = 25; 
         }
         if (totalA == 83)
         {
            totalA = 76;
         }
         if (totalA == 85)
         {
            totalA = 59; 
         }
         if (totalA == 90) 
         {
            totalA = 48;
         }
         if (totalA == 75) 
         {
            totalA = 28; 
         }
         if (totalA == 56)
         {
            totalA = 1;
         }
         if (totalA == 51)
         {
            totalA = 6;
         }
         if (totalA == 39)
         {
            totalA = 5;
         }
         if (totalA == 26)
         {
            totalA = 10;
         }
      
         turnChecker = 5; 
      } 
      //Checks if its player two's turn to move and end their turn.  
      if (movePeg.equals(evt.getSource())&& turnChecker == 5)
      {
         oneA.hideIt(); 
         twoA.hideIt();
         repaint();
         turnChecker = 2; 
         //If Player Two reaches a total of 100, they win. System exits throught System.exit(); 
         if (totalA == 100) 
         {
            System.out.println(playerTwoName+ " You've Won!");
            System.exit(0);   
         }
      }
      
   }
   
   //Main method --> Calling onto the GUI class and the Dice Class and Initializing Everyone. 
   public static void main (String[] args)
   {
      //Initializing Scanner 
      Scanner inData = new Scanner(System.in); 
      //Input Player One's Name --> A variation of this can be made with GUIs where the user inputs there information on a diferent panel with text fields
      System.out.println("What is Player One's Name: ");
      //Storing information in a static string 
      playerOneName = inData.nextLine(); 
      //Exact same information above 
      System.out.println("What is Player Two's Name: ");
      playerTwoName = inData.nextLine();  
      //Instantiating the Panel and Frame and Graphics from the SnakesAndLadder class. 
      new SnakesAndLadder();
   }
   
   
}
