package Uebung_3;

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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
public class Feuerwerk extends Application {
 
    private List<MovingEllipse> ovals = new ArrayList<MovingEllipse>();
    private Group group = new Group();  //root node for the play window
    private final Random random = new Random();
    private final Button bt = new Button("Restart");

    public static void main(String[] args) {
        Application.launch(args);  
    }

    @Override
    public void start(Stage primaryStage) {
        final BorderPane borderPane; 
        final Scene scene;
        final Pane pane;
        primaryStage.setTitle("Ellipse & AnimationTimer Example");        
       // generate(Color.RED, 100.0, 100.0, 35.0, 0.81 ,true);         //the first moving circle
       // generate(Color.GREENYELLOW, 150.0, 150.0, 17.0, 0.81 ,true); //the second moving circle
        
        //create a pane for a group with all moving objects
        pane = new Pane(group); 
        pane.setPrefSize(500,500);
        pane.setStyle("-fx-background-color: black;");
        //create a restart button
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	//ovals.clear();              //clear List with references
               // group.getChildren().clear();//clear all moving objects  
               // generate(Color.RED, 100.0, 100.0, 35.0, true); //the new first moving circle
            }
        });
        //create the main window lauout
        borderPane = new BorderPane();
        borderPane.setTop(bt);
        borderPane.setCenter(pane);
        scene = new Scene(borderPane, 500, 500, Color.ANTIQUEWHITE);
        primaryStage.setScene(scene);
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

        pane.setOnMousePressed(event->
        { 
        	int r;
        	double dirx=0,diry=0;
        	for(int i = 0;i<=1000;i++){
        		r = i%8;
        		System.out.println(r);
        		switch (r) {
				case 0:
					dirx=Math.random();
					diry=Math.random();
					break;
				case 1:
					dirx=Math.random();
					diry=Math.random()*-1;
					break;
				case 2:
					dirx=Math.random()*-1;
					diry=Math.random()*-1;
					break;
				case 3:
					dirx=Math.random()*-1;
					diry=Math.random();
					break;
				case 4:
					dirx=Math.random()*1.5;
					diry=Math.random();
					break;
				case 5:
					dirx=Math.random();
					diry=Math.random()*1.5;
					break;
				case 6:
					dirx=Math.random()*-1.5;
					diry=Math.random();
					break;
				case 7:
					dirx=Math.random();
					diry=Math.random()*-1.5;
					break;
				default:
					break;
				}
        		if(i<=250&&i>0){
        			generate(Color.YELLOW, event.getX(), event.getY(), dirx, diry,5.0, 0.01, true);
        		}else if(i<=500&&i>250){
        			generate(Color.GREEN, event.getX(), event.getY(), dirx, diry,5.0, 0.01, true);
        		}else if(i<=750&&i>500){
        			generate(Color.RED, event.getX(), event.getY(), dirx, diry,5.0, 0.01, true);
        		}else if(i<=1000&&i>750){
        			generate(Color.PURPLE, event.getX(), event.getY(), dirx, diry,5.0, 0.01, true);
        		}
        		     	
        	}        		
        });
        	
        primaryStage.show();
        
        new AnimationTimer() { //animate all circles
            @Override
            public void handle(long now) {
            	
                for(MovingEllipse e:ovals){
                	
                	if(e.getEllipse().getCenterY()+e.getEllipse().getRadiusY()+30 >= scene.getHeight()){
                		e.setStepY(e.getStepY()*(-1));
                	}else if(e.getEllipse().getCenterX()+e.getEllipse().getRadiusX() >= scene.getWidth() ){
                		e.setStepX(e.getStepX()*(-1)); 
                	}else if(e.getEllipse().getCenterY()-e.getEllipse().getRadiusY()<=0){
                		e.setStepY(e.getStepY()*(-1));
                	}else if(e.getEllipse().getCenterX()-e.getEllipse().getRadiusX()<=0){
                		e.setStepX(e.getStepX()*(-1));
                	}else if(e.getEllipse().getCenterX()+e.getEllipse().getRadiusX()>=scene.getWidth()){
                		e.setStepX(e.getStepX()*(-1));
                	}else if(e.getStepY() == 0){
                		e.setStepX(0);
                	}else if(e.getEllipse().getCenterY()+e.getEllipse().getRadiusY()+30 < scene.getHeight()&&e.getEllipse().getCenterX()+e.getEllipse().getRadiusX()<scene.getWidth()-10&&e.getEllipse().getCenterX()-e.getEllipse().getRadiusX()>10){
                		if(e.getStepY()>0){
                			e.setStepY(e.getStepY()+e.getGravity());
                		}else if(e.getStepY()<0){
                			e.setStepY(e.getStepY()+e.getGravity()*(Math.random()*10));
                		}	
                	}
                	
                	if(e.getEllipse().getCenterY()-e.getEllipse().getRadiusY()<=30){
                		try {
							Thread.sleep(2);
							((borderPane).getChildren()).remove(e);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                	}
                	
                	e.getEllipse().setCenterX((e.getEllipse().getCenterX()+e.getStepX()));
                	e.getEllipse().setCenterY((e.getEllipse().getCenterY()+e.getStepY())); 
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }
    
    private void generate(Color c, Double x, Double y,Double dirx,Double diry,Double radius,double grav, boolean clickable){
                        Ellipse localCircle = new Ellipse(x, y, radius, radius);
                        localCircle.setStrokeWidth(3);
                        localCircle.setStroke(Color.BLACK);
                        localCircle.setFill(c);
                        /**if(clickable){  //add event handler
                            localCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) { //create one more moving circle
                                    generate(Color.YELLOW, e.getSceneX(), e.getSceneY() - bt.getHeight(),dirx,diry, 10.0, grav ,false);
                                }
                            });
                        }**/
                        ovals.add(new MovingEllipse(localCircle, dirx, diry,grav));
                        group.getChildren().add(localCircle); //add obect to the group
        
    }
/**    private void generatef(Color c, Double x, Double y, Double radius, boolean clickable){
        Ellipse localCircle = new Ellipse(x, y, radius, radius);
        localCircle.setStrokeWidth(1);
        localCircle.setStroke(Color.BLACK);
        localCircle.setFill(c);
        if(clickable){  //add event handler
            localCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) { //create one more moving circle
                    generate(Color.YELLOW, e.getSceneX(), e.getSceneY() - bt.getHeight(), 10.0, false);
                }
            });
        }
        ovals.add(new MovingEllipse(localCircle, random.nextDouble(), random.nextDouble()));
        group.getChildren().add(localCircle); //add obect to the group

}**/
    private class MovingEllipse{
        private double stepX; //
        private double stepY;
        private double gravity;
        private Ellipse c; //reference on a circle
        MovingEllipse(Ellipse c, double dx, double dy,double grav){
            this.c = c;
            stepX = dx;
            stepY = dy;
            gravity = grav;
        }
        public double getStepX() {
            return stepX;
        }
        public void setStepX(double stepX) {
            this.stepX = stepX;
        }
        public double getStepY() {
            return stepY;
        }
        public void setStepY(double stepY) {
            this.stepY = stepY;
        }
        public Ellipse getEllipse() {
            return c;
        }
        public void setEllipse(Ellipse c) {
            this.c = c;
        }
        double getDistance(Ellipse e){
            double x = c.getCenterX() - e. getCenterX();
            double y = c.getCenterY() - e. getCenterY();
            return Math.sqrt(x * x + y * y);
        }
        double getDistance(double coordX, double coordY){
            double x = c.getCenterX() - coordX;
            double y = c.getCenterY() - coordY;
            return Math.sqrt(x * x + y * y);
        }
        public void setGravity(double g){
        	this.gravity = g;
        }
        public double getGravity(){
        	return this.gravity;
        }
    }
}