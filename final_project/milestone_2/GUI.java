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
 * file: GUI.java
 * author: Christopher Piccirillo
 * course: CMPT 440
 * assignment: Final Project
 * due date: May 2nd, 2016
 * version: 1.5
 * 
 * This file contains the methods to check to output or GUI and its functionality.
 *
 */

public class GUI extends Application{
    StringBuilder sb; // string builer for file reading
    Button runButton; // run runButton
    final Tooltip runtooltip = new Tooltip(); // tooltip for run button
    Button clearButton; // clear runButton
    final Tooltip cleartooltip = new Tooltip(); // tooltip for clear button
    final Tooltip savetooltip = new Tooltip(); // tooltip for save button
    final Tooltip loadtooltip = new Tooltip(); // tooltip for load button
    String filePath = ""; // path to save file
    MenuBar menuBar = new MenuBar(); // file menu bar
    SeparatorMenuItem sep = new SeparatorMenuItem(); // separator for our menu items
    Menu menuFile = new Menu("File"); // file menu
    Menu colorMenu = new Menu("Text Color Schemes"); // color menu  
    Menu lineSep = new Menu("|"); // separator for menu bar 
    String tempHTML = "";
    static HTMLEditor HTMLEditorx;
	public static void main (String args[]){
		
		//System.out.println("Hello world");	
		// Sets up program as JFX application
		launch(args);
	}
	
/**
 * method to get file text
 */
	public void getFile() throws Exception{
	    JFileChooser fileChooser = new JFileChooser(); // File Chooser object to grab file text
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
	    fileChooser.setFileFilter(filter); // only text files allowed
	    sb = new StringBuilder(); // String to build and read into our IDE
	    System.out.println("GET FILE METHOD");
	    if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	        // get the file 
	        java.io.File file = fileChooser.getSelectedFile();
	        Scanner input = new Scanner(file);
	        //read text from file
	        while(input.hasNext()){
	            sb.append(input.nextLine());
	            sb.append("\n");
	        }
	        input.close();
	    }
	    
	    else {
	        sb.append("No File Was Selected");
	    }
	    
	    
	}
	/**
	 * method to save a file to PC from input string
	 * @throws IOException 
	 */
	public void saveFile() throws IOException{
	    JFileChooser fileChooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
	    fileChooser.setFileFilter(filter); // only text files allowed
	    fileChooser.setDialogTitle("Specify a file to save");   
	     
	    int userSelection = fileChooser.showSaveDialog(null);
	     
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
	            }catch (FileNotFoundException ex) {
	            System.out.println(ex.toString());
	            }
	    }
	    
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    MenuItem load = new MenuItem("Load File");
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
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                try {
                    saveFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
      	HTMLEditorx = new HTMLEditor();
		primaryStage.setTitle("Christopher Piccirillo's IDE");
		runButton = new Button("Analyze!");
		runtooltip.setText("Click here to analyze this snippet of code against our grammar.");
		runButton.setTooltip(runtooltip);
		clearButton = new Button("Clear");
        cleartooltip.setText("Click here to clear the text area.");
        clearButton.setTooltip(cleartooltip);
		savetooltip.setText("Click here to save this .txt file to your computer.");
		loadtooltip.setText("Click here choose a file to load into our editor.");
		lineSep.setDisable(true);
	    menuFile.getItems().addAll(load,sep,save);
	    menuBar.getMenus().addAll(menuFile,lineSep,colorMenu);
	    menuBar.setStyle("-fx-background-color: #f0f0f5;");
		// TODO Auto-generated method stub
		//THIS IS OUR MAIN JAVAFX CODE
		//Entire window of JFX is called stage, including close max minimize, all called stage, content inside is is the scene,
		// we put runButtons widgets and stuff in scene
		GridPane layout = new GridPane();
		layout.setStyle("-fx-background-color: #669999;");
		//layout.getChildren().add(HTMLEditor);
		layout.add(menuBar,0,0);
		layout.add(HTMLEditorx,0,1);
		runButton.setTranslateX(225);
		clearButton.setTranslateX(305);
		layout.add(runButton,0,2);
		layout.add(clearButton,0,2);
		  runButton.setOnAction(new EventHandler<ActionEvent>() {
			  // CALL METHOD TO CHECK TEXT AND HIGHLIGHT IT W.E
		        @Override
		        public void handle(ActionEvent event) {
		        	tempHTML = HTMLEditorx.getHtmlText();
		        	//System.out.println(HTMLEditorx.getHtmlText());
		        	String x = tempHTML.replaceAll("<p>","@");
		            String y = x.replaceAll("&nbsp;"," ");
		           // String c = "<span style='border-bottom: 1px solid #ff0000;'>Underlined text here.</span>";
		          //  HTMLEditorx.setHtmlText(c);
		            
		           // HTMLEditorx.setStyle("font: normal 10px Verdana, Arial, sans-serif;");
		           // System.out.println(HTMLtoText(y).trim().length() + HTMLtoText(y));
		           // System.out.println("TEXT PRE STRIP" + y);
		            System.out.println("sending this " + y);
		            System.out.println("sending this " + HTMLtoText(y));
		            checkUserInput.checkInput(HTMLtoText(y));
		           // HTMLEditorx.setHtmlText("<font size='3' color='red'>Print()!</font>");
		        //    runButton.setVisible(false);
		        //    clearButton.setVisible(true);
		        }
		   });
		  clearButton.setOnAction(new EventHandler<ActionEvent>() {
              // CALL METHOD TO CHECK TEXT AND HIGHLIGHT IT W.E
                @Override
                public void handle(ActionEvent event) {
                  HTMLEditorx.setHtmlText("");
                }
            });   
 
		Scene scene = new Scene(layout, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
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


}
