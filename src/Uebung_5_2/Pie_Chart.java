/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uebung_5_2;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Pie_Chart extends Application {
 
    int i;
    int j;
    int k;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
 
                
        Slider slider1 = new Slider();
        slider1.setMin(0);
        slider1.setMax(100);
        slider1.setValue(0);
        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        slider1.setMaxWidth(300);
        
        Slider slider2 = new Slider();
        slider2.setMin(0);
        slider2.setMax(100);
        slider2.setValue(0);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setMaxWidth(300);
       
        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Parameter 1", 0);
        PieChart.Data slice2 = new PieChart.Data("Parameter 2", 0);
        PieChart.Data slice3 = new PieChart.Data("Parameter 3", 100);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        pieChart.setLegendSide(Side.LEFT);
 
        slider1.valueProperty().addListener(
            (observable, oldvalue, newvalue) ->
            {
                
                i = newvalue.intValue();
                
                if(i+j <=100){
                
                    k = 100 - i - j;
                    
                }else{
                    
                    k = 0;
                    j = 100 - i;
                    slider2.setValue(j);
                    
                }
                
                System.out.println(i);
                System.out.println(j);
                System.out.println(k);
                
                
                slice1.setPieValue(i);
                slice2.setPieValue(j);
                slice3.setPieValue(k);

                
            });
        
        slider2.valueProperty().addListener(
            (observable, oldvalue, newvalue) ->
            {
                
                j = newvalue.intValue();
                
                if(i+j <=100){
                
                    k = 100 - i - j;
                    
                }else{
                    
                    k = 0;
                    i = 100 - j;
                    slider1.setValue(i);
                }
                
                System.out.println(i);
                System.out.println(j);
                System.out.println(k);
                 
                slice1.setPieValue(i);
                slice2.setPieValue(j);
                slice3.setPieValue(k);
                
            });
       

        primaryStage.setTitle("Kuchendiagramm");
        BorderPane root = new BorderPane();

        root.setCenter(pieChart);
        
        root.setBottom(slider2);

        Scene scene = new Scene(root, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        BorderPane root2 = new BorderPane();
        
        root2.setCenter(slider1);
        
        Stage secondStage = new Stage();
        secondStage.setTitle("Parameter 1");
        
        Scene scene2 = new Scene(root2, 400, 200);
        
        secondStage.setScene(scene2);
        secondStage.show();
        
          
        BorderPane root3 = new BorderPane();
        
        root3.setCenter(slider2);
        
        Stage secondStage2 = new Stage();
        secondStage2.setTitle("Parameter 2");
        
        Scene scene3 = new Scene(root3, 400, 200);
        
        secondStage2.setScene(scene3);
        secondStage2.show();
        
    }
 
   public static void main(String[] args) {
       Application.launch(args);
   }
}
