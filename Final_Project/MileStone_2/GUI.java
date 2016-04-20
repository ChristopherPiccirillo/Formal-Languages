import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class GUI extends Application{
    Button button; // run button
    Button button2; // reset button
    String tempHTML = "";
    static HTMLEditor HTMLEditorx;
    GridLayout experimentLayout = new GridLayout(0,2);
	public static void main (String args[]){
		
		//System.out.println("Hello world");	
		// Sets up program as JFX application
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
      	HTMLEditorx = new HTMLEditor();
      //	HTMLEditorx.setHtmlText("<style> body {background-color:PapayaWhip;} </style> ");
		primaryStage.setTitle("Christopher Piccirillo's IDE");
		button = new Button("Run!");
		button2 = new Button("Reset");
		//button.setText("Click Me");
		// TODO Auto-generated method stub
		//THIS IS OUR MAIN JAVAFX CODE
		//Entire window of JFX is called stage, including close max minimize, all called stage, content inside is is the scene,
		// we put buttons widgets and stuff in scene
		GridPane layout = new GridPane();
		//layout.getChildren().add(HTMLEditor);
		layout.add(HTMLEditorx,0,0);
		button.setTranslateX(275);
		button2.setTranslateX(275);
		button2.setVisible(false);
		layout.add(button,0,1);
		layout.add(button2,0,1);
		//layout.getChildren().add(button);
		  button.setOnAction(new EventHandler<ActionEvent>() {
			  // CALL METHOD TO CHECK TEXT AND HIGHLIGHT IT W.E
		        @Override
		        public void handle(ActionEvent event) {
		        	tempHTML = HTMLEditorx.getHtmlText();
		        	//System.out.println(HTMLEditorx.getHtmlText());
		        	String x = tempHTML.replaceAll("</p>","@");
		        	String c = x.replaceAll("</body>","~");
		            String y = c.replaceAll("&nbsp;","");
		           // String c = "<span style='border-bottom: 1px solid #ff0000;'>Underlined text here.</span>";
		          //  HTMLEditorx.setHtmlText(c);
		            
		           // HTMLEditorx.setStyle("font: normal 10px Verdana, Arial, sans-serif;");
		           // System.out.println(HTMLtoText(y).trim().length() + HTMLtoText(y));
		           // System.out.println("TEXT PRE STRIP" + y);
		            System.out.println("sending this " + y);
		            System.out.println("sending this " + HTMLtoText(y));
		            checkUserInput.checkInput(HTMLtoText(c));
		           // HTMLEditorx.setHtmlText("<font size='3' color='red'>Print()!</font>");
		            button.setVisible(false);
		            button2.setVisible(true);
		        }
		    });
		  button2.setOnAction(new EventHandler<ActionEvent>() {
              // CALL METHOD TO CHECK TEXT AND HIGHLIGHT IT W.E
                @Override
                public void handle(ActionEvent event) {
                  HTMLEditorx.setHtmlText("");
                  button.setVisible(true);
                  button2.setVisible(false);
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
