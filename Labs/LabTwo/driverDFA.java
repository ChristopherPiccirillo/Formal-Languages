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
 * Usage: javac driverDFA
 * 		: java driverDFA "Any Input Here"
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
	
  public static void main(String Args[]){
	  String[] input = Args;
	  ManWolf.testInput(input[0]);
  }  
}


