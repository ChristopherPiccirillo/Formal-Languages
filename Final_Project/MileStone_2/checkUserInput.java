import java.util.HashMap;

/**
 * file: test.java
 * author: Christopher Piccirillo
 * course: CMPT 440
 * assignment: Final Project
 * due date: May 2nd, 2016
 * version: 1.3
 * 
 * This file contains the methods to check user input in our GUI against our grammar.
 *
 */
public class checkUserInput {
    
  static HashMap<Character, Integer> map = new HashMap<>(); // Hash map for all char values /
  public static int state = 0; // Current transition state
  static String htmlString = ""; // String to add styled text to. 
  static String styleString = "";  // Adds styles to the texts
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
 * Parameter: String of user input from our HTML Editor
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
   //  map.put('~',45); // End Add Chars
    // check for input in file
     //System.out.println(userInput);
     
     for(int i = 0; i<userInput.length(); i++){   // Loop through user input string
         char selectedChar = userInput.charAt(i); // Set curr selected char to selectedChar
         System.out.println("Selected Char: " + selectedChar);
         try {
         columnNo = map.get(selectedChar);        // Set columnNo to our lookup value in hashmap
         }
         catch(NullPointerException ex) { // try catch for out of our alphabet
             System.out.println("CATCHING NULL POINTER");
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
         //htmlString += selectedChar;             // Add to our html string
         }
         System.out.println(state + " state");
         state = Matrix.matrix[state][columnNo]; // Setting our lookup state
         switch(state){
         // COLOR INDEX:
         // STATEMENTS (PRINT) (VAR) = 
         case 0: System.out.println("case 0"); // Neutral Start State
                 break;
         case 1: System.out.println("case 1"); // p case 
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
         case 2: System.out.println("case 2");
                 break;
         case 3: System.out.println("case 3");
                 break;
         case 4: System.out.println("case 4");
                 break;
         case 5: System.out.println("case 5"); // Print               
                 break;
         case 6: System.out.println("case 6");
                 break;
         case 7: System.out.println("case 7");
                 break;
         case 8: System.out.println("case 8");
                 break;
         case 9: System.out.println("case 9");
                 break;
         case 10: System.out.println("case 10");
                  break;
         case 11: System.out.println("case 11");
                  break;
         case 12: System.out.println("case 12");
                  break;
         case 13: System.out.println("case 13");
                  break;
             
         case 14:  // Print Success Case
             System.out.println("case 14");
             htmlString+="<font color='"+color1+"'>" + textString + "</font>";
             textString = "";
            // state = 0;
             break;
             
         case 15: System.out.println("case 15");
                  break;
         case 16: System.out.println("case 16");
                  break;
         case 17: System.out.println("case 17");
                  break;
         case 18: System.out.println("case 18");
                  break;
         case 19: System.out.println("case 19");
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
         case 20: System.out.println("case 20");
                  break;
         case 21: System.out.println("case 21");
                  break;
         case 22: System.out.println("case 22");
                  break;            
         case 23: System.out.println("case 23"); // Var Decl Case
         System.out.println("case 23");
         htmlString+="<font color='"+color4+"'> " + textString + "</font>";
         textString = "";
        // state = 0;
                  break;
///// GOING TO HAVE TO DO THIS IN MORE SPOTS  OR FIND ALTERNATIVE FIX  ////////////////////////////////////////////////////////                  
         case 24: System.out.println("case 24");
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
         case 25: System.out.println("case 25");
         try {
             if(userInput.charAt(i+1)!= '='){
                 tempString = textString;
                 textString = "";
                 htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
                 state = 0;// if new line, put it after the error underline
                break;
             }
             else {
                break;
             }
    }
    catch(StringIndexOutOfBoundsException ex){
    }
              
                  break;
         case 26: System.out.println("case 26");
                  break;
         case 27: System.out.println("case 27");
                  break;
         case 28: System.out.println("case 28");
         htmlString+="<font color='"+color2+"'>" + textString + "</font>";
         textString = "";
        // state = 0;
                  break;
         case 29: System.out.println("case 29");
                  break;
         case 30: System.out.println("case 30");
                  break;
         case 31: System.out.println("case 31");
         htmlString+="<font color='"+color2+"'>" + textString + "</font>";
         textString = "";
        // state = 0;
                  break;
         case 32: System.out.println("case 32");
                  break;
         case 33: System.out.println("case 33");
                  break;
         case 34: System.out.println("case 34");
                  break;
         case 35: System.out.println("case 35"); // assign accept
         htmlString+="<font color='"+color2+"'>" + textString + "</font>";
         textString = "";
        // state = 0;
                  break;
         case 36: System.out.println("case 36");
                  starCount++;
                  if(starCount %2 == 0){
                      tempString = textString;
                      textString = "";
                      htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
                    //htmlString = "String c = "<span style='border-bottom: 1px solid #ff0000;'>Underlined text here.</span>";"
                  //  GUI.HTMLEditorx.setHtmlText(htmlString);
                   // state = 0;
                      state = 0;
                      break;
                      
                  }
                  break;
         case 37: System.out.println("case 37");
                  break;
         case 38: System.out.println("case 38");
                  break;
         case 39: System.out.println("case 39");
                  break;
         case 40: System.out.println("case 40");
                  break;
         case 41: System.out.println("case 41"); // Comment Accept
         starCount++;
         System.out.println("case 41");
         htmlString+="<font color='"+color3+"'>" + textString + "</font>";
         textString = "";
        // state = 0;
                  break;
         case 42: System.out.println("case 42");
                  break;      
         case 100:   System.out.println("ERROR STATE 100");  // ERROR STATE, UNDERLINE TEXT RED
                     System.out.println(textString);
                     tempString = textString;
                     textString = "";
                     htmlString += "<span style='border-bottom: 1px solid #ff0000;'>" + tempString + "</span>";
                   //htmlString = "String c = "<span style='border-bottom: 1px solid #ff0000;'>Underlined text here.</span>";"
                 //  GUI.HTMLEditorx.setHtmlText(htmlString);
                  // state = 0;
                     state = 0;
                     break;
         
         }
       } 
    System.out.println("END LOOP");// End loop through input
    GUI.HTMLEditorx.setHtmlText(htmlString); // Display new html
  // Reset strings/states/
  System.out.println("Final HTML: " + htmlString);
  htmlString = "";
  styleString = "";
  tempString = "";
  textString = "";
  state = 0;
  starCount = 0;
  columnNo = 100;
    
  } // End Method
}  // End Class
