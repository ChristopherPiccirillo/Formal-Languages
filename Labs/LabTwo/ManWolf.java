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
	
  private static final int q0 = 0;
  private static final int q1 = 1;
  private static final int q2 = 2;
  private static final int q3= 3;
  private static final int q4 = 4;
  private static final int q5 = 5;
  private static final int q6 = 6;
  private static final int q7 = 7;
  private static final int q8 = 8;
  private static final int q9 = 9;   //accept state
  private static final int q10 = 10; //fail state
  private static int state = q0;
  private static int g = 0;
		
  static private int[][] delta = {
	//  g   n   c   w 
	   {q1,q10,q10,q10},   // q0
	   {q0,q2,q10,q10},    // q1
	   {q10,q2,q5,q3},     // q2
	   {q4,q10,q10,q2},    // q3
	   {q3,q10,q7,q10},    // q4
	   {q6,q10,q2,q10},    // q5
	   {q5,q10,q10,q7},    // q6
	   {q10,q8,q4,q6},     // q7
	   {q9,q8,q10,q10},    // q8
	   {q8,q9,q9,q9}       // q9
	
  }; 
	
  public static void testInput(String userInput){
	  if (userInput.isEmpty()){
		  System.out.println("Please enter something next time! That is a not a solution");
	  }
	  for(int i = 0; i<userInput.length(); i++) {
          char c = userInput.charAt(i);
	      int coOrds = 10;
		   switch (c) {
		           case 'g':  coOrds = 0;
		             break;
		           case 'n':  coOrds = 1;
		              break;
		           case 'c':  coOrds = 2;
		             break;
		           case 'w':  coOrds = 3;
		             break;			          
		        }
		     
			try{
			state = delta[state][coOrds];
			
			if (i == userInput.length()-1 && state !=q9 && state !=q10){
				System.out.println("Ran out of chars! Bad Input! That is not a solution.");
				return;
			}
			if(state == q10) {
				System.out.println("That is not a solution.");
				return;
			}
			if(state == q9 && c!= g){
				System.out.println("That is a solution.");
				return;
			}
			
			} catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("Invalid Input! That is not a solution.");
				return;
			}
		}
		
	
	}
}


