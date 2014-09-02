package daftControl.view;

import javafx.fxml.FXML;
import daftControl.Main;
import daftControl.model.Led;

public class MatrixController {
	
	private int rightShift = 0;
	Matrix m;
	private Main mainApp;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setMatrix(Matrix m) {
		this.m = m;
		bindMatrix();
	}
	
	private void bindMatrix () {
		for (int i = 0; i < m.circles.size(); i++)
			for(int j = 0; j < m.circles.get(0).size(); j++)
				mainApp.allLeds.add(i,j,new Led(i,j,m.circles.get(i, j)));
	}
	
	@FXML
	public void toolBarShiftRight() {
		rightShift++;
		
		if(mainApp.allLeds.size() <= m.circles.size() + rightShift) {
			int temp = mainApp.allLeds.size();
			for (int i = 0; i < m.circles.get(0).size(); i++) {
				mainApp.allLeds.add(temp, i,
						new Led(temp, i));
			}
		}
		
		remapCircles();
	}
	
	@FXML
	public void toolBarShiftLeft() {
		if (rightShift != 0)
			rightShift--;
		remapCircles();
	}
	
	private void remapCircles() {
		for(int i = 0; i < m.circles.size(); i++) {
			for (int j = 0; j < m.circles.get(0).size(); j++) {
				mainApp.allLeds.get(i + rightShift, j).setC(m.circles.get(i, j));
			}
		}
	}
	

	
	public MatrixController() {}
	
	
}
