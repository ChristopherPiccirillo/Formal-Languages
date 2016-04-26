import java.util.HashMap;

/**
 * file: test.java
 * author: Christopher Piccirillo
 * course: CMPT 440
 * assignment: Final Project
 * due date: May 2nd, 2016
 * version: 1.4
 * 
 * This file contains the methods to check user input in our GUI against our grammar.
 *
 */
public class checkUserInput {
    
  static HashMap<Character, Integer> map = new HashMap<>(); // Hash map for all char values /
  public static int state = 0; // Current transition state
  static String htmlString = ""; // String to add styled text to. 
  static String tempString = "";  // Adds add styles in front of HTML string
  static String textString = ""; // Adding literal text to a string
  static String color1 = "#0099ff"; // color scheme editing
  static String color2 = "orange"; // color scheme editing
  static String color3 = "gray"; // color scheme editing
  static String color4 = "green"; // color scheme editing
  static int starCount = 0; // Counting for Comments
  public static int columnNo = 100; // Start in Error State

/**
 * checkInput
 *
 * This function checks the text inputed into our GUI against our DFA for proper usage.  
 * The text will be formatted according to correctness.
 * 
 * @param String of user input from our HTML Editor
 * 
 */

public static void checkInput(String userInput){
  map.put('a',0); // Adding all chars to map for state transition positions    
  map.put('b',1);
  map.put('c',2);
  map.put('d',3);
  map.put('e',4);
  map.put('f',5);
  map.put('g',6);    
  map.put('h',7);
  map.put('i',8);
  map.put('j',9);
  map.put('k',10);
  map.put('l',11);
  map.put('m',12);
  map.put('n',13);
  map.put('o',14);
  map.put('p',15);
  map.put('q',16);   
  map.put('r',17);
  map.put('s',18);
  map.put('t',19);
  map.put('u',20);
  map.put('v',21);
  map.put('w',22);
  map.put('x',23);
  map.put('y',24);
  map.put('z',25);
  map.put('0',26);   
  map.put('1',27);
  map.put('2',28);
  map.put('3',29);
  map.put('4',30);
  map.put('5',31);
  map.put('6',32);
  map.put('7',33);
  map.put('8',34);
  map.put('9',35);
  map.put('=',36);
  map.put('+',37);   
  map.put('(',38);
  map.put(')',39);
  map.put('-',40);
  map.put('*',41);
  map.put(' ',42);
  map.put('@',43);
  map.put('"',44);
     
  for(int i = 0; i<userInput.length(); i++){   // Loop through user input string
    char selectedChar = userInput.charAt(i); // Set curr selected char to selectedChar
    try {
      columnNo = map.get(selectedChar);        // Set columnNo to our lookup value in hashmap
    }
    catch(NullPointerException ex) { // try catch for out of our alphabet
      textString+=selectedChar;  
      tempString = textString;
      textString = "";
      htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
      state = 0;        
      continue;
    }
    if(selectedChar == '@'){                // Add new line if we reach new line char
      htmlString+="<p>";
    }
    else { 
      textString += selectedChar;             // Add to our literal string
    }
    state = Matrix.matrix[state][columnNo]; // Setting our lookup state
    switch(state){
      case 0: // Start State
        break;
        
      case 1: // p case 
        try {
          if(userInput.charAt(i+1)=='@'){ // if new line, put it after the error underline
            tempString = textString;
            textString = "";
            htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
            state = 0;
            selectedChar = userInput.charAt(i+1);
          }
        }
        catch(StringIndexOutOfBoundsException ex){
          tempString = textString;
          textString = "";
          htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
          state = 0;   
        }
        break;   
        
      case 14:  // Print Success Case
        htmlString+="<font color='"+color1+"'>" + textString + "</font>";
        textString = "";
        break;
          
      case 19: // v case
        try {
          if(userInput.charAt(i+1)=='@'){ // if new line, put it after the error underline
            tempString = textString;
            textString = "";
            htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
            state = 0;
            selectedChar = userInput.charAt(i+1);
          }
        }
        catch(StringIndexOutOfBoundsException ex){
          tempString = textString;
          textString = "";
          htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
          state = 0;
        }
        break;
        
       case 23: // Var Decl Case
         htmlString+="<font color='"+color4+"'> " + textString + "</font>";
         textString = "";
         break;            
         
       case 24: // special check for single ids
         try {
           if(userInput.charAt(i+1)=='@'){ // if new line, put it after the error underline
             tempString = textString;
             textString = "";
             htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
             state = 0;
             selectedChar = userInput.charAt(i+1);
           }
         }
         catch(StringIndexOutOfBoundsException ex){
           tempString = textString;
           textString = "";
           htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
           state = 0;      
         }  
         break;
         
         case 25:  // special check for single ids
           try {
             if(userInput.charAt(i+1)!= '='){
               tempString = textString;
               textString = "";
               htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
               state = 0;// if new line, put it after the error underline ^
               break;
             }
             else {
               break;
             }
          }
          catch(StringIndexOutOfBoundsException ex){
              // do nothing here
          }
          break;
          
         case 28: //  Assign accept state
           htmlString+="<font color='"+color2+"'>" + textString + "</font>";
           textString = "";
           break;
           
         case 31:  // Assign accept state
           htmlString+="<font color='"+color2+"'>" + textString + "</font>";
           textString = "";
           break;
           
         case 35: // Assign accept state
           htmlString+="<font color='"+color2+"'>" + textString + "</font>";
           textString = "";
           break;
           
         case 36: // * comment check
           starCount++;
           if(starCount %2 == 0){
             tempString = textString;
             textString = "";
             htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
             state = 0;
             break;
           }
           break;
           
         case 41:  // Comment Accept
           starCount++;
           htmlString+="<font color='"+color3+"'>" + textString + "</font>";
           textString = "";
           break;

         case 100: // Error state, underline text red
           tempString = textString;
           textString = "";
           if (!tempString.equals (" ")){
           htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
           }
           state = 0;
           break;       
    } // End Switch
  } // End Loop
  GUI.HTMLEditorx.setHtmlText(htmlString); // Display newly created html  
  // Reset strings/states/
  htmlString = "";
  tempString = "";
  textString = "";
  state = 0;
  starCount = 0;
  columnNo = 100;    
  } // End Method
}  // End Class
