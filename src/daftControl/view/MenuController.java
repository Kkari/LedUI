package daftControl.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import daftControl.Main;

public class MenuController {
	
	private Main mainApp;
	
	@FXML
	private GridPane toolBar;
	
	@FXML 
	private MenuItem designSign;
	
	@FXML
	private GridPane mainGrid;
	
	@FXML
	private Group mainGroup;
	
	public MenuController() {}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void designView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/DesignSignMenu.fxml"));
			toolBar.getChildren().setAll(loader.load());
			
			MatrixController mC = new MatrixController();
			mC.setMainApp(mainApp);
			
			mC.initializeMatrix(mainGroup, 40, 8);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
