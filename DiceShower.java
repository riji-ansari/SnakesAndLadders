/**************************************************************************************************************
	File: DiceShower.java 
	Purpose: Calls onto the actual program which makes the die and therefore "Shows" it.     	
	Author: Areej Ansari 
	Date: January 24th, 2018
	Based on: ICS4U Java Assignment Final Project
**************************************************************************************************************/
import java.awt.Graphics;
import java.awt.Graphics2D;   
import javax.swing.*;
import java.awt.Color;
public class DiceShower extends JFrame 
{
   //Reference variables and variables
   DiceMaker make;
   private int dieOne;
      //Add all requirements needed. 
   //Constructor Method
   DiceShower (int dieOne)
   {
      this.dieOne = dieOne; 
      make = new DiceMaker (dieOne); 
      setBounds(300,300,300,300);
      setResizable(false); 
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      setVisible(true);
      add(make); 
   }
   //Get and Set Methods
   void setOne(int dieOne)
   {
      this.dieOne = dieOne; 
   }
   int getOne()
   {
      return dieOne; 
   } 
   //Creating my own method to hide the frames   
   void hideIt()
   {
      this.dispose(); 
   }   
   /*Testing it with main method here
   public static void main(String[] args) 
   {
      new DiceShower(6);
   }
   */
   
    
}