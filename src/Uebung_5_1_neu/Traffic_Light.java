package Uebung_5_1_neu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Jan
 */
public class Traffic_Light extends Application{
    
    Ellipse red = new Ellipse(20, 20);
    Ellipse yellow = new Ellipse(20, 20);
    Ellipse green = new Ellipse(20, 20);
    
    Boolean blink = false;
    int state = 0;
    
    
    @Override
    public void start(Stage primaryStage) {
        Button redbtn = new Button("Rot");
        Button greenbtn = new Button("Grün");
        Button blinkbtn = new Button("Blinken");
        Button autobtn = new Button("Automatisch");
        
    /*    btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
    
        */
        
        BorderPane root = new BorderPane();
        HBox buttonBox = new HBox(4.0);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.getChildren().add(redbtn);
        buttonBox.getChildren().add(greenbtn);
        buttonBox.getChildren().add(blinkbtn);
        buttonBox.getChildren().add(autobtn);
        
        BorderPane.setMargin(buttonBox, new Insets(4.0, 4.0, 30.0, 4.0));
        
        root.setBottom(buttonBox);
        
        Rectangle rect = new Rectangle(60,150);
        rect.setFill(Color.BLACK);
        root.setCenter(rect);
        
        red.setFill(Color.RED);
        red.setCenterX(155);
        red.setCenterY(57);
        root.getChildren().add(red);
    
        yellow.setFill(Color.BLACK);
        yellow.setCenterX(155);
        yellow.setCenterY(102);
        root.getChildren().add(yellow);
        
        green.setFill(Color.BLACK);
        green.setCenterX(155);
        green.setCenterY(147);
        root.getChildren().add(green);
        
       
        redbtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                
                red();
                
            }
        });
        
        greenbtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                
                green();
                
            }
        });
        
        blinkbtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                
                Thread t = new Thread(new Runnable(){
                    
                    public void run(){
        
                        while(true){
            
                            blink();
            
                            try{
                
                                Thread.sleep(1000);
                
                            }catch(InterruptedException e){}
            
                        }
        
                    }
                    
                });
                t.start();
                
                
            }
        });
        
        autobtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                
                Thread t = new Thread(new Runnable(){
                    
                    public void run(){
        
                        while(true){
            
                            update();
            
                            try{
                
                                if(state%4 == 2){
                                    
                                    Thread.sleep(2000);
                                    
                                }else if(state%4 == 0){Thread.sleep(3000);
                                        
                                }else{Thread.sleep(1000);}
                
                            }catch(InterruptedException e){}
            
                        }
        
                    }
                    
                });
                t.start();
                
            }
        });
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public  void red(){
        
        red.setFill(Color.RED);
        yellow.setFill(Color.BLACK);
        green.setFill(Color.BLACK);
        
        blink = false;
    }
    
    public  void redyellow(){
        
        red.setFill(Color.RED);
        yellow.setFill(Color.YELLOW);
        green.setFill(Color.BLACK);
        
        blink = false;
        
    }
     
    public  void yellow(){
        
        red.setFill(Color.BLACK);
        yellow.setFill(Color.YELLOW);
        green.setFill(Color.BLACK);
        
        blink = true;
        
    }
      
    public  void green(){
        
        red.setFill(Color.BLACK);
        yellow.setFill(Color.BLACK);
        green.setFill(Color.GREEN);
                
        blink = false;
        
    }
    
    public  void blink(){
       
        if(this.blink == false){
            
            yellow();
            
        }else{
            
            red.setFill(Color.BLACK);
            yellow.setFill(Color.BLACK);
            green.setFill(Color.BLACK);
            
            blink = false;
            
        }
     
    }
    
    public void update(){
        
        int n = state % 4;
        
        System.out.println(n);

        if(n == 0){
            
            red();
            
        }else if(n == 1){
            
            redyellow();
            
            
        }else if(n == 2){
            
            green();
            
        }else if(n == 3){
            
            yellow();
            
        }
        
        state++;
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
