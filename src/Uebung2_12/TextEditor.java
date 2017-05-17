package Uebung2_12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class TextEditor extends Application {
	Stage primarystage;
	TextArea ta = new TextArea();
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		 
			this.primarystage = primaryStage;
		
			MenuBar menuBar = new MenuBar();		 
	        Menu menuFile = new Menu("Datei");	 
	        Menu menuEdit = new Menu("Bearbeiten");	 
	        Menu menuClose = new Menu("Beenden");
	        menuClose.getItems().add(new MenuItem()); 
	        MenuItem menuFileItemOpen = new MenuItem("Öffnen");
	        MenuItem menuFileItemSaveAs = new MenuItem("Speichern unter");
	        MenuItem menuFileItemNew = new MenuItem("Neu");
	        MenuItem menuSearch = new MenuItem("Suche");
	        MenuItem menuReplace = new MenuItem("Ersetzen");
	        
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
	        
	        menuClose.showingProperty().addListener((observable, oldValue, newValue) -> {
			    	if (observable.getValue()) {
			    	System.exit(0);
			    	}
			        	
			    });
	        
	        menuSearch.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	popupdia(primaryStage);
			    }
			        	
			    });
	        
	        menuReplace.setOnAction(new EventHandler<ActionEvent>() {
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
	        
	        menuEdit.getItems().add(menuSearch);
	        menuEdit.getItems().add(menuReplace);
	        
	        menuBar.getMenus().addAll(menuFile, menuEdit, menuClose);
	        
	        
	        VBox vbox = new VBox(0);
	        vbox.setVgrow(ta, Priority.ALWAYS);
	        vbox.getChildren().addAll(menuBar,ta);
	        Scene scene = new Scene(vbox, 1200, 800);
	        
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
	
	private void popupdia(Stage pStage){
		Stage pop = new Stage();
		pop.initModality(Modality.APPLICATION_MODAL);
		pop.initOwner(pStage);
		
		TextField search = new TextField();
		Button sbutton = new Button("Suche");
		
		FlowPane flpane = new FlowPane();
		
		//flpane.set(search, Priority.ALWAYS);
		flpane.getChildren().addAll(search,sbutton);
		
		
		Scene scene2 = new Scene(flpane,400,300);
		
		pop.setScene(scene2);
		pop.show();
		
		sbutton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//String text=ta.replaceSelection(replacement);
				String text=ta.getText();
				String such=search.getText();
				ta.selectRange(text.indexOf(such),such.length()+text.indexOf(such));
			}
		});
		
	}
}
