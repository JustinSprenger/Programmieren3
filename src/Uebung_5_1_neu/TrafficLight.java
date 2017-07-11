package Uebung_5_1_neu;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
	Ellipse red = new Ellipse(10,10);
	Ellipse yellow = new Ellipse(10,10);
	Ellipse green = new Ellipse(10,10);
	Rectangle traffic = new Rectangle(40,90);
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GreenThread g = new GreenThread(this);
        RedThread r = new RedThread(this);
        BlinkThread b = new BlinkThread(this);
		
		
		Group group = new Group();
		
		Button redbtn = new Button("red");
		Button greenbtn = new Button("green");
		Button blinkbtn = new Button("blink");
		Button auto = new Button("auto");
		final BorderPane borderPane; 
        final Scene scene;
        final Pane pane;
		primaryStage.setTitle("Ellipse & AnimationTimer Example");        
	       
	        //create a pane for a group with all moving objects
	    	pane = new Pane(group); 
	        pane.setPrefSize(500,500);
	        pane.setStyle("-fx-background-color: white;");
	        //create a restart button
	        
	        //create the main window lauout
	        borderPane = new BorderPane();
	        
	        HBox hbox = new HBox(4.0);
	        
	        hbox.setAlignment(Pos.BOTTOM_CENTER);
	        hbox.getChildren().addAll(greenbtn,redbtn,blinkbtn,auto);	        	  
	        
	        BorderPane.setAlignment(pane, Pos.CENTER);
	        borderPane.setCenter(pane);
	        
	        BorderPane.setAlignment(hbox, Pos.BOTTOM_CENTER);
	        borderPane.setBottom(hbox);
	        
	        scene = new Scene(borderPane, 500, 500, Color.ANTIQUEWHITE);
	        primaryStage.setScene(scene);
	        
	        traffic.setFill(Color.GRAY);
	        traffic.setX(((scene.getWidth()-(scene.getWidth()/10))/2)-20);
	        traffic.setY(scene.getHeight()-315);
			group.getChildren().add(traffic);
			
	        red.setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
	        red.setCenterY(scene.getHeight()-300);
			group.getChildren().add(red);
			
			green.setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
			green.setCenterY(scene.getHeight()-240);			
			group.getChildren().add(green);
			
			yellow.setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
	        yellow.setCenterY(scene.getHeight()-270);	        
			group.getChildren().add(yellow);	        
	        
	        red.setFill(Color.RED);
	        green.setFill(Color.BLACK);
	        yellow.setFill(Color.BLACK);
				
	        primaryStage.show();
	        
	        greenbtn.setOnAction((event)-> {
				g.run();
				b.pause();
			});
	        redbtn.setOnAction((event)-> {
				r.run();
				b.pause();
			});
	        blinkbtn.setOnAction((event)-> {
				b.run();
			});
	        auto.setOnAction((event)-> {
				while(true){
					g.run();
					r.run();
				}
			});
		
	}
	public void setGreen(boolean c){
    	if(c==true){
    		green.setFill(Color.GREEN);
    	}else{
    		green.setFill(Color.BLACK);
    	}
		
    }
    public void setRed(boolean c){
    	if(c==true){
    		red.setFill(Color.RED);
    	}else{
    		red.setFill(Color.BLACK);
    	}
    }
    public void setYellow(boolean c){
    	if(c==true){
    		yellow.setFill(Color.YELLOW);
    	}else{
    		yellow.setFill(Color.BLACK);
    	}
    }
    
    
    
    public Ellipse getGreen(){
		return green;
    }
    public Ellipse getRed(){
		return red;
    }
    public Ellipse getYellow(){
		return yellow;
    }
}
