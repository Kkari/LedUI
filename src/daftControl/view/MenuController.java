package daftControl.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import daftControl.Main;
import daftControl.model.SaveMngt;
import daftControl.model.SaveMngt.Pages;

public class MenuController {
	
	private Main mainApp;
	private SaveMngt save = new SaveMngt();
	
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
			
			save.page = Pages.DESIGN;
			
			Matrix m = new Matrix();
			m.initializeMatrix(mainGroup);
			
			MatrixController mC = loader.getController();
			mC.setMainApp(mainApp);
			mC.setMatrix(m);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void saveMenuItem() {
		save.save(mainApp.allLeds);
	}
}
