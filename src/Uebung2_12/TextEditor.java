package Uebung2_12;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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
	        MenuItem menuFileItemOpen = new MenuItem("÷ffnen");
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
			    	popupSearch();
			    }
			        	
			    });
	        
	        menuReplace.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	popupReplace();
			    }
			        	
			    });

	        
	        menuFileItemNew.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
	        menuFileItemSaveAs.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
	        menuFileItemOpen.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
	        menuSearch.setAccelerator(KeyCombination.keyCombination("shortcut+F"));
	        
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
		System.out.println("Datei ÷ffnen");
	}
	
	private int leng = 0;
	
	private void popupSearch(){
		Stage pop = new Stage();
		pop.initModality(Modality.APPLICATION_MODAL);
		pop.initOwner(primarystage);
		
		TextField search = new TextField();
		TextField replace = new TextField();
		Button sbutton = new Button("Suche");
		Button ebutton = new Button("ersetzen");
		CheckBox lowCase = new CheckBox("Groﬂ/Kleinschreibung beachten");
		
		FlowPane flpane = new FlowPane();
		FlowPane flpane2 = new FlowPane();
		VBox vbox = new VBox(1);
		//flpane.set(search, Priority.ALWAYS);
		flpane.getChildren().addAll(search,sbutton);
		flpane2.getChildren().addAll(replace,ebutton);
		vbox.getChildren().addAll(flpane,lowCase,flpane2);
		
		Scene scene2 = new Scene(vbox,400,300);
		
		pop.setScene(scene2);
		pop.show();
		
		
		sbutton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//String text=ta.replaceSelection(replacement);
				String text=ta.getText();
				String such=search.getText();
				
				
				if(lowCase.isSelected()==true){
					ta.selectRange(text.indexOf(such, leng),such.length()+text.indexOf(such, leng));
					leng = leng + such.length()+text.indexOf(such);
				}else{
					text = text.toLowerCase();
					such = such.toLowerCase();
					ta.selectRange(text.indexOf(such, leng),such.length()+text.indexOf(such, leng));
					leng = leng + such.length()+text.indexOf(such);
				}
				
				if(leng>=text.length()){
					leng = 0;
				}
			}
		});
		
		ebutton.setOnAction((event) -> {
			String wort = "";
			wort = replace.getText();
			if(wort != ""){
				ta.replaceSelection(wort);		
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information!");
				alert.setHeaderText("Keine Eingabe");
				alert.setContentText("Bitte ein Wort eingeben, welches das Alte ersetzen soll!");
				alert.showAndWait().ifPresent(rs -> {
				    if (rs == ButtonType.OK) {
				        System.out.println("Pressed OK.");
				    }
				});
			}
		});
	
	}
	
	private void popupReplace(){
		Stage pop = new Stage();
		pop.initModality(Modality.APPLICATION_MODAL);
		pop.initOwner(primarystage);
		
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
