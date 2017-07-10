package Uebung_5_1;

/**
 * Created by user on 31.03.16.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class Ampel extends Application {
 
    //private List<MovingEllipse> ovals = new ArrayList<MovingEllipse>();
    private Group group = new Group();  //root node for the play window
    private final Random random = new Random();
    private final Button bg = new Button("Green");
    private final Button br = new Button("Red");
    private final Button bb = new Button("Blink");
    private Ellipse red = new Ellipse();
    private Ellipse green = new Ellipse();
    private Ellipse yellow = new Ellipse();
    private Rectangle rec = new Rectangle();

    public static void main(String[] args) {
    	/**Ampel a = new Ampel();
		
		System.out.println(a.green());
		System.out.println(a.yellow());
		System.out.println(a.green());
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a.red());
		System.out.println(a.redYellow());
		System.out.println(a.red());
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a.blink());**/
    	Application.launch(args);  
    }

    @Override
    public void start(Stage primaryStage) {
        final BorderPane borderPane; 
        final Scene scene;
        final Pane pane;
              
        GreenThread g = new GreenThread(this);
        RedThread r = new RedThread(this);
        BlinkThread b = new BlinkThread(this);
        
        primaryStage.setTitle("Ellipse & AnimationTimer Example");        
        
        //create a pane for a group with all moving objects
        pane = new Pane(group); 
        pane.setPrefSize(500,500);
        pane.setStyle("-fx-background-color: white;");
        //create a restart button
        
        //create the main window lauout
        borderPane = new BorderPane();
        
        FlowPane flpane = new FlowPane();
		flpane.getChildren().addAll(bg,br,bb);
		
		VBox v1 = new VBox(0);
		//v1.setPrefHeight(100);
		v1.getChildren().addAll(flpane);
		
		borderPane.setBottom(v1);
        
        borderPane.setCenter(pane);
        scene = new Scene(borderPane, 500, 500, Color.ANTIQUEWHITE);
        primaryStage.setScene(scene);
        
        rec.setX(((scene.getWidth()-(scene.getWidth()/10))/2)-20);
		rec.setY(scene.getHeight()-315);
		rec.setWidth(40);
		rec.setHeight(90);
		rec.setStroke(Color.GRAY);
		rec.setFill(Color.GRAY);
		rec.setStrokeWidth(3);
		group.getChildren().add(rec);
		
        red.setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
        red.setCenterY(scene.getHeight()-300);
        red.setRadiusX(10);
        red.setRadiusY(10);
        red.setStrokeWidth(3);
        red.setStroke(Color.RED);
        red.setFill(Color.RED);
		group.getChildren().add(red);
		
		green.setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
		green.setCenterY(scene.getHeight()-240);
		green.setRadiusX(10);
		green.setRadiusY(10);
		green.setStrokeWidth(3);
		green.setStroke(Color.GREEN);
		green.setFill(Color.GREEN);
		group.getChildren().add(green);
		
		yellow.setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
        yellow.setCenterY(scene.getHeight()-270);
        yellow.setRadiusX(10);
        yellow.setRadiusY(10);
        yellow.setStrokeWidth(3);
        yellow.setStroke(Color.YELLOW);
        red.setFill(Color.YELLOW);
		group.getChildren().add(yellow);
		
		red.setVisible(true);
		yellow.setVisible(false);
		green.setVisible(false);
		
		
        //set pane autoresisable
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                System.out.println("Width: " + newSceneWidth);
                pane.setPrefWidth(scene.getWidth());
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                System.out.println("Height: " + newSceneHeight);
                pane.setPrefHeight(scene.getHeight());
            }
        });
        primaryStage.show();

        new AnimationTimer() { //animate all circles
            @Override
            public void handle(long now) {
            	
            }
        }.start();
        
        bg.setOnAction((event)-> {
			g.run();
			b.pause();
		});
        
        br.setOnAction((event)-> {
        	r.run();
        	b.pause();
		});
        
        bb.setOnAction((event)-> {
        	//b.consume();
        	b.run();
		});
        
    }
    public void setGreen(boolean c){
    	green.setVisible(c);
    }
    public void setRed(boolean c){
    	red.setVisible(c);
    }
    public void setYellow(boolean c){
    	yellow.setVisible(c);
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