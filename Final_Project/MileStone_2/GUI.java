import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * file/class: GUI.java
 * author: Christopher Piccirillo
 * course: CMPT 440
 * assignment: Final Project
 * due date: May 2nd, 2016
 * version: 1.6
 * 
 * This file contains the methods to display our beautiful Graphical
 * User Interface and the functionality of all of its formatting methods
 *
 */

  public class GUI extends Application{
    StringBuilder sb; // string builer for file reading
    Button runButton; // run runButton
    final Tooltip runtooltip = new Tooltip(); // tooltip for run button
    Button clearButton; // clear runButton
    final Tooltip cleartooltip = new Tooltip(); // tooltip for clear button
    String filePath = ""; // path to save file
    MenuBar menuBar = new MenuBar(); // file menu bar
    SeparatorMenuItem sep = new SeparatorMenuItem(); // separator for our menu items
    Menu menuFile = new Menu("File"); // file menu
    Menu colorMenu = new Menu("Text Color Schemes"); // color menu  
    Menu lineSep = new Menu("|"); // separator for menu bar 
    String tempHTML = ""; // temporary string to hold html with our specified new line chars
    static HTMLEditor HTMLEditorx; // Our Rich Text Editor
  
/**
* file: GUI.java
* author: Christopher Piccirillo
* course: CMPT 440
* assignment: Final Project
* due date: May 2nd, 2016
* version: 1.5
* 
* This file contains the methods to display our beautiful Graphical
* User Interface and the functionality of all of its formatting methods
*
*/  
    
/**
* main()
* This is our programs main method.  This launches our stage. 
* @param n/a
* @return n/a
*/     
  public static void main (String args[]){
    launch(args);
  }
	
/**
 * getFile()
 * This method utilizes JFileChooser to prompt our user to select and open a file in our HTML text editor
 * @param n/a
 * @return n/a
 */
  public void getFile() throws Exception{
    JFileChooser fileChooser = new JFileChooser(); // File Chooser object to grab file text
    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); 
    fileChooser.setFileFilter(filter); // only text files allowed
    sb = new StringBuilder(); // String to build and read into our IDE
    if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){ // Checking for selected file 
      // get the file 
      java.io.File file = fileChooser.getSelectedFile();
      Scanner input = new Scanner(file);
      //read text from file
      while(input.hasNext()){
        sb.append(input.nextLine()); // Build our string with the selected text from file
        sb.append("\n");
	  }
      input.close();
    }	    
    else {
      sb.append("No File Was Selected");
    }
  }
/**
* saveFile()
* This method utilizes JFileChooser to prompt our user to name and save the current text they have
* entered as a file on their PC.
* @param n/a
* @return n/a
*/
  public void saveFile() throws IOException{
    JFileChooser fileChooser = new JFileChooser(); 
    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); 
    fileChooser.setFileFilter(filter); // only text files allowed
    fileChooser.setDialogTitle("Specify a file to save"); // prompt for file saving	     
    int userSelection = fileChooser.showSaveDialog(null); // catching user selection module	     
    if (userSelection == JFileChooser.APPROVE_OPTION) {
      File fileToSave = fileChooser.getSelectedFile();
      System.out.println("Save as file: " + fileToSave.getAbsolutePath());
      filePath = fileToSave.getAbsolutePath();
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath + ".txt")))) {
        String tempText = HTMLEditorx.getHtmlText();
        String tempText2 = tempText.replaceAll("<p>", System.lineSeparator());
        String tempText3 = HTMLtoText(tempText2);
        bw.write(tempText3);
        bw.close();
       }
       catch (FileNotFoundException ex) {
         System.out.println("File not found");
	   }
    }
  }	
/**
* start()
* This method utilizes launches our stage and start our program. It contains the event handlers
* for all of our buttons as well.
* @param our stage
* @return n/a
*/
  @Override
  public void start(Stage primaryStage) throws Exception {
      
    MenuItem load = new MenuItem("Load File");  
    // Event handler for our load file button
    load.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent t) {
      try{
        getFile();
      }
      catch(Exception e){
      }
      String x = sb.toString().replaceAll("\n", "<p>");
      HTMLEditorx.setHtmlText(x);   
      }
    });
    
    MenuItem save = new MenuItem("Save File");
   // Event handler for our save file button
    save.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent t) {
      try {
        saveFile();
      } 
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    });
    
    MenuItem light = new MenuItem("Light");
     // Event handler for our save light color button
    light.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent t) { // changing our color globals
      checkUserInput.color1 = "#0099ff";
      checkUserInput.color2 = "orange";
      checkUserInput.color3 = "gray";
      checkUserInput.color4 = "green";
    }
    });
           
    MenuItem dark = new MenuItem("Dark");
    // Event handler for our save dark color button
    dark.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent t) {
      checkUserInput.color1 = "#6600cc";
      checkUserInput.color2 = "#990033";
      checkUserInput.color3 = "#47476b";
      checkUserInput.color4 = "#663300";
    }
    });
    
    // CREATING OUR GUI (Positioning, adding nodes, text, color Etc)
    HTMLEditorx = new HTMLEditor(); // HTML editor
    primaryStage.setTitle("Christopher Piccirillo's IDE"); // Naming
    runButton = new Button("Analyze!");
    runtooltip.setText("Click here to analyze this snippet of code against our grammar.");
    runButton.setTooltip(runtooltip);
    clearButton = new Button("Clear");
    cleartooltip.setText("Click here to clear the text area.");
    clearButton.setTooltip(cleartooltip);
    lineSep.setDisable(true);
    menuFile.getItems().addAll(load,sep,save);
    colorMenu.getItems().addAll(light,dark);
    menuBar.getMenus().addAll(menuFile,lineSep,colorMenu);
    menuBar.setStyle("-fx-background-color: #f0f0f5;");
    GridPane layout = new GridPane();
    layout.setStyle("-fx-background-color: #669999;");
    layout.add(menuBar,0,0);
    layout.add(HTMLEditorx,0,1);
    runButton.setTranslateX(225);
    clearButton.setTranslateX(305);
    layout.add(runButton,0,2);
    layout.add(clearButton,0,2); 
    Scene scene = new Scene(layout, 600, 600);
    primaryStage.setScene(scene);
    primaryStage.show();		
    
    // Event handler for our run button
    runButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
      tempHTML = HTMLEditorx.getHtmlText();
      String x = tempHTML.replaceAll("<p>","@"); // temp string to hold HTML with our specified new line char
      String y = x.replaceAll("&nbsp;"," "); // getting rid of nbsp, creates some formatting issues otherwise
      checkUserInput.checkInput(HTMLtoText(y));
    }
    });
    // Event handler for our clear button
    clearButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
      HTMLEditorx.setHtmlText(""); // Clear our HTML editor
    }
    });  
  }	
  
/**
* HTMLtoText()
* This method takes in our HTML text and returns it as regular text. 
* @param HTML Text String
* @return Stripped and normal text string
*/  
  private String HTMLtoText(String htmlText) {
    Pattern pattern = Pattern.compile("<[^>]*>");
    Matcher matcher = pattern.matcher(htmlText);
    final StringBuffer buff = new StringBuffer(htmlText.length());
    while(matcher.find()) {
          matcher.appendReplacement(buff, "");
    }
    matcher.appendTail(buff);
    return(buff.toString().trim());
  }
} // End Class
