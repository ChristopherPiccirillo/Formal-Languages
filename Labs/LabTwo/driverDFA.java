/**
 * file: driverDFA.java
 * @author Christopher Piccirillo
 * course: CMPT 440
 * assignment: Lab Two
 * due date: February 15, 2015
 * version: 1.1
 * 
 * This file contains a driver for the class ManWolf.  The testInput function is called on a string entered at the time this 
 * driver is called.  
 * 
 * Usage1: javac driverDFA
 * Usage2: java driverDFA "Any Input Here"
 * 
 * Valid Input: gncgwng
 * Invalid:     ggggggggg
 * 
 */

/** 
 * driverDFA.java
 * This class acts as a driver for the testInput method in the ManWolf.java class
 * 
 */
public class driverDFA {
	
	
/** 
 * Main Method to initiate the driver and ManWolf.javas method
 * @param userInput in the command line
 */
  public static void main(String Args[]){
	  String[] input = Args;
	  ManWolf.testInput(input[0]);
  }  
}


