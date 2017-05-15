package Uebung2_12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextEditor extends Application {
	Stage primarystage;
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		 
			this.primarystage = primaryStage;
		
			MenuBar menuBar = new MenuBar();		 
	        Menu menuFile = new Menu("Datei");	 
	        Menu menuEdit = new Menu("Suche");	 
	        Menu menuView = new Menu("Beenden");
	        MenuItem menuFileItemOpen = new MenuItem("Öffnen");
	        MenuItem menuFileItemSaveAs = new MenuItem("Speichern unter");
	        MenuItem menuFileItemNew = new MenuItem("Neu");
	        
	        menuFileItemNew.setOnAction(new EventHandler<ActionEvent>() {
	        @Override 
	        public void handle(ActionEvent e) {
	        	newFile();
	        }
	        	
	        });
	        
	        menuFileItemSaveAs.setOnAction(new EventHandler<ActionEvent>() {
	        @Override 
		    public void handle(ActionEvent e) {
	        	saveFile();
		    }
		        	
		    });
	        
	        menuFileItemOpen.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	openFile();
		    }
		        	
		    });
	        
	        menuFileItemNew.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
	        menuFileItemSaveAs.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
	        menuFileItemOpen.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
	        
	        menuFile.getItems().add(menuFileItemNew);
	        menuFile.getItems().add(menuFileItemOpen);
	        menuFile.getItems().add(menuFileItemSaveAs);
	        
	        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
	        TextArea ta = new TextArea();
	        
	        VBox vbox = new VBox(0);
	        vbox.setVgrow(ta, Priority.ALWAYS);
	        vbox.getChildren().addAll(menuBar,ta);
	        Scene scene = new Scene(vbox, 300, 250);
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
	
	private void newFile(){
		System.out.println("neue Datei");
	}
	private void saveFile(){
		System.out.println("Datei Speichern");
	}
	private void openFile(){
		System.out.println("Datei Öffnen");
	}
}
