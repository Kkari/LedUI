package daftControl.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import daftControl.Main;
import daftControl.model.DesignSpace;

public class MenuController {
	
	private DesignSpace workspace;
	
	@FXML
	private GridPane toolBar;
	
	@FXML 
	private MenuItem designSign;
	
	@FXML
	private GridPane mainGrid;
	
	@FXML
	private Group mainGroup;
	
	public MenuController() {}
	
	@FXML
	private void designView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/DesignSignMenu.fxml"));
			toolBar.getChildren().setAll(loader.load());
			
			Matrix m = new Matrix();
			m.initializeMatrix(mainGroup);
			
			if (workspace == null) {
				workspace = new DesignSpace(Matrix.MATRIX_WIDTH, Matrix.MATRIX_HEIGHT);
			}
			
			MatrixController mC = loader.getController();
			mC.setMatrix(m);
			mC.setWorkSpace(workspace);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void saveMenuItem() {
		workspace.save();
	}
	
	@FXML
	private void loadMenuItem() {
		workspace = DesignSpace.loadFromFile();	
		workspace.activeToAllLeds(Matrix.MATRIX_WIDTH, Matrix.MATRIX_HEIGHT);
		designView();
	}
}
