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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sun.applet.resources.MsgAppletViewer_sv;

public class Arkanoid extends Application {

	private List<MovingEllipse> ovals = new ArrayList<MovingEllipse>();
	private List<Rectangle> rectengles = new ArrayList<Rectangle>();
	private Ellipse ball = new Ellipse();
	private MovingEllipse ov = new MovingEllipse(ball, -4, -4);
	private Rectangle cursor = new Rectangle();
	private Group group = new Group(); // root node for the play window
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
		primaryStage.setTitle("Arkanoid");
		double wid = 0;
		
		 //the first moving
		// circle
		// generate(Color.GREENYELLOW, 150.0, 150.0, 17.0, true); //the second
		// moving circle
		// create a pane for a group with all moving objects
		pane = new Pane(group);
		pane.setPrefSize(500, 500);
		pane.setStyle("-fx-background-color: blue;");
		// create a restart button
		for (int i = 0; i<5;i++) {
			for (int j = 0; j < 5; j++) {
				generateRectangle(Color.YELLOW,i*150.0,j*25.0,150.0,25.0);
			}
			wid = wid+150;
		}
		
		// create the main window layout
		borderPane = new BorderPane();
		borderPane.setTop(bt);
		borderPane.setCenter(pane);
		scene = new Scene(borderPane,  wid, 500, Color.ANTIQUEWHITE);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ovals.clear(); // clear List with references
				rectengles.clear();
				group.getChildren().clear();// clear all moving objects
				// generate(Color.RED, 100.0, 100.0, 35.0, true); //the new
				// first moving circle
				for (int i = 0; i<5;i++) {
					for (int j = 0; j < 5; j++) {
						generateRectangle(Color.YELLOW,i*150.0,j*25.0,150.0,25.0);
					}
				}
				generatecursor(Color.BLACK, scene);
				generate(Color.YELLOW,scene);
			}
		});
		generatecursor(Color.BLACK, scene);
		generate(Color.YELLOW, scene);
		// set pane autoresisable
		scene.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
					Number newSceneWidth) {
				System.out.println("Width: " + newSceneWidth);
				pane.setPrefWidth(scene.getWidth());
			}
		});
		scene.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight,
					Number newSceneHeight) {
				System.out.println("Height: " + newSceneHeight);
				pane.setPrefHeight(scene.getHeight());
			}
		});
		
		
		primaryStage.show();
		
		new AnimationTimer() { // animate all circles
			@Override
			public void handle(long now) {

			

					if (ov.getEllipse().getCenterY() + ov.getEllipse().getRadiusY() + 30 > scene.getHeight()) {
						ov.setStepY(ov.getStepY() * (-1));
					} else if (ov.getEllipse().getCenterX() + ov.getEllipse().getRadiusX() > scene.getWidth()) {
						ov.setStepX(ov.getStepX() * (-1));
					} else if (ov.getEllipse().getCenterY() - ov.getEllipse().getRadiusY() < 0) {
						ov.setStepY(ov.getStepY() * (-1));
					} else if (ov.getEllipse().getCenterX() - ov.getEllipse().getRadiusX() < 0) {
						ov.setStepX(ov.getStepX() * (-1));
					} else if (ov.getEllipse().getCenterY()+ov.getEllipse().getRadiusX()>=cursor.getY()&&ov.getEllipse().getCenterX()>=cursor.getX()&&ov.getEllipse().getCenterX()<=cursor.getX()+cursor.getWidth()){
						ov.setStepY(ov.getStepY()*(-1));
					}
					
					
					ov.getEllipse().setCenterX(ov.getEllipse().getCenterX() + ov.getStepX());
					ov.getEllipse().setCenterY(ov.getEllipse().getCenterY() + ov.getStepY());
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}.start();
		
		
		new AnimationTimer() { // animate all recs
			@Override
			public void handle(long now) {
				double ballY,ballX,ballYw,ballXw,blockY,blockX;
				for(Rectangle e : rectengles){
                	ballY = ov.getEllipse().getCenterY()-ov.getEllipse().getRadiusY();
                	ballYw = ov.getEllipse().getCenterY()+ov.getEllipse().getRadiusY();
                	ballX = ov.getEllipse().getCenterX()-ov.getEllipse().getRadiusX();
                	ballXw = ov.getEllipse().getCenterX()+ov.getEllipse().getRadiusX();
                	blockY = e.getY();
                	blockX = e.getX();
                	
                	if(ballY <= blockY + e.getHeight()&&ballYw>=blockY){
                		if(ballX<=blockX+e.getWidth()&&ballXw>=blockX){
                			ov.setStepY(ov.getStepY()*(-1));
                			try {
								rectengles.remove(e);
							} catch (Exception e2) {
								
							}
                			group.getChildren().remove(e);
                		}	 
                	}else if(ballX<=blockX+e.getWidth()&&ballXw>=blockX){
                		if(ballY <= blockY + e.getHeight()&&ballYw>=blockY){
                			ov.setStepX(ov.getStepX()*(-1));
                			try {
								rectengles.remove(e);
							} catch (Exception e2) {
								
							}
                			group.getChildren().remove(e);
                		}
                	}
                	if(rectengles.isEmpty()==true){
                		ovals.clear();
                		group.getChildren().clear();
                	}else{
                		System.out.println(rectengles.size());
                	}
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
			}.start();
		
		
		new AnimationTimer() { // animate all recs
			boolean left=false,right=false;
			@Override
			public void handle(long now) {
				
				
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

					public void handle(KeyEvent event) {
						 switch (event.getCode()) {
		               
		                 case LEFT:  left  = true; break;
		                 case RIGHT: right  = true; break;
		               
		             }
						
					}
					
				});;
				if(left == true){
					cursor.setX(cursor.getX()-10);
					left = false;
				}else if(right == true){
					cursor.setX(cursor.getX()+10);
					right = false;
				}
				
				
			}
		}.start();
		
		
	}
	

	private void generate(Color c, Scene scene) {
		
		ov.getEllipse().setCenterX(((scene.getWidth()-(scene.getWidth()/10))/2));
		ov.getEllipse().setCenterY(scene.getHeight()-80);
		ov.getEllipse().setRadiusX(10);
		ov.getEllipse().setRadiusY(10);
		ov.getEllipse().setStroke(Color.BLACK);
		ov.getEllipse().setStrokeWidth(3);
		ov.getEllipse().setFill(Color.YELLOW);
		group.getChildren().add(ov.getEllipse());
		
	}
	
	private void generateRectangle(Color c, Double x, Double y, Double width, Double heigth) {
		Rectangle block = new Rectangle(x, y, width, heigth);
		block.setStrokeWidth(3);
		block.setStroke(Color.BLACK);
		block.setFill(c);
		rectengles.add(block);
		group.getChildren().add(block);
	}
	
	private void generatecursor(Color c,Scene scene) {
		cursor.setX((scene.getWidth()-(scene.getWidth()/10))/2);
		cursor.setY(scene.getHeight()-50);
		cursor.setHeight(scene.getHeight()/100);
		cursor.setWidth(scene.getWidth()/10);
		group.getChildren().add(cursor);
	}
	
	private class MovingEllipse {
		private double stepX; //
		private double stepY;
		private Ellipse c; // reference on a circle

		MovingEllipse(Ellipse c, double dx, double dy) {
			this.c = c;
			stepX = dx;
			stepY = dy;
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

		double getDistance(Ellipse e) {
			double x = c.getCenterX() - e.getCenterX();
			double y = c.getCenterY() - e.getCenterY();
			return Math.sqrt(x * x + y * y);
		}

		double getDistance(double coordX, double coordY) {
			double x = c.getCenterX() - coordX;
			double y = c.getCenterY() - coordY;
			return Math.sqrt(x * x + y * y);
		}
	}
}