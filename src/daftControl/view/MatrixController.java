package daftControl.view;

import java.util.ArrayList;

import javafx.fxml.FXML;
import daftControl.Main;
import daftControl.model.DesignSpace;
import daftControl.model.Led;

public class MatrixController {
	
	private int rightShift = 0;
	Matrix m;
	private DesignSpace workspace;
	
	@Deprecated 
	public void setMainApp(Main mainApp) {
	}
	
	public void setWorkSpace(DesignSpace workspace) {
		this.workspace = workspace;
		remapCircles();
	}
	
	@FXML
	public void toolBarShiftRight() {
		rightShift++;
		
		if(workspace.getAllLeds().size() <= m.circles.size() + rightShift) {
			workspace.addColumn();
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
		
		for (ArrayList<Led> list : workspace.getAllLeds())
			for (Led ld : list)
				if(ld.getC() != null)
				ld.clearCircle();
		
		for(int i = 0; i < m.circles.size(); i++) {
			for (int j = 0; j < m.circles.get(0).size(); j++) {
				workspace.getAllLeds().get(i + rightShift, j).setC(m.circles.get(i, j));
			}
		}
	}
	

	
	public MatrixController() {}

	public void setMatrix(Matrix m2) {
		this.m = m2;
	}
	
	
}
