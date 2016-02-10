/**
 * file: ManWolf.java
 * @author Christopher Piccirillo
 * course: CMPT 440
 * assignment: Lab Two
 * due date: February 15, 2015
 * version: 1.0
 * 
 * This file contains the code to to validate a certain string for a
 * correct solution to The Wolf, the Goat, and the Cabbage problem
 * 
 */

/** 
 * ManWolf.java
 * This class contains a table-driven DFA approach to verifying a possible solution to 
 * The Wolf, the Goat, and the Cabbage problem.
 * A 2d array is used to represent the transition table states and a single for loop is processed around the string input
 * to progress through the table.
 */


public class ManWolf {
								     // The 10 possible states of the transition table as ints	
  private static final int q0 = 0;
  private static final int q1 = 1;
  private static final int q2 = 2;
  private static final int q3= 3;
  private static final int q4 = 4;
  private static final int q5 = 5;
  private static final int q6 = 6;
  private static final int q7 = 7;
  private static final int q8 = 8;
  private static final int q9 = 9;   // Accept state   
  private static final int q10 = 10; // Fail state 
  private static int state = q0;     // Starting state in the transition table
  
  
  
  // 2d array to represent a state transition table (Rows as states, columns as letters in this alphabet)
  static private int[][] delta = {
	//  g   n   c   w  	   // each of these characters to the left correspond to a specific column
	  					   // each of these characters to the right correspond to a specific row(state)
	   {q1,q10,q10,q10},   // q0 
	   {q0,q2,q10,q10},    // q1
	   {q10,q1,q5,q3},     // q2
	   {q4,q10,q10,q2},    // q3
	   {q3,q10,q7,q10},    // q4
	   {q6,q10,q2,q10},    // q5
	   {q5,q10,q10,q7},    // q6
	   {q10,q8,q4,q6},     // q7
	   {q9,q7,q10,q10},    // q8
	   {q8,q10,q10,q10}    // q9
	
  };  
/**
 *  testInput
 *  
 *  This function takes in a user input string from driverDFA.  It loops through the entire string and transitions through the table above
 *  with a simple switch case.  A
 *  
 * @param userInput: The string passed by driverDFA.  This will be looped through.
 * 
 * @return No actual return value.  If the string entered is a solution the user will be notified in the command prompt, alternatively they will
 * 		   be notified of an incorrect answer as well.
 */	  
  public static void testInput(String userInput){
	  
	  if (userInput.isEmpty()){
		  System.out.println("Please enter something next time! That is a not a solution"); // Check empty string before computations are made
	  }
	  for (int i = 0; i<userInput.length(); i++){											// Looping through entire string, checking for characters and 
           char c = userInput.charAt(i);													// Performing a table lookup for a transition (switch case)
	       int columnNo = 10; 																// 10 is a placeholder, no significance
	       switch (c){
		       case 'g':  columnNo = 0;
		      	 		 break;
		       case 'n':  columnNo = 1;
		                  break;
		       case 'c':  columnNo = 2;
		                  break;
		       case 'w':  columnNo = 3;
		                  break;			          
		   }    
		   try {			   																// Try Catch to Catch index out of bounds in our 2d array as an error message
			   state = delta[state][columnNo];
			   System.out.println(state); ////////////////////;////////////////////;////////////////////;////////////////////
			   if (i == userInput.length()-1 && state !=q9 && state !=q10) {  				//Check for invalid solution
				   System.out.println("That is not a solution.");
				   return;
			   }
			   if (state == q10) {														    //Check for invalid solution
				   System.out.println("That is not a solution.");							
				   return;
			}
			   if(state == q9 && i == userInput.length()-1) {  								//Check for valid solution	
				  System.out.println("That is a solution.");
				  return;
			   }
			
		   } 
		   catch(ArrayIndexOutOfBoundsException ex){
				 System.out.println("Invalid Input! That is not a solution.");
				 return;
   }
  }		
 }
}


