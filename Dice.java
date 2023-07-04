/**************************************************************************************************************
	File: Dice.java 
	Purpose: Very very very very simple class that just generates a die number between 1-6. I chose this method
   to carry out this task because the idea of instantiating a variable in the actual program itself seemed much
   cleaner versus having code doing math when there is a lot of math already happening.    	
	Author: Areej Ansari 
	Date: January 24th, 2018
	Based on: ICS4U Java Assignment Final Project
**************************************************************************************************************/
class Dice
{
   int diceNumber; 
   
   //Empty constructors 
   Dice()
   {
   }
   //Return a number from 1-6 
   int diceOutcome()
   {
      diceNumber = (int)(Math.random() * 6) + 1;   
      return diceNumber;
   }
}
    
