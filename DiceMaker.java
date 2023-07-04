/**************************************************************************************************************
	File: DiceMaker.java 
	Purpose: Makes the dice by creating different boxes and circles within them.     	
	Author: Areej Ansari 
	Date: January 24th, 2018
	Based on: ICS4U Java Assignment Final Project
**************************************************************************************************************/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Color;

class DiceMaker extends JPanel 
{
   //Variables 
   private int dieOne; 
   //Constructor
   DiceMaker (int dieOne)
   {
      this.dieOne = dieOne; 
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
   //Graphics Method
   public void paintComponent(Graphics g) 
   {
      Graphics2D g2d = (Graphics2D) g;
      super.paintComponent(g);
      g2d.drawLine(100,0,100,300);
      g2d.drawLine(200,0,200,300); 
      g2d.drawLine(300,0,300,300);
      g2d.drawLine(0,90,300,90);
      g2d.drawLine(0,185,300,185); 
      if (dieOne == 1) 
      {
         g2d.fillOval(125,112,50,50);
      }
      if (dieOne == 2) 
      {
         g2d.fillOval(25,112,50,50);
         g2d.fillOval(225,112,50,50);
      }
      if (dieOne == 3) 
      {
         g2d.fillOval(225,12,50,50);
         g2d.fillOval(125,112,50,50);
         g2d.fillOval(25,212,50,50);
      }
      if (dieOne == 4) 
      {
        g2d.fillOval(25,12,50,50);
         g2d.fillOval(225,212,50,50);
         g2d.fillOval(225,12,50,50);
         g2d.fillOval(25,212,50,50);
      }
      if (dieOne == 5) 
      {
         g2d.fillOval(25,12,50,50);
         g2d.fillOval(125,112,50,50);
         g2d.fillOval(225,212,50,50);
         g2d.fillOval(225,12,50,50);
         g2d.fillOval(25,212,50,50);
      }
      if (dieOne == 6) 
      {
         g2d.fillOval(25,12,50,50);
         g2d.fillOval(25,112,50,50);
         g2d.fillOval(25,212,50,50);
         g2d.fillOval(225,12,50,50);
         g2d.fillOval(225,112,50,50);
         g2d.fillOval(225,212,50,50);
      }
       
   }
}