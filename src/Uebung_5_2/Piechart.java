package Uebung_5_2;

import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Piechart extends Application {
	Stage primary;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primary = primaryStage;
		
		PieChart chart = new PieChart();
		
		PieChart.Data slice1 = new PieChart.Data("Parameter 1", 69);
		PieChart.Data slice2 = new PieChart.Data("Parameter 2", 12);
		PieChart.Data slice3 = new PieChart.Data("Parameter 3", 19);
		
		chart.getData().addAll(slice1,slice2,slice3);
		
		HBox hbox = new HBox(chart);
		
		Scene scene = new Scene(hbox,600,600);
		primary.setTitle("PieChart");
		primary.setScene(scene);
		primary.show();
		

		Stage sliderstage1 = new Stage();
		sliderstage1.setTitle("Slider 1");
		
		Slider s1 = new Slider();
		//s1.setMax(100);
		s1.setShowTickLabels(true);
		s1.setShowTickMarks(true);
		
		BorderPane pane1 = new BorderPane();
		pane1.setCenter(s1);
		Scene scene2 = new Scene(pane1,400,200);

		sliderstage1.setScene(scene2);
		
		sliderstage1.show();
		
		s1.valueProperty().addListener((Observable, oldvalue, newValue)->{
			if(newValue.doubleValue() + slice2.getPieValue()>=100){
				slice2.setPieValue(100-newValue.doubleValue());
				slice1.setPieValue(newValue.doubleValue());
				slice3.setPieValue(0);
				//slice1.setName("Parameter 1" + Math.round(100-(slice2.getPieValue()+slice3.getPieValue())));
				
			}else{
				//slice1.setName("Parameter 1" + Math.round(newValue.doubleValue()));
				slice3.setPieValue(100-(newValue.doubleValue()+slice2.getPieValue()));
				
			}
			
			
		});

		Stage sliderstage2 = new Stage();
		sliderstage2.setTitle("Slider 2");
		
		Slider s2 = new Slider();
		//s2.setMax(100);
		s2.setShowTickLabels(true);
		s2.setShowTickMarks(true);
		s2.valueProperty().addListener((Observable, oldvalue, newValue)->{
			if(newValue.doubleValue() + slice1.getPieValue()>=100){
				slice1.setPieValue(100-newValue.doubleValue());
				slice2.setPieValue(newValue.doubleValue());
				slice3.setPieValue(0);
			}else{
				slice3.setPieValue(100-(newValue.doubleValue()+slice1.getPieValue()));
			}
			
			
		});
		BorderPane pane2 = new BorderPane();
		pane2.setCenter(s2);
		Scene scene3 = new Scene(pane2,400,200);
		
		sliderstage2.setScene(scene3);
		
		sliderstage2.show();
	
 }
}
